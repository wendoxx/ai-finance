CREATE TABLE expense (
    id UUID PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    description VARCHAR(255)
    user_id UUID NOT NULL,
    CONSTRAINT fk_user_expense FOREIGN KEY (user_id) REFERENCES users(id)
);