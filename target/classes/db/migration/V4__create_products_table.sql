-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V4__create_products_table.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Creates products table
-- --------------------------------------------------------------------

CREATE TABLE products
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(255) NOT NULL,

    slug VARCHAR(255) UNIQUE,

    description TEXT,

    short_description VARCHAR(500),

    price DECIMAL(19,2) NOT NULL,

    discount_price DECIMAL(19,2),

    stock_quantity INTEGER DEFAULT 0,

    sku VARCHAR(255) UNIQUE,

    featured BOOLEAN DEFAULT FALSE,

    thumbnail_url VARCHAR(500),

    vendor_id BIGINT,

    category_id BIGINT,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_product_vendor
        FOREIGN KEY (vendor_id)
            REFERENCES users(id),

    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id)
            REFERENCES categories(id)
);