package app;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class file_system {
	
	
	String level = "lv1";
	File file;
	
	
	public void load_new(String g){
		
		level = g;
		
//		data.loadnew = true;
	}
	
	
	//check code
	public void save(){
		 try{
			 
			file = new File(getClass().getResource("save.txt").toURI());
			FileWriter a = new FileWriter(file);
			a.write(level);
			a.close();
				
		 }catch (Exception e){
			 System.out.println(e);
		 }
	}
	//check code
	public void write_new_file(){
		level = "lv1";
		save();
	}
	
	//check code
	public void load_save(){
		
		try{
			Scanner f = new Scanner(file);
			level = f.next();
			
			//remove println code later
			System.out.println(level);
			f.close();
		}catch (Exception e){
			System.out.println(e);
		}
	}
	public void set(String a){
		level = a;
		System.out.println(a);

	}

}
