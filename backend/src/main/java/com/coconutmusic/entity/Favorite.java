package com.coconutmusic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorites",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "music_id"}))
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "music_id", nullable = false)
    private Music music;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Constructors
    public Favorite() {}

    public Favorite(User user, Music music) {
        this.user = user;
        this.music = music;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Music getMusic() { return music; }
    public void setMusic(Music music) { this.music = music; }    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // Helper methods for IDs
    public Long getUserId() { return user != null ? user.getId() : null; }
    public Long getMusicId() { return music != null ? music.getId() : null; }
    public void setUserId(Long userId) {
        // This is used for direct database operations in test endpoints
        // In production, always use setUser() with proper User entity
    }
    public void setMusicId(Long musicId) {
        // This is used for direct database operations in test endpoints
        // In production, always use setMusic() with proper Music entity
    }
}
