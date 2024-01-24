package com.Matazor.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        schoolService.SaveSchool(school);

    }
    @GetMapping
    public ResponseEntity<List<School>> getSchools(){
        return ResponseEntity.ok(schoolService.findAllSchool());
    }
    @GetMapping("/withStudents/{school-id}")
    public ResponseEntity<FullSchoolResponse> getSchools(@PathVariable Integer school_id){
        return ResponseEntity.ok(schoolService.GetSchoolswithStudents(school_id));
    }





}
