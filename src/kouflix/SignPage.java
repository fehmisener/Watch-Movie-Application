package kouflix;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignPage
{

	private JFrame frame;
	public JFrame getFrame()
        {
		return frame;
	}

	private JTextField txtName;
	private JPasswordField txtPass;
	private JTextField txtMail;
	private JTextField txtBirtday;
	private JPanel panelType; 
	
	private boolean date = false;
    static int counter=0;
	static boolean kontrol[]= new boolean [10];
	static ArrayList  <Integer> secim  = new ArrayList <Integer> ();
	static ArrayList  <JLabel> list  = new ArrayList <JLabel> ();
	static int  userId=-1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignPage window = new SignPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public SignPage() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		
		
			/*
			
			Pencerenin olu�turuldu�u ve gerekli componentlerin eklenmesinin yap�ld��� metot.
			
			*/
		
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
		
		JLabel lblCloseIcon = new JLabel("Minus");
		lblCloseIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconClose.png")));
		lblCloseIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblCloseIcon.setBounds(676, 13, 32, 32);
		panelHead.add(lblCloseIcon);
		
		JLabel lblMinusIcon = new JLabel("New label");
		lblMinusIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
		});
		lblMinusIcon.setIcon(new ImageIcon(LoginPage.class.getResource("/images/iconMinus.png")));
		lblMinusIcon.setBounds(632, 13, 32, 32);
		panelHead.add(lblMinusIcon);
		
		JLabel lblBackicon = new JLabel("Back");
		lblBackicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				LoginPage sc = new LoginPage();
				sc.getFrame().setVisible(true);
			}
		});
		lblBackicon.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconBack.png")));
		lblBackicon.setBounds(583, 13, 32, 32);
		panelHead.add(lblBackicon);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0,220));
		panel.setVisible(false);
		
		
		panel.setBounds(102, 93, 518, 608);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIcon_1_1 = new JLabel("KOUFLIX");
		lblIcon_1_1.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconKouflix.png")));
		lblIcon_1_1.setBounds(139, 41, 232, 86);
		panel.add(lblIcon_1_1);
		
		JLabel lblIteSeninIin = new JLabel("\u0130\u015Fte tam sana g\u00F6re olan filmler");
		lblIteSeninIin.setForeground(Color.WHITE);
		lblIteSeninIin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIteSeninIin.setBounds(119, 113, 286, 86);
		panel.add(lblIteSeninIin);
		
		JLabel lblMovie1_1 = new JLabel("New label");
		lblMovie1_1.setBounds(12, 298, 145, 24);
		lblMovie1_1.setForeground(Color.WHITE);
		panel.add(lblMovie1_1);
		list.add(lblMovie1_1);
		
		JLabel lblMovie2_1 = new JLabel("New label");
		lblMovie2_1.setBounds(190, 298, 145, 24);
		lblMovie2_1.setForeground(Color.WHITE);
		panel.add(lblMovie2_1);
		list.add(lblMovie2_1);
		
		JLabel lblMovie3_1 = new JLabel("New label");
		lblMovie3_1.setBounds(361, 298, 145, 24);
		lblMovie3_1.setForeground(Color.WHITE);
		panel.add(lblMovie3_1);
		list.add(lblMovie3_1);
		
		JLabel lblMovie1_2 = new JLabel("New label");
		lblMovie1_2.setBounds(12, 335, 145, 24);
		lblMovie1_2.setForeground(Color.WHITE);
		panel.add(lblMovie1_2);
		list.add(lblMovie1_2);
		
		JLabel lblMovie2_2 = new JLabel("New label");
		lblMovie2_2.setBounds(190, 335, 145, 24);
		lblMovie2_2.setForeground(Color.WHITE);
		panel.add(lblMovie2_2);
		list.add(lblMovie2_2);
		
		JLabel lblMovie3_2 = new JLabel("New label");
		lblMovie3_2.setBounds(361, 335, 145, 24);
		lblMovie3_2.setForeground(Color.WHITE);
		panel.add(lblMovie3_2);
		list.add(lblMovie3_2);
		
		JLabel lblMovie1_3 = new JLabel("New label");
		lblMovie1_3.setBounds(12, 372, 145, 24);
		lblMovie1_3.setForeground(Color.WHITE);
		panel.add(lblMovie1_3);
		list.add(lblMovie1_3);
		
		JLabel lblMovie2_3 = new JLabel("New label");
		lblMovie2_3.setBounds(190, 372, 145, 24);
		lblMovie2_3.setForeground(Color.WHITE);
		panel.add(lblMovie2_3);
		list.add(lblMovie2_3);
		
		JLabel lblMovie3_3 = new JLabel("New label");
		lblMovie3_3.setBounds(361, 372, 145, 24);
		lblMovie3_3.setForeground(Color.WHITE);
		panel.add(lblMovie3_3);
		list.add(lblMovie3_3);
		
		JLabel lblMovie4_1 = new JLabel("New label");
		lblMovie4_1.setBounds(12, 458, 145, 24);
		lblMovie4_1.setForeground(Color.WHITE);
		panel.add(lblMovie4_1);
		list.add(lblMovie4_1);
		
		JLabel lblMovie5_1 = new JLabel("New label");
		lblMovie5_1.setBounds(190, 458, 145, 24);
		lblMovie5_1.setForeground(Color.WHITE);
		panel.add(lblMovie5_1);
		list.add(lblMovie5_1);
		
		JLabel lblMovie6_1 = new JLabel("New label");
		lblMovie6_1.setBounds(361, 458, 145, 24);
		lblMovie6_1.setForeground(Color.WHITE);
		panel.add(lblMovie6_1);
		list.add(lblMovie6_1);
		
		JLabel lblMovie4_2 = new JLabel("New label");
		lblMovie4_2.setBounds(12, 495, 145, 24);
		lblMovie4_2.setForeground(Color.WHITE);
		panel.add(lblMovie4_2);
		list.add(lblMovie4_2);
		
		
		JLabel lblMovie5_2 = new JLabel("New label");
		lblMovie5_2.setBounds(190, 495, 145, 24);
		lblMovie5_2.setForeground(Color.WHITE);
		panel.add(lblMovie5_2);
		list.add(lblMovie5_2);
		
		JLabel lblMovie6_2 = new JLabel("New label");
		lblMovie6_2.setBounds(361, 495, 145, 24);
		lblMovie6_2.setForeground(Color.WHITE);
		panel.add(lblMovie6_2);
		list.add(lblMovie6_2);
		
		JLabel lblMovie4_3 = new JLabel("New label");
		lblMovie4_3.setBounds(12, 532, 145, 24);
		lblMovie4_3.setForeground(Color.WHITE);
		panel.add(lblMovie4_3);
		list.add(lblMovie4_3);
		
		JLabel lblMovie5_3 = new JLabel("New label");
		lblMovie5_3.setBounds(190, 532, 145, 24);
		lblMovie5_3.setForeground(Color.WHITE);
		panel.add(lblMovie5_3);
		list.add(lblMovie5_3);
		
		JLabel lblMovie6_3 = new JLabel("New label");
		lblMovie6_3.setBounds(361, 532, 145, 24);
		lblMovie6_3.setForeground(Color.WHITE);
		panel.add(lblMovie6_3);
		list.add(lblMovie6_3);
		
	
		
		
		panelType = new JPanel();
		panelType.setBounds(100, 93, 520, 608);
		frame.getContentPane().add(panelType);
		panelType.setBackground(new Color(0, 0, 0,220));
		panelType.setLayout(null);
		panelType.setVisible(false);
		
		JLabel lblIcon_1 = new JLabel("KOUFLIX");
		lblIcon_1.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconKouflix.png")));
		lblIcon_1.setBounds(140, 54, 232, 86);
		panelType.add(lblIcon_1);
		
		JLabel lblNewLabel = new JLabel("Hangi t\u00FCrler ho\u015Funa gider ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(127, 129, 279, 86);
		panelType.add(lblNewLabel);
		
		JLabel lbl1 = new JLabel("Aksiyon");	
		lbl1.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconActions.png")));
		lbl1.setBounds(70, 220, 85, 85);
		panelType.add(lbl1);
		
		// KULLANICIDAN 3 TANE T�R SE�MES�N� �STEYEN KISIM ���N MAUSE CL�CK L�STENER
		
		lbl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
					if(counter<3 && !kontrol[0]) {
						lbl1.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconActionsTick.png")));	
						kontrol[0]=true;
						counter++;
						secim.add(1);
						
					}
					else if(kontrol[0]){
						lbl1.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconActions.png")));
						kontrol[0]=false;
						counter--;
						secim.remove(secim.indexOf(1));
						
					}
				
			
			}
		});
		
		
		JLabel lbl2 = new JLabel("Cocuk-Aile");
		lbl2.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconDocumentary.png")));
		lbl2.setBounds(165, 220, 85, 85);
		panelType.add(lbl2);
		lbl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(counter<3 && !kontrol[1]) {
						lbl2.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconDocumentaryTick.png")));	
						kontrol[1]=true;
						counter++;
						secim.add(2);
					}
				else if(kontrol[1]) {
					lbl2.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconDocumentary.png")));
						kontrol[1]=false;
						counter--;
						secim.remove(secim.indexOf(2));
					}
				
			}
		});
		
		JLabel lbl3 = new JLabel("Belgesel");
		lbl3.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconSci-fi.png")));
		lbl3.setBounds(260, 220, 85, 85);
		panelType.add(lbl3);
		lbl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(counter<3 && !kontrol[2]) {
						lbl3.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconSci-fiTick.png")));	
						kontrol[2]=true;
						counter++;
						secim.add(3);
					}
				else if(kontrol[2]){
					lbl3.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconSci-fi.png")));
						kontrol[2]=false;
						counter--;
						secim.remove(secim.indexOf(3));
				}
				
			}
		});
		
		JLabel lbl4 = new JLabel("Drama");
		lbl4.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsNature.png")));
		lbl4.setBounds(355, 220, 85, 85);
		panelType.add(lbl4);
		lbl4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(counter<3 && !kontrol[3]) {
						lbl4.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsNatureTick.png")));	
						kontrol[3]=true;
						counter++;
						secim.add(4);
				}
				else if(kontrol[3]){
					lbl4.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsNature.png")));
						kontrol[3]=false;
						counter--;
						secim.remove(secim.indexOf(4));
				}
				
			}
		});
		
		JLabel lbl5 = new JLabel("Komedi");
		lbl5.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconChildAndfamily.png")));
		lbl5.setBounds(70, 311, 85, 85);
		panelType.add(lbl5);
		lbl5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				if(counter<3 && !kontrol[4]) {
						lbl5.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconChildAndfamilyTick.png")));	
						kontrol[4]=true;
						counter++;
						secim.add(5);
				}
				else if(kontrol[4]) {
					lbl5.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconChildAndfamily.png")));
						kontrol[4]=false;
						counter--;
						secim.remove(secim.indexOf(5));
				}
				
			
			}
		});
		
		JLabel lbl6 = new JLabel("Romantizim");
		lbl6.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconDrama.png")));
		lbl6.setBounds(165, 311, 85, 85);
		panelType.add(lbl6);
		lbl6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(counter<3 && !kontrol[5]) {
						lbl6.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconDramaTick.png")));
						kontrol[5]=true;
						counter++;
						secim.add(6);
					}
				else if(kontrol[5]) {
					lbl6.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconDrama.png")));
						kontrol[5]=false;
						counter--;
						secim.remove(secim.indexOf(6));
				}
				
			}
		});
		
		JLabel lbl7 = new JLabel("Bilimkurgu");
		lbl7.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsThriller.png")));
		lbl7.setBounds(260, 311, 85, 85);
		panelType.add(lbl7);
		lbl7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				if(counter<3 && !kontrol[6]) {
						lbl7.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsThrillerTick.png")));
						kontrol[6]=true;
						counter++;
						secim.add(7);
					}
				else if(kontrol[6]) {
					lbl7.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsThriller.png")));
						kontrol[6]=false;
						counter--;
						secim.remove(secim.indexOf(7));
				}
				}
			
		});
		
		JLabel lbl8 = new JLabel("Korku");
		lbl8.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconComedy.png")));
		lbl8.setBounds(355, 311,85, 85);
		panelType.add(lbl8);
		lbl8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				if(counter<3 && !kontrol[7]) {
						lbl8.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconComedyTick.png")));
						kontrol[7]=true;
						counter++;
						secim.add(8);
					}
				else if(kontrol[7]) {
					lbl8.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconComedy.png")));

						kontrol[7]=false;
						counter--;
						secim.remove(secim.indexOf(8));
					}
			}
		}); 
		
		JLabel lbl9 = new JLabel("Gerilim");
		lbl9.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsHorror.png")));
		lbl9.setBounds(165, 401, 85, 85);
		panelType.add(lbl9);
		lbl9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(counter<3 && !kontrol[8]) {
						lbl9.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsHorrorTick.png")));	
						kontrol[8]=true;
						counter++;
						secim.add(9);
				}
				else if(kontrol[8]) {
					lbl9.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconsHorror.png")));
						kontrol[8]=false;
						counter--;
						secim.remove(secim.indexOf(9));
				}
				
			}
		});
		
		JLabel lbl10 = new JLabel("Doga");
		lbl10.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconRomance.png")));
		lbl10.setBounds(260, 401, 85, 85);
		panelType.add(lbl10);
		

		lbl10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
				if(counter<3 && !kontrol[9]) {
						lbl10.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconRomanceTick.png")));
						kontrol[9]=true;
						counter++;
						secim.add(10);
				}
				else if(kontrol[9]) {
					lbl10.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconRomance.png")));
						kontrol[9]=false;
						counter--;
						secim.remove(secim.indexOf(10));
				}
				
			}
		});
	
		
		JPanel panelMiddle = new JPanel();
        panelMiddle.setBackground(new Color(0, 0, 0,220));
		panelMiddle.setBounds(100, 93, 520, 608);
		frame.getContentPane().add(panelMiddle);
		panelMiddle.setLayout(null);
		
		JLabel lblNameicon = new JLabel("name icon");
		lblNameicon.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconName.png")));
		lblNameicon.setBounds(12, 159, 32, 32);
		panelMiddle.add(lblNameicon);
		
		txtName = new JTextField();
		txtName.setForeground(Color.LIGHT_GRAY);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtName.setBackground(new Color(0, 0, 0, 220));
		txtName.setBounds(69, 150, 370, 45);
		panelMiddle.add(txtName);
		
		JLabel lblMailicon = new JLabel("Mail icon");
		lblMailicon.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconMail.png")));
		lblMailicon.setBounds(12, 227, 32, 32);
		panelMiddle.add(lblMailicon);
		
		txtMail = new JTextField();
		txtMail.setForeground(Color.LIGHT_GRAY);
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMail.setColumns(10);
		txtMail.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtMail.setBackground(new Color(0, 0, 0, 220));
		txtMail.setBounds(69, 214, 370, 45);
		panelMiddle.add(txtMail);
		
		JLabel lblPassicon = new JLabel("pass icon");
		lblPassicon.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconPass.png")));
		lblPassicon.setBounds(12, 296, 32, 32);
		panelMiddle.add(lblPassicon);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(Color.LIGHT_GRAY);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setColumns(10);
		txtPass.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtPass.setBackground(new Color(0, 0, 0, 220));
		txtPass.setBounds(69, 287, 371, 45);
		panelMiddle.add(txtPass);
		
		JLabel lblBirthdayicon = new JLabel("pass icon");
		lblBirthdayicon.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconBirthday.png")));
		lblBirthdayicon.setBounds(12, 364, 32, 32);
		panelMiddle.add(lblBirthdayicon);
		
		txtBirtday = new JTextField("�RN : 2000-12-30");
	
		txtBirtday.setForeground(Color.LIGHT_GRAY);
		txtBirtday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBirtday.setColumns(10);
		txtBirtday.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txtBirtday.setBackground(new Color(0, 0, 0, 220));
		txtBirtday.setBounds(69, 358, 370, 45);
		panelMiddle.add(txtBirtday);
		txtBirtday.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtBirtday.setText("");
			}
		});
		
		
		
		
		
		
		JLabel lblIcon = new JLabel("KOUFLIX");
		lblIcon.setIcon(new ImageIcon(SignPage.class.getResource("/images/iconKouflix.png")));
		lblIcon.setBounds(136, 51, 232, 86);
		panelMiddle.add(lblIcon);
		
		JPanel panelAc = new JPanel();
		panelAc.setLayout(null);
		panelAc.setBackground(new Color(178, 34, 34));
		panelAc.setBounds(125, 427, 262, 45);
		panelMiddle.add(panelAc);
		
		JLabel lblHesapOlutur = new JLabel("HESAP OLU\u015ETUR");
		lblHesapOlutur.setHorizontalAlignment(SwingConstants.CENTER);
		lblHesapOlutur.setForeground(Color.WHITE);
		lblHesapOlutur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHesapOlutur.setBounds(0, 0, 262, 45);
		panelAc.add(lblHesapOlutur);
		
		JPanel panelAc_1 = new JPanel();
		panelAc_1.setLayout(null);
		panelAc_1.setBackground(Color.RED);
		panelAc_1.setBounds(125, 497, 262, 45);
		panelMiddle.add(panelAc_1);
		
		JLabel lblGeriDn = new JLabel("GER\u0130 D\u00D6N");
		lblGeriDn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				LoginPage sc = new LoginPage();
				sc.getFrame().setVisible(true);
			}
		});
		lblGeriDn.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeriDn.setForeground(Color.WHITE);
		lblGeriDn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGeriDn.setBounds(0, 0, 262, 45);
		panelAc_1.add(lblGeriDn);
		
		  
	
	        
	    
		lblHesapOlutur.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				panelAc.setBackground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				panelAc.setBackground(new Color(178, 34, 34));
			}
			public void mouseClicked(MouseEvent arg0) {
				String request="SELECT COUNT(*) as count FROM t_user WHERE mail_user='"+txtMail.getText()+"'";	
				ResultSet myRs=database.show(request);
				// Kullan�c�n�n girdi�i mail veri taban�nda mevcut mu ? Sorgusu. 
				
			       try {
			           String str =txtBirtday.getText();
			           SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
			           sdfrmt.setLenient(false);
			           Date javaDate = sdfrmt.parse(str);
			           date=true;
			       } catch (ParseException ex) {
			           date=false;
			       }
			       
				try {
					
					if(txtMail.getText().trim().isEmpty() || txtPass.getText().trim().isEmpty() || txtName.getText().trim().isEmpty() || txtBirtday.getText().trim().isEmpty()) {
						
						JOptionPane sc = new JOptionPane();
						sc.showMessageDialog(frame, "L�tfen t�m alanlar� doldurunuz ! ","Hata",JOptionPane.ERROR_MESSAGE);
					}
						
					else if(myRs.getInt("count")==1) {
						
						JOptionPane.showMessageDialog(frame, "Girmi� Oldu�unuz Mail Kullan�mda ! ","Hata",JOptionPane.ERROR_MESSAGE);
					}
					else  if(date==false) {
						
						JOptionPane.showMessageDialog(frame, "Girmi� Oldu�unuz Do�um tarihi ge�ersiz ! ","Hata",JOptionPane.ERROR_MESSAGE);
					}
					else {
							
							String request1="SELECT COUNT(*) as count FROM t_user";	
							ResultSet myRs2=database.show(request1);
							
								if(myRs2.next())
									userId =1+myRs2.getInt("count");
							
							String request2  = "INSERT INTO t_user (id_user,name_user, mail_user, pass_user, birthday_user) "
									+ "VALUES ('"+userId+"', '"+txtName.getText()+"','"+txtMail.getText()+"','"+txtPass.getText()+"','"+txtBirtday.getText()+"')";
							database.add(request2);
							
							panelMiddle.setVisible(false);
							panelType.setVisible(true);
							
						}
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		});
		JPanel panelDevam = new JPanel();
		panelDevam.setLayout(null);
		panelDevam.setBackground(Color.RED);
		panelDevam.setBounds(127, 499, 262, 45);
		panelType.add(panelDevam);
		
	
		
		JLabel lblDevam = new JLabel("DEVAM ET");
		lblDevam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelType.setVisible(false);				
				for(int i=0; i<3; i++) {
					int j=i;
					String request3 = "SELECT  name_show,name_type,AVG(show_star) FROM t_showtype AS stype ,t_show AS shows ,t_usertoshow  as rate , t_type as typename "
							+ "where stype.id_type="+secim.get(i)+" and shows.id_show=rate.id_show and shows.id_show=stype.id_show and typename.id_type=stype.id_type "
							+ "GROUP BY shows.name_show "
							+ "ORDER BY AVG(show_star) DESC LIMIT 2;";
					ResultSet myRs=database.show(request3);
					
					try {
						
						while(myRs.next()) {
							list.get(j).setText(myRs.getString("name_show"));
							list.get(j+3).setText("T�r : "+myRs.getString("name_type"));
							list.get(j+6).setText("Puan : "+new DecimalFormat("##.##").format(myRs.getFloat("AVG(show_star)")));
							j+=9;
							
						}
					}	
					catch(SQLException e1) {
						e1.printStackTrace();
					}
					
					
				}
				
				
				panel.setVisible(true);
			}
		
		});
		lblDevam.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevam.setForeground(Color.WHITE);
		lblDevam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDevam.setBounds(0, 0, 262, 45);
		panelDevam.add(lblDevam);
		

	
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(LoginPage.class.getResource("/images/loginBackground.jpg")));
		Background.setBounds(0, 0, 720, 760);
		frame.getContentPane().add(Background);
	}
}
