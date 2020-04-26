package Draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


import Main.Check_Seat_actionListner;
import Main.DataBase;


public class CheckingSeat implements Drawing {
	public static final int SEAT_NUM = 30;

	public void Draw(){
		try {
			Check_Seat_actionListner L = new Check_Seat_actionListner();
			JFrame frame = new JFrame("Swing GUI"); //1.�ֻ��� �����̳� ����
			frame.setSize(900, 450); //������		
			frame.setLayout(new FlowLayout());
			
			JButton[] seat = new JButton [SEAT_NUM]; //2.������Ʈ�� �߰��ϱ�
			int []color = new int [SEAT_NUM];
			color = DataBase.get_color(SEAT_NUM);
			
			for(int i=0;i<SEAT_NUM;i++) {
				System.out.println(color[i]);
				seat[i] = new JButton(""+(i+1));
				seat[i].setPreferredSize(new Dimension(130,70));
				if(color[i] == 1) {
					seat[i].setBackground(new Color(100,100,200));
				}
				else {
					seat[i].setBackground(new Color(10,10,20));	
				}
				frame.add(seat[i]);
				seat[i].addActionListener(L);
				
			}
			
			frame.setLocation(300, 200);  //��ġ ����
			frame.setVisible(true); //ȭ�鿡 ���̱�
		}
		catch(Exception e) {
			System.out.println("ERROR \n"+e);
		}
	}
}
