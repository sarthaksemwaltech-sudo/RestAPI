package com.RestAPI.StudentManagementSystem.Controller;


import com.RestAPI.StudentManagementSystem.DTO.StudentDTO;
import com.RestAPI.StudentManagementSystem.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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


    //Endpoint to get the student by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO>getStudentbyID(@PathVariable Long id){

        return new ResponseEntity<>(studentService.getStudentByIdService(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<StudentDTO>updateStudent(@PathVariable Long id,@RequestBody StudentDTO studentDTO){

        return new ResponseEntity<>(studentService.updateStudentService(id,studentDTO),HttpStatus.OK);

    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean>deleteStudent(@PathVariable Long id){

        return new ResponseEntity<>(studentService.deleteStudentService(id),HttpStatus.ACCEPTED);
    }

}
