package Draw;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Main.Language;

public class MainScreen implements Drawing {

	JButton ADDB;
	JButton look_seatB;
	JButton ChangeLangB;
	JButton BuyGiftcard;
	JButton ChargeTB;
	public void Draw() {
		//////////////////////////�̸��� ����� �ٲپ� �ֱ� ���� ������/////////////////////////////////////////
		String look_seat_name[] = {"�¼� Ȯ��", "CHECK SEAT"};
		String changeLang_name[] = {"��� ����", "LANGUAGE CHANGE"};
		String BuyGiftCard_name[] = {"��ȭ ��ǰ�� ����", "BUY GIFT CARD"};
		String ChargeTB_name[] = {"�ð� ����", "CHARGE TIME"};
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		
		JFrame main_screen = new JFrame("main_screen");
		main_screen.setSize(1800,900);
		main_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_screen.setLayout(new BorderLayout());
		

		look_seatB = new JButton(look_seat_name[Language.LNG]);
		ChangeLangB = new JButton(changeLang_name[Language.LNG]);
		BuyGiftcard = new JButton(BuyGiftCard_name[Language.LNG]);
		ChargeTB = new JButton(ChargeTB_name[Language.LNG]);
		
		
		main_screen.add(look_seatB,"East");
		main_screen.add(ChangeLangB, "South");
		main_screen.add(BuyGiftcard,"West");
		main_screen.add(ChargeTB, "Center");

		main_screen.setVisible(true);
		
	
		look_seatB.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				Drawing D = new CheckingSeat();
				D.Draw();
				System.out.println("�¼� ����");
			}
		});
		
		ChangeLangB.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				Language.change();
				main_screen.dispose();
				Drawing D = new MainScreen();
				D.Draw();
			}
		});
		
		BuyGiftcard.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ȭ ��ǰ�� ����");
				main_screen.dispose();
				Drawing D = new BuyGiftCard();
				D.Draw();
			}
		});
		
		ChargeTB.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				main_screen.dispose();
				Drawing D = new LoginScreen();
				D.Draw();
			}
		});
		
	}


}
