package com.RestAPI.StudentManagementSystem.Controller;


import com.RestAPI.StudentManagementSystem.DTO.ProfessorDTO;
import com.RestAPI.StudentManagementSystem.DTO.StudentDTO;
import com.RestAPI.StudentManagementSystem.Services.ProfessorService;
import com.RestAPI.StudentManagementSystem.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;


    //Dependancy Injection
    public ProfessorController(ProfessorService professorService) {

      this.professorService = professorService;

    }


    //Endpoint to insert the student
    @PostMapping()
    public ResponseEntity<ProfessorDTO> insertprofessor(@RequestBody ProfessorDTO professorDTO){

        ProfessorDTO response=professorService.insertProfessorService(professorDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    //EndPoint to Get All Students

    @GetMapping()
    public ResponseEntity<List<ProfessorDTO>> getAllProfessor(){

        return new ResponseEntity<>(professorService.getAllProfessorService(),HttpStatus.OK);
    }


    //Endpoint to get the student by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO>getProfessorbyID(@PathVariable Long id){

        return new ResponseEntity<>(professorService.getProfessorByIdService(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO>updateProfessor(@PathVariable Long id,@RequestBody ProfessorDTO professorDTO){

        return new ResponseEntity<>(professorService.updateProfessorService(id,professorDTO),HttpStatus.OK);

    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean>deleteProfessor(@PathVariable Long id){

        return new ResponseEntity<>(professorService.deleteProfessorService(id),HttpStatus.ACCEPTED);
    }














}
