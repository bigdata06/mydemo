package com.mydemo.func;

import java.util.*;

class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {


        List<Person> personList = Arrays.asList(new Person("said", "senhadji"),
                new Person("leila", "berezak"), new Person("toufik", "ouriachi"));

     //   Collections.sort(personList,new SortByName());


                for(Person p : personList){
                    System.out.println(p.lastName);
                }


    }
}
    class SortByName implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getLastName().compareTo(o2.getLastName());
                    }
                }












