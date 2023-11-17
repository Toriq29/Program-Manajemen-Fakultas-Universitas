package university.command;

import university.Composite.Department;
import university.Composite.University;

public class AddComponentCommand implements Command{
    private University university;
    private Department department;

    public AddComponentCommand(University university, Department department) {
        this.university = university;
        this.department = department;
    }

    @Override
    public void execute() {
        university.addComponent(department);
    }
}
