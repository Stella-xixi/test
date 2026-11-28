package com.example.studentcrud.controller;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class SemesterSummaryController {

    private final StudentRepository repository;

    public SemesterSummaryController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/semesters")
    public String displaySummary(Model model) {
        Map<Integer, Long> studentCounts = repository.findAll().stream()
                .collect(Collectors.groupingBy(Student::getSemester, TreeMap::new, Collectors.counting()));

        model.addAttribute("studentCounts", studentCounts);
        return "semesterSummary";
    }
}
