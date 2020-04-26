package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Draw.MainScreen;
import Draw.Drawing;

public class Approval implements ActionListener {
	JFrame Frame;
	public Approval(JFrame frame) {
		this.Frame = frame;
	}

	String ID;
	JFrame frame;

	public void actionPerformed(ActionEvent E) {
		String s[] = {"�ݾ��� �־��ּ���", "insert money"};
		String s2[] = {"�ùٸ� �ݾ��� �־��ּ���", "Please put the correct amount"};
		String S3[] = {"��ȭ��ǰ�� ��ȣ�� ������ �����ϴ�.", "Here is your GiftCardNumber"};
 		try {
			
			String input_money = JOptionPane.showInputDialog(s[Language.LNG] + E.getActionCommand() );
			
			try {
				Integer.valueOf(E.getActionCommand()).intValue();
				System.out.println("����Ʈ ī�� ���");

				String price = E.getActionCommand();
				if(input_money.equals("card") || price.equals(input_money)) {
					String Code = DataBase.PrintGiftCard(price);
					JOptionPane.showMessageDialog(null, S3[Language.LNG] + "\n"+Code);
					Frame.dispose();
					Drawing D = new MainScreen();
					D.Draw();
				}
				else {
					
					JOptionPane.showMessageDialog(null, s2[Language.LNG]);
				}
				
			}
			catch(Exception e){
				
				System.out.println("�ð� ����");
				
				if(input_money.equals("card")) {
					String temp_str = E.getActionCommand();
					charge_time(temp_str, return_money(temp_str));
				}
				else {
					input_money = input_money.replace("\n", "");
					int money_input = Integer.valueOf(input_money).intValue();
					String AE = E.getActionCommand();
					
					charge_time(AE,money_input);
				}
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, s2[Language.LNG]);
			System.out.println("ERROR \n"+e);
		}		
		
	}
	
	public void charge_time(String AE, int money_input) {
		int need_money = return_money(AE);
		if(need_money == money_input) {
			String s[] = {"�ð��� �����Ǿ����ϴ�.", "hour charged"};
			//System.out.println(return_time(AE));
			int Time = return_time(AE);
			DataBase.Charge_time(ID, Time);
			JOptionPane.showMessageDialog(null, Time + s[Language.LNG]);
			
			Frame.dispose();
			Drawing D = new MainScreen();
			D.Draw();
		}
		else {
			String s[] = {"�ùٸ� �ݾ��� �־��ּ���", "Please put the correct amount"};
			JOptionPane.showMessageDialog(null, s[Language.LNG]);
		}
		
	}
	
	public int return_money(String AE) {
		
		int price = 0;
		if(AE.compareTo("1")>=0 && AE.compareTo("9") <=0) {
			String[] array = AE.split(":");
			String str = array[1].replace("��", "");
			str = str.replace("\n", "");
			System.out.println(array[1]);

			price = Integer.valueOf(str).intValue();
		}		
		return price;
		
	}

	public int return_time(String AE) {
		int time = 0;
		String[] array = AE.split("�ð�|hour");
		String str = array[0].replace("��", "");
		str = str.replace("\n", "");
		time = Integer.valueOf(str).intValue();
		return time;
		
	}
}

