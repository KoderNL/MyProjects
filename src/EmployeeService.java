import java.util.Objects;

public class EmployeeService {
    Employee[] employees;
    public EmployeeService(Employee[] employees) {//конструктор который при вызове вернет нам новый экземпляр класса EmployeeService,
        this.employees = employees;//присваиваем свойству адрес на массив который к нам пришел
    }
    public boolean equals(Object object1, Object object2) {
        if (object1 == object2) {
            return true;
        }
        return false;
    }
    Employee[] sortByNameAndSalary() {//возвращают отсортированный массив с сотрудниками по критерию

    }
    public Employee getByName(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (equals(employees[i].name, name)){
                return employees[i];
            }
        }
        return null;
    }
    public Employee edit(Employee employee) {
        Employee oldEmployee = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].id == employee.id) {
                oldEmployee = employees[i];
                employees[i] = employee;
            }
        }
        return oldEmployee;
    }
    public Employee remove(long id) {
        //находит сотрудника по id, и удаляет его из массива. Возвращает ссылку на удаленного сотрудника. Массив сокращается на 1.
        Employee[] newEmployees = new Employee[employees.length - 1];
        Employee removedEmployee = employees[0];
        int j = 0;
        for (long i = 0; i < employees.length; i++) {
            if(employees[(int)i].id == id) {
                removedEmployee = employees[(int)i];
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != removedEmployee) {
                newEmployees[j] = employees[i];
                j++;
            }
        }
        return removedEmployee;
    }
    public void add(Employee employee) {
        Employee[] newEmployees = new Employee[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            newEmployees[i] = employees[i];
            if(i == employees.length - 1){
                newEmployees[i + 1] = employee;
            }
        }
        employees = newEmployees;
    }
    public Employee getById(long idNumber) {
        Employee employee = employees[0];
        int index = (int) idNumber;
        for (int i = 0; i < employees.length; i++) {
            if(i == index){
                employee = employees[i];
            }
        }
        return employee;
    }
    public double calculateSalaryAndBonus(){
        double result = 0.0;
        for (Employee employee : employees) {
            if (employee instanceof Desinger desinger) {
                result += desinger.fullSalary(desinger.salary);
            }
            if (employee instanceof Developer developer) {
                result += developer.fullSalary(developer.salary);
            }
            if (employee instanceof Manager manager) {
                result += manager.salary;
            }
        }
        return result;
    }
    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.print("Employee #" + employee.id + ", name = "
                    + employee.name + ", age " + employee.age + ", salary = "
                    + employee.salary + ", gender = " + employee.gender);
            if (employee instanceof Desinger desinger) {
                System.out.print(", rate = " + desinger.rate + ", workDays = " + desinger.workedDays);
            }
            if (employee instanceof Developer developer) {
                System.out.print(", fixedBugs = " + developer.fixedBugs);
            }
            System.out.println(".");
        }
    }
}
/* Documentation
+Разработать класс EmployeeService который будет хранить всех сотрудников предприятия в массиве.
+Класс должен содержать методы для работы с сотрудниками (которые представлены массивом внутри класса):
+void printEmployees() -> вывод на экран информации о сотрудниках
+double calculateSalaryAndBonus() -> возвращает количество денег необходимое для выплаты зарплат для всех сотрудников в этом месяце
+Employee getById(long) -> возвращает сотрудника по заданному id
+Employee[] getByName(String) -> возвращает сотрудника по заданному имени
Employee[] sortByNameAndSalary() -> возвращают отсортированный массив с сотрудниками по критерию
+Employee edit(Employee) -> находит сотрудника по id, и подменяет информацию о нем на новую. Старую версию сотрудника метод возвращает.
+Employee remove(long id) -> находит сотрудника по id, и удаляет его из массива. Возвращает ссылку на удаленного сотрудника. Массив сокращается на 1.
+void add(Employee) -> Добавляет нового сотрудника. Массив увеличивается на 1.
*/