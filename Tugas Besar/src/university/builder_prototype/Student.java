package university.builder_prototype;

public class Student implements Cloneable {
    private Integer id;
    private String name;
    private String departement;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.departement = builder.departement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class StudentBuilder {
        private Integer id;
        private String name;
        private String departement;

        public StudentBuilder() {

        }

        public StudentBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }
        public StudentBuilder departement(String departement) {
            this.departement = departement;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
}
