package com.skillsmarket.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class SkillGenerationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String userPrompt;

    @Column(columnDefinition = "TEXT")
    private String clarifiedRequirements;

    @Column(columnDefinition = "TEXT")
    private String generatedSkillContent;

    @Column(columnDefinition = "TEXT")
    private String reviewFeedback;

    @Column(columnDefinition = "TEXT")
    private String finalSkillContent;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private GenerationStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static SkillGenerationRequest create(String userPrompt) {
        SkillGenerationRequest request = new SkillGenerationRequest();
        request.userPrompt = userPrompt;
        request.status = GenerationStatus.PENDING;
        return request;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
