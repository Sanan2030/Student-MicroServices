package com.Matazor.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {
    private final StudentRepository studentRepository;
    public void SaveStudents(Student student){
        studentRepository.save(student);
    }
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }  public List<Student> findAllStudentsById(Integer school_id){
        return studentRepository.findAllById(school_id);
    }


}
