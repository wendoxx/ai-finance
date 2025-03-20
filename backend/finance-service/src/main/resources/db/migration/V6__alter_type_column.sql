-- V6__alter_type_column.sql
ALTER TABLE expense ALTER COLUMN type DROP DEFAULT;

ALTER TABLE expense
ALTER COLUMN type TYPE smallint
USING CASE
    WHEN type = 'FOOD' THEN 1
    WHEN type = 'TRANSPORT' THEN 2
    WHEN type = 'ENTERTAINMENT' THEN 3
    WHEN type = 'SHOPPING' THEN 4
    WHEN type = 'AESTHETIC' THEN 5
    WHEN type = 'HEALTH' THEN 6
    WHEN type = 'EDUCATION' THEN 7
    WHEN type = 'OTHER' THEN 8
    ELSE NULL
END;

DROP TYPE expense_type;