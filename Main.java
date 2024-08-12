import java.sql.SQLOutput;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class Employee{
    private String name;
    private int id;


    public Employee(String name,int id){
        this.name=name;
        this.id=id;

    }

    public String getName() {
        return name;
    }



    public int getId() {
        return id;
    }

    public abstract double CalculateSallary();
    @Override
    public String toString() {
        return "employee{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", salary=" + CalculateSallary() +
                '}';
    }

}


class FullTimeEmployee extends Employee {
    private double monthalySalary;

    public FullTimeEmployee(String name, int id,double monthalySalary) {
        super(name, id);
        this.monthalySalary=monthalySalary;
    }

    @Override
    public double CalculateSallary() {
        return monthalySalary;
    }
}
class partTimeEmployee extends Employee{
     private double HourlayRate;
     private int  HoursWorked;

    public partTimeEmployee( String name,int id,int HoursWorked,double HourlayRate){
        super(name, id);
        this.HourlayRate=HourlayRate;
        this.HoursWorked=HoursWorked;
    }

    @Override
    public double CalculateSallary() {

        return HourlayRate*HoursWorked;
    }
}
class payRollSaytem{

    private ArrayList<Employee> employeesList;
    public payRollSaytem(){
        employeesList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);


    }
    public void RemoveEmployee(int id){
        Employee ToRemoveEmployee= null;
        for(Employee employee : employeesList){
            if(employee.getId()==id){
                ToRemoveEmployee=employee;
                break;
            }


        }
        if(ToRemoveEmployee!=null){
            employeesList.remove(ToRemoveEmployee);
        }

    }
    public void DisplayEmployee(){
        for(Employee employee: employeesList){
            System.out.println(employee);
        }
    }

}


public class Main {
    public static void main(String[] args) {
        payRollSaytem payrollSaytem=new payRollSaytem();
        FullTimeEmployee emp1= new FullTimeEmployee("abhi",101,25000.0);
        partTimeEmployee emp2= new partTimeEmployee("akshata",102,40,500);


        payrollSaytem.addEmployee(emp1);
        payrollSaytem.addEmployee(emp2);
        System.out.println("All Employees Details :");
        payrollSaytem.DisplayEmployee();

        System.out.println("_____________________________________________________________________________");

        payrollSaytem.RemoveEmployee(102);
        System.out.println("After Removing the  employee");
        payrollSaytem.DisplayEmployee();


    }
}