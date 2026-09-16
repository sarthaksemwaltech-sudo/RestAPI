package com.RestAPI.StudentManagementSystem.Services;

import com.RestAPI.StudentManagementSystem.DTO.StudentDTO;
import com.RestAPI.StudentManagementSystem.Entity.StudentEntity;
import com.RestAPI.StudentManagementSystem.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    //Varible for the DI
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;



    //Dependancy injection

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }



    //Method to create the student inside the DB
    public StudentDTO insertStudent(StudentDTO studentDTO) {

       StudentEntity student=modelMapper.map(studentDTO,StudentEntity.class);

       studentRepository.save(student);

       return modelMapper.map(student,StudentDTO.class);
    }
}
