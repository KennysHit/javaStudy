package javaStudy;

public class casting {

	public static void main(String[] args) {
		casting c = new casting();
		people p = new people("name");
		teacher t = new teacher("Deng", "Yangan");
		busDriver b = new busDriver("Liu", 726);
		p = new teacher("Shuai", "Yangan");
		c.castingPrint(p);
		c.castingPrint(t);
		c.castingPrint(b);
	}
	
	public void castingPrint(people p) {
		System.out.println("name："+p.getName());
		if(p instanceof teacher) {
			teacher t = (teacher)p;
			System.out.println("teacher "+t.getName()+" is working in："+t.getSchool()+" school");
		}
		if(p instanceof busDriver) {
			busDriver b = (busDriver)p;
			System.out.println(b.getName()+"'s id of his bus is："+b.getCarId());
		}
	}
}
class people{
	private String name;
	public people(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class teacher extends people{
	private String school;
	public teacher(String name,String school) {
		super(name);
		this.school = school;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
}
class busDriver extends people{
	private int carId;
	public busDriver(String name,int carId) {
		super(name);
		this.carId = carId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
}
