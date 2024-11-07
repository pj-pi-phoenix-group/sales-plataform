-- Create the product table if it doesn't exist
CREATE TABLE IF NOT EXISTS product (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL
);

INSERT INTO product (description, brand, category, quantity, price, status)
VALUES
('Redmi Note 12', 'Xiomi', 'Electronics', 100, 1300.00, 'ACTIVE'),
('Iphone 16', 'Apple', 'Electronics', 50, 6000.78, 'ACTIVE'),
('Air Dots', 'Apple', 'Electronics', 200, 19.99, 'ACTIVE');
