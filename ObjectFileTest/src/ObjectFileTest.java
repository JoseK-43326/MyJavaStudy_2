import java.util.*;
import java.io.*;


public class ObjectFileTest {

	public static void main(String[] args) {
		
		Manager boss = new Manager("Mike", 80000, 1995, 10, 10);
		boss.setBouns(5000);
		Employee[] staff = new Employee[3];
		
		staff[0] = boss;
		staff[1] = new Employee("Jarry", 50000, 1998, 11, 12);
		staff[2] = new Employee("HeDan", 60000, 2000, 10, 03);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:\\java\\java_test\\ObjectFileTest.txt"));
			out.writeObject(staff);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\java\\java_test\\ObjectFileTest.txt"));
			Employee[] employees =(Employee[]) in.readObject();
			in.close();
			
			for(Employee e : employees)
				System.out.println(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(){}	
	public Employee(String n, double s, int y, int m, int d){
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(y, m-1, d);
		hireDay = calendar.getTime();
	}
	
	public String getName(){
		return name;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public Date getHireDay(){
		return hireDay;
	}
	
	public String toString(){
		return getClass().getName() 
				+ "[name = " + name 
				+ ", salary = " + salary
				+ ", hireDay = " + hireDay
				+ "]";
	}
}

class Manager extends Employee{
	
	private static final long serialVersionUID = 1L;
	private double bouns;
	
	public Manager(String n, double s, int y, int m, int d){
		super(n, s, y, m, d);
		bouns = 0;
	}
	
	public void setBouns(double b){
		bouns = b;
	}
	
	public double getSalary(){		
		double baseSalary = super.getSalary();
		return baseSalary + bouns;
	}
		
	public String toString(){
		return super.toString() 
				+ "[bouns = " + bouns + "]";
	}
}