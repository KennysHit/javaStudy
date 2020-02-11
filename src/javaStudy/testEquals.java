package javaStudy;

public class testEquals {

	public static void main(String[] args) {
		Eq e1 = new Eq(1, 'a');
		Eq e2 = new Eq(1, 'a');
		System.out.println(e1.equals(e2));
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1.equals(s2));
		Eqqq eq1 = new Eqqq(1,'a',1);
		Eqqq eq2 = new Eqqq(1,'a',1);
		System.out.println(eq1.equals(eq2));
	}
}
class  Eq{
	private int i;
	private char j;
	public Eq(int i,char j) {
		this.i = i;
		this.j = j;
		
	}
	public boolean equals(Object obj) {
		if(obj==null) {return false;}
		else if(obj instanceof Eq) {
			Eq e = (Eq)obj;
			if(this.i==e.i && this.j==e.j) {
				return true;
			}
			return false;
		}else {
			return false;
		}
	}
}
class Eqqq extends Eq{
	int k;
	public Eqqq(int i,char j,int k) {
		super(i,j);
		this.k = k;
	}
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(obj instanceof Eqqq) {
				Eqqq eqqq = (Eqqq)obj;
				if(this.k == eqqq.k) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}