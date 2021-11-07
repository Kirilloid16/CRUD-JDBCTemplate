package ru.lukash.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    @NotEmpty(message = "Expected Email")
    @Email(message = "Email not valid")
    private String email;
    @Min(value = 0,message = "Age must be more than -n")
    private int age;
    @Size(min = 2,max = 45,message ="Should be between 2 and 45 charactar")
    @NotEmpty(message = "Expected name")
    private String name;
    private int id;

    public Person(){}
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(String name, int id,String email,int Age) {
        this.age = Age;
        this.email=email;
        this.name = name;
        this.id = id;
    }
}
