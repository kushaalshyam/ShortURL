package com.kushaal.ShortURL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "url_mapping")
@Getter
@Setter
@NoArgsConstructor
public class UrlMapping {

    // allocationSize must match the sequence's INCREMENT BY (1) or Hibernate's ID math drifts.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_id_gen")
    @SequenceGenerator(name = "url_id_gen", sequenceName = "url_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "short_code", nullable = false, unique = true, length = 16)
    private String shortCode;

    @Column(name = "long_url", nullable = false, columnDefinition = "TEXT")
    private String longUrl;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
}
