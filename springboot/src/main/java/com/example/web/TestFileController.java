package com.example.web;

import com.example.domain.Employee;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by aiyabeetle on 2017/6/19.
 */
public class TestFileController {

    public static  void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("tom",75000,1987);
        staff[1] = new Employee("jack",50000,1989);
        staff[2] = new Employee("merry",40000,1990);

        //将雇员信息保存到employye.txt文件中
        try (PrintWriter out = new PrintWriter("F:\\employee.txt","UTF-8")){
            writeData(staff,out);
        }

        try (Scanner in = new Scanner(new FileInputStream("F:\\employee.txt"),"UTF-8")){
            Employee[] newStaff = readData(in);
            for (Employee e:newStaff) {
                System.out.println(e);
            }
        }

        //遍历字符编码
        Charset cset = Charset.forName("ISO-8859-1");
        Set<String> aliases = cset.aliases();
        System.out.println(aliases);

        //获取可用字符集
        getCharsets();
    }

    private static void writeData(Employee[] employees, PrintWriter out){
        out.println(employees.length);
        for (Employee e: employees) {
            System.out.println(e);
        }
    }

    private static Employee[] readData(Scanner in){
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i=0; i<employees.length; i++){
            employees[i] = new Employee("apple",1990,1992);
        }

        return employees;
    }

    //获取可用字符集
    private static void getCharsets(){
        Map<String,Charset> charsetMap = Charset.availableCharsets();
        for (String name: charsetMap.keySet()) {
            System.out.println(name);
        }
    }
}
