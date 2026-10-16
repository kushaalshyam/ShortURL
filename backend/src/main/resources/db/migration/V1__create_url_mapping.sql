CREATE SEQUENCE url_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE url_mapping (
    id         BIGINT       PRIMARY KEY,
    short_code VARCHAR(16)  NOT NULL,
    long_url   TEXT         NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE UNIQUE INDEX idx_url_mapping_short_code ON url_mapping (short_code);
