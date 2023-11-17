package university.proxy;

import university.Composite.Department;
import university.builder_prototype.Student;

public class DepartementProxy implements IDepartement{

    private Department realDepartment;

    public DepartementProxy(Department department) {
        this.realDepartment = department;
    }

    @Override
    public void enrollStudent(Student student) {
        realDepartment.enrollStudent(student);
    }

    @Override
    public void graduateStudent(Integer id) {
        realDepartment.graduateStudent(id);

    }
}
