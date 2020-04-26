package Draw;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Main.Customer;
import Main.DataBase;
import Main.Language;

public class LoginScreen implements Drawing {

	public Customer C;
	
	public void Draw() {
		
		//////////////////////////�̸��� ����� �ٲپ� �ֱ� ���� ������/////////////////////////////////////////
		String LoginB_name[] = {"�α���", "Login"};
		String IDlable_name[] = {"ȸ���� ��� ID�� �α��� �� �ֽʽÿ�.", "If you are a member, please login with your ID."};
		String cardlable_name[] = {"��ȸ���� ��� �� PC�濡�� �����ϴ� card��ȣ�� �α����� �ֽʽÿ�.", "If you are not a member, log in using the card number provided in this PC room."};
		String Remain_time_is[] = {"���� �ð���", "remain time is"};
		String Respect[] = {"�Դϴ�.", ""};
		String Check_your_ID[] = {"ID�� �ٽ� Ȯ���� �ּ���", "Check Your ID"};
		/////////////////////////////////////////////////////////////////////////////////////////////

		
		
		
		JTextField ID,CardNum;
		JButton Login;
		JLabel IDlable, cardlable;
		JFrame Login_screen = new JFrame("Login_screen");
		Login_screen.setSize(1800,900);
		//Login_screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login_screen.setLayout(new GridLayout(5,2));

		
		
		
		ID = new JTextField();
		CardNum = new JTextField();
		Login = new JButton(LoginB_name[Language.LNG]);
		IDlable = new JLabel(IDlable_name[Language.LNG]);
		cardlable= new JLabel(cardlable_name[Language.LNG]);
		
		Login_screen.add(IDlable);
		Login_screen.add(ID);
		Login_screen.add(cardlable);
		Login_screen.add(CardNum);
		Login_screen.add(Login);
		Login_screen.setVisible(true);
		
		Login.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e) {
				
				if(ID.getText().length()>2 ) {					//ȸ������ �α���
					if(DataBase.IS_correnct_ID(ID.getText())) {	//�α��� ����
						System.out.println("�α��� ����");
						Customer C = DataBase.fill_in_information(ID.getText());
						//C.print_info();
						JOptionPane.showMessageDialog(null, Remain_time_is[Language.LNG] + C.get_Remaining_time() + Respect[Language.LNG]);
						Login_screen.dispose();
						Drawing D = new BuyTimeScreen(C);
						D.Draw();
					}
					else {
						JOptionPane.showMessageDialog(null, "���̵� �ٽ� Ȯ���� �ּ���.");
						System.out.println("�α��� ����");
					}

				}
				else {											//��ȸ������ �α���
					int card_number = Integer.parseInt(CardNum.getText());
					if(card_number>0 && card_number<41) {
						System.out.println("�α��� ����");
						Customer C = DataBase.fill_in_information(CardNum.getText());
						//C.print_info();
						Login_screen.dispose();
						Drawing D = new BuyTimeScreen(C);
						D.Draw();

						
					}
					else {
						JOptionPane.showMessageDialog(null, Check_your_ID[Language.LNG]);
						System.out.println("�α��� ����");
					}
				}
			}
		});
	}
}
