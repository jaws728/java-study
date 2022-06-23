package java8;

public class Person {
    private Teacher teacher;

    public Person() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Person(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Person{" +
                "teacher=" + teacher +
                '}';
    }
}
