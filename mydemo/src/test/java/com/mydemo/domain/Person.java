package com.mydemo.domain;

import static com.google.common.base.Preconditions.checkState;

public class Person {

    private String title;
    private final String name;
    private final String surname;
    private String prefix;
    private double salary;

    public Person(String title, String name, String surname, String prefix,double salary) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.prefix = prefix;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", prefix='" + prefix + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static Builder builder(String name,String surname){
            return new Builder(name, surname);
        }



    public static class Builder {
        private String title;
        private final String name;
        private final String surname;
        private String prefix;
        private double salary;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }


        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public Person build() {
            checkState(title != null && prefix != null);
            return new Person(title, name, surname, prefix,salary);
        }

    }

    public static void main(String[] args) {
        Person person = Person.builder("karim","senhadji")
                .prefix("Mr").title("phd").salary(90000)
                .build();
        System.out.println(person);
    }


}
