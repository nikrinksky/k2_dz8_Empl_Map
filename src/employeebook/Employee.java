package employeebook;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private float salary;
    private static int ID_COUNTER = 1;
    private final int id;

    public Employee(String fullName, int department, float salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = ID_COUNTER++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public static int getID_COUNTER() {
        return ID_COUNTER;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ФИО сотрудника: " + fullName + ", отдел № " + department +
                ", зарплата: " + salary + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Float.compare(employee.salary, salary) == 0 && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }
}
