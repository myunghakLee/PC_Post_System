package Draw;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;

import Main.Customer;
import Main.Language;
import Main.Approval;

public class BuyTimeScreen implements Drawing {
	JButton T1;
	JButton T3;
	JButton T5;
	JButton T8;
	JButton T12;
	JButton T24;
	int price;
	double discount = 1;

	public Customer C = null;
	public BuyTimeScreen(Customer C){
		this.C = C;
	}
	public void Draw() {
		if(C.get_ID().length()>2) {discount = 0.9;}
		//////////////////////////이름을 영어로 바꾸어 주기 위한 변수들/////////////////////////////////////////
		String T1_name[] = {"1시간:\n" + (int)(1000*discount)  +"원", 		"1hour:\n" + (int)(1000*discount)};
		String T3_name[] = {"3시간:\n" + (int)(3000*discount) +"원", 			"3hour:\n" + (int)(3000*discount)};
		String T5_name[] = {"5시간:\n" + (int)(4000*discount) +"원", 			"5hour:\n" + (int)(4000*discount)};
		String T8_name[] = {"8시간:\n" + (int)(6500*discount) +"원", 			"8hour:\n" + (int)(6500*discount)};;
		String T12_name[] = {"12시간:\n" + (int)(10000*discount) +"원", 		"12hour:\n" + (int)(10000*discount)};
		String T24_name[] = {"24시간:\n" + (int)(20000*discount) + "원",	 	"24hour:\n" + (int)(20000*discount)};
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		JFrame Buy_T_screen = new JFrame("Buy_T_screen");
		Buy_T_screen.setSize(1800,900);
		Buy_T_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Buy_T_screen.setLayout(new GridLayout(3,2));
		Approval L = new Approval(Buy_T_screen);
		
		
		T1 = new JButton(T1_name[Language.LNG]);
		T3 = new JButton(T3_name[Language.LNG]);
		T5 = new JButton(T5_name[Language.LNG]);
		T8 = new JButton(T8_name[Language.LNG]);
		T12 = new JButton(T12_name[Language.LNG]);
		T24 = new JButton(T24_name[Language.LNG]);
		
		T1.addActionListener(L);
		T3.addActionListener(L);
		T5.addActionListener(L);
		T8.addActionListener(L);
		T12.addActionListener(L);
		T24.addActionListener(L);
		
		Buy_T_screen.add(T1);
		Buy_T_screen.add(T3);
		Buy_T_screen.add(T5);
		Buy_T_screen.add(T8);
		Buy_T_screen.add(T12);
		Buy_T_screen.add(T24);
		Buy_T_screen.setVisible(true);
		
		
	}
    
}
