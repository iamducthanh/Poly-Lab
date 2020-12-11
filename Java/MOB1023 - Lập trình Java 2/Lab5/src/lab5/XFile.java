package lab5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lab5QLNV.*;

public class XFile {
	public static byte[] read(String path) throws IOException {
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			int i = fis.read();
			System.out.println(i);
			int n = fis.available();
			byte[] chuoi = new byte[n];
			fis.read(chuoi);
			fis.close();
			return chuoi;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void write(String path, byte[] chuoi) throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(chuoi);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Object readObject(String path) throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			Object object = new Object();
			object = ois.readObject();
			return object;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void writeObject(String path, Object object) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(object);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
