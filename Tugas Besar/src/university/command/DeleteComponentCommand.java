package university.command;

import university.Composite.University;

public class DeleteComponentCommand implements Command{
    private University university;
    private String department;

    public DeleteComponentCommand(University university, String department) {
        this.university = university;
        this.department = department;
    }

    @Override
    public void execute() {
        university.deleteComponent(department);
    }
}
