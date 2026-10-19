package com.example.analitik.service;

import com.example.analitik.dto.SurveyDtos;
import com.example.analitik.model.*;
import com.example.analitik.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SurveyService {
    private final UserRepository users;
    private final SurveyRepository surveys;

    public SurveyService(UserRepository users, SurveyRepository surveys) {
        this.users = users;
        this.surveys = surveys;
    }

    public SurveyDtos.Response submit(String email, SurveyDtos.SubmitRequest req) {
        User employee = users.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User tidak ditemukan"));

        int weightTotal = req.mentalDemandWeight() + req.physicalDemandWeight()
                + req.temporalDemandWeight() + req.performanceWeight()
                + req.effortWeight() + req.frustrationWeight();
        if (weightTotal != 15) {
            throw new IllegalArgumentException("Total bobot NASA-TLX harus 15. Total saat ini: " + weightTotal);
        }

        // NASA-TLX weighted score = sum(rating x weight) / sum(weights)
        int weightedSum = req.mentalDemand() * req.mentalDemandWeight()
                + req.physicalDemand() * req.physicalDemandWeight()
                + req.temporalDemand() * req.temporalDemandWeight()
                + req.performance() * req.performanceWeight()
                + req.effort() * req.effortWeight()
                + req.frustration() * req.frustrationWeight();
        int nasaTlxScore = Math.round(weightedSum / 15.0f);

        // Simpan skor NASA-TLX sebagai skor utama; rata-rata rating dimensi menjadi pembanding workload.
        int workloadAverage = Math.round((req.mentalDemand() + req.physicalDemand()
                + req.temporalDemand() + req.performance() + req.effort() + req.frustration()) / 6.0f);
        int combined = nasaTlxScore;
        StressLevel level = combined < 40 ? StressLevel.RENDAH :
                combined < 70 ? StressLevel.SEDANG : StressLevel.TINGGI;

        String recommendation = switch (level) {
            case RENDAH -> "Beban kerja berdasarkan NASA-TLX tergolong rendah. Pertahankan pola kerja dan istirahat teratur.";
            case SEDANG -> "Beban kerja berdasarkan NASA-TLX tergolong sedang. Atur prioritas tugas, ambil jeda, dan diskusikan beban kerja dengan manajer.";
            case TINGGI -> "Beban kerja berdasarkan NASA-TLX tergolong tinggi. Evaluasi pembagian tugas dan diskusikan tindak lanjut dengan manajer/HR.";
        };

        Survey saved = surveys.save(Survey.builder()
                .employee(employee)
                .stressScore(nasaTlxScore)
                .workloadScore(workloadAverage)
                .nasaTlxScore(nasaTlxScore)
                .mentalDemand(req.mentalDemand())
                .physicalDemand(req.physicalDemand())
                .temporalDemand(req.temporalDemand())
                .performance(req.performance())
                .effort(req.effort())
                .frustration(req.frustration())
                .mentalDemandWeight(req.mentalDemandWeight())
                .physicalDemandWeight(req.physicalDemandWeight())
                .temporalDemandWeight(req.temporalDemandWeight())
                .performanceWeight(req.performanceWeight())
                .effortWeight(req.effortWeight())
                .frustrationWeight(req.frustrationWeight())
                .stressLevel(level)
                .recommendation(recommendation)
                .notes(req.notes())
                .submittedAt(LocalDateTime.now())
                .build());

        return map(saved);
    }

    public List<SurveyDtos.Response> mine(String email) {
        User u = users.findByEmail(email).orElseThrow();
        return surveys.findByEmployeeIdOrderBySubmittedAtDesc(u.getId()).stream().map(this::map).toList();
    }

    private SurveyDtos.Response map(Survey s) {
        return new SurveyDtos.Response(s.getId(), s.getStressScore(), s.getWorkloadScore(), s.getNasaTlxScore(),
                s.getMentalDemand(), s.getPhysicalDemand(), s.getTemporalDemand(), s.getPerformance(),
                s.getEffort(), s.getFrustration(), s.getMentalDemandWeight(), s.getPhysicalDemandWeight(),
                s.getTemporalDemandWeight(), s.getPerformanceWeight(), s.getEffortWeight(), s.getFrustrationWeight(),
                s.getStressLevel().name(), s.getRecommendation(), s.getNotes(), s.getSubmittedAt().toString());
    }
}
