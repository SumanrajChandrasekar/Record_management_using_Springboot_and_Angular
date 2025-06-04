package com.project.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Crud")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String studentName;

    @Column
    private String phoneNo;

    @Column
    private String nativePlace;

    @Column
    private String email;

    @Column
    private LocalDate dob;

    @Column
    private String department;
    public Student() {
        
    }

    public Student(String studentName, String phoneNo, String nativePlace, String email, LocalDate dob, String department) {
        this.studentName = studentName;
        this.phoneNo = phoneNo;
        this.nativePlace = nativePlace;
        this.email = email;
        this.dob = dob;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student [id=" + id 
            + ", studentName=" + studentName 
            + ", phoneNo=" + phoneNo 
            + ", nativePlace=" + nativePlace 
            + ", email=" + email 
            + ", dob=" + dob 
            + ", department=" + department + "]";
    }
}
