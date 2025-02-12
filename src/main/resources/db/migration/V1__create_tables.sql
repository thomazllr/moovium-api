CREATE TABLE movie
(
    id             UUID         NOT NULL PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    synopsis       TEXT,
    duration       INTEGER      NOT NULL,
    release_date   DATE         NOT NULL,
    genre          VARCHAR(100) CHECK (genre IN
                                       ('ACTION', 'ADVENTURE', 'ANIMATION', 'COMEDY', 'CRIME', 'DRAMA', 'FANTASY',
                                        'HORROR', 'MYSTERY', 'ROMANCE', 'SCI_FI', 'THRILLER', 'DOCUMENTARY', 'MUSICAL',
                                        'WAR', 'WESTERN')),
    age_rating     VARCHAR(10),
    poster_url     VARCHAR(255),
    status         VARCHAR(20) DEFAULT 'active',
    is_featured    BOOLEAN     DEFAULT FALSE,
    featured_until DATE,
    created_at     TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE theater
(
    id         UUID PRIMARY KEY NOT NULL,
    name       VARCHAR(255)     NOT NULL,
    capacity   INTEGER,
    room_type  VARCHAR(10)      NOT NULL CHECK (room_type IN ('IMAX', 'XD', 'D-BOX')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE seat
(
    id          UUID PRIMARY KEY NOT NULL,
    theater_id  UUID             NOT NULL REFERENCES theater (id),
    seat_number VARCHAR(2)       NOT NULL,
    row         VARCHAR(2)       NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (theater_id, row, seat_number)
);

CREATE TABLE session
(
    id           UUID PRIMARY KEY NOT NULL,
    movie_id     UUID REFERENCES movie (id),
    theater_id   UUID             NOT NULL REFERENCES theater (id),
    session_time TIMESTAMP        NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE seat_reservation
(
    id                     UUID PRIMARY KEY NOT NULL,
    session_id             UUID             NOT NULL REFERENCES session (id),
    seat_id                UUID             NOT NULL REFERENCES seat (id),
    status                 VARCHAR(10)      NOT NULL CHECK (status IN ('AVAILABLE', 'RESERVED', 'SOLD')),
    reservation_expiration TIMESTAMP        NOT NULL,
    created_at             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at             TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (session_id, seat_id)
);

CREATE TABLE ticket
(
    id             UUID PRIMARY KEY NOT NULL,
    reservation_id UUID             NOT NULL REFERENCES seat_reservation (id),
    price          DECIMAL(18, 2)   NOT NULL,
    qr_code        text     NOT NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);