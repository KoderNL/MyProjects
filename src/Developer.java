import java.util.Random;
public class Developer extends Employee {
    int fixedBugs;
    Random random = new Random();
    public Developer (long id, String name, int age, int salary, char gender, int fixedBugs) {
        super(id, name, age, salary, gender);
        this.fixedBugs = fixedBugs;
    }
    double fullSalary(int salary) {//method of class
        boolean randomBoolean = random.nextBoolean();
        return (salary + fixedBugs * 2) * (randomBoolean ? 2 : 0);
    }
}


