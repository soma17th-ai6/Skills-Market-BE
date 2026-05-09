package com.skillsmarket.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.skillsmarket.demo.domain.GenerationStatus;
import com.skillsmarket.demo.domain.SkillGenerationRequest;
import com.skillsmarket.demo.repository.SkillGenerationRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class SkillGenerationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SkillGenerationRequestRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void 유효한_userPrompt_전송_시_202_반환_및_requestId_포함() throws Exception {
        mockMvc.perform(post("/skills/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"userPrompt": "Spring Boot REST API 스킬 만들어줘"}
                                """))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.requestId").isNotEmpty())
                .andExpect(jsonPath("$.status").value("PENDING"));
    }

    @Test
    void 빈_userPrompt_전송_시_400_반환() throws Exception {
        mockMvc.perform(post("/skills/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"userPrompt": "   "}
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void userPrompt_누락_시_400_반환() throws Exception {
        mockMvc.perform(post("/skills/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void 응답의_status가_PENDING인지_확인() throws Exception {
        mockMvc.perform(post("/skills/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"userPrompt": "React Hooks 스킬 만들어줘"}
                                """))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.status").value("PENDING"));
    }

    @Test
    void DB에_요청이_실제로_저장되었는지_확인() throws Exception {
        // when
        MvcResult result = mockMvc.perform(post("/skills/generate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"userPrompt": "Docker 스킬 만들어줘"}
                                """))
                .andExpect(status().isAccepted())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        Long requestId = com.fasterxml.jackson.databind.json.JsonMapper.builder().build()
                .readTree(responseBody).get("requestId").asLong();

        // then
        SkillGenerationRequest saved = repository.findById(requestId).orElseThrow();
        assertThat(saved.getUserPrompt()).isEqualTo("Docker 스킬 만들어줘");
        assertThat(saved.getStatus()).isEqualTo(GenerationStatus.PENDING);
        assertThat(saved.getCreatedAt()).isNotNull();
    }
}
