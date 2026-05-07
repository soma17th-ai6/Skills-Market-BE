package com.skillsmarket.demo.dto;

import org.springframework.ai.document.Document;

public record SimilarSkillResponse(
        long id,
        String title,
        String description,
        Double percentage
) {

    public SimilarSkillResponse(Document document) {
        this(
                ((Number) document.getMetadata().get("skillId")).longValue(),
                (String) document.getMetadata().get("title"),
                (String) document.getMetadata().get("description"),
                document.getScore()
        );
    }
}
