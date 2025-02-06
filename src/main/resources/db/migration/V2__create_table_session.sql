CREATE TABLE session (
                         id UUID not null primary key,
                         movie_id UUID REFERENCES movie(id),
                         session_time TIMESTAMP NOT NULL,
                         seats_available INTEGER,
                         total_seats INTEGER,
                         theater_name VARCHAR(255),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
