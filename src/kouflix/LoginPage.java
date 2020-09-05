package kouflix;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Toolkit;

public class LoginPage
{
	private JFrame frame;
	private JTextField txtMail;
	private JPasswordField txtPass;
	private static String userMail;
	private static String userId;
	
	public static String getUserId()
        {
		return userId;
	}

	public static void setUserId(String userId)
        {
		LoginPage.userId = userId;
	}
	
	
	public static String getUserMail()
        {
		return userMail;
	}

	public void setUserMail(String userMail)
        {
		this.userMail = userMail;
	}

	

	public static void main(String[] args)
        {
		EventQueue.invokeLater(new Runnable()
                {
			public void run()
                        {
				try
                                {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e)
                                {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginPage()
        {
		initialize();
	}

	private void initialize()
        {
		
		frame = new JFrame(); 
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/iconApp.jpg")));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 720, 760);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBounds(0, 0, 720, 50);
		frame.getContentPane().add(panelHead);
		panelHead.setBackground(new Color(0, 0, 0,120));
		panelHead.setLayout(null);
		
		JLabel lblCloseIcon = new JLabel("New label");
		lblCloseIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconClose.png")));
		lblCloseIcon.addMouseListener(new MouseAdapter()
                {
			public void mouseClicked(MouseEvent e)
                        {
				System.exit(0); 
			}
		});
		lblCloseIcon.setBounds(676, 13, 32, 32);
		panelHead.add(lblCloseIcon);
		
		JLabel lblMinusIcon = new JLabel("New label");
		lblMinusIcon.addMouseListener(new MouseAdapter()
                {
			@Override
			public void mouseClicked(MouseEvent e)
                        {
                            frame.setState(frame.ICONIFIED); 
			}
		});
		lblMinusIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconMinus.png")));
		lblMinusIcon.setBounds(632, 13, 32, 32);
		panelHead.add(lblMinusIcon);
		
		JPanel panelMiddle = new JPanel();
                panelMiddle.setBackground(new Color(0, 0, 0,220));
		panelMiddle.setBounds(101, 93, 520, 608);
		frame.getContentPane().add(panelMiddle);
		panelMiddle.setLayout(null);
		
		txtMail = new JTextField();
		txtMail.setForeground(Color.LIGHT_GRAY);
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMail.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtMail.setBackground(new Color(0, 0, 0,220));
		txtMail.setBounds(69, 208, 370, 45);
		panelMiddle.add(txtMail);
		txtMail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(Color.LIGHT_GRAY);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
		txtPass.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtPass.setBounds(69, 279, 371, 45);
		txtPass.setBackground(new Color(0, 0, 0,220));
		panelMiddle.add(txtPass);
		txtPass.setColumns(10);
		
		JPanel panelGir = new JPanel();
		panelGir.setBackground(new Color(178, 34, 34));
		panelGir.setBounds(120, 356, 262, 45);
		panelMiddle.add(panelGir);
		panelGir.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OTURUM A\u00C7");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 262, 45);
		panelGir.add(lblNewLabel);
		
		JPanel panelAc = new JPanel();
		panelAc.setLayout(null);
		panelAc.setBackground(Color.RED);
		panelAc.setBounds(120, 426, 262, 45);
		panelMiddle.add(panelAc);
		
		database.connect();
		
		lblNewLabel.addMouseListener(new MouseAdapter()
                {
			public void mouseEntered(MouseEvent e)
                        {
                            panelGir.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e)
                        {
                            panelGir.setBackground(new Color(178, 34, 34));
			}
			public void mouseClicked(MouseEvent arg0)
                        {
                            String request="SELECT id_user,mail_user,pass_user,count(id_user) AS giris from t_user where mail_user='"+txtMail.getText()+"'"; 
                            ResultSet myRs = database.show(request);					
                            try
                            {
                                while(myRs.next())
                                {
                                    if(txtMail.getText().trim().isEmpty() || txtPass.getText().trim().isEmpty())
                                    {
					JOptionPane sc = new JOptionPane();
					sc.showMessageDialog(frame, "Kullanıcı adı ya da şifre boş bırakılamaz","Hata",JOptionPane.ERROR_MESSAGE);
                                    }						
                                    else if(myRs.getInt("giris")==0)
                                    {	
					JOptionPane sc = new JOptionPane();
					sc.showMessageDialog(frame, "Görünüşe göre henüz kayıt olmamışssın !","Hata",JOptionPane.ERROR_MESSAGE);
                                    }
                                    else if(myRs.getInt("giris")==1)
                                    {
					if(myRs.getString("pass_user").equals(txtPass.getText()))
                                        {
								 
                                            setUserMail(txtMail.getText());
                                            setUserId(myRs.getString("id_user"));
                                            MainPage sc = new MainPage();
                                            sc.setVisible(true);				
                                            frame.dispose();
					}
					else
                                        {						
                                            JOptionPane sc = new JOptionPane();
                                            sc.showMessageDialog(frame, "Kullanıcı adı ya da şifre hatalı","Hata",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }			
													
                                }
                            } catch (SQLException e)
                            {
				e.printStackTrace();
                            }	
			}
		});	
		JLabel lblHesapOlutur = new JLabel("HESAP OLU\u015ETUR");
		lblHesapOlutur.addMouseListener(new MouseAdapter()
                {
			public void mouseClicked(MouseEvent arg0)
                        {
				SignPage sc;
				try
                                {
					sc = new SignPage();
					sc.getFrame().setVisible(true);
					frame.setVisible(false);
				} catch (ParseException e)
                                {	
                                    e.printStackTrace();
				}	
			}
		});
                
		lblHesapOlutur.setHorizontalAlignment(SwingConstants.CENTER);
		lblHesapOlutur.setForeground(Color.WHITE);
		lblHesapOlutur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHesapOlutur.setBounds(0, 0, 262, 45);
		panelAc.add(lblHesapOlutur);
		
		JLabel lblIcon = new JLabel("KOUFLIX");
		lblIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconKouflix.png")));
		lblIcon.setBounds(144, 53, 232, 86);
		panelMiddle.add(lblIcon);
		
		JLabel lblMailicon = new JLabel("Mail icon");
		lblMailicon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconMail.png")));
		lblMailicon.setBounds(12, 217, 32, 32);
		panelMiddle.add(lblMailicon);
		
		JLabel lblPassicon = new JLabel("pass icon");
		lblPassicon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconPass.png")));
		lblPassicon.setBounds(12, 285, 32, 32);
		panelMiddle.add(lblPassicon);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(LoginPage.class.getResource("/images/loginBackground.jpg")));
		Background.setBounds(0, 0, 720, 760);
		frame.getContentPane().add(Background);


	}
	public JFrame getFrame()
        {
		return frame;
	}

}
