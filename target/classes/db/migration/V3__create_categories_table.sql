-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V3__create_categories_table.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Creates categories table
-- --------------------------------------------------------------------

CREATE TABLE categories
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(255) NOT NULL UNIQUE,

    slug VARCHAR(255) UNIQUE,

    description TEXT,

    featured BOOLEAN DEFAULT FALSE,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100)
);