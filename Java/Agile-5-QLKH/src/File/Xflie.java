package File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Duy
 */
public class Xflie {
//	public static String path ="C:\\Program Files\\QLKH\\File.txt";
//    StringBuilder error = new StringBuilder();
   static ArrayList<String> listFile =new ArrayList();
    public static Object readObject(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));) {
            Object object = ois.readObject();
            ois.close();
            return object;
        }
    }

    public static void writeObject(String path, Object object) throws FileNotFoundException, IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(object);
            oos.close();
        }
    }
//    public static void main(String[] args) {
//    	try {
////    		listFile=  (ArrayList<String>) Xflie.readObject(path);
//    		String string ="Lịch Sử";
//    		listFile.add(string);
//    		Xflie.writeObject(path, listFile);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
}