package com.RestAPI.StudentManagementSystem.Controller;


import com.RestAPI.StudentManagementSystem.DTO.StudentDTO;
import com.RestAPI.StudentManagementSystem.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {


    //DI variable
    private final StudentService studentService;


    //Dependancy Injection
    public StudentController(StudentService studentService) {

        this.studentService=studentService;

    }


    //Endpoint to insert the student
    @PostMapping()
    public ResponseEntity<StudentDTO> insertStudent(@RequestBody StudentDTO studentDTO){

        StudentDTO response=studentService.insertStudent(studentDTO);


        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }


    //EndPoint to Get All Students

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAllStudents(){

        return new ResponseEntity<>(studentService.getAllStudentService(),HttpStatus.OK);
    }

}
