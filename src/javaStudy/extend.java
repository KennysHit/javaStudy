package javaStudy;

public class extend {

	public static void main(String[] args) {
		son s1 = new son("张三",18,01,"阳安中学");
		s1.setName("李登怀");
		s1.display();

	}

}
class father{
	private String name;
	private int age;
	private int id;
	father(String name,int age,int id) {
		this.name = name;
		this.age = age;
		this.id = id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
class son extends father{
	private String school;
	son(String name,int age,int id,String school){
		super(name, age, id);
		this.school = school;
	}
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	public void display() {
		System.out.println("name:"+this.getName());
		System.out.println("age:"+this.getAge());
		System.out.println("id:"+this.getId());
		System.out.println("school:"+this.getSchool());
	}
}