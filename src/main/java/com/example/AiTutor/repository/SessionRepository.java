package com.example.AiTutor.repository;

import com.example.AiTutor.model.LearningSession;
import com.example.AiTutor.subject.SubjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<LearningSession, Long> {

    /**
     * Find active session for a student and subject
     * (Used to maintain subject-wise memory)
     */
    @Query("""
        SELECT s FROM LearningSession s
        WHERE s.studentId = :studentId
          AND s.subject = :subject
          AND s.active = true
    """)
    Optional<LearningSession> findActiveSession(
            @Param("studentId") Long studentId,
            @Param("subject") SubjectType subject
    );

    /**
     * Optional: Find any active session for student
     * (Useful when switching subject)
     */
    Optional<LearningSession> findByStudentIdAndActiveTrue(Long studentId);
}
