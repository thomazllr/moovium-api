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

CREATE TABLE "user"
(
    id            UUID PRIMARY KEY NOT NULL,
    email         VARCHAR(255)     NOT NULL UNIQUE,
    password_hash VARCHAR(255)     NOT NULL,
    full_name     VARCHAR(255)     NOT NULL,
    nickname      VARCHAR(50),
    avatar_url    VARCHAR(255),
    bio           TEXT,
    role          VARCHAR(20)      NOT NULL CHECK (role IN ('CUSTOMER', 'EMPLOYEE', 'ADMIN')),
    status        VARCHAR(20) DEFAULT 'active',
    created_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE friendship
(
    id         UUID PRIMARY KEY NOT NULL,
    user_id_1  UUID             NOT NULL REFERENCES "user" (id),
    user_id_2  UUID             NOT NULL REFERENCES "user" (id),
    status     VARCHAR(20)      NOT NULL CHECK (status IN ('PENDING', 'ACCEPTED', 'REJECTED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id_1, user_id_2)
);

CREATE TABLE movie_recommendation
(
    id           UUID PRIMARY KEY NOT NULL,
    from_user_id UUID             NOT NULL REFERENCES "user" (id),
    to_user_id   UUID             NOT NULL REFERENCES "user" (id),
    movie_id     UUID             NOT NULL REFERENCES movie (id),
    message      TEXT,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE session_group
(
    id         UUID PRIMARY KEY NOT NULL,
    name       VARCHAR(255)     NOT NULL,
    creator_id UUID             NOT NULL REFERENCES "user" (id),
    session_id UUID             NOT NULL REFERENCES session (id),
    status     VARCHAR(20) CHECK (status IN ('PLANNING', 'CONFIRMED', 'CANCELLED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE session_group_member
(
    id         UUID PRIMARY KEY NOT NULL,
    group_id   UUID             NOT NULL REFERENCES session_group (id),
    user_id    UUID             NOT NULL REFERENCES "user" (id),
    status     VARCHAR(20) CHECK (status IN ('INVITED', 'ACCEPTED', 'DECLINED')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (group_id, user_id)
);

CREATE TABLE ticket
(
    id             UUID PRIMARY KEY NOT NULL,
    reservation_id UUID             NOT NULL REFERENCES seat_reservation (id),
    user_id        UUID             NOT NULL REFERENCES "user"(id),
    price          DECIMAL(18, 2)   NOT NULL,
    qr_code        text             NOT NULL,
    status_ticket         VARCHAR(20)      NOT NULL CHECK (status_ticket IN ('VALID', 'USED', 'CANCELLED', 'EXPIRED')),
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);