CREATE TABLE ticket (
                        id UUID PRIMARY KEY NOT NULL,
                        session_id UUID NOT NULL,
                        seat_number VARCHAR(255) NOT NULL,
                        price DECIMAL(18, 2) NOT NULL,
                        is_sold BOOLEAN NOT NULL,
                        qr_code VARCHAR(255) NOT NULL,
                        FOREIGN KEY (session_id) REFERENCES session(id)
);
