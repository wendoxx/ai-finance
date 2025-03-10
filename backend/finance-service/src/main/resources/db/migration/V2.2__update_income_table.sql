CREATE TABLE income (
    id UUID PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    description VARCHAR(255)
);