-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V2__create_users_table.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Creates users table
-- --------------------------------------------------------------------

CREATE TABLE users
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    email VARCHAR(150) NOT NULL UNIQUE,

    phone_number VARCHAR(30),

    password VARCHAR(255) NOT NULL,

    role VARCHAR(50),

    enabled BOOLEAN DEFAULT TRUE,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100)
);