package com.RestAPI.StudentManagementSystem.Controller;


import com.RestAPI.StudentManagementSystem.DTO.SubjectDTO;
import com.RestAPI.StudentManagementSystem.Services.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Subjects")
public class SubjectController {


    //DI variable
    private final SubjectService subjectService;



    //Dependancy Injection
    public SubjectController(SubjectService subjectService) {

        this.subjectService = subjectService;

    }



    //Endpoint to insert the subject
    @PostMapping()
    public ResponseEntity<SubjectDTO> insertSubject(@RequestBody SubjectDTO subjectDTO){

        SubjectDTO response = subjectService.insertSubject(subjectDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    //EndPoint to Get All Subjects

    @GetMapping()
    public ResponseEntity<List<SubjectDTO>> getAllSubjects(){

        return new ResponseEntity<>(subjectService.getAllSubjectService(), HttpStatus.OK);
    }


    //Endpoint to get the subject by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubjectDTO> getSubjectbyID(@PathVariable Long id){

        return new ResponseEntity<>(subjectService.getSubjectByIdService(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO){

        return new ResponseEntity<>(subjectService.updateSubjectService(id, subjectDTO), HttpStatus.OK);

    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> deleteSubject(@PathVariable Long id){

        return new ResponseEntity<>(subjectService.deleteSubjectService(id), HttpStatus.ACCEPTED);
    }

}