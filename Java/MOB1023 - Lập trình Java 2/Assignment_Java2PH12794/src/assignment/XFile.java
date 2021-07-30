package assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class XFile implements Serializable{
//	public static void main(String[] args) throws IOException {
//		ArrayList<Staff> list = new ArrayList<Staff>();
//		
//
//		list.add(new Staff("NV11209","Trương Đức Huy",19,"huytd@gmail.com",15000000));
//		list.add(new Staff("NV09543","Quách Đức Anh",21,"anhqd@gmail.com",10000000));
//		list.add(new Staff("NV12794","Nguyễn Đức Thành",24,"thanhnd@gmail.com",9000000));
//		list.add(new Staff("NV08674","Nguyễn Phùng Chung",27,"chungnp@gmail.com",8000000));
//		list.add(new Staff("NV13545","Nguyễn Duyên Vinh",24,"vinhnd@gmail.com",7000000));
//		list.add(new Staff("NV11209","Trịnh Thị Lan",19,"lantt@gmail.com",7600000));
//		list.add(new Staff("NV16501","Nguyễn Danh Huy",25,"huynd@gmail.com",8300000));
//		list.add(new Staff("NV16101","Nguyễn Công Quý",23,"quync@gmail.com",6700000));
//		list.add(new Staff("NV15305","Hoàng Quốc Huy",25,"huyhq@gmail.com",9800000));
//		list.add(new Staff("NV09435","Nguyễn Việt Hà",18,"hanv@gmail.com",6900000));
//		
//		System.out.println("done");
//		
//		
//		
//	}
	
	@SuppressWarnings("resource")
	public static Object readObject(String path) throws IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Object staff = new Object();
		try {
			staff = ois.readObject();
			ois.close();
			return staff;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void writeObject(Object staffObject, String path) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(staffObject);
		oos.close();
	}
}
