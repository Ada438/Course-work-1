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





