package kouflix;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private static String FilmId;

	public static String getFilmId()
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
					MainPage frame = new MainPage();
					frame.setVisible(true);
				}
                                catch (Exception e)
                                {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainPage() 
        {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/iconApp.jpg")));
		setBounds(100, 100, 1273, 959);
		setMinimumSize(new Dimension(1042,902));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scp1 = new JScrollPane();
		scp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scp2 = new JScrollPane();
		scp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panelHead = new JPanel();
		panelHead.setBackground(new Color(105, 105, 105,100));
		
		JLabel lblNewLabel_1 = new JLabel("Haftanın Filmleri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(174)
					.addComponent(scp2, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
					.addGap(180))
				.addComponent(panelHead, GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addComponent(scp1, GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE)
					.addGap(91))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(511)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addGap(460))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelHead, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(scp1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scp2, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panelHead.setLayout(null);
		
		JLabel lblIcon = new JLabel("KOUFLIX");

		lblIcon.setIcon(new ImageIcon(MainPage.class.getResource("/images/iconKouflix.png")));
		lblIcon.setBounds(0, 0, 233, 80);
		panelHead.add(lblIcon);
		
		JLabel lblSearch = new JLabel("New label");
		lblSearch.addMouseListener(new MouseAdapter()
                {
			@Override
			public void mouseClicked(MouseEvent e)
                        {				
				SearchPage sc = new SearchPage();
				sc.getFrame().setVisible(true);				
			}
		});
		lblSearch.setIcon(new ImageIcon(MainPage.class.getResource("/images/iconSearch.png")));
		lblSearch.setBounds(375, 13, 60, 60);
		panelHead.add(lblSearch);
		
		JLabel lblAcc = new JLabel("New label");
		lblAcc.addMouseListener(new MouseAdapter()
                {
			public void mouseClicked(MouseEvent arg0)
                        {
				UserPanel sc = new UserPanel();
				sc.getFrame().setVisible(true);	
			}
		});
		lblAcc.setIcon(new ImageIcon(MainPage.class.getResource("/images/iconAccount.png")));
		lblAcc.setBounds(282, 13, 60, 60);
		panelHead.add(lblAcc);
		

		JPanel panelTopFilm = new JPanel();
		panelTopFilm.setBackground(new Color(174, 0, 0));
		panelTopFilm.setPreferredSize(new Dimension(2450,267));
		scp1.setViewportView(panelTopFilm);
		

		
		
		int x=0;
		
		for(int i=0; i<10; i++)
                {
			JButton lblNewLabel = new JButton(Integer.toString(i+1));
			lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/poster/"+Integer.toString(i+1)+".jpg")));
                        lblNewLabel.setBounds(x,0, 190, 267);
			lblNewLabel.addActionListener(this);
			panelTopFilm.add(lblNewLabel);
			x=x+220;
		}
		
		JPanel panelAllFilm = new JPanel();
		panelAllFilm.setPreferredSize(new Dimension(2170,2000));
		scp2.setViewportView(panelAllFilm);
		panelAllFilm.setLayout(null);
		
		
		int x1=10;
		int counter=0;
	
		
		
		int y=5;
		for(int i=10; i<75; i++)
                {
			JButton lblNewLabel = new JButton(Integer.toString(i+1));
			lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/poster/"+Integer.toString(i+1)+".jpg")));
			lblNewLabel.setBounds(x1,y, 190, 267);
			lblNewLabel.addActionListener(this);
			panelAllFilm.add(lblNewLabel);

			x1=x1+220;
			counter++;
			
			if(counter==10) 
                        {
                            y=y+287;
                            x1=10;
                            counter=0;
			}
		}
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e)
        {
		setFilmId(e.getActionCommand());
		FilmPage sc = new FilmPage();	
		sc.getFrame().setVisible(true);	
	}
}
