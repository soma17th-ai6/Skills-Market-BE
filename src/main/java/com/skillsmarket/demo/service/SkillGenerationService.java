package com.skillsmarket.demo.service;

import com.skillsmarket.demo.domain.GenerationStatus;
import com.skillsmarket.demo.domain.SkillGenerationRequest;
import com.skillsmarket.demo.dto.SkillGenerateResponse;
import com.skillsmarket.demo.repository.SkillGenerationRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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

    @Async("skillGenerationExecutor")
    @Transactional
    public void runPipeline(Long requestId) {
        log.info("Starting skill generation pipeline for requestId={}", requestId);

        SkillGenerationRequest request = skillGenerationRequestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found: " + requestId));

        try {
            // Step 1: Clarifying
            request.updateStatus(GenerationStatus.CLARIFYING);
            skillGenerationRequestRepository.save(request);
            log.info("Pipeline step CLARIFYING for requestId={}", requestId);

            // Step 2: Generating
            request.updateStatus(GenerationStatus.GENERATING);
            skillGenerationRequestRepository.save(request);
            log.info("Pipeline step GENERATING for requestId={}", requestId);

            // Step 3: Reviewing
            request.updateStatus(GenerationStatus.REVIEWING);
            skillGenerationRequestRepository.save(request);
            log.info("Pipeline step REVIEWING for requestId={}", requestId);

            // Step 4: Refining
            request.updateStatus(GenerationStatus.REFINING);
            skillGenerationRequestRepository.save(request);
            log.info("Pipeline step REFINING for requestId={}", requestId);

            // Step 5: Completed
            request.updateStatus(GenerationStatus.COMPLETED);
            skillGenerationRequestRepository.save(request);
            log.info("Pipeline COMPLETED for requestId={}", requestId);

        } catch (Exception e) {
            log.error("Pipeline FAILED for requestId={}", requestId, e);
            request.updateStatus(GenerationStatus.FAILED);
            skillGenerationRequestRepository.save(request);
        }
    }
}
