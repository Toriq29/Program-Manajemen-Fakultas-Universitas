package university.Composite;

import university.builder_prototype.Student;
import university.proxy.IDepartement;

import java.util.List;

public class Department implements UniversityComponent, IDepartement {
    private String name;
    private List<Student> students;
    public Department(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void showDetails() {
        System.out.println("Departemen: " + this.name);
    }


    @Override
    public void enrollStudent(Student student) {
        this.students.add(student);
        System.out.println("Student "+student.getId()+" "+student.getName()+" has been added");
    }

    @Override
    public void graduateStudent(Integer id) {

        for (Student student : this.getStudents()){
            if (student.getId().equals(id)){
                this.students.remove(student);
                System.out.println("Student "+student.getId()+" "+student.getName()+" has graduated");
                break;
            }
        }
    }
}
