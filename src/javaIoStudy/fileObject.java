package javaIoStudy;

import java.io.*;

public class fileObject {

	public static void main(String[] args) {
		try {
			testObject tWrite = new testObject();
			tWrite.setI(20);
			File file = new File("JavaIoTestFiles/object.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tWrite);
			oos.flush();
			oos.close();
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			testObject tRead = (testObject)ois.readObject();
			System.out.println("i："+tRead.getI());
			System.out.println("j："+tRead.getJ());
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
/*
 * Serializable接口，实现序列化必须实现该接口
 * Externalizable接口，自己控制object读写
 */
class testObject implements Serializable,Externalizable{
	private static final long serialVersionUID = 1L;
	private int i;
	transient private int j;//transient使变量在读写时不予考虑
	public testObject() {
		this.i = 10;
		this.j = 100;
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		in.readObject();
	}
	
	
}