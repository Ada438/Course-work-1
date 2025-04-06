public class EmployeeBook {
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
