package collectionStudy;

import java.util.*;
public class testComparable {

	public static void main(String[] args) {
		Collection<comPerson> c = new LinkedList<comPerson>();
		c.add(new comPerson("ZhangSan", 18));
		c.add(new comPerson("LiSi", 19));
		c.add(new comPerson("WangWu", 22));
		c.add(new comPerson("SunLiu", 17));
		c.add(new comPerson("ZhaoQi", 20));
		c.add(new comPerson("LiuBa", 21));
		
		Collections.sort((List<comPerson>) c);
		System.out.println(c);
	}
	
}
class comPerson implements Comparable<comPerson>{
	private String name;
	private int age;
	public comPerson(String name,int age) {
		this.age = age;
		this.name = name;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if(obj instanceof comPerson) {
			comPerson c = (comPerson)obj;
			if(this.name.equals(c.name) && this.age==c.age) {
				return true;
			}
		}
		return false;
	}

	public int compareTo(comPerson o) {
		return this.age==o.age?0:(this.age>o.age?1:-1);//按照年龄大小排序
	}
	public String toString() {
		return "姓名："+this.name+" 年龄："+this.age;
	}
}
