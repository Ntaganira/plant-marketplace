-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V6__create_cart_and_order_tables.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Creates cart and order tables
-- --------------------------------------------------------------------

CREATE TABLE carts
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    user_id BIGINT UNIQUE,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_cart_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
);

CREATE TABLE cart_items
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    cart_id BIGINT,

    product_id BIGINT,

    quantity INTEGER,

    unit_price DECIMAL(19,2),

    total_price DECIMAL(19,2),

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_cart_item_cart
        FOREIGN KEY (cart_id)
            REFERENCES carts(id),

    CONSTRAINT fk_cart_item_product
        FOREIGN KEY (product_id)
            REFERENCES products(id)
);

CREATE TABLE orders
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    order_number VARCHAR(255) UNIQUE,

    customer_id BIGINT,

    vendor_id BIGINT,

    total_amount DECIMAL(19,2),

    delivery_address VARCHAR(500),

    customer_phone_number VARCHAR(30),

    order_status VARCHAR(50),

    whatsapp_message TEXT,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_order_customer
        FOREIGN KEY (customer_id)
            REFERENCES users(id),

    CONSTRAINT fk_order_vendor
        FOREIGN KEY (vendor_id)
            REFERENCES vendors(id)
);

CREATE TABLE order_items
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    order_id BIGINT,

    product_id BIGINT,

    quantity INTEGER,

    unit_price DECIMAL(19,2),

    total_price DECIMAL(19,2),

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_order_item_order
        FOREIGN KEY (order_id)
            REFERENCES orders(id),

    CONSTRAINT fk_order_item_product
        FOREIGN KEY (product_id)
            REFERENCES products(id)
);