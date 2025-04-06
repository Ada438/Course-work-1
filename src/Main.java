import java.util.Objects;

class Employee {
    private String fullName;
    private int department;
    private double salary;
    private int id;
    private static int idCounter = 1;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = idCounter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && id == employee.id && Objects.equals(fullName, employee.fullName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

    @Override
    public String toString() {
        return "ФИО сотрудника: " +
                fullName + ", отдел: " + department +
                ", зарплата = " + salary +
                ", ID = " + id;
    }
}

class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public boolean addEmployee(String fullName, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void printAllNamesAndStats() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public void printAllNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    public void indexAllSalaries(double percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + percent / 100);

                employee.setSalary(newSalary);
            }
        }
    }

    public void printMinSalaryInDepartment(int department) {
        Employee min = null;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                min = employee;
                break;
            }
        }
        if (min == null) {
            System.out.println("В отделе " + department + " сотрудников нет.");
            return;
        }

        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() < min.getSalary()) {
                min = employee;
            }
        }

        System.out.println("Минимальная зп в отделе " + department + ": " + min);
    }

    public void printMaxSalaryInDepartment(int department) {
        Employee max = null;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                max = employee;
                break;
            }
        }
        if (max == null) {
            System.out.println("В отделе " + department + " сотрудников нет.");
            return;
        }

        for (Employee employee : employees) {
            if (employee.getDepartment() == department && employee.getSalary() > max.getSalary()) {
                max = employee;
            }
        }

        System.out.println("Максимальная зп в отделе " + department + ": " + max);
    }

    public void printSumSalaryInDepartment(int department) {
        double sum = 0;
        boolean hasEmployees = false;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                hasEmployees = true;
            }
        }

        if (hasEmployees) {
            System.out.println("Общая сумма зп в отделе " + department + ": " + sum);
        } else {
            System.out.println("В отделе " + department + " сотрудников нет.");
        }
    }

    public void printAverageSalaryInDepartment(int department) {
        double sum = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Средняя зарплата в отделе " + department + ": " + (sum / count));
        } else {
            System.out.println("В отделе " + department + " сотрудников нет.");
        }
    }

    public void indexSalariesInDepartment(int department, double percent) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
        System.out.println("Зарплаты в отделе " + department + " проиндексированы на " + percent + "%.");
    }

    public void printEmployeesInDepartment(int department) {
        boolean hasEmployees = false;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                hasEmployees = true;
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", зарплата: " + employee.getSalary());
            }
        }
        if (!hasEmployees) {
            System.out.println("В отделе " + department + " сотрудников нет.");
        }
    }

    public void printEmployeesWithSalaryLessThan(double amount) {
        System.out.println("Сотрудники с зп меньше " + amount + ":");
        for (Employee employee : employees) {
            if (employee.getSalary() < amount) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThanOrEqual(double amount) {
        System.out.println("Сотрудники с зп больше или равно " + amount + ":");
        for (Employee employee : employees) {
            if (employee.getSalary() >= amount) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", зарплата: " + employee.getSalary());
            }
        }
    }


    public double getTotalSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public void printTotalSalary() {
        System.out.println("Сумма всех зарплат: " + getTotalSalary());
    }

    public void printAverageSalary() {
        double averageSalary = getTotalSalary() / employees.length;
        System.out.println("Средняя зарплата: " + averageSalary);
    }
    public void printMinSalary () {
            Employee minSalaryEmployee = employees[0];
            for (Employee employee : employees) {
                if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }

            System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        }

        public void printMaxSalary () {
            Employee maxSalaryEmployee = employees[0];
            for (Employee employee : employees) {
                if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }

            System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        }
}



public class Main {
        public static void main(String[] args) {
            EmployeeBook book = new EmployeeBook();
            book.addEmployee("Иванов Иван Иванович", 1, 50000);
            book.addEmployee("Петров Пётр Петрович", 2, 65000);
            book.addEmployee("Фёдоров Фёдор Фёдорович", 3, 70000);
            book.addEmployee("Александрова Александра Александровна", 2, 46000);
            book.addEmployee("Янина Яна Яновна", 1, 120000);
            book.addEmployee("Сидоров Сидор Сидорович", 5, 24000);
            book.addEmployee("Алексеев Алексей Алексеевич", 4, 38000);
            book.addEmployee("Олегов Олег Олегович", 4, 64000);
            book.addEmployee("Вадимов Вадим Вадимович", 1, 60000);
            book.addEmployee("Максимов Максим Максимович", 5, 80000);

            System.out.println("Все сотрудники (полная информация):");
            book.printAllNamesAndStats();

            System.out.println("Все сотрудники (только ФИО):");
            book.printAllNames();

            book.printTotalSalary();
            book.printAverageSalary();
            book.printMinSalary ();
            book.printMaxSalary ();

            System.out.println("Сотрудники из отдела 2:");
            book.printEmployeesInDepartment(2);
            book.printMinSalaryInDepartment(2);
            book.printMaxSalaryInDepartment(2);
            book.printSumSalaryInDepartment(2);
            book.printAverageSalaryInDepartment(2);
            System.out.println("Индексация ЗП в отделе 2 на 15%");
            book.indexSalariesInDepartment(2, 15);
            book.printEmployeesInDepartment(2);

            System.out.println("Поиск сотрудника по ID:");
            Employee hasEmployee = book.getEmployeeById(3);
            if (hasEmployee != null) {
                System.out.println("Найден: " + hasEmployee);
            } else {
                System.out.println("Сотрудник не найден");
            }


            book.printEmployeesWithSalaryLessThan(50000);

            book.printEmployeesWithSalaryMoreThanOrEqual(80000);

            System.out.println("Удаление сотрудника с ID 3:");
            book.removeEmployee(3);
            book.printAllNames();

            System.out.println("Индексация зарплат на 10%:");
            book.indexAllSalaries(10);
            book.printAllNamesAndStats();
        }

    }





