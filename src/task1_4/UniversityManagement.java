package task1_4;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

class Student extends Person {
    private String major;

    public Student(String name, int id, String major) {
        super(name, id);
        this.major = major;
    }

    public String getMajor() { return major; }

    @Override
    public String toString() {
        return super.toString() + ", Major: " + major + " (Student)";
    }
}

class Teacher extends Person {
    private String department;

    public Teacher(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return super.toString() + ", Department: " + department + " (Teacher)";
    }
}

class University {
    private List<Person> personnel;

    public University() {
        personnel = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personnel.add(person);
    }

    public void removePerson(int id) {
        personnel.removeIf(person -> person.getId() == id);
    }

    public Person findPerson(int id) {
        for (Person person : personnel) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void displayAllPersonnel() {
        for (Person person : personnel) {
            System.out.println(person);
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        University university = new University();

        Student student1 = new Student("Иван Иванов", 1, "Информатика");
        Student student2 = new Student("Петр Петров", 2, "Математика");
        Teacher teacher1 = new Teacher("Анна Сидорова", 101, "Компьютерные науки");

        university.addPerson(student1);
        university.addPerson(student2);
        university.addPerson(teacher1);

        System.out.println("Весь персонал университета:");
        university.displayAllPersonnel();

        System.out.println("\nПоиск человека с ID 2:");
        Person found = university.findPerson(2);
        if (found != null) {
            System.out.println("Найден: " + found);
        }

        System.out.println("\nУдаление человека с ID 1:");
        university.removePerson(1);
        university.displayAllPersonnel();
    }
}
