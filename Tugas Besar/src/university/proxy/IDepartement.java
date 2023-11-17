package university.proxy;

import university.builder_prototype.Student;

public interface IDepartement {
    void enrollStudent(Student student);
    void graduateStudent(Integer id);
}
