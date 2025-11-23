package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/students")
@RestController
public class StudentController {

    @PostMapping("")
    public String create(@RequestBody Student student) {
        return "Create Student";
    }

    @GetMapping("{studentId}")
    public String read(@PathVariable Integer studentId) {
        return "Get Student";
    }

    @PutMapping("{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody  Student student) {
        return "Update Student";
    }

    @DeleteMapping("{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "Delete Student";
    }
}
