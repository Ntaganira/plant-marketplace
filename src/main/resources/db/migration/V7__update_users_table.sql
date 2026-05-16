-- --------------------------------------------------------------------
-- Project      : Rwanda Plant Marketplace
-- File         : V7__update_users_table.sql
-- Author       : Heritier Ntaganira
-- Company      : NIHO TECHNOLOGIES LTD
-- Created Date : 2026-05-14
-- Description  : Updates users table for profile management
-- --------------------------------------------------------------------

ALTER TABLE users
ADD COLUMN profile_photo_url VARCHAR(500);

ALTER TABLE users
ADD COLUMN account_non_locked BOOLEAN DEFAULT TRUE;