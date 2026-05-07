package com.skillsmarket.demo.repository;

import com.skillsmarket.demo.domain.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
}
