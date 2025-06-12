CREATE TABLE mst_cars (
       id SERIAL PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       brand_id INT REFERENCES mst_brands(id) NULL,

       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
       created_by VARCHAR(255) NULL,
       updated_at TIMESTAMP,
       updated_by VARCHAR(255),
       is_active BOOLEAN DEFAULT TRUE,
       is_delete BOOLEAN NOT NULL DEFAULT FALSE,
       deleted_by VARCHAR(36),
       deleted_at TIMESTAMP
);