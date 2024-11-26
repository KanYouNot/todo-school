class Employee {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

interface TaxCalculator {
    double calculateTax(double salary);
}

class ManagerTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double salary) {
        return salary * 0.2;
    }
}

class DeveloperTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double salary) {
        return salary * 0.15;
    }
}

class DefaultTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double salary) {
        return salary * 0.1;
    }
}

class TaxService {
    private final TaxCalculator taxCalculator;

    public TaxService(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void printTax(Employee employee) {
        double tax = taxCalculator.calculateTax(employee.getSalary());
        System.out.println("Tax for " + employee.getName() + " (" + employee.getPosition() + "): " + tax + " zł");
    }
}

interface EmployeeRepository {
    void save(Employee employee);
}

class DatabaseEmployeeRepository implements EmployeeRepository {
    @Override
    public void save(Employee employee) {
        System.out.println("Saved employee: " + employee.getName() + " to the database.");
    }
}

// Main program class
public class Main {
    public static void main(String[] args) {
        Employee manager = new Employee("Anna Kowalska", "Manager", 8000);
        Employee developer = new Employee("Jan Nowak", "Developer", 6000);
        Employee worker = new Employee("Piotr Wiśniewski", "Worker", 4000);

        TaxService managerTaxService = new TaxService(new ManagerTaxCalculator());
        TaxService developerTaxService = new TaxService(new DeveloperTaxCalculator());
        TaxService defaultTaxService = new TaxService(new DefaultTaxCalculator());

        managerTaxService.printTax(manager);
        developerTaxService.printTax(developer);
        defaultTaxService.printTax(worker);

        EmployeeRepository repository = new DatabaseEmployeeRepository();
        repository.save(manager);
        repository.save(developer);
        repository.save(worker);
    }
}

