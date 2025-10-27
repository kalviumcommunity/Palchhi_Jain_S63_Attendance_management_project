package com.school;

public class Person {
    private static int nextIdCounter = 1;  // static counter for auto-increment
    protected int id;
    protected String name;

    // Constructor
    public Person(String name) {
        this.id = nextIdCounter++;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Display method
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}