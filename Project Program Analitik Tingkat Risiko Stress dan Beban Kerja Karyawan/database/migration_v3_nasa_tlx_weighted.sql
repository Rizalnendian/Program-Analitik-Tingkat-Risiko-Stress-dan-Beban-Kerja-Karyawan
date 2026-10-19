-- Jalankan pada database analitik_beban_kerja yang sudah ada.
USE analitik_beban_kerja;

ALTER TABLE surveys ADD COLUMN nasa_tlx_score INT NULL;
ALTER TABLE surveys ADD COLUMN mental_demand INT NULL;
ALTER TABLE surveys ADD COLUMN physical_demand INT NULL;
ALTER TABLE surveys ADD COLUMN temporal_demand INT NULL;
ALTER TABLE surveys ADD COLUMN performance INT NULL;
ALTER TABLE surveys ADD COLUMN effort INT NULL;
ALTER TABLE surveys ADD COLUMN frustration INT NULL;
ALTER TABLE surveys ADD COLUMN mental_demand_weight INT NULL;
ALTER TABLE surveys ADD COLUMN physical_demand_weight INT NULL;
ALTER TABLE surveys ADD COLUMN temporal_demand_weight INT NULL;
ALTER TABLE surveys ADD COLUMN performance_weight INT NULL;
ALTER TABLE surveys ADD COLUMN effort_weight INT NULL;
ALTER TABLE surveys ADD COLUMN frustration_weight INT NULL;
