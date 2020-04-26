package Main;

import java.util.Calendar;

public class Customer {
	String ID;
	String PW;
	String name;
	String Phone_num;
	int age;
	String Remaining_time;
	Customer(String ID, String PW,String name, String Phone_num, String Byear, String Remaining_time){
		this.ID = ID;
		this.PW = PW;
		this.name = name;
		this.Phone_num = Phone_num;
		this.age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(Byear);
		this.Remaining_time = Remaining_time;
	}
	public void print_info(){
		System.out.println(ID + " " +PW + " " +name + " " +Phone_num + " " +age + " " +Remaining_time);
		
	}

	public String get_ID() {
		return ID;
	}
	public String get_PW() {
		return PW;
	}
	public String get_name() {
		return name;
	}
	public String get_Phone_num() {
		return Phone_num;
	}
	public int age() {
		return age;
	}
	public String get_Remaining_time() {
		return Remaining_time;
	}


}
