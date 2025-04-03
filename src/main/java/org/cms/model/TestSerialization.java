package model;
import java.io.*;

public class TestSerialization {

	public static void main(String[] args) throws IOException {
			File file = new File("/Users/danish/Desktop/TechM/studentser.dat");
			FileOutputStream fw = new FileOutputStream(file);
			System.out.println("File Created");
			ObjectOutputStream out = new ObjectOutputStream(fw);
	        System.out.println("object bytestream ");
	        Student s=new Student("1010","sunil","bengaluru",2017);
	        out.writeObject(s);
	        System.out.println("object serialized");
	}
}
