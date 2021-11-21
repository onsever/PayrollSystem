import java.util.*;

// ONURCAN SEVER - C0830345

public class PayrollSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("\nPAYROLL SYSTEM");
        System.out.println("-------------------------------");
        System.out.println("1. Use the test data");
        System.out.println("2. Add data manually");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                testData(employees);
                break;
            case 2:
                menuHandler(input, employees);
                break;
            default:
                break;
        }

    }

    // This is the main menu for adding employees, vehicles and see the total payroll amount.
    public static void menuHandler(Scanner input, ArrayList<Employee> employees) {

        while (true) {
            System.out.println("\nChoose an option below");
            System.out.println("-------------------------------");
            System.out.println("1. Calculate the total payroll");
            System.out.println("2. Add an Intern Employee");
            System.out.println("3. Add a Full-time Employee");
            System.out.println("4. Add a Part-time Employee");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    printTotalPayroll(employees);
                    break;

                case 2:
                    Employee internEmployee = addIntern(input);
                    employees.add(internEmployee);
                    break;

                case 3:
                    Employee fullTimeEmployee = addFullTime(input);
                    employees.add(fullTimeEmployee);
                    break;

                case 4:
                    System.out.println("Choose an option below");
                    System.out.println("-------------------------------");
                    System.out.println("1. Add a Commission Based Part-time Employee");
                    System.out.println("2. Add a Fixed Based Part-time Employee");

                    int partTimeChoice = input.nextInt();

                    switch (partTimeChoice) {
                        case 1:
                            Employee commissionBasedPartTimeEmployee = addCommissionedPartTime(input);
                            employees.add(commissionBasedPartTimeEmployee);
                            break;

                        case 2:
                            Employee fixedBasedPartTimeEmployee = addFixedPartTime(input);
                            employees.add(fixedBasedPartTimeEmployee);
                            break;

                        default:
                            break;
                    }

                default:
                    break;

            }

            System.out.println();
            System.out.println("Do you want to continue? (y/n)");
            char answer = input.next().toLowerCase().charAt(0);

            if (answer == 'n') {
                System.out.println();
                printTotalPayroll(employees);
                break;
            }

        }

    }

    // Methods below are for adding employee. (Each method is used for adding different types of employee)
    public static Intern addIntern(Scanner input) {
        System.out.println("Enter the details for Intern employee...\n");
        System.out.println("Enter the employee's name: ");
        String employeeName = validatedString(input);

        System.out.println("Enter the employee's age: ");
        int employeeAge = input.nextInt();

        Vehicle vehicle = hasVehicle();

        System.out.println("Enter the employee's school name: ");
        String schoolName = validatedString(input);

        return new Intern(employeeName, employeeAge, vehicle, schoolName);
    }

    public static FullTime addFullTime(Scanner input) {
        System.out.println("Enter the details for Full-time employee...\n");
        System.out.println("Enter the employee's name: ");
        String employeeName = validatedString(input);

        System.out.println("Enter the employee's age: ");
        int employeeAge = input.nextInt();

        Vehicle vehicle = hasVehicle();

        System.out.println("Enter the employee's salary: ");
        double employeeSalary = input.nextDouble();

        System.out.println("Enter the bonus for the employee: ");
        double employeeBonus = input.nextDouble();

        return new FullTime(employeeName, employeeAge, vehicle, employeeSalary,
                employeeBonus);
    }

    public static CommissionBasedPartTime addCommissionedPartTime(Scanner input) {
        System.out.println("Enter the details for Commission based Part-time employee...\n");
        System.out.println("Enter the employee's name: ");
        String employeeName = validatedString(input);

        System.out.println("Enter the employee's age: ");
        int employeeAge = input.nextInt();

        Vehicle vehicle = hasVehicle();

        System.out.println("Enter the employee's rate: ");
        double employeeRate = input.nextDouble();

        System.out.println("Enter the number of hours that employee works: ");
        double hoursWorked = input.nextDouble();

        System.out.println("Enter a commission rate for the employee: (ex: %20 is 0.2)");
        Double commissionRate = validatedCommission(input);

        // Validating the commission rate.
        while (commissionRate == null) {
            System.out.println("Enter a valid commission rate: (0.0 - 1.0)");
            System.out.println("Enter a commission rate for the employee: (ex: %20 is 0.2)");
            commissionRate = validatedCommission(input);
        }

        return new CommissionBasedPartTime(employeeName,
                employeeAge, vehicle, employeeRate, hoursWorked, commissionRate);
    }

    public static FixedBasedPartTime addFixedPartTime(Scanner input) {
        System.out.println("Enter the details for Fixed based Part-time employee...\n");
        System.out.println("Enter the employee's name: ");
        String employeeName = validatedString(input);

        System.out.println("Enter the employee's age: ");
        int employeeAge = input.nextInt();

        Vehicle vehicle = hasVehicle();

        System.out.println("Enter the employee's rate: ");
        double employeeRate = input.nextDouble();

        System.out.println("Enter the number of hours that employee works: ");
        double hoursWorked = input.nextDouble();

        System.out.println("Enter a fixed amount that employee earns: ");
        double fixedAmount = input.nextDouble();

        return new FixedBasedPartTime(employeeName, employeeAge,
                vehicle, employeeRate, hoursWorked, fixedAmount);
    }

    // This method returns null if employee doesn't own any vehicle. If he / she owns a vehicle, it asks for details
    // of the vehicle and returns a vehicle object that can be car or motorcycle.
    public static Vehicle hasVehicle() {
        Scanner input = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Does this employee owns any vehicle? (y/n)");
        char answer = input.next().toLowerCase().charAt(0);

        if (answer == 'y') {
            System.out.println("Choose an option below");
            System.out.println("-------------------------------");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the car make: ");
                    String carMake = validatedString(input);

                    System.out.println("Enter the car plate: ");
                    String carPlate = validatedString(input);

                    System.out.println("Enter the car color: ");
                    String carColor = validatedString(input);

                    System.out.println("Enter the car type (ex: Sedan): ");
                    String carType = validatedString(input);

                    return new Car(carMake, carPlate, carColor, carType);

                case 2:
                    System.out.println("Enter the motorcycle make: ");
                    String motorMake = validatedString(input);

                    System.out.println("Enter the motorcycle plate: ");
                    String motorPlate = validatedString(input);

                    System.out.println("Enter the motorcycle's engine cylinder (ex: 5000): ");
                    int motorEngine = input.nextInt();

                    System.out.println("Enter the motorcycle's engine horse power (ex: 500): ");
                    int motorPower = input.nextInt();

                    return new Motorcycle(motorMake, motorPlate, motorEngine, motorPower);

                default:
                    break;
            }
        }

        return null;

    }

    // This method calculates the total payroll each time we add new employee.
    public static double calculatePayroll(ArrayList<Employee> employees) {
        double total = 0.0;

        for (Employee employee: employees) {
            total += employee.calcEarnings();
        }

        return total;
    }

    // This method prints the total payroll. (To make the code cleaner)
    public static void printTotalPayroll(ArrayList<Employee> employees) {
        for (Employee employee: employees) {
            employee.printMyData();
        }

        System.out.println("TOTAL PAYROLL: " + calculatePayroll(employees) + " Canadian Dollars");
    }

    // I created a special function for inputs that contains whitespaces (otherwise application doesn't work properly)
    public static String validatedString(Scanner input) {
        // Creating a ArrayList for string. (Used ArrayList instead of normal array to access it's special methods)
        ArrayList<String> strings = new ArrayList<>();
        // When we input any string, it appends to the ArrayList.
        strings.add(input.next());

        // We assign first stored index to a variable because we will reuse this function for all String inputs, so
        // we can clear and reuse it.
        String inputString = strings.get(0);
        strings.clear();

        return inputString;
    }

    // Validating commission rate to be correct value, otherwise calculation will not show the correct result.
    public static Double validatedCommission(Scanner input) {
        double commission = input.nextDouble();

        if (commission >= 0 && commission <= 1) {
            return commission;
        }

        return null;
    }

    // This method can be used as test case for saving time.
    public static void testData(ArrayList<Employee> employees) {
        Vehicle toyota = new Car("Toyota", "34 HAS 91", "Dark Blue", "Sedan");
        Vehicle bmw = new Car("BMW", "11 ZOL 33", "Red", "Hatchback");

        Vehicle yamaha = new Motorcycle("Yamaha", "28 ALS 112", 5000, 350);
        Vehicle honda = new Motorcycle("Honda", "03 KHA 004", 3000, 125);

        Employee intern1 = new Intern("Onurcan Sever", 22, bmw, "Lambton College");
        Employee intern2 = new Intern("John Blackbeard", 26, null, "Seneca College");
        employees.add(intern1);
        employees.add(intern2);

        Employee fullTime1 = new FullTime("Elise Bandwidth", 29, yamaha, 5000, 1000);
        Employee fullTime2 = new FullTime("Zack Blue", 36, null, 5500, 1400);
        employees.add(fullTime1);
        employees.add(fullTime2);

        Employee comPartTime1 = new CommissionBasedPartTime("Hector Birdsworth", 53, toyota, 30, 10, 0.15);
        Employee comPartTime2 = new CommissionBasedPartTime("John Black", 24, honda, 30, 10, 0.2);
        employees.add(comPartTime1);
        employees.add(comPartTime2);

        Employee fixedPartTime1 = new FixedBasedPartTime("Cindy Light", 45, bmw, 30, 20, 100);
        Employee fixedPartTime2 = new FixedBasedPartTime("Matthew Flyronn", 27, null, 26, 16, 80);
        employees.add(fixedPartTime1);
        employees.add(fixedPartTime2);

        printTotalPayroll(employees);

    }

}
