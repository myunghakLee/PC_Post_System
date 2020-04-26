package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Draw.CheckingSeat;

public class Check_Seat_actionListner extends CheckingSeat implements ActionListener {
	public void actionPerformed(ActionEvent E) {
		
		try {
			System.out.println(E.getID());
			System.out.println(E.getActionCommand());
			int SeatID = Integer.valueOf(E.getActionCommand()).intValue();
			String time = DataBase.Check_Seat_time(SeatID);
			JOptionPane.showMessageDialog(null, time);
		}
		catch(Exception e) {
			System.out.println("ERROR \n"+e);
		}	
		
	}
}
