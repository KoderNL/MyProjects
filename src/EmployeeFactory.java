import java.util.Random;

public class EmployeeFactory {
    Employee[] employees;
    public Employee[] generateEmployees(int size) {//метод класса EmployeeFactory возвращает массив данных класса Employee
        Random random = new Random();
        this.employees = new Employee[size];
        int managerArrayLength;
        int developerArrayLength;
        int desingerArrayLength;
        int employeeArrayLength = size;
        long idNumber = 1;
        int index = 0;
        managerArrayLength = valueGenerator(size - 2 ,1);
        size = size - managerArrayLength;
        developerArrayLength = valueGenerator(size - 1,1);
        size = size - developerArrayLength;
        desingerArrayLength = size;
            for (int j = 0; j < managerArrayLength; j++) {
                Manager manager = new Manager(idNumber,nameGenerator(),valueGenerator(31,25),2000,genderGenerator());
                employees[index] = manager;
                idNumber++;
                index++;
            }
            for (int j = 0; j < developerArrayLength; j++) {
                Developer developer = new Developer(idNumber,nameGenerator(),valueGenerator(31,25),3000,genderGenerator(),valueGenerator(1,200));
                employees[index] = developer;
                idNumber++;
                index++;
            }
            for (int j = 0; j < desingerArrayLength; j++) {
                Desinger desinger = new Desinger(idNumber,nameGenerator(),valueGenerator(31,25),2500,genderGenerator(),valueGenerator(2,20),valueGenerator(1,20));
                employees[index] = desinger;
                idNumber++;
                if(index != employeeArrayLength) {
                    index++;
                }
            }
    return employees;
    }
    private int valueGenerator(int max, int min) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }
    private String nameGenerator() {
        Random random = new Random();
        String[] names = {"Charlie", "Sidney", "Alex", "Taylor", "Jamie", "Hayden", "Riley"};
        return names[random.nextInt(7)];
    }
    private char genderGenerator() {
        Random random = new Random();
        char[] names = {'m', 'w'};
        return names[random.nextInt(2)];
    }
}

/* Documentation
id+, name+, age(18,60), salary(2000), gender+, fixedBugs(1,200), rate+, workedDays(1,20);
generateEmployees(size) генерирует случайным образом заданое количество сотрудников
- определяем тип будущего массива
- пишем конструктор с параметрами классов с какими будем работать
- пишем метод который будем вызывать из сервис или тест
- методе создаем массив куда будем ложить объекты всех классов, создаем цикл и счечтики, на каждой итерации вызываем
вызываем нужные классы и создаем объекты и ложим их в массив.
 количество объектов решить через рандом
*/