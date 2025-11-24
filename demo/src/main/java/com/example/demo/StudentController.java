package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/students")
@RestController
public class StudentController {

    @PostMapping("")
    public String create(@RequestBody @Valid Student student) {
        return "Student created successfully";
    }

    @GetMapping("{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId) {
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
