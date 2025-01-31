class Employee
{
  private String name;
  private int id;
  private double salary;

  public Employee(String name,int id,double salary)
  {
   this.name=name;
   this.id=id;
   this.salary=salary;
  }
   void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("Employee ID: "+id);
        System.out.println("Salary: "+salary);
      }
public static void main(String []args)
{
Employee employee=new Employee("Harshit Kumar Goyal", 123, 60000.00);
employee.displayDetails();
}
}

