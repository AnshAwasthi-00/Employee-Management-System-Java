import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        System.out.println("\n------ WELCOME TO EMPLOYEE MANAGEMENT SYSTEM ------");
        while(true) {
            System.out.println("1:To add employee");
            System.out.println("2:To view employees");
            System.out.println("3:To search an employee");
            System.out.println("4:To delete an employee");
            System.out.println("5:To update an employee");
            System.out.println("6: To exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    boolean exists = false;
                    for(Employee emp : employees){
                        if(emp.getId() == id){
                            exists = true;
                            break;
                        }
                    }
                    if(exists){
                        System.out.println("Employee ID already exists..!!");
                    }
                    else{
                        System.out.print("Enter employee name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter employee department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter employee salary: ");
                        double salary = scanner.nextDouble();
                        employees.add(new Employee(id, name, department, salary));
                        System.out.println("Employee details added successfully");
                    }
                    break;

                case 2:
                    if(employees.isEmpty()){
                        System.out.println("No employees found..!!");
                    }
                    else {
                        System.out.println("Showing employees: ");
                        System.out.println("------------");
                        for (Employee emp : employees) {
                            emp.display();
                            System.out.println("------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the employee's ID you want to search: ");
                    int seachid = scanner.nextInt();

                    boolean found = false;

                    for(Employee emp : employees){
                        if(emp.getId() == seachid){
                            found = true;
                            System.out.println("Employee found..!!");
                            emp.display();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Employee not found..!!");
                    }
                    break;

                case 4:
                    System.out.print("Enter the employee's ID you want to remove: ");
                    int deleteid = scanner.nextInt();

                    boolean removed = false;

                    for(Employee emp : employees){
                        if(emp.getId() == deleteid){
                            employees.remove(emp);
                            removed = true;
                            System.out.println("Employee removed..!!");
                            break;
                        }
                    }
                    if(!removed){
                        System.out.println("Employee not found..!!");
                    }
                    break;

                case 5:
                    System.out.println("Enter the employee's ID you want to update: ");
                    int updateid = scanner.nextInt();

                    boolean updated = false;

                    for(Employee emp : employees){
                        if(emp.getId() == updateid){
                            updated = true;
                            System.out.println("Select what you want to update");
                            System.out.println("1:Update Name");
                            System.out.println("2:Update ID");
                            System.out.println("3:Update Salary");
                            System.out.println("4:Update Department");
                            System.out.println("Enter choice(1/2/3/4): ");
                            int ch = scanner.nextInt();

                            switch (ch){
                                case 1:
                                    System.out.println("Enter new name: ");
                                    scanner.nextLine();
                                    emp.setName(scanner.nextLine());
                                    break;

                                case 2:
                                    System.out.println("Enter new ID: ");
                                    emp.setId(scanner.nextInt());
                                    System.out.println("Updated successfully");
                                    break;

                                case 3:
                                    System.out.println("Enter new salary: ");
                                    emp.setSalary(scanner.nextDouble());
                                    System.out.println("Updated successfully");
                                    break;

                                case 4:
                                    System.out.println("Enter new department: ");
                                    scanner.nextLine();
                                    emp.setDepartment(scanner.nextLine());
                                    System.out.println("Updated successfully");
                                    break;

                                default:
                                    System.out.println("Enter a valid choice..!!");
                            }
                            break;
                        }

                    }
                    if(!updated){
                        System.out.println("Employee not found..!!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting..!!");
                    return;

                default:
                    System.out.println("Enter a valid choice..!!");

            }

            System.out.print("Would you like to continue(Y/N)?: ");
            char ch = scanner.next().charAt(0);
            System.out.println();
            if(ch == 'Y' || ch == 'y'){
                continue;
            }
            else{
                System.out.println("THANK YOU..!!");
                return;
            }
        }
    }
}