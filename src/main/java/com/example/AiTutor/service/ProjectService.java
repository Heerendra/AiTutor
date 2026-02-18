package com.example.AiTutor.service;

import com.example.AiTutor.model.AppGenerationRequest;
import com.example.AiTutor.model.ProjectEntity;
import com.example.AiTutor.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repo;

    public ProjectEntity create(AppGenerationRequest req) {
        ProjectEntity p = new ProjectEntity();
        p.setAppName(req.getAppName());
        p.setTechStack(req.getTechStack());
        p.setStatus("CREATED");
        p.setCreatedAt(LocalDateTime.now());
        return repo.save(p);
    }

    public void complete(Long projectId) {
        ProjectEntity p = repo.findById(projectId).orElseThrow(null);
        p.setStatus("COMPLETED");
        repo.save(p);
    }

    public ProjectEntity get(Long id) {
        return repo.findById(id).orElseThrow();
    }
}

