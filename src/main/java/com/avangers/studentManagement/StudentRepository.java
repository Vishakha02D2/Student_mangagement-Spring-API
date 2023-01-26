package com.avangers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int id){
        return db.get(id);
    }

    public String addStudent( Student student){
        int id = student.getAdmnNo();
        db.put(id,student);
        return "Student added successsfully";
    }
    public String deleteStudent ( int id ){
        if(!db.containsKey(id))
            return "invalid id";

        db.remove(id) ;
        return "Successfully remove from HashMap " ;
    }
    public String updateStudent ( int id ,int age ){
        if(!db.containsKey(id))
            return "invalid id";

        db.get(id).setAge(22);
        return "Your age updated successfully" ;
    }
}
