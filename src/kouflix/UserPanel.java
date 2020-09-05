package kouflix;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPanel {

	private  JFrame frame;
	private JTextField txtMail;
	private JPasswordField fieldPass;
	private JTextField txtName;
	private JPasswordField fieldOldPass;
	String oldData[]=new String[3];


	public static void main(String[] args)
        {
		EventQueue.invokeLater(new Runnable()
                {
			public void run()
                        {
				try {
					UserPanel window = new UserPanel();
					window.frame.setVisible(true);				
				}
                                catch (Exception e)
                                {
					e.printStackTrace();
				}
			}
		});
	}

	public UserPanel()
        {
		initialize();
	}

	private void initialize()
        {
	
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/iconApp.jpg")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 680, 707);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		    
	
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 674, 672);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBackground(Color.BLACK);
		panelHead.setBounds(0, 0, 674, 86);
		panel.add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblIcon = new JLabel("KOUFLIX");
		lblIcon.setIcon(new ImageIcon(UserPanel.class.getResource("/images/iconKouflix.png")));
		lblIcon.setBounds(0, 0, 232, 86);
		panelHead.add(lblIcon);
		
		JPanel panelName = new JPanel();
		panelName.setLayout(null);
		panelName.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelName.setBackground(Color.WHITE);
		panelName.setBounds(170, 144, 325, 64);
		panel.add(panelName);
		
		JLabel lblName = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblName.setForeground(new Color(211, 211, 211));
		lblName.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		lblName.setBounds(32, 13, 94, 16);
		panelName.add(lblName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setForeground(Color.DARK_GRAY);
		txtName.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtName.setBounds(32, 29, 281, 25);
		panelName.add(txtName);
		
		JPanel panelNameLeft = new JPanel();
		panelNameLeft.setBackground(Color.RED);
		panelNameLeft.setBounds(0, 0, 10, 64);
		panelName.add(panelNameLeft);
		
		JPanel panelMail = new JPanel();
		panelMail.setLayout(null);
		panelMail.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelMail.setBackground(Color.WHITE);
		panelMail.setBounds(170, 226, 325, 64);
		panel.add(panelMail);
		
		JLabel lblMail = new JLabel("Kullan\u0131c\u0131 E-Posta");
		lblMail.setForeground(new Color(211, 211, 211));
		lblMail.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		lblMail.setBounds(32, 13, 113, 16);
		panelMail.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setForeground(Color.DARK_GRAY);
		txtMail.setEditable(false);
		txtMail.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		txtMail.setColumns(10);
		txtMail.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMail.setBounds(32, 29, 281, 25);
		panelMail.add(txtMail);
		
		JPanel panelMailLeft = new JPanel();
		panelMailLeft.setBackground(Color.RED);
		panelMailLeft.setBounds(0, 0, 10, 64);
		panelMail.add(panelMailLeft);
		
		JPanel panelPass = new JPanel();
		panelPass.setLayout(null);
		panelPass.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelPass.setBackground(Color.WHITE);
		panelPass.setBounds(170, 303, 325, 64);
		panel.add(panelPass);
		
		JLabel lblPass = new JLabel("Kullan\u0131c\u0131 Sifre");
		lblPass.setForeground(new Color(211, 211, 211));
		lblPass.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		lblPass.setBounds(32, 13, 94, 16);
		panelPass.add(lblPass);
		
		fieldPass = new JPasswordField();
		fieldPass.setForeground(Color.DARK_GRAY);
		fieldPass.setEditable(false);
		fieldPass.setDisabledTextColor(Color.DARK_GRAY);
		fieldPass.setBorder(new LineBorder(new Color(0, 0, 0)));
		fieldPass.setBounds(32, 29, 281, 22);
		panelPass.add(fieldPass);
		
		JPanel panelPassLeft = new JPanel();
		panelPassLeft.setBackground(Color.RED);
		panelPassLeft.setBounds(0, 0, 10, 64);
		panelPass.add(panelPassLeft);
		
		
		System.out.println(LoginPage.getUserId());
		
		String request = "SELECT name_user,mail_user,pass_user FROM t_user where id_user='"+LoginPage.getUserId()+"'";
		ResultSet myRs=database.show(request);
		
		try
                {
			
			while(myRs.next())
                        {
				
				oldData[0]=myRs.getString("name_user");
				oldData[1]=myRs.getString("mail_user");
				oldData[2]=myRs.getString("pass_user");
				
				
				txtName.setText(oldData[0]);
				txtMail.setText(oldData[1]);
				fieldPass.setText(oldData[2]);
				
			}
		}	
		catch(SQLException e1)
                {
			e1.printStackTrace();
		}
		
		
		
		
		
		JPanel panelAccept = new JPanel();
		panelAccept.setLayout(null);
		panelAccept.setBackground(Color.RED);
		panelAccept.setBounds(241, 568, 189, 49);
		panelAccept.setVisible(false);
		
		JPanel panelOldPass = new JPanel();
		panelOldPass.setLayout(null);
		panelOldPass.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelOldPass.setBackground(Color.WHITE);
		panelOldPass.setBounds(170, 463, 325, 64);
		panelOldPass.setVisible(false);
		panel.add(panelOldPass);
		
		JLabel lblOldPass = new JLabel("Kullan\u0131c\u0131 Eski \u015Eifre Tekrar");
		lblOldPass.setForeground(new Color(211, 211, 211));
		lblOldPass.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		lblOldPass.setBounds(32, 13, 176, 16);
		panelOldPass.add(lblOldPass);
		
		fieldOldPass = new JPasswordField();
		fieldOldPass.setForeground(Color.DARK_GRAY);
		fieldOldPass.setDisabledTextColor(Color.DARK_GRAY);
		fieldOldPass.setBorder(new LineBorder(new Color(0, 0, 0)));
		fieldOldPass.setBounds(32, 29, 281, 22);
		panelOldPass.add(fieldOldPass);
		
		JPanel panelOldPassLeft = new JPanel();
		panelOldPassLeft.setBackground(Color.RED);
		panelOldPassLeft.setBounds(0, 0, 10, 64);
		panelOldPass.add(panelOldPassLeft);
		panel.add(panelAccept);
		
		JLabel lblAccept = new JLabel("De\u011Fi\u015Fiklikleri onayla");
		lblAccept.addMouseListener(new MouseAdapter()
                {
			@Override
			public void mouseClicked(MouseEvent e)
                        {
				
				if(fieldOldPass.getText().equals(oldData[2]))
                                {
					
					String request1="UPDATE t_user SET name_user='"+txtName.getText()+"',mail_user='"+txtMail.getText()+"',pass_user='"+fieldPass.getText()+"' WHERE id_user="+LoginPage.getUserId();				
					database.add(request1);
					
					
					
					txtName.setEditable(false);
					txtMail.setEditable(false);
					fieldPass.setEditable(false);
					
					
					panelOldPass.setVisible(false);
					panelAccept.setVisible(false);
					
					
					
				    JOptionPane.showMessageDialog(frame,"Bilgiler Ba�ar�yla G�ncellendi","Ba�ar�l�",JOptionPane.WARNING_MESSAGE);     
				}
				else
                                {
					JOptionPane.showMessageDialog(frame, "�ifre Hatal� Girildi","Hata",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		lblAccept.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccept.setForeground(Color.WHITE);
		lblAccept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccept.setBounds(0, 0, 189, 49);
		panelAccept.add(lblAccept);
		
		JPanel panelChange = new JPanel();
		panelChange.setLayout(null);
		panelChange.setBackground(Color.RED);
		panelChange.setBounds(241, 386, 189, 49);
		panel.add(panelChange);
		
		
		
		
		JLabel lblChange = new JLabel("De\u011Fi\u015Fiklik Yap");
		lblChange.addMouseListener(new MouseAdapter()
                {
			public void mouseClicked(MouseEvent arg0)
                        {
				txtName.setEditable(true);
				txtMail.setEditable(true);
				fieldPass.setEditable(true);
				
				panelOldPass.setVisible(true);
				panelAccept.setVisible(true);
			}
		});
		lblChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblChange.setForeground(Color.WHITE);
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChange.setBounds(0, 0, 189, 49);
		panelChange.add(lblChange);
		
	}

	public JFrame getFrame()
        {
		return frame;
	}
}
