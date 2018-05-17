class Dog{
	int size;
	String name;
	
	void bark(){
		if(size < 20) 
			System.out.println(this.name+"  " +"a");
		else if(size < 50)
			System.out.println(this.name+"  "  +"b");
		else 
			System.out.println(this.name+"  "  +"c");
	}
}
public class DogTest {
	public static void main(String[] args) {
		Dog one = new Dog();
		Dog two = new Dog();
		Dog three = new Dog();
		
		one.name = "A";
		one.size = 15;
		two.name = "B";
		two.size = 45;
		three.name = "C";
		three.size = 60;
		
		one.bark();
		two.bark();
		three.bark();
	}
}
