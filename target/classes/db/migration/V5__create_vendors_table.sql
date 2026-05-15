-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V5__create_vendors_table.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Creates vendors table
-- --------------------------------------------------------------------

CREATE TABLE vendors
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    business_name VARCHAR(255) NOT NULL,

    slug VARCHAR(255) UNIQUE,

    description TEXT,

    phone_number VARCHAR(30),

    email_address VARCHAR(150),

    address VARCHAR(255),

    city VARCHAR(100),

    country VARCHAR(100),

    logo_url VARCHAR(500),

    banner_url VARCHAR(500),

    whatsapp_number VARCHAR(30),

    vendor_status VARCHAR(50),

    user_id BIGINT UNIQUE,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_vendor_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
);