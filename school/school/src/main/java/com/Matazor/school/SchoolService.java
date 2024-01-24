package com.Matazor.school;

import com.Matazor.school.client.StudentClient;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class SchoolService {
    private final SchoolRepository schoolRepository;
    private StudentClient studentClient;
    public void SaveSchool(School school){
        schoolRepository.save(school);
    }
    public List<School> findAllSchool(){return schoolRepository.findAll();}


    public FullSchoolResponse GetSchoolswithStudents(Integer school_id) {
        var school=schoolRepository.findById(school_id)
                .orElse(School.builder()
                        .name("NotFound")
                        .email("NotFound")
                        .build());
        var students=studentClient.findAllStudentsBySchool(school_id);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
