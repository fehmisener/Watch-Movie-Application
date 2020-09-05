package kouflix;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FilmPage {

	private JFrame frame;
	public static String FilmId;
	private  int showNmbr=1;
	private static String selectedEpisode;
	private static int lastMin;

	public static int getLastMin()
        {
		return lastMin;
	}

	public static String getSelectedEpisode()
        {
		return selectedEpisode;
	}

	public String getFilmId()
        {
		return FilmId;
	}

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
				try
                                {
                                    FilmPage window = new FilmPage();
                                    window.frame.setVisible(true);
				} catch (Exception e)
                                {
					e.printStackTrace();
				}
			}
		});
	}


	public FilmPage()
        {
		initialize();
	}


	private void initialize()
        {
		

		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/iconApp.jpg")));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 656, 681);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		

		
		if(SearchPage.getFilmId()!=null) {
			setFilmId(SearchPage.getFilmId()); 
		}
		else if(MainPage.getFilmId()!=null){
			setFilmId(MainPage.getFilmId());  
		}
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FilmPage.class.getResource("/poster/"+getFilmId()+".jpg")));
		lblNewLabel.setBounds(213, 112, 190, 267);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIcon = new JLabel("KOUFLIX");
		lblIcon.setIcon(new ImageIcon(FilmPage.class.getResource("/images/iconKouflix.png")));
		lblIcon.setBounds(188, 13, 232, 86);
		frame.getContentPane().add(lblIcon);
		
		String request = "SELECT nmbrOf_show FROM t_show where id_show='"+getFilmId()+"'";		
		ResultSet myRs=database.show(request);
		
		try
                {
			if(myRs.next())
                        {
				showNmbr=myRs.getInt("nmbrOf_show");
			}
		}
                catch (SQLException e1)
                {
			e1.printStackTrace();
		}

		Vector nmbr = new Vector();
		for(int i=1; i<=showNmbr; i++)
                {
			nmbr.add(Integer.toString(i)); 
		}
		
		JComboBox cb =new JComboBox(nmbr); 
		JLabel lblChoose = new JLabel("\u0130zlenecek B\u00F6l\u00FCm");
	
		if(showNmbr==1)
                {
			cb.setVisible(false);
			lblChoose.setVisible(false);
		}
			    
		 cb.setBounds(422, 407, 50, 40);
		 frame.getContentPane().add(cb);
		
		JButton btnWatch = new JButton("\u0130ZLE");
		btnWatch.addActionListener(new ActionListener()
                {
			public void actionPerformed(ActionEvent arg0)
                        {
				WatchPage sc;
				try {
					selectedEpisode=cb.getSelectedItem().toString(); 
					sc = new WatchPage(); 
					sc.frame.setVisible(true);
					frame.dispose();
				}
                                catch (SQLException e)
                                {
				
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		btnWatch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnWatch.setBounds(266, 460, 114, 38);
		frame.getContentPane().add(btnWatch);
		
		
		lblChoose.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChoose.setForeground(Color.WHITE);
		lblChoose.setBounds(169, 407, 232, 40);
		frame.getContentPane().add(lblChoose);
		
		JButton btnCont = new JButton("Kald\u0131\u011F\u0131m yerden devam et");
		btnCont.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCont.setBounds(188, 572, 284, 40);
		
		
		JLabel lblLast = new JLabel("Son kaldiginiz yer :");
		lblLast.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLast.setForeground(Color.WHITE);
		lblLast.setBounds(50, 511, 614, 54);
		
	
		
		
		
		String request2 = "SELECT watched_episode, watch_time FROM t_usertoshow WHERE id_show='"+getFilmId()+"' and id_user='"+LoginPage.getUserId()+
				"' ORDER BY id_userTOshow DESC LIMIT 1; ";
		ResultSet myRs2=database.show(request2);
			
		try {
			if(myRs2.next())
                        {
				lblLast.setText(lblLast.getText()+myRs2.getString("watched_episode")+". B�l�m "+myRs2.getString("watch_time")+". Dakika ");
				frame.getContentPane().add(lblLast);
				frame.getContentPane().add(btnCont);
								
				
				btnCont.addActionListener(new ActionListener()
                                {
					public void actionPerformed(ActionEvent arg0)
                                        {						
						WatchPage sc;
						try {
							selectedEpisode=myRs2.getString("watched_episode");
							lastMin=myRs2.getInt("watch_time");
							sc = new WatchPage();
							sc.frame.setVisible(true);
							frame.dispose();
						}
                                                catch (SQLException e)
                                                {
							e.printStackTrace();
						}
					}
				});
			}
	
		}
                catch (SQLException e)
                {
			e.printStackTrace();
		}
		
		frame.addWindowListener(new WindowAdapter()
                {
			@Override
			public void windowClosing(WindowEvent arg0)
                        {
				SearchPage.setFilmId(null);
			}
		});
		
		
		
	}

	public JFrame getFrame()
        {
		return frame;
	}
}
