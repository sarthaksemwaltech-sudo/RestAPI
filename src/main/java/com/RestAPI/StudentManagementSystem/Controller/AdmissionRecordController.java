package com.RestAPI.StudentManagementSystem.Controller;


import com.RestAPI.StudentManagementSystem.DTO.AdmissionRecordDTO;
import com.RestAPI.StudentManagementSystem.Services.AdmissionRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdmissionRecords")
public class AdmissionRecordController {


    //DI variable
    private final AdmissionRecordService admissionRecordService;


    //Dependancy Injection
    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {

        this.admissionRecordService = admissionRecordService;

    }


    //Endpoint to insert the admission record
    @PostMapping()
    public ResponseEntity<AdmissionRecordDTO> insertAdmissionRecord(@RequestBody AdmissionRecordDTO admissionRecordDTO){

        AdmissionRecordDTO response = admissionRecordService.insertAdmissionRecord(admissionRecordDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    //EndPoint to Get All Admission Records

    @GetMapping()
    public ResponseEntity<List<AdmissionRecordDTO>> getAllAdmissionRecords(){

        return new ResponseEntity<>(admissionRecordService.getAllAdmissionRecordService(), HttpStatus.OK);
    }


    //Endpoint to get the admission record by ID

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdmissionRecordDTO> getAdmissionRecordbyID(@PathVariable Long id){

        return new ResponseEntity<>(admissionRecordService.getAdmissionRecordByIdService(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<AdmissionRecordDTO> updateAdmissionRecord(@PathVariable Long id, @RequestBody AdmissionRecordDTO admissionRecordDTO){

        return new ResponseEntity<>(admissionRecordService.updateAdmissionRecordService(id, admissionRecordDTO), HttpStatus.OK);

    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> deleteAdmissionRecord(@PathVariable Long id){

        return new ResponseEntity<>(admissionRecordService.deleteAdmissionRecordService(id), HttpStatus.ACCEPTED);
    }

}