package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("detail")
@RestController
public class MyController {

    @RequestMapping("/test1")
    public String test1(@RequestParam  Integer id,
                        @RequestParam(required = false) String name) {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return id + name;
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        return student.getId() + " " + student.getName();
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader(name="Content-Type") String contentType) {
        return contentType;
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                         @PathVariable String name) {
        return id + " " + name;
    }



    @PostMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        store.setProductList(list);
        return store;
    }

    @PostMapping("user")
    public Student user() {
        Student student = new Student();
        student.setName("Judy");
        return student;
    }
}
