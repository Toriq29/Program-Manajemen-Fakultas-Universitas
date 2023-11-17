package university.Composite;

import university.builder_prototype.Student;
import university.iterator.UniversityDepartementIterator;
import university.iterator.UniversityIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class University implements UniversityComponent {
    private List<Department> components = new ArrayList();

    public University() {
    }

    public void addComponent(Department component) {
        this.components.add(component);
    }

    public void deleteComponent(String departement){
        Department dep = null;
        for (Department componen : components){
            if(componen.getName().equals(departement)){
                components.remove(componen);
                break;
            }
        }
    }

    public Department returnDepartement(String departement){
        Department dep = null;
        for (Department componen : components){
            if(componen.getName().equals(departement)){
                dep = componen;
                break;
            }
        }
        return dep;
    }

    public void showDetails() {

        if (components.isEmpty()){
            System.out.println("there is no single department");
        }
        else {
            UniversityIterator iterator = this.createIterator();

            while(iterator.hasNext()) {
                UniversityComponent component = (UniversityComponent)iterator.next();
                component.showDetails();
            }
        }
    }

    public UniversityIterator createIterator() {
        return new UniversityDepartementIterator(components);
    }
}