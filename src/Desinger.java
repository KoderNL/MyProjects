public class Desinger extends Employee {
    int rate;
    int workedDays;
    Desinger(long id, String name, int age, int salary, char gender, int rate, int workedDays) {
        super(id, name, age, salary, gender);//parents class statements
        this.rate = rate;//unique statement
        this.workedDays = workedDays;//unique statement
    }//constructor call for make new object of this class
    double fullSalary(int salary) {//method of class
        return salary + (rate * workedDays);
    }
}
