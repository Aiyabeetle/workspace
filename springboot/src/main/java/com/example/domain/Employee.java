package com.example.domain;

/**
 * Created by aiyabeetle on 2017/6/19.
 */
public class Employee {

    private String userName;
    private int salary;
    private int birthday;

    public Employee(String userName, int salary, int birthday) {
        this.userName = userName;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userName='" + userName + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}
