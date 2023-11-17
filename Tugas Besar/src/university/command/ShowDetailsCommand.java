package university.command;

import university.Composite.University;

public class ShowDetailsCommand implements Command{

    private University university;

    public ShowDetailsCommand(University university) {
        this.university = university;
    }

    @Override
    public void execute() {
        university.showDetails();
    }
}
