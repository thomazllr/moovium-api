CREATE TABLE movie (
                       id UUID NOT NULL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       synopsis TEXT,
                       duration INTEGER NOT NULL,
                       release_date DATE NOT NULL,
                       genre VARCHAR(100) CHECK (genre IN ('ACTION', 'ADVENTURE', 'ANIMATION', 'COMEDY', 'CRIME', 'DRAMA', 'FANTASY', 'HORROR', 'MYSTERY', 'ROMANCE', 'SCI_FI', 'THRILLER', 'DOCUMENTARY', 'MUSICAL', 'WAR', 'WESTERN')),
                       age_rating VARCHAR(10),
                       director VARCHAR(255),
                       poster_url VARCHAR(255),
                       status VARCHAR(20) DEFAULT 'active',
                       is_featured BOOLEAN DEFAULT FALSE,
                       featured_until DATE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
