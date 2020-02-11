package javaStudy;

public class Polymorphic {

	public static void main(String[] args) { 
		province province = new province("China", "Sichuan");
		company company = new company("China", "Alipapa");
		polymorphicPeople people = new polymorphicPeople("Zhangsan", province);
		people.info();
	}

}
abstract class country{
	private String countryName;
	public country(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String cName) {
		this.countryName = cName;
	}
	abstract public void declare();
}
class company extends country{
	private String companyName;
	public company(String countryName,String companyName) {
		super(countryName);
		this.companyName = companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public void declare() {
		System.out.println("I am living："+this.getCountryName()+" country "+this.getCompanyName()+" company");
	}

	
}
class province extends country{
	private String provinceName;
	public province(String countryName,String provinceName) {
		super(countryName);
		this.provinceName = provinceName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public void declare() {
		System.out.println("I am living："+this.getCountryName()+" country "+this.getProvinceName()+" province");
	}
}
class polymorphicPeople{
	private String name;
	country country;
	public polymorphicPeople(String name,country country) {
		this.name = name;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public country getCountry() {
		return country;
	}
	public void setCountry(country country) {
		this.country = country;
	}
	public void info() {
		System.out.println("my name is："+this.name);
		country.declare();
	}
}