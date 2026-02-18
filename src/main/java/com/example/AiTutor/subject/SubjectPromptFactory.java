package com.example.AiTutor.subject;

import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class SubjectPromptFactory {

    private final Map<SubjectType, SubjectPromptStrategy> map =
            new EnumMap<>(SubjectType.class);

    public SubjectPromptFactory(
            MathsTeacher maths,
            PhysicsTeacher physics,
            ChemistryTeacher chemistry) {

        map.put(SubjectType.MATHS, maths);
        map.put(SubjectType.PHYSICS, physics);
        map.put(SubjectType.CHEMISTRY, chemistry);
    }

    public SubjectPromptStrategy getTeacher(SubjectType subject) {
        return map.get(subject);
    }
}

