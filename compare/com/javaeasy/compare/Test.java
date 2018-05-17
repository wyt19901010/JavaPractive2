package com.javaeasy.compare;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Student s = new Student("aaa",32);
        Student b = new Student("aaa",32);

        System.out.println(s.hashCode());
        System.out.println(b.hashCode());
        System.out.println(s.equals(b));

    }
}
