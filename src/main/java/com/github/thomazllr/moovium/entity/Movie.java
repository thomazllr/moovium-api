package com.github.thomazllr.moovium.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String synopsis;

    private Integer duration;

    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String ageRating;

    private String posterUrl;

    private Boolean isFeatured;

    private LocalDate featuredUntil;

    private String status;

    @OneToMany(mappedBy = "movie")
    private List<Session> sessions;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
