package com.Matazor.school;

import lombok.Builder;

import java.util.List;
@Builder

public class FullSchoolResponse {
    private String name;
    private String email;
    List<Students> students;

}
