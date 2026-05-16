-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V8__create_reviews_and_wishlist_tables.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Creates wishlist and review tables
-- --------------------------------------------------------------------

CREATE TABLE wishlist_items
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    user_id BIGINT,

    product_id BIGINT,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_wishlist_user
        FOREIGN KEY (user_id)
            REFERENCES users(id),

    CONSTRAINT fk_wishlist_product
        FOREIGN KEY (product_id)
            REFERENCES products(id)
);

CREATE TABLE product_reviews
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    product_id BIGINT,

    user_id BIGINT,

    review TEXT,

    rating INTEGER,

    status VARCHAR(30),

    created_at TIMESTAMP,

    updated_at TIMESTAMP,

    created_by VARCHAR(100),

    updated_by VARCHAR(100),

    CONSTRAINT fk_review_product
        FOREIGN KEY (product_id)
            REFERENCES products(id),

    CONSTRAINT fk_review_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
);