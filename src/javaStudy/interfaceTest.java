package javaStudy;

public class interfaceTest {

	public static void main(String[] args) {
		interfaceSon son = new interfaceSon("Deng", "Shangyu");
		interfaceTest interfaceTest = new interfaceTest();
		interfaceTest.testInfo(son);
		interfaceTest.playing(son);
		interfaceTest.studying(son);
	}
	public void playing(play p) {
		p.basketball();
	}
	public void studying(study s) {
		s.math();
	}
	public void testInfo(interfaceFather f) {
		f.info();
	}
}
interface play {
	public void basketball();
}
interface study{
	public void math();
}
class interfaceFather {
	private String firstName;
	public interfaceFather(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void info() {
		System.out.println("my first name is:"+this.getFirstName());
	}
} 
class interfaceSon extends interfaceFather implements play,study{
	private String lastName;
	public interfaceSon(String firstName,String lastName) {
		super(firstName);
		this.lastName = lastName;
	}
	public void basketball() {
		System.out.println("i can play basketball");
	}
	public void math() {
		System.out.println("i will study Math");
	}
	public String getlastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void info() {
		System.out.println("my name is:"+super.getFirstName()+" "+this.lastName);
	}
}