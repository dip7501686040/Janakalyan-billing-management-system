package janakalyan;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class Janakalyan {

	private JFrame frame;
	private JTextField txtNgnfnn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_9;
	private JTable table;
	private JTextField textField_14;
	private JTextField textField_16;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private ArrayList<Character> pName = new ArrayList<>();
	static String s ;
	static String selected="";
	static Connection con=null;
	private JList<String> list; 
	private JTextField textField_15;
	private JTextField textField_18;
	private JTextField textField_19;
	private JLabel lblDate;
	private JLabel lblTime;
	JButton btnNewButton_4;
	JButton btnNewButton_3;
	JLabel lblNewLabel_10;
	JLabel label_5;
	JLabel label_7;
	JLabel label_10;
	JLabel label_6;
	JLabel label_2;
	JLabel label_9;
	JLabel label_11;
	JPanel panel;
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	JPanel stock_panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						Class.forName("com.mysql.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/janakalyan_ayurved_pharmacy_db","root","NCSDsaha@12345");
						Janakalyan window = new Janakalyan();
						window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janakalyan() {
		initialize();
		loaddata();
		showDate();
		showTime();
	}

	private void loaddata() {
		
		String query="select pname from product";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			DefaultListModel<String> model=new DefaultListModel<String>();
			while(rs.next())
			{
				String listitem=rs.getString("pname");
				model.addElement(listitem);
			}
			list.setModel(model);
			
			
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
	}
	
	private void showDate() {
		
		Date date=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
		lblDate.setText(s.format(date));
	}
	Timer timer;
	private JTextField textField_10;
	private JTextField textField_13;
	private JTextField textField_17;
	private JTextField textField_20;
	private JTextField textField_21;
	private void showTime() {
		ActionListener actionListener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");
				String time=s.format(date);
				lblTime.setText(time);
			}
		};
		timer = new Timer(1000, actionListener);
		timer.setInitialDelay(0);
		timer.start();
	}

	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtNgnfnn.requestFocus();
				/*Robot robot;
				try {
					robot = new Robot();
					robot.keyPress(KeyEvent.VK_CAPS_LOCK);
				}
				catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		frame.getContentPane().setForeground(Color.WHITE);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,dim.width+20,dim.height-20);      //dimensions width 1366+20,height 768-20
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("JANAKALYAN AYURVED PHARMACY");
		lblNewLabel.setBackground(new Color(173, 255, 47));
		lblNewLabel.setForeground(new Color(102, 0, 51));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(350, 0, 657, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PARTY RECORDS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setForeground(new Color(102, 0, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(214, 47, 174, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("STOCK  RECORDS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_3.setVisible(false);
				btnNewButton_3.setVisible(false);
				StockPanel stock_panel = new StockPanel();
				stock_panel.setLayout(null);
				stock_panel.setBorder(new MatteBorder(0, 0, 10, 0, (Color) new Color(0, 139, 139)));
				stock_panel.setBackground(new Color(176, 224, 230));
				stock_panel.setBounds(617, 11, 723, 573);
				panel.add(stock_panel);
				
			}
		});
		btnNewButton_1.setForeground(new Color(102, 0, 51));
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(387, 47, 174, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBilling = new JButton("SALES RECORDS");
		btnBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBilling.setForeground(new Color(102, 0, 51));
		btnBilling.setBackground(new Color(176, 224, 230));
		btnBilling.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBilling.setBounds(560, 47, 174, 23);
		frame.getContentPane().add(btnBilling);
		
		JButton btnPurchase = new JButton("PURCHASE RECORDS");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPurchase.setForeground(new Color(102, 0, 51));
		btnPurchase.setBackground(new Color(176, 224, 230));
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPurchase.setBounds(733, 47, 174, 23);
		frame.getContentPane().add(btnPurchase);
		
		panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_R)
				{
					loaddata();
					pName.clear();
					s="";
					txtNgnfnn.setText("");
					txtNgnfnn.requestFocus();
				}
			}
		});
		panel.setBackground(new Color(176, 224, 230));
		panel.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(0, 139, 139)));
		panel.setBounds(10, 70, 1350, 628);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(0, 0, 10, 0, (Color) new Color(0, 139, 139)));
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(10, 11, 308, 573);
		panel.add(panel_1);
		
		txtNgnfnn = new JTextField();
		DefaultListModel<String> model = new DefaultListModel<String>();
		txtNgnfnn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if((int)e.getKeyChar() == 8)
				{
					if(pName.size() > 0)
						pName.remove( pName.size() - 1);
					
					s="";
					for(int i =0; i < pName.size(); i++)
					{
						s = s + pName.get(i);
					}
				}
				else if((int)e.getKeyChar()>=32 && (int)e.getKeyChar()<=126)
				{
					s="";
					pName.add(e.getKeyChar());
					for(int i =0; i < pName.size(); i++)
					{
						s = s + pName.get(i);
						e.consume();
					}
				}
				else if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					list.requestFocus();
				}
				else if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					loaddata();
					pName.clear();
					s="";
					txtNgnfnn.setText("");
					btnNewButton.requestFocus();
				}
				else
				{
					s="";
					for(int i =0; i < pName.size(); i++)
					{
						s = s + pName.get(i);
					}
				}
				
				try {
					model.clear();
					String query="select pname from product where pname like '"+s+"%'";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						String ItemList2 = rs.getString("pname");
						model.addElement(ItemList2 );
					}
					list.setModel(model);
					
					rs.close();
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		txtNgnfnn.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNgnfnn.setBounds(0, 22, 308, 48);
		panel_1.add(txtNgnfnn);
		txtNgnfnn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SEARCH PRODUCTS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(102, 0, 168, 19);
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 76,308, 486);
		panel_1.add(scrollPane);
		
		list = new JList<String>();
		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					textField_21.requestFocus();
				}
				if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					txtNgnfnn.requestFocus();
				}
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!list.isSelectionEmpty()) {
				selected =list.getSelectedValue().toString();
				textArea_2.setText("  "+selected);
				
				String query="select * from product where pname='"+selected+"'"; 
				
				try {
					
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					rs.next();
					textField.setText(String.valueOf(rs.getInt("pinstock")));
					textField_1.setText(rs.getString("pbatchno"));
					textField_2.setText(String.valueOf(rs.getDouble("pmrp")));
					textField_3.setText(String.valueOf(rs.getDate("pexp")));
					textField_4.setText(String.valueOf(rs.getDouble("ptax")));
					textField_5.setText(String.valueOf(rs.getDouble("ppurchaserate")));
					textField_6.setText(String.valueOf(rs.getDouble("psallingrate")));
					textField_7.setText(String.valueOf(rs.getDouble("pdiscount")));
					textField_8.setText(rs.getString("ptax"));
					textArea.setText(rs.getString("pdescription"));
					textArea_1.setText(rs.getString("plocation"));
					getItemValue();
					textField_20.setText(rs.getString("phsnno"));
					
				}
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		});
		list.setBounds(0, 76,308, 486);
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(list);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(0, 10, 10, 10, (Color) new Color(0, 139, 139)));
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(319, 11, 299, 573);
		panel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT DETAILS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(99, 0, 171, 19);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("INSTOCK :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(35, 89, 69, 14);
		panel_2.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(114,81, 131, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblBatchno = new JLabel("BATCHNO :");
		lblBatchno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBatchno.setBounds(29, 119, 77, 14);
		panel_2.add(lblBatchno);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(114, 112, 131, 30);
		panel_2.add(textField_1);
		
		JLabel lblMrp = new JLabel("MRP :");
		lblMrp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMrp.setBounds(65, 149, 39, 14);
		panel_2.add(lblMrp);
		
		JLabel lblExp = new JLabel("EXP :");
		lblExp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExp.setBounds(69, 182, 35, 14);
		panel_2.add(lblExp);
		
		JLabel lblTax_1 = new JLabel("TAX :");
		lblTax_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTax_1.setBounds(69, 212, 35, 14);
		panel_2.add(lblTax_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(114, 205, 131, 30);
		panel_2.add(textField_4);
		
		JLabel lblPrate = new JLabel("PRATE :");
		lblPrate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrate.setBounds(51, 243, 53, 14);
		panel_2.add(lblPrate);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(114, 236, 131, 30);
		panel_2.add(textField_5);
		
		JLabel lblSrate = new JLabel("SRATE :");
		lblSrate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSrate.setBounds(51, 274, 53, 14);
		panel_2.add(lblSrate);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(114, 267, 131, 30);
		panel_2.add(textField_6);
		
		JLabel lblDiscount_1 = new JLabel("DISCOUNT :");
		lblDiscount_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiscount_1.setBounds(24, 305, 80, 14);
		panel_2.add(lblDiscount_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(114, 298, 131, 30);
		panel_2.add(textField_7);
		
		JLabel lblNewLabel_4 = new JLabel("DESCRIPTION");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(114, 456, 77, 14);
		panel_2.add(lblNewLabel_4);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(10, 471, 279, 41);
		panel_2.add(textArea);
		
		JLabel lblLocation = new JLabel("LOCATION");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLocation.setBounds(133, 512, 77, 14);
		panel_2.add(lblLocation);
		
		textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 526, 279, 35);
		panel_2.add(textArea_1);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(114, 329, 131, 30);
		panel_2.add(textField_8);
		
		JLabel lblFree = new JLabel("FREE :");
		lblFree.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFree.setBounds(62, 336, 42, 14);
		panel_2.add(lblFree);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(114, 143, 131, 30);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(114, 174, 131, 30);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(114, 360, 131, 30);
		panel_2.add(textField_9);
		
		JLabel lblNoitem = new JLabel("ITEM VALUE :");
		lblNoitem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNoitem.setBounds(14, 367, 90, 14);
		panel_2.add(lblNoitem);
		
		textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 24, 279, 46);
		panel_2.add(textArea_2);
		
		JLabel lblHsnNo_1 = new JLabel("HSN NO. :");
		lblHsnNo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHsnNo_1.setBounds(39, 398, 65, 14);
		panel_2.add(lblHsnNo_1);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(114, 391, 131, 30);
		panel_2.add(textField_20);
		
		JLabel lblQty = new JLabel("QTY. :");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQty.setBounds(62, 430, 42, 14);
		panel_2.add(lblQty);
		
		textField_21 = new JTextField();
		textField_21.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					btnNewButton_3.requestFocus();
				}
				if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					list.requestFocus();
				}
			}
		});
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_21.setText("1");
		textField_21.setColumns(10);
		textField_21.setBounds(114, 422, 131, 30);
		panel_2.add(textField_21);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(0, 0, 10, 0, (Color) new Color(0, 139, 139)));
		panel_3.setBackground(new Color(176, 224, 230));
		panel_3.setBounds(617, 11, 723, 573);
		panel.add(panel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(2, 66, 721, 312);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					if(table.getSelectedRow()==table.getRowCount()-1 && table.getSelectedColumn()== table.getColumnCount()-1)
					{
						textField_13.requestFocus();
					}
					else
					{
						table.editCellAt(table.getSelectedRow(), table.getSelectedColumn());
						netRate();
						getSubTotal();
						getTotal();
					}
				}
				if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					btnNewButton_3.requestFocus();
				}
			}
		});
		
		InputMap im =table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		KeyStroke enter=KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		KeyStroke tab=KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
		im.put(enter, im.get(tab));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"                PRODUCT", " QTY.", "FREE", "MRP", "S. RATE", "DISC.", "TAX.", "NET RATE"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(273);
		table.getColumnModel().getColumn(1).setPreferredWidth(53);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.getColumnModel().getColumn(5).setPreferredWidth(53);
		table.getColumnModel().getColumn(6).setPreferredWidth(53);
		table.getColumnModel().getColumn(7).setPreferredWidth(87);
		table.setRowHeight(30);
		table.setBounds(2, 70, 721, 356);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("PHONE NO.");
		lblNewLabel_6.setBounds(10, 7, 68, 14);
		panel_3.add(lblNewLabel_6);
		
		textField_14 = new JTextField();
		textField_14.setBounds(90, 0, 132, 28);
		panel_3.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("NAME");
		lblNewLabel_7.setBounds(242, 7, 49, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("AGE");
		lblNewLabel_8.setBounds(469, 7, 35, 14);
		panel_3.add(lblNewLabel_8);
		
		textField_16 = new JTextField();
		textField_16.setBounds(504, 0, 58, 25);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(290, 0, 159, 28);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("HISTORY");
		btnNewButton_6.setBounds(491, 32, 89, 23);
		panel_3.add(btnNewButton_6);
		
		JLabel lblBillNo = new JLabel("BILL NO.");
		lblBillNo.setBounds(22, 36, 58, 14);
		panel_3.add(lblBillNo);
		
		textField_18 = new JTextField();
		textField_18.setBounds(90, 32, 132, 27);
		panel_3.add(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("PNAME");
		lblNewLabel_9.setBounds(242, 36, 49, 14);
		panel_3.add(lblNewLabel_9);
		
		textField_19 = new JTextField();
		textField_19.setBounds(290, 30, 170, 27);
		panel_3.add(textField_19);
		textField_19.setColumns(10);
		
		lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(634, 0, 89, 28);
		panel_3.add(lblDate);
		
		lblTime = new JLabel("TIME");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setBounds(644, 32, 79, 16);
		panel_3.add(lblTime);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(173, 216, 230));
		panel_4.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_4.setBounds(242, 378, 239, 184);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblAmount = new JLabel("ITEM VALUE :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount.setBounds(46, 15, 82, 14);
		panel_4.add(lblAmount);
		
		label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(138, 11, 91, 23);
		panel_4.add(label_6);
		
		JLabel lblSgst = new JLabel("SGST :");
		lblSgst.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSgst.setBounds(88, 91, 40, 14);
		panel_4.add(lblSgst);
		
		label_9 = new JLabel("");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(138, 87, 91, 23);
		panel_4.add(label_9);
		
		JLabel lblCgst = new JLabel("CGST :");
		lblCgst.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCgst.setBounds(88, 134, 40, 14);
		panel_4.add(lblCgst);
		
		label_11 = new JLabel("");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(138, 130, 91, 23);
		panel_4.add(label_11);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(138, 49, 91, 23);
		panel_4.add(label_2);
		
		JLabel lblPurchaseRate = new JLabel("PURCHASE RATE :");
		lblPurchaseRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPurchaseRate.setBounds(18, 53, 110, 14);
		panel_4.add(lblPurchaseRate);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_5.setBackground(new Color(173, 216, 230));
		panel_5.setBounds(2, 378, 239, 184);
		panel_3.add(panel_5);
		
		JLabel lblNewLabel_5 = new JLabel("BATCH NO. :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(26, 16, 74, 14);
		panel_5.add(lblNewLabel_5);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(113, 12, 116, 23);
		panel_5.add(lblNewLabel_10);
		
		label_5 = new JLabel("");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(113, 52, 116, 23);
		panel_5.add(label_5);
		
		JLabel lblExpDate = new JLabel("EXP. DATE :");
		lblExpDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExpDate.setBounds(30, 56, 70, 14);
		panel_5.add(lblExpDate);
		
		label_7 = new JLabel("");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(113, 93, 116, 23);
		panel_5.add(label_7);
		
		JLabel lblHsnNo = new JLabel("HSN. NO. :");
		lblHsnNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHsnNo.setBounds(36, 97, 64, 14);
		panel_5.add(lblHsnNo);
		
		JLabel lblInstock = new JLabel("INSTOCK :");
		lblInstock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInstock.setBounds(36, 140, 64, 14);
		panel_5.add(lblInstock);
		
		label_10 = new JLabel("");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(113, 136, 116, 23);
		panel_5.add(label_10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(482, 378, 240, 184);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_6.setBackground(new Color(173, 216, 230));
		
		textField_10 = new JTextField("0.0");
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(111, 23, 119, 29);
		panel_6.add(textField_10);
		
		JLabel label = new JLabel("SUBTOTAL :");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(28, 27, 78, 18);
		panel_6.add(label);
		
		JLabel lblAddLess = new JLabel("ADD LESS :");
		lblAddLess.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddLess.setBounds(35, 73, 68, 14);
		panel_6.add(lblAddLess);
		
		textField_13 = new JTextField("0.0");
		textField_13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					NumberFormat nf=NumberFormat.getInstance();
					nf.setMaximumFractionDigits(2);
					double subTotal=Double.parseDouble(textField_10.getText());
					double addless=Double.parseDouble(textField_13.getText());
					double total=subTotal-addless;
					textField_17.setText(nf.format(total));
					btnNewButton_4.requestFocus();
				}
				if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					table.requestFocus();
				}
			}
		});
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_13.setColumns(10);
		textField_13.setBounds(111, 63, 97, 31);
		panel_6.add(textField_13);
		
		JLabel label_4 = new JLabel("TOTAL :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(22, 125, 59, 14);
		panel_6.add(label_4);
		
		textField_17 = new JTextField(" 0.0");
		textField_17.setEditable(false);
		textField_17.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField_17.setColumns(10);
		textField_17.setBounds(91, 112, 139, 37);
		panel_6.add(textField_17);
		
		JButton btnNewButton_2 = new JButton("REFERSH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loaddata();
				pName.clear();
				s="";
				txtNgnfnn.setText("");
				txtNgnfnn.requestFocus();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(87, 588, 116, 27);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("ADD TO INVOICE");
		btnNewButton_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					double nr;
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.addRow(new Object[] {
							
							textArea_2.getText(),
							textField_21.getText(),
							textField_8.getText(),
							textField_2.getText(),
							textField_6.getText(),
							textField_7.getText(),
							textField_4.getText(),
							nr=0.0
					});
					table.requestFocus();
					table.setRowSelectionInterval(table.getRowCount()-1,table.getRowCount()-1);
					table.setColumnSelectionInterval(0,0);
					netRate();
					getSubTotal();
					getTotal();
					lblNewLabel_10.setText(textField_1.getText());
					label_5.setText(textField_3.getText());
					label_7.setText(textField_20.getText());
					label_10.setText(textField.getText());
					label_6.setText(textField_9.getText());
					label_2.setText(textField_5.getText());
					label_9.setText(String.valueOf(Double.parseDouble(textField_4.getText())/2));
					label_11.setText(String.valueOf(Double.parseDouble(textField_4.getText())/2));
					label_7.setText(textField_20.getText());
				}

				if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					textField_21.requestFocus();
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double nr;
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						
						textArea_2.getText(),
						textField_21.getText(),
						textField_8.getText(),
						textField_2.getText(),
						textField_6.getText(),
						textField_7.getText(),
						textField_4.getText(),
						nr=0.0
				});
				table.requestFocus();
				table.setRowSelectionInterval(table.getRowCount()-1,table.getRowCount()-1);
				table.setColumnSelectionInterval(0,0);
				netRate();
				getSubTotal();
				getTotal();
				lblNewLabel_10.setText(textField_1.getText());
				label_5.setText(textField_3.getText());
				label_7.setText(textField_20.getText());
				label_10.setText(textField.getText());
				label_6.setText(textField_9.getText());
				label_2.setText(textField_5.getText());
				label_9.setText(String.valueOf(Double.parseDouble(textField_4.getText())/2));
				label_11.setText(String.valueOf(Double.parseDouble(textField_4.getText())/2));
				label_7.setText(textField_20.getText());
			}

		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBounds(428, 588, 177, 27);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("PREVIEW INVOICE");
		btnNewButton_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					InvoiceFrame invoice=new InvoiceFrame();
					invoice.setVisible(true);
					invoice.btnPrint.requestFocus();
				}
				if(e.getKeyChar()==KeyEvent.VK_ESCAPE)
				{
					textField_13.requestFocus();
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvoiceFrame invoice=new InvoiceFrame();
				invoice.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.setBounds(945, 588, 181, 27);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("CLEAR");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea_2.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_20.setText("");
				textArea.setText("");
				textArea_1.setText("");
				pName.clear();
				s="";
				txtNgnfnn.setText("");
				txtNgnfnn.requestFocus();
				loaddata();
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_8.setBounds(329, 588, 89, 27);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("DELETE");
		btnNewButton_7.setBounds(731, 589, 91, 24);
		panel.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getModel().getRowCount()==0) {
					
					JOptionPane.showMessageDialog(panel_3, "PLEASE ADD A PRODUCT");
				}
				else if(table.getSelectedRow()==-1) {
					
					JOptionPane.showMessageDialog(panel_3, "PLEASE SELECT A PRODUCT");	
				}
				else {
						afterDeleteSubtotal();
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						model.removeRow(table.getSelectedRow());
					}
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton_5 = new JButton("CLEAR");
		btnNewButton_5.setBounds(844, 589, 91, 25);
		panel.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.setRowCount(0);
				textField_10.setText("0.0");
				textField_13.setText("0.0");
				textField_17.setText("0.0");
			}
			
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel background1=new JLabel(new ImageIcon("F:/My projects/JBanking/9fc0dcf592abff4ba9d9cba6e2a17b13.jpg"));
		background1.setText("");
		background1.setBounds(0,0,1370,709);
		frame.getContentPane().add(background1);
		
	}
	private void getSubTotal() {
		double total=0;
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		for(int i=0;i<table.getRowCount();i++) {
		
			double sallingRate=Double.parseDouble(table.getValueAt(i, 7).toString());
			total+=sallingRate;
		}
		textField_10.setText(String.valueOf(nf.format(total)));
	}
	private void afterDeleteSubtotal(){
		
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		double sallingRate=Double.parseDouble(table.getValueAt(table.getSelectedRow(), 7).toString());
		double subTotal=Double.parseDouble(textField_10.getText()+"");
		subTotal-=sallingRate;
		textField_10.setText(String.valueOf(nf.format(subTotal)));
		getTotal();

	}
	private void netRate() {
		double netRate;
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
			double srate=Double.parseDouble(table.getValueAt(table.getSelectedRow(), 4).toString());
			double disc=Double.parseDouble(table.getValueAt(table.getSelectedRow(), 5).toString());
			double tax=Double.parseDouble(table.getValueAt(table.getSelectedRow(), 6).toString());
			int qty=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1).toString());
			netRate=qty*((srate-(srate*(disc/100)))+((srate-(srate*(disc/100)))*(tax/100)));
			table.setValueAt(nf.format(netRate), table.getSelectedRow(), 7);
	}
	private void getTotal()
	{
		double subTotal=Double.parseDouble(textField_10.getText());
		textField_17.setText(String.valueOf(subTotal));
	}
	private void getItemValue()
	{
		NumberFormat nf=NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		double mrp=Double.parseDouble(textField_2.getText());
		double tax=Double.parseDouble(textField_4.getText());
		double itemvalue=mrp-(mrp*(tax/100));
		textField_9.setText(nf.format(itemvalue));
	}

}
