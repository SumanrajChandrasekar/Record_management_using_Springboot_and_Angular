package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.entity.Student;
import com.project.repository.StudentRepository;


@Service
public class StudentService {

    private final StudentRepository repo;
    
    public StudentService(StudentRepository repo) {
    	this.repo=repo;
    }

    public ResponseEntity<String> postStudent(Student student) {
        repo.save(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Student added successfully");
    }
    public List<Student> getAllStudent(){
    	return repo.findAll();
		
	}
    @GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student student=repo.findById(id).get();
		return student;
		
	}
    
    public Student getStudentById(int id) {
    	return repo.findById(id).orElse(null);
    }
    
    public ResponseEntity<String> updateStudent(int id, Student student) {
        Optional<Student> optionStudent = repo.findById(id);
        
        if (optionStudent.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student not found with id " + id);
        }

        Student existStudent = optionStudent.get();
        existStudent.setStudentName(student.getStudentName());
        existStudent.setDepartment(student.getDepartment());
        existStudent.setDob(student.getDob());
        existStudent.setEmail(student.getEmail());
        existStudent.setNativePlace(student.getNativePlace());
        existStudent.setPhoneNo(student.getPhoneNo());

        repo.save(existStudent);
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Student updated successfully");
    }
    
    public void deleteStudent(int id) {
    	repo.deleteById(id);
    }
}