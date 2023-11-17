package university.iterator;

import university.Composite.Department;
import university.builder_prototype.Student;

import java.util.List;

public class UniversityDepartementIterator implements UniversityIterator{
    private List<Department> components;
    private int currentIndex;

    public UniversityDepartementIterator(List<Department> components) {
        this.components = components;
        this.currentIndex = 0;
    }
    public boolean hasNext() {
        return currentIndex < components.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return components.get(currentIndex++);
        }
        return null;
    }
}
