package Employee;

public class Employee {
    int age;
    float salary;
    String position;

    public Employee(int age, float salary, String position) {
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
