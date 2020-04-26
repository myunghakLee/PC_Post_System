package Draw;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Main.Approval;

public class BuyGiftCard implements Drawing {
	public void Draw() {
		JFrame GiftCard_screen = new JFrame("GifrCard_screen");
		GiftCard_screen.setSize(1800,900);
		GiftCard_screen.setLayout(new GridLayout(3,2));
		Approval L = new Approval(GiftCard_screen);
		JButton []Gift = new JButton[6];
		Gift[0] = new JButton("1000");
		Gift[1] = new JButton("3000");
		Gift[2] = new JButton("5000");
		Gift[3] = new JButton("10000");
		Gift[4] = new JButton("30000");
		Gift[5] = new JButton("50000");

		for(int i=0; i<6;i++) {
			Gift[i].addActionListener(L);
			GiftCard_screen.add(Gift[i]);
		}
		
		
		GiftCard_screen.setVisible(true);

	}

}
