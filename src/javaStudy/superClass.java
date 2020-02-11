package javaStudy;

public class superClass {

	public static void main(String[] args) {
		superC s1 = new superC("张三", 18);
		childC c1 = new childC();
		childC c2 = new childC("李四",20,"成都");
		System.out.println(s1.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
class superC{
	private String name;
	private int age;
	public superC(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
	
}
class childC extends superC{
	private String location;
	public childC() {
		this("null", 0, "成都");
	}
	public childC(String name,int age,String location){
		super(name,age);
		this.location = location;
	}
	public void setName(String name) {
		this.setName(name); 
	}
	public void setAge(int age) {
		this.setAge(age);
	}
	public String getLocation() {
		return location;
	} 

	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		
		return super.toString()+"[location=" + location + "]";
	}
	
}