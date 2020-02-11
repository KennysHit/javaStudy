package javaStudy;

public class testCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(),3);
		Circle c2 = new Circle(new Point(1.0,1.0),2);
		c1.display();
		c2.display();
		System.out.println();
		System.out.println("c1:"+c1.getArea()+" cm2");
		System.out.println("c1:"+c2.getArea()+" cm2");
	}

}
class Point{
	private double x,y;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Point(double x,double y){
		this.x = x;
		this.y = y;
	}
	public Point(){
		this.x = 0;
		this.y = 0;
	}
	public void display() {
		System.out.println("x:"+this.x+"   y:"+this.y);
	}
}
class Circle{
	private Point p;
	private double r;
	public Circle(Point p,double r){
		this.p = p;
		this.r = r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Point getPoint () {
		return this.p;
	}
	public double getR() {
		return r;
	}
	public void setPoint(int x,int y) {
		this.p.setX(x);
		this.p.setY(y);
	}
	public double getArea() {
		return (3.14*this.r*this.r);
	}
	public void display() {
		System.out.println("x:"+this.p.getX()+"   y:"+this.p.getY());
		System.out.println("r:"+r);
	}
}