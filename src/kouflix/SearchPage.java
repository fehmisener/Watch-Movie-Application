package kouflix;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class SearchPage 
{

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private String request;
	private JRadioButton rdName;
	private JRadioButton rdCatagory;
	private static String filmName;
	private static String filmId;
	
	private Object [] kolomlar = {"Program Ad�","Tip","Program T�r�","Uzunluk"};
	private Object [] satirlar = new Object[4];
	private DefaultTableModel model = new DefaultTableModel();
	
	public static  String getFilmId()
        {
		return filmId;
	}


	public static void setFilmId(String filmId)
        {
		SearchPage.filmId = filmId;
	}


	public  String getFilmName()
        {
		return filmName;
	}


	public void setFilmName(String filmName)
        {
		this.filmName = filmName;
	}


	public JFrame getFrame()
        {
		return frame;
	}


	public static void main(String[] args)
        {
		EventQueue.invokeLater(new Runnable()
                {
			public void run()
                        {
				try
                                {
					SearchPage window = new SearchPage();
					window.frame.setVisible(true);
				}
                                catch (Exception e)
                                {
					e.printStackTrace();
				}
			}
		});
	}


	public SearchPage()
        {
		initialize();
	}


	private void initialize()
        {
	
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/iconApp.jpg")));
		frame.setBounds(100, 100, 900, 750);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.BLACK);
		panelMain.setBounds(0, 0, 894, 715);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		rdName = new JRadioButton("\u0130sme G\u00F6re Ara");
		rdName.setSelected(true);
		rdName.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdName.setForeground(Color.ORANGE);
		rdName.setBackground(Color.BLACK);
		rdName.setBounds(211, 62, 186, 25);
		panelMain.add(rdName);
		
		rdCatagory = new JRadioButton("Kategoriye G\u00F6re Ara");
		rdCatagory.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdCatagory.setForeground(Color.ORANGE);
		rdCatagory.setBackground(Color.BLACK);
		rdCatagory.setBounds(519, 62, 244, 25);
		panelMain.add(rdCatagory);
		
		ButtonGroup sc = new ButtonGroup();
		sc.add(rdName);
		sc.add(rdCatagory);
		
		
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 4));
		textField.setBounds(211, 96, 541, 59);
		panelMain.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 236, 783, 453);
		panelMain.add(scrollPane);
		
		table = new JTable()
                {
			public boolean isCellEditable(int row, int column)
                        {       
                             return false;               
                        };
		};
		
		table.setBounds(57, 236, 783, 453);
		model.setColumnIdentifiers(kolomlar);
		scrollPane.setViewportView(table);
		request = "SELECT shows.name_show,shows.type_show,GROUP_CONCAT(DISTINCT typs.name_type ) AS catagory,shows.duration_show "
				+ "FROM t_show AS shows,t_type AS typs,t_showtype AS showtype "
				+ "WHERE shows.id_show=showtype.id_show and showtype.id_type=typs.id_type "
				+ "GROUP BY shows.name_show;";
		ResultSet myRs=database.show(request);
		
				
		try
                {
			
			while(myRs.next())
                        {
				satirlar[0]=myRs.getString("name_show");
				satirlar[1]=myRs.getString("type_show");
				satirlar[2]=myRs.getString("catagory");
				satirlar[3]=myRs.getString("duration_show");
				model.addRow(satirlar);
			}
		}	
		catch(SQLException e1)
                {
			e1.printStackTrace();
		}
		table.setModel(model);
		
		JLabel lblInfo = new JLabel("Filmin \u00DCzerine \u0130ki kere T\u0131klayarak A\u00E7abilirsiniz");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(221, 168, 510, 41);
		panelMain.add(lblInfo);
		
		textField.getDocument().addDocumentListener(new DocumentListener()
                {			
			@Override
			public void changedUpdate(DocumentEvent e)
                        {		
			}

			@Override
			public void insertUpdate(DocumentEvent e)
                        {
		
					if(rdName.isSelected())
                                        {
						
						
						model.setRowCount(0); 
						request="SELECT shows.name_show,shows.type_show,GROUP_CONCAT(DISTINCT typs.name_type ) AS catagory,shows.duration_show "
								+ "FROM t_show AS shows,t_type AS typs,t_showtype AS showtype "
								+ "WHERE shows.id_show=showtype.id_show and showtype.id_type=typs.id_type and shows.name_show "
								+ "LIKE '%"+textField.getText()+"%' GROUP BY shows.name_show;";	
						ResultSet myRs=database.show(request);
						
						try
                                                {
							
							while(myRs.next())
                                                        {
								satirlar[0]=myRs.getString("name_show");
								satirlar[1]=myRs.getString("type_show");
								satirlar[2]=myRs.getString("catagory");
								satirlar[3]=myRs.getString("duration_show");
								model.addRow(satirlar);
							}
						}	
						catch(SQLException e1)
                                                {
							e1.printStackTrace();
						}
						
						table.setModel(model);
						
					}		
					else if(rdCatagory.isSelected())
                                        {
						
						
						model.setRowCount(0);
						request="SELECT shows.name_show,shows.type_show,GROUP_CONCAT(DISTINCT typs.name_type ) AS catagory,shows.duration_show "
								+ "FROM t_show AS shows,t_type AS typs,t_showtype AS showtype "
								+ "WHERE shows.id_show=showtype.id_show and showtype.id_type=typs.id_type and typs.name_type "
								+ "LIKE '%"+textField.getText()+"%' GROUP BY shows.name_show;";
						ResultSet myRs=database.show(request);
						
						try
                                                {
							
							while(myRs.next())
                                                        {
								satirlar[0]=myRs.getString("name_show");
								satirlar[1]=myRs.getString("type_show");
								satirlar[2]=myRs.getString("catagory");
								satirlar[3]=myRs.getString("duration_show");
								model.addRow(satirlar);
							}
						}	
						catch(SQLException e1)
                                                {
							e1.printStackTrace();
						}
						table.setModel(model);
					}	
			}

			@Override
			public void removeUpdate(DocumentEvent e)
                        {
                            if(rdName.isSelected())
                            {
						
						
						model.setRowCount(0); 
						request="SELECT shows.name_show,shows.type_show,GROUP_CONCAT(DISTINCT typs.name_type ) AS catagory,shows.duration_show "
								+ "FROM t_show AS shows,t_type AS typs,t_showtype AS showtype "
								+ "WHERE shows.id_show=showtype.id_show and showtype.id_type=typs.id_type and shows.name_show "
								+ "LIKE '%"+textField.getText()+"%' GROUP BY shows.name_show;";	
						ResultSet myRs=database.show(request);
						
						try {
							
							while(myRs.next())
                                                        {
								satirlar[0]=myRs.getString("name_show");
								satirlar[1]=myRs.getString("type_show");
								satirlar[2]=myRs.getString("catagory");
								satirlar[3]=myRs.getString("duration_show");
								model.addRow(satirlar);
							}
						}	
						catch(SQLException e1)
                                                {
							e1.printStackTrace();
						}
						
						table.setModel(model);
						
					}		
					else if(rdCatagory.isSelected()) {
						

						model.setRowCount(0);
						request="SELECT shows.name_show,shows.type_show,GROUP_CONCAT(DISTINCT typs.name_type ) AS catagory,shows.duration_show "
								+ "FROM t_show AS shows,t_type AS typs,t_showtype AS showtype "
								+ "WHERE shows.id_show=showtype.id_show and showtype.id_type=typs.id_type and typs.name_type "
								+ "LIKE '%"+textField.getText()+"%' GROUP BY shows.name_show;";
						ResultSet myRs=database.show(request);
						
						try
                                                {
							
							while(myRs.next())
                                                        {
								satirlar[0]=myRs.getString("name_show");
								satirlar[1]=myRs.getString("type_show");
								satirlar[2]=myRs.getString("catagory");
								satirlar[3]=myRs.getString("duration_show");
								model.addRow(satirlar);
							}
						}	
						catch(SQLException e1)
                                                {
							e1.printStackTrace();
						}
						
						table.setModel(model);
					}			
				
				if(textField.getText().trim().isEmpty())
                                {
						
					request = "SELECT shows.name_show,shows.type_show,GROUP_CONCAT(DISTINCT typs.name_type ) AS catagory,shows.duration_show "
							+ "FROM t_show AS shows,t_type AS typs,t_showtype AS showtype "
							+ "WHERE shows.id_show=showtype.id_show and showtype.id_type=typs.id_type "
							+ "GROUP BY shows.name_show;";
					ResultSet myRs=database.show(request);
					try
                                        {
						
						while(myRs.next())
                                                {
							satirlar[0]=myRs.getString("name_show");
							satirlar[1]=myRs.getString("type_show");
							satirlar[2]=myRs.getString("catagory");
							satirlar[3]=myRs.getString("duration_show");
							model.addRow(satirlar);
						}
					}	
					catch(SQLException e1)
                                        {
						e1.printStackTrace();
					}
					table.setModel(model);
				}
			}
			
	
		});	
		
		table.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent arg0)
                    {
			
			   if (arg0.getClickCount() == 2 && !arg0.isConsumed())
                           {
				   arg0.consume();
				 		   
				   int x,y;
					x=table.getSelectedRow();
					y=0;			
					
					ResultSet my=database.show(" SELECT id_show FROM t_show WHERE name_show='"+table.getValueAt(x,y).toString()+"';");
					int filmId=-1;	
					try
                                        {
						if(my.next())
							filmId=my.getInt("id_show"); 
							setFilmId(Integer.toString(filmId));
					} catch (SQLException e)
                                        {
						e.printStackTrace();
					}
					
					FilmPage sc = new FilmPage(); 
					sc.getFrame().setVisible(true);
					
					
			   }
                    }
		});
	
	}	
}

