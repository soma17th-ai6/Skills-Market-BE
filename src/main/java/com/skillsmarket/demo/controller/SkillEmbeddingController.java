package com.skillsmarket.demo.controller;

import com.skillsmarket.demo.dto.SimilarSkillResponses;
import com.skillsmarket.demo.service.SkillEmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillEmbeddingController {

    private final SkillEmbeddingService skillEmbeddingService;

    @PostMapping("/embed-all")
    public ResponseEntity<Void> embedAllSkills() {
        skillEmbeddingService.embedAllSkills();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recommendation")
    public ResponseEntity<SimilarSkillResponses> searchSimilarSkills(
            @RequestParam String query,
            @RequestParam(defaultValue = "3") int topK
    ) {
        SimilarSkillResponses results = skillEmbeddingService.findSimilarSkills(query, topK);
        return ResponseEntity.ok(results);
    }
}
