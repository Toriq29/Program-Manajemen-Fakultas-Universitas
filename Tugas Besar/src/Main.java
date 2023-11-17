import university.Composite.Department;
import university.Composite.University;
import university.builder_prototype.Student;
import university.command.*;
import university.proxy.DepartementProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);

        University university = new University();
        UniversityManager manager = new UniversityManager();

        Student studentTamplate = (new Student.StudentBuilder()
                .id(0)
                .name("")
                .departement("")
                .build());

        ShowDetailsCommand showDetail = new ShowDetailsCommand(university);

        while (true) {
            System.out.println("1. Print Departement");
            System.out.println("2. Create Departement");
            System.out.println("3. Delete Departement");
            System.out.println("4. Print Students Departement");
            System.out.println("5. Insert Students Departement");
            System.out.println("6. Remove Students Departement");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            Integer choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manager.setCommand(showDetail);
                    manager.executeCommand();
                    break;
                case 2:
                    System.out.print("Enter your name Departement: ");
                    String nameDepartement = scanner.nextLine();
                    List<Student> data = new ArrayList();
                    Department department = new Department(nameDepartement, data);
                    Command newDepartementCommand = new AddComponentCommand(university, department);
                    manager.setCommand(newDepartementCommand);
                    manager.executeCommand();
                    break;
                case 3:
                    manager.setCommand(showDetail);
                    manager.executeCommand();
                    System.out.print("Enter your name Departement: ");
                    String deleteDepartement = scanner.nextLine();
                    Command deleteDepartementCommand = new DeleteComponentCommand(university, deleteDepartement);
                    manager.setCommand(deleteDepartementCommand);
                    manager.executeCommand();
                    break;
                case 4:
                    manager.setCommand(showDetail);
                    manager.executeCommand();
                    System.out.print("Enter name Departement : ");
                    String nameDepartement1 = scanner.nextLine();
                    Department dep = university.returnDepartement(nameDepartement1);
                    if (dep.getStudents().isEmpty()){
                        System.out.println("there is no single student");
                    }
                    else {
                        for (Student student : dep.getStudents()) {
                            System.out.println("ID : " + student.getId() + " Name : " + student.getName());
                        }
                    }

                    break;
                case 5:
                    manager.setCommand(showDetail);
                    manager.executeCommand();
                    System.out.print("Enter name Departement : ");
                    String nameDepartement2 = scanner.nextLine();
                    Department depInsert = university.returnDepartement(nameDepartement2);
                    System.out.print("Name : ");
                    String nameInsert = scanner.nextLine();
                    System.out.print("ID : ");
                    Integer idInsert = scanner.nextInt();
                    Student createStudent = (Student) studentTamplate.clone();
                    createStudent.setId(idInsert);
                    createStudent.setName(nameInsert);
                    createStudent.setDepartement(depInsert.getName());
                    DepartementProxy depProxyIsert = new DepartementProxy(depInsert);
                    depProxyIsert.enrollStudent(createStudent);
                    break;
                case 6:
                    manager.setCommand(showDetail);
                    manager.executeCommand();
                    System.out.print("Enter name Departement : ");
                    String nameDepartement3 = scanner.nextLine();
                    Department depRemove = university.returnDepartement(nameDepartement3);
                    System.out.print("ID : ");
                    Integer idRemove = scanner.nextInt();
                    DepartementProxy depProxyRemove = new DepartementProxy(depRemove);
                    depProxyRemove.graduateStudent(idRemove);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }
    }
}