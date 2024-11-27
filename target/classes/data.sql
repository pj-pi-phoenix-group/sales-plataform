-- Create the product table if it doesn't exist
CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (name, number, email, password)
VALUES
('Eduardo Mendes', '1234567890', 'eduardo.mendess@icloud.com', 'password123');

CREATE TABLE IF NOT EXISTS product (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO product (description, brand, category, quantity, price, status, user_id)
VALUES
('Redmi Note 12', 'Xiomi', 'Electronics', 100, 1300.00, 'ACTIVE', 1),
('Iphone 16', 'Apple', 'Electronics', 50, 6000.78, 'ACTIVE', 1),
('Air Dots', 'Apple', 'Electronics', 200, 19.99, 'ACTIVE', 1);
