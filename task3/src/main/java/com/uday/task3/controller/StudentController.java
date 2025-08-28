package com.uday.task3.controller;

import com.uday.task3.model.Student;
import com.uday.task3.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", repo.findAll());
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/students";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        repo.save(existing);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/students";
    }
}
