package com.avangers.studentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    //get information by admnno
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q")int admnNo){
        return db.get(admnNo);
    }
    //adding the information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        int admnNo = student.getAdmnNo();
        db.put(admnNo,student);
        return "Student added successsfully";
    }
    //get information by name

    @GetMapping("/get_student_byname")
    public Student getStudent(@RequestParam("q")String name){
        return db.get(name);
    }
    //Delete information using Id :-->>
    @DeleteMapping("/delete_student")
    public String deleteStudent ( @RequestParam("q") int admnNo ){
        db.remove(admnNo) ;
        return "Successfully remove from HashMap " ;
    }

    // Update the Information :-->>
    @PutMapping("/update_student")
    public String updateStudent (@RequestParam("q") int admnNo , @RequestBody Student student ){
        db.put(admnNo , student) ;
        return "Your Name updated successfully" ;
    }
}
