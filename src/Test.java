
public class Test {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();//cоздаем объект класса от которого будет его вызывать
        EmployeeService employeeService = new EmployeeService(employeeFactory.generateEmployees(10));
        //employeeService содержит теперь наших сотрудников, массив которых мы положили в свойства этого бъекта
        //ранее определенного в классе(голове). что бы получить к ним доступ можно "employeeService.employees"
        //employeeService.printEmployees();
        System.out.println(employeeService.calculateSalaryAndBonus());
        System.out.println(employeeService.getById(8));
        employeeService.add(new Employee((long)employeeService.employees.length + 1,"Valya",20, 2000,'m'));
        System.out.println(employeeService.remove(11));
        System.out.println(employeeService.edit(new Employee(11,"Katya",21, 2000,'w')));
        System.out.println(employeeService.getByName("Katya"));
        employeeService.sortByNameAndSalary();
        employeeService.printEmployees();
    }
}
/* Documentation
 создания объекта EmployeeService и тестирования описаных выше методов
*/