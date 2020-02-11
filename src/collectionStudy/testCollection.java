package collectionStudy;
import java.util.*;


public class testCollection {

	public static void main(String[] args) {
		Collection<collectionPerson> c = new LinkedList<collectionPerson>();
		Collection<collectionPerson> b = new HashSet<collectionPerson>();
		b.add(new collectionPerson("Zhang san"));
		b.add(new collectionPerson("Wang er ma zi"));
		b.add(new collectionPerson("wang wu"));
		c.add(new collectionPerson("Zhang san"));
		c.add(new collectionPerson("li si"));
		c.add(new collectionPerson("wang wu"));
		collectionPerson c1 = new collectionPerson("Zhang san");
		for(Iterator<collectionPerson> i = c.iterator();i.hasNext();) {
			collectionPerson testc = (collectionPerson)i.next();
			if(c1.equals(testc)) {
				System.out.println("Find Zhang san");
			}else {
				System.out.println(testc.getName());
			}
		}
		b.retainAll(c);
		System.out.println("c和b的交集："+b);
	}
	
}
class collectionPerson{
	private String name;
	public collectionPerson(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean equals(Object obj) {
		if(obj instanceof collectionPerson) {
			collectionPerson c = (collectionPerson) obj;
			if(this.name.equals(c.name)) {
				return true;
			}
		}
		return super.equals(obj);
	}
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public String toString() {
		return this.name;
	}
}