package com.skillsmarket.demo.service;

import com.skillsmarket.demo.domain.SkillGenerationRequest;
import com.skillsmarket.demo.dto.SkillGenerateResponse;
import com.skillsmarket.demo.repository.SkillGenerationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SkillGenerationService {

    private final SkillGenerationRequestRepository skillGenerationRequestRepository;

    @Transactional
    public SkillGenerateResponse submitGenerationRequest(String userPrompt) {
        SkillGenerationRequest request = SkillGenerationRequest.create(userPrompt);
        SkillGenerationRequest saved = skillGenerationRequestRepository.save(request);
        return SkillGenerateResponse.from(saved);
    }
}
