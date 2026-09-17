package com.RestAPI.StudentManagementSystem.Services;

import com.RestAPI.StudentManagementSystem.DTO.StudentDTO;
import com.RestAPI.StudentManagementSystem.Entity.StudentEntity;
import com.RestAPI.StudentManagementSystem.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public List<StudentDTO> getAllStudentService() {

        List<StudentEntity>Students=studentRepository.findAll();

        return Students.
                stream().
                map(student->modelMapper.map(student,StudentDTO.class)).
                toList();
    }


    //Method to Get Student By ID

    public StudentDTO getStudentByIdService(Long id) {

        StudentEntity student=studentRepository.findById(id).orElseThrow();

        return modelMapper.map(student,StudentDTO.class);


    }


    //Method to Update Student
    public StudentDTO updateStudentService(Long id, StudentDTO studentDTO) {

        StudentEntity student =modelMapper.map(studentDTO,StudentEntity.class);

        student.setId(id);

        studentRepository.save(student);


        return modelMapper.map(student,StudentDTO.class);


    }


    //Method to Delete Student By ID

    public Boolean deleteStudentService(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new NoSuchElementException("Entity Not Found");
        }

        studentRepository.deleteById(id);

        return true;
    }
}
