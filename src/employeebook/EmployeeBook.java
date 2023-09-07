package employeebook;

import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] listEmp = new Employee[10];

    ////// Базовая сложность:
    public void printListOfAllEmployees() { //список всех сотрудников с данными
        for (Employee employee : listEmp) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public float sumSalaryAllEmployees() { //подсчет суммы всех зарплат в месяц
        float sum = 0;
        for (Employee employee : listEmp) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() { //поиск сотрудника с минимальной зарплатой
        Employee value = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : listEmp) {
            if (employee != null) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    value = employee;
                }
            }
        }
        return value;
    }

    public Employee findEmployeeWithMaxSalary() { //поиск сотрудника с максимальной зарплатой
        Employee value = null;
        float maxSalary = Integer.MIN_VALUE;
        for (Employee employee : listEmp) {
            if (employee != null) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    value = employee;
                }
            }
        }
        return value;
    }

    public double findAverageSalaryAllListEmp() { //подсчет среднего значения зарплат
        return sumSalaryAllEmployees() / listEmp.length;
    }

    public void printFullNameAllEmployees() { //получить Ф.И.О. всех сотрудников
        System.out.println("ФИО всех сотрудников:" + "\n");
        for (Employee employee : listEmp) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    ////// Повышенная сложность:
    public void indexPercentSalary(float percent) { // индексирование зарплаты
        for (Employee employee : listEmp) {
            if (employee != null) {
                float s = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary(s);
            }
        }
    }

    public Employee findEmpDepartmentWithMinSalary(int department) { //поиск сотрудника отдела с минимальной зарплатой
        Employee value = null;
        double minSalary = Integer.MAX_VALUE;
        for (Employee employee : listEmp) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() <= minSalary) {
                    minSalary = employee.getSalary();
                    value = employee;
                }
            }
        }
        return value;
    }

    public Employee findEmpDepartmentWithMaxSalary(int department) { //поиск сотрудника отдела с максимальной зарплатой
        Employee value = null;
        float maxSalary = Integer.MIN_VALUE;
        for (Employee employee : listEmp) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    value = employee;
                }
            }
        }
        return value;
    }

    public float sumSalaryDepartmentEmployees(int department) { //подсчет суммы всех зарплат в месяц по отделу
        float sum = 0;
        for (Employee employee : listEmp) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public float findAverageSalaryDepartmentEmp(int department) { //подсчет среднего значения зарплат по отделу
        int count = 0;
        float sum = 0;
        for (Employee employee : listEmp) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        if (count == 0) { // проверка на ноль так как на ноль делить нельза
            System.out.println("В этом отделе нет сотрудников - ");
            return 0;
        } else return sum / count;
    }

    public void indexPercentSalaryDepartment(int department, float percent) { // индексирование зарплаты сотрудников отдела
        for (Employee employee : listEmp) {
            if (employee != null && employee.getDepartment() == department) {
                float s = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary(s);
            }
        }
    }

    public void printFullEmployeesDepartment(int department) { //напечатать всех сотрудников отдела (кроме номра отдела)
        System.out.println("Список всех сотрудников " + department + "-го отдел: ");
        for (Employee employee : listEmp) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(employee.getFullName() + " " + employee.getSalary());
            }
        }
    }

    public void findSalaryLessNumber(float number) { // Сотрудники с зарплатой меньше заданного числа
        System.out.println("Сотрудники с зарлатой меньше " + number + " руб.: ");
        for (Employee employee : listEmp) {
            if (employee != null) {
                if (employee.getSalary() < number) {
                    System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
                }
            }
        }
    }

    public void findSalaryMoreNumber(float number) { // Сотрудники с зарлатой больше или равно заданного числа
        System.out.println("Сотрудники с зарлатой больше или равно " + number + " руб.: ");
        for (Employee employee : listEmp) {
            if (employee != null) {
                if (employee.getSalary() >= number) {
                    System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
                }
            }
        }

    }

    ////// Очень сложно:
    public void addNewEmployee(String fullName, int department, float salary) { // Добавить нового сотрудника
        int count = 0;
        for (int i = 0; i < listEmp.length; i++) {
            if (listEmp[i] == null) {
                listEmp[i] = new Employee(fullName, department, salary);
                break;
            }
            count++;
            if (count == listEmp.length) {
                System.out.println("Невозможно добавить сотрудника: " + fullName + ". Штат сотрудников уже набран");
            }
        }


    }

    public void deleteEmployee(String fullName) { // Удалить сотрудника
        for (int i = 0; i < listEmp.length; i++) {
            if (listEmp[i] != null) {
                if (listEmp[i].getFullName().equals(fullName)) {
                    listEmp[i] = null;
                    System.out.println("Сотрудник " + fullName + " удалён");
                    break;
                }
            }
        }
    }

    public void changeEmployeeData(String fullName, int department, float salary) { // изменить сотрудника(получить по ФИО, модернизировать)
        for (Employee employee : listEmp) {                                 // изменить зарплату и отдел
            if (employee != null && employee.getFullName().equals(fullName)) {
                if (salary == 0) {
                    employee.setDepartment(department);
                    System.out.println("Меняем отдел сотрудника: " + fullName + " на " + department
                            + " отдел");
                    break;
                } else if (department == 0) {
                    employee.setSalary(salary);
                    System.out.println("Меняем зарплату сотрудника: " + fullName + " на " + salary
                            + " руб.");
                    break;
                } else {
                    employee.setDepartment(department);
                    employee.setSalary(salary);
                    System.out.println("Меняем зарплату и отдел сотрудника: " + fullName + " на " + department
                            + " отдел с зарплатой " + salary + " руб.");
                    break;
                }
            }
        }
    }

    // перегруз метода changeEmployeeData(String fullName, int department, float salary)
    public void changeEmployeeData(String fullName, int department) {
        changeEmployeeData(fullName, department, 0);
    }

    // перегруз метода changeEmployeeData(String fullName, int department, float salary)
    public void changeEmployeeData(String fullName, float salary) {
        changeEmployeeData(fullName, 0, salary);
    }

    public void printFullNameAllEmployees(int department) { //получить Ф.И.О. всех сотрудников
        for (Employee employee : listEmp) {             // Это метод реализуется в методе printFullNameAllEmployeesDepartments()
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void printFullNameAllEmployeesDepartments() { //получить Ф.И.О. всех сотрудников по отделам
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n" + "Сотрудники " + i + "-го" + " отдела: ");
            printFullNameAllEmployees(i);
        }
    }


    // Разделитель:
    public void separator() {
        System.out.println("==================================================================" + "\n");
    }
}
