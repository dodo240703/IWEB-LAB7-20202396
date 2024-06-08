package com.example.practicandocrud.Beans;


import java.sql.Date;

public class Employee {
    private int employeeId;
    private String fullNameEmployee;
    private String emailEmployee;
    private String passwordEmployee;
    private String phoneEmployee;
    private Date hireDateEmployee;
    private String job_id;
    private double salaryEmployee;
    private double commissionPctEmployee;
    private int manangerId;
    private int departmentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(String fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getPasswordEmployee() {
        return passwordEmployee;
    }

    public void setPasswordEmployee(String passwordEmployee) {
        this.passwordEmployee = passwordEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public Date getHireDateEmployee() {
        return hireDateEmployee;
    }

    public void setHireDateEmployee(Date hireDateEmployee) {
        this.hireDateEmployee = hireDateEmployee;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public double getCommissionPctEmployee() {
        return commissionPctEmployee;
    }

    public void setCommissionPctEmployee(double commissionPctEmployee) {
        this.commissionPctEmployee = commissionPctEmployee;
    }

    public int getManangerId() {
        return manangerId;
    }

    public void setManangerId(int manangerId) {
        this.manangerId = manangerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


}
