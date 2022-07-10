package com.bluetree.office.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee", uniqueConstraints = {@UniqueConstraint(name = "email_unique",columnNames = {"email"})})
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private Date dob;
    private int age;
    private double salary;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
     this.age=this.dob.getYear();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee() {
    }

    public Employee(int id, String name, String email, Date dob, int age, double salary, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = dob.getYear();
        this.salary = salary;
        this.status = status;
    }
}
