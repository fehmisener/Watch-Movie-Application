package kouflix;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;




import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WatchPage
{

	public JFrame frame;
	private JTextField txtStar;
	private  String id="";
	
	private static String  FilmId;
	
	
	public void setFilmId(String filmId)
        {
		FilmId = filmId;
	}
	public static void main(String[] args)
        {
		EventQueue.invokeLater(new Runnable()
                {
			public void run()
                        {
				try {
					WatchPage window = new WatchPage();
					window.frame.setVisible(true);
					
				}
                                catch (Exception e)
                                {
					e.printStackTrace();
				}
			}
		});
	}



	public WatchPage() throws SQLException
        {
		initialize();
	}

	
	
	private void initialize() throws SQLException
        {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/iconApp.jpg")));
		frame.setSize(862, 725);
		frame.setMinimumSize(new Dimension(700,600));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		long tStart = System.currentTimeMillis(); 

		String request="SELECT COUNT(*) as count FROM t_usertoshow";	
		ResultSet myRs=database.show(request);

		if(myRs.next())
			id= myRs.getString("count");
			
		int idS=Integer.parseInt(id)+1; 
		setFilmId(FilmPage.FilmId);
		
		String request2="INSERT INTO t_usertoshow (id_userTOshow,id_show,id_user,watched_date,watch_time,watched_episode)"
				+ " VALUES ("+idS+",'"+FilmId+"','"+LoginPage.getUserId()+"', '"+java.time.LocalDate.now()+"', '00:00:00', '"+FilmPage.getSelectedEpisode()+"')";
		database.add(request2);
			
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.BLACK);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
		);
		
		JSeparator sep = new JSeparator();
		sep.setBounds(100, 760, 861, 10);
		
		JLabel lblVote = new JLabel("Filme Puan Ver");
		lblVote.setBounds(447, 792, 201, 37);
		lblVote.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblVote.setHorizontalAlignment(SwingConstants.CENTER);
		lblVote.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.add(sep);
		panel.add(lblVote);
		
		JButton btnSend = new JButton("G\u00F6nder");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnSend.setBounds(456, 870, 192, 47);
		panel.add(btnSend);
		
		JLabel lblNumber = new JLabel("/10");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNumber.setForeground(Color.WHITE);
		lblNumber.setBounds(546, 833, 58, 25);
		panel.add(lblNumber);
		
		txtStar = new JTextField();
		txtStar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtStar.setBounds(501, 833, 43, 24);
		panel.add(txtStar);
		txtStar.setColumns(10);
		frame.getContentPane().setLayout(groupLayout);
		

		
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				int x = frame.getWidth()/2;
				int y = frame.getHeight();
				
			
				sep.setSize(panel.getWidth()-200,10);
				sep.setLocation(100, y-350);
				lblVote.setLocation(x-100, y-330);
				lblNumber.setLocation(x+45-100, y-270);
				txtStar.setLocation(x-100, y-270);
				btnSend.setLocation(x-100, y-240);
			}
		});
		
		
		btnSend.addActionListener(new ActionListener()
                {
			public void actionPerformed(ActionEvent e)
                        {
				
				if(Integer.parseInt(txtStar.getText())>10)
                                {
					JOptionPane.showMessageDialog(frame, "L�tfen 1-10 aras�nda puan giriniz","Hata",JOptionPane.ERROR_MESSAGE);
				}
				else
                                {
					int idS=Integer.parseInt(id)+1;
					String request3="UPDATE t_usertoshow SET show_star = '"+txtStar.getText()+"' "
							+ "WHERE (id_userTOshow = '"+idS+"')";
							
						
					database.add(request3);
				}
				
				
			
			}
		});
		
		frame.addWindowListener(new WindowAdapter()
                {
			public void windowClosing(WindowEvent e)
                        {
				
				int idS=Integer.parseInt(id)+1;
				
				
				
				long tEnd = System.currentTimeMillis();
				long tDelta = tEnd - tStart;
				int elapsedSeconds = (int) (tDelta/(1000));
				
				
				
				if((FilmPage.getLastMin()!=0))
					elapsedSeconds+=FilmPage.getLastMin();
				
				String time=Integer.toString(elapsedSeconds);
											
				
				String request4="UPDATE t_usertoshow SET watch_time = '"+time+"' "
					+ "WHERE (id_userTOshow = '"+idS+"')";
				database.add(request4);
                        }
		});
		
	
	}
}
