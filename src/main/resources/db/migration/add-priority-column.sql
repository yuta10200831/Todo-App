-- 既存のtasksテーブルにpriorityカラムを追加（カラムが存在する場合はスキップ）
SET @exists = (SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'tasks' AND COLUMN_NAME = 'priority');
SET @sql = IF(@exists = 0, 'ALTER TABLE tasks ADD COLUMN priority VARCHAR(10) NOT NULL DEFAULT ''MEDIUM''', 'SELECT 1');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
