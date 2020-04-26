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
		
		//////////////////////////이름을 영어로 바꾸어 주기 위한 변수들/////////////////////////////////////////
		String LoginB_name[] = {"로그인", "Login"};
		String IDlable_name[] = {"회원일 경우 ID로 로그인 해 주십시오.", "If you are a member, please login with your ID."};
		String cardlable_name[] = {"비회원일 경우 본 PC방에서 제공하는 card번호로 로그인해 주십시오.", "If you are not a member, log in using the card number provided in this PC room."};
		String Remain_time_is[] = {"남은 시간은", "remain time is"};
		String Respect[] = {"입니다.", ""};
		String Check_your_ID[] = {"ID를 다시 확인해 주세요", "Check Your ID"};
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
				
				if(ID.getText().length()>2 ) {					//회원으로 로그인
					if(DataBase.IS_correnct_ID(ID.getText())) {	//로그인 성공
						System.out.println("로그인 성공");
						Customer C = DataBase.fill_in_information(ID.getText());
						//C.print_info();
						JOptionPane.showMessageDialog(null, Remain_time_is[Language.LNG] + C.get_Remaining_time() + Respect[Language.LNG]);
						Login_screen.dispose();
						Drawing D = new BuyTimeScreen(C);
						D.Draw();
					}
					else {
						JOptionPane.showMessageDialog(null, "아이디를 다시 확인해 주세요.");
						System.out.println("로그인 실패");
					}

				}
				else {											//비회원으로 로그인
					int card_number = Integer.parseInt(CardNum.getText());
					if(card_number>0 && card_number<41) {
						System.out.println("로그인 성공");
						Customer C = DataBase.fill_in_information(CardNum.getText());
						//C.print_info();
						Login_screen.dispose();
						Drawing D = new BuyTimeScreen(C);
						D.Draw();

						
					}
					else {
						JOptionPane.showMessageDialog(null, Check_your_ID[Language.LNG]);
						System.out.println("로그인 실패");
					}
				}
			}
		});
	}
}
