package com.Matazor.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student ){
        studentService.SaveStudents(student);

    }
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    } @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> getStudents(@PathVariable("school-id") Integer school_id){
        return ResponseEntity.ok(studentService.findAllStudentsById(school_id));
    }

}