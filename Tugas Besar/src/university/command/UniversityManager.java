package university.command;

import university.Composite.University;

public class UniversityManager extends University {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
