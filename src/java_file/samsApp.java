package java_file;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.List;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Choice;

import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;

import java.awt.SystemColor;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Checkbox;
import java.awt.Label;
import java.io.IOException;
import java.io.InputStream;



import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import lu.tudor.santec.jtimechooser.JTimeChooser;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.ScrollPaneConstants;
public class samsApp {
	//java.util.Date date;
	//java.sql.Date sqldate;

	int itm,itm2;
	String imgpath;
	JFrame frmStudentAttendanceSystem;
	
	private JTextField txtsubBdtl;
	private JTextField txtennoreg;
	private JTextField txtrollnoreg;
	private JTextField txtstudentnamereg;
	private JTextField txtfathernamereg;
	private JTextField txtFmonoreg;
	private JTextField txtmothernamereg;
	private JTextField txtMmonoreg;
	private JTextField txtstudentmonoreg;
	private JTextField txtemailidreg;
	List listrollnoDres;
	
	JPanel masterpanel;

	private JTextField txtpassdtl;


	CardLayout cardLayout;
	
	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps;
	private JTextField txtAdmisiondatereg;
	private JTextField txtundtl;
	private JTextField txtAnswer;
	private JTextField txtbranchBdtl;
	private JTextField txtbranchnameBdtl;
	private JTextField txtdateDres;
	private JTextField txtrollnoDres;
	private JTextField txtnameDres;
	private JTextField txtrollnoMres;
	private JTextField txtnameMres;
	private JTextField txtrollnoSres;
	
	private JTextField txtnameSres;
	private JTextField txtyearMres;
	private JTextField txtyearSres;
	private JTextField textsubcodeBdtl;
	private JTextField txtdobSdtl;
	private JTextField txtdateAtt;
	private JScrollPane sp;
	private JTable table_1;
	private JTable BdetailTable;
	
	JComboBox cmbsem2Bdtl;
	JComboBox cmbbranch2bdtl;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					samsApp window = new samsApp();
					window.frmStudentAttendanceSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public samsApp() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentAttendanceSystem = new JFrame();
		frmStudentAttendanceSystem.setResizable(false);
		frmStudentAttendanceSystem.getContentPane().setBackground(Color.ORANGE);
		frmStudentAttendanceSystem.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		frmStudentAttendanceSystem.setTitle("STUDENT ATTENDANCE SYSTEM");
		frmStudentAttendanceSystem.setBounds(100, 100, 1130, 727);
		frmStudentAttendanceSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentAttendanceSystem.getContentPane().setLayout(null);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			cardLayout.show(masterpanel, "panelhomestring");
			}
		});
		btnHome.setFont(new Font("Calibri", Font.BOLD, 14));
		btnHome.setBounds(10, 86, 147, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnHome);
		
		
		JButton btnBranchdtl = new JButton("BRANCH DETAIL");
		btnBranchdtl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
					cardLayout.show(masterpanel, "BranchDtlPanel");
			}
		});
		
		btnBranchdtl.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBranchdtl.setBounds(10, 129, 147, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnBranchdtl);
		
		JButton btnStudentdtl = new JButton("STUDENT DETAIL");
		btnStudentdtl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
						cardLayout.show(masterpanel,"studentDtlPnl");
			}
			
		});
		btnStudentdtl.setFont(new Font("Calibri", Font.BOLD, 14));
		btnStudentdtl.setBounds(10, 173, 147, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnStudentdtl);
		
		JButton btnViewAllStudent = new JButton("VIEW ALL STUDENT");
		btnViewAllStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cardLayout.show(masterpanel, "panelstudentlist");
			}
		});
		btnViewAllStudent.setFont(new Font("Calibri", Font.BOLD, 13));
		btnViewAllStudent.setBounds(10, 216, 147, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnViewAllStudent);
		
		JButton btnUserDetail = new JButton("USER DETAIL");
		btnUserDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				login l=new login();
				if(l.type.equals("Admin"))
				{
					cardLayout.show(masterpanel, "pnluserdetail");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You Are Not Authorized User");
					
				}
				
			}
		});
		btnUserDetail.setFont(new Font("Calibri", Font.BOLD, 14));
		btnUserDetail.setBounds(10, 403, 140, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnUserDetail);
		
		JButton btnAttendance = new JButton("ATTENDANCE");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cardLayout.show(masterpanel, "pnlattendance");
			}
		});
		
		
		btnAttendance.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAttendance.setBounds(10, 250, 147, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnAttendance);
		
		JLabel lblresult = new JLabel("RESULTS");
		lblresult.setForeground(Color.BLUE);
		lblresult.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		lblresult.setBounds(54, 284, 75, 14);
		frmStudentAttendanceSystem.getContentPane().add(lblresult);
		
		JButton btnDaily = new JButton("DAILY");
		btnDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				cardLayout.show(masterpanel, "pnldayres");
			}
		});
		btnDaily.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDaily.setBounds(29, 299, 100, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnDaily);
		
		JButton btnMonthly = new JButton("MONTHLY");
		btnMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				cardLayout.show(masterpanel, "pnlmonthres");
			}
		});
		btnMonthly.setFont(new Font("Calibri", Font.BOLD, 14));
		btnMonthly.setBounds(29, 326, 100, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnMonthly);
		
		
		JButton btnSem = new JButton("SEM");
		btnSem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				cardLayout.show(masterpanel, "pnlsemres");
			}
		});
		btnSem.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSem.setBounds(29, 352, 100, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnSem);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			
				login window = new login();
				frmStudentAttendanceSystem.setVisible(false);
				window.frmLoginForm.setVisible(true);
			
			}
		});
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLogout.setBounds(10, 437, 140, 23);
		frmStudentAttendanceSystem.getContentPane().add(btnLogout);
		
		masterpanel = new JPanel();
		masterpanel.setBounds(178, 0, 939, 690);
		frmStudentAttendanceSystem.getContentPane().add(masterpanel);
		masterpanel.setLayout(new CardLayout(0, 0));
		cardLayout=(CardLayout)masterpanel.getLayout();
		
		JPanel panelhome = new JPanel();
		panelhome.setBackground(Color.PINK);
		masterpanel.add(panelhome, "panelhomestring");
		panelhome.setLayout(null);
		
		JLabel lbl_attimg = new JLabel("");
		lbl_attimg.setBounds(10, 66, 929, 382);
		panelhome.add(lbl_attimg);
		ImageIcon img = new ImageIcon("src/image/attimg.jpeg");
		lbl_attimg.setIcon(new ImageIcon(samsApp.class.getResource("/java_file/attimg.jpg")));
		
		JLabel lblStudentAttendanceManagement = new JLabel("\"STUDENT ATTENDANCE MANAGEMENT SYSTEM\"");
		lblStudentAttendanceManagement.setForeground(Color.BLUE);
		lblStudentAttendanceManagement.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblStudentAttendanceManagement.setBounds(244, 29, 628, 45);
		panelhome.add(lblStudentAttendanceManagement);
		
		JLabel lblNote = new JLabel("NOTE:-");
		lblNote.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNote.setBounds(10, 496, 80, 26);
		panelhome.add(lblNote);
		
		JLabel lblToView = new JLabel("1) To view image of student in any result then click only that roll no.\r\n\r\n");
		lblToView.setFont(new Font("Calibri", Font.BOLD, 16));
		lblToView.setBounds(57, 533, 495, 40);
		panelhome.add(lblToView);
		
		JLabel lblNewLabel_2 = new JLabel("2) Only admin can handle user detail (Create,delete or Update).");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_2.setBounds(57, 596, 462, 14);
		panelhome.add(lblNewLabel_2);
		

		
		JPanel pnlbranchdtl = new JPanel();
		pnlbranchdtl.setBackground(Color.PINK);
		pnlbranchdtl.setForeground(Color.RED);
		masterpanel.add(pnlbranchdtl, "BranchDtlPanel"); 				//Branch Detail Panel Given Name
		pnlbranchdtl.setLayout(null);
		
		
		JLabel lblBranchDetail = new JLabel("BRANCH DETAIL");
		lblBranchDetail.setForeground(Color.BLUE);
		lblBranchDetail.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblBranchDetail.setBounds(376, 11, 278, 31);
		pnlbranchdtl.add(lblBranchDetail);
		
		JLabel lblBranch_Bdtl = new JLabel("Branch");
		lblBranch_Bdtl.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranch_Bdtl.setBounds(281, 56, 46, 14);
		pnlbranchdtl.add(lblBranch_Bdtl);
		
		txtbranchBdtl = new JTextField();
		txtbranchBdtl.setBounds(372, 53, 271, 20);
		pnlbranchdtl.add(txtbranchBdtl);
		txtbranchBdtl.setColumns(10);
		
		JLabel lblBranchNameBdtl = new JLabel("Branch Name");
		lblBranchNameBdtl.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranchNameBdtl.setBounds(281, 112, 81, 14);
		pnlbranchdtl.add(lblBranchNameBdtl);
		
		txtsubBdtl = new JTextField();
		txtbranchnameBdtl = new JTextField();
		txtbranchnameBdtl.setColumns(10);
		txtbranchnameBdtl.setBounds(372, 109, 271, 20);
		pnlbranchdtl.add(txtbranchnameBdtl);
		
		JLabel lblsubBdtl = new JLabel("Subject");
		lblsubBdtl.setFont(new Font("Calibri", Font.BOLD, 13));
		lblsubBdtl.setBounds(281, 171, 66, 14);
		pnlbranchdtl.add(lblsubBdtl);
		txtsubBdtl.setBounds(373, 168, 271, 20);
		pnlbranchdtl.add(txtsubBdtl);
		txtsubBdtl.setColumns(10);
		
		JLabel lblSemBdtl = new JLabel("Sem");
		lblSemBdtl.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSemBdtl.setBounds(281, 266, 46, 14);
		pnlbranchdtl.add(lblSemBdtl);
		
		final JComboBox cmbsemBdtl = new JComboBox();
		cmbsemBdtl.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsemBdtl.setBounds(373, 263, 89, 20);
		pnlbranchdtl.add(cmbsemBdtl);
		
		JLabel lblsubcodeBdtl = new JLabel("Subject Code");
		lblsubcodeBdtl.setFont(new Font("Calibri", Font.BOLD, 13));
		lblsubcodeBdtl.setBounds(281, 216, 81, 14);
		pnlbranchdtl.add(lblsubcodeBdtl);
		
		textsubcodeBdtl = new JTextField();
		textsubcodeBdtl.setBounds(372, 213, 271, 20);
		pnlbranchdtl.add(textsubcodeBdtl);
		textsubcodeBdtl.setColumns(10);
		
		JButton btnBAdd = new JButton("ADD");
		btnBAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String branch,bname,sub,sem,subcode;	
				branch=txtbranchBdtl.getText();
				bname=txtbranchnameBdtl.getText();
				sub=txtsubBdtl.getText();
				sem=cmbsemBdtl.getSelectedItem().toString();
				subcode=textsubcodeBdtl.getText();
				try
				{
					if(branch.equals("")||sub.equals("")||sem.equals(""))
					{
						JOptionPane.showMessageDialog(null, "PLZ FILL ALL FIELDS");
					}
					else{
					
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					int i=st.executeUpdate("insert into branchdetail values('" +branch+ "','" +bname+ "','"+sub+"','"+sem+"','"+subcode+"')");
					JOptionPane.showMessageDialog(null,"Record Inserted");
					//txtbranchBdtl.setText("");
					//txtbranchnameBdtl.setText("");
					txtsubBdtl.setText("");
					
					st.close();
					con.close();
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				
			}
		});
		btnBAdd.setBackground(SystemColor.control);
		btnBAdd.setBounds(281, 308, 89, 23);
		pnlbranchdtl.add(btnBAdd);
		
		JButton btnBDelete = new JButton("DELETE");
		btnBDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String branch=txtbranchBdtl.getText();
				String sub=txtsubBdtl.getText();
				String sem=cmbsemBdtl.getSelectedItem().toString();

				String str=txtrollnoreg.getText();
				int conf = JOptionPane.showConfirmDialog (null, "Are you sure?","To Delete Student", JOptionPane.YES_NO_OPTION);
	            if(conf == 0) 
	            	{
				try
				{
					if(branch.equals("")||sub.equals("")||sem.equals(""))
					{
						JOptionPane.showMessageDialog(null, "PLZ FILL BRANCH,SUBJECT AND SEM TO DELETE RECORD");
					}
					else{
					
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					int i=st.executeUpdate("delete from branchdetail where branch='"+branch+"' AND sub='"+sub+"' AND sem='"+sem+"' ");
					JOptionPane.showMessageDialog(null,"Record Deleted");
					
					txtbranchBdtl.setText("");
					txtsubBdtl.setText("");
				
					st.close();
					con.close();
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			
				}
	            else
					JOptionPane.showMessageDialog(null,"CANCLED");

			}
			
		});
		btnBDelete.setBackground(SystemColor.control);
		btnBDelete.setBounds(425, 308, 89, 23);
		pnlbranchdtl.add(btnBDelete);
		
		JButton btnBClear = new JButton("CLEAR");
		btnBClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtbranchBdtl.setText("");
				txtbranchnameBdtl.setText("");
				txtsubBdtl.setText(null);
			}
		});
		btnBClear.setBackground(SystemColor.control);
		btnBClear.setBounds(555, 308, 89, 23);
		pnlbranchdtl.add(btnBClear);
		
		JLabel lblChooseSemAnd = new JLabel("CHOOSE  SEM AND BRANCH TO  VIEW ALL SUBJECT AND SUBJECT CODE");
		lblChooseSemAnd.setFont(new Font("Calibri", Font.BOLD, 15));
		lblChooseSemAnd.setBounds(252, 375, 454, 14);
		pnlbranchdtl.add(lblChooseSemAnd);
		
		JLabel lblSem_2bdtl = new JLabel("Sem");
		lblSem_2bdtl.setBounds(392, 415, 46, 14);
		pnlbranchdtl.add(lblSem_2bdtl);
		
		JLabel lblBranch2_Bdtl = new JLabel("Branch");
		lblBranch2_Bdtl.setBounds(505, 415, 46, 14);
		pnlbranchdtl.add(lblBranch2_Bdtl);
		
		cmbsem2Bdtl = new JComboBox();
		cmbsem2Bdtl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsem2Bdtl.setBounds(329, 440, 116, 20);
		pnlbranchdtl.add(cmbsem2Bdtl);
		
		cmbbranch2bdtl = new JComboBox();
		
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select DISTINCT branch from branchdetail ";
						st = con.createStatement();
						rs = st.executeQuery(sql);
						
						while(rs.next())
						{
							
							cmbbranch2bdtl.addItem(rs.getString(1));
							
						}
				}
				catch(Exception e)
				{
					JOptionPane.showConfirmDialog(null,e);
				}
			
		
		cmbbranch2bdtl.setBounds(468, 440, 117, 20);
		pnlbranchdtl.add(cmbbranch2bdtl);
		
		/*JLabel lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setBounds(299, 503, 89, 14);
		pnlbranchdtl.add(lblSubjectCode);
		
		JLabel lblSubject_1Bdtl = new JLabel("Subject");
		lblSubject_1Bdtl.setBounds(567, 503, 46, 14);
		pnlbranchdtl.add(lblSubject_1Bdtl);
		
		final List listsubcodeBdtl = new List();
		listsubcodeBdtl.setForeground(Color.BLACK);
		//listsubcodeBdtl.setBackground(new Color(255, 255, 255));
		listsubcodeBdtl.setBounds(274, 528, 116, 147);
		pnlbranchdtl.add(listsubcodeBdtl);
		
		final List listsubBdtl = new List();
		listsubBdtl.setForeground(Color.BLACK);
		listsubBdtl.setBounds(527, 528, 116, 147);
		pnlbranchdtl.add(listsubBdtl);*/
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(291, 500, 335, 154);
		pnlbranchdtl.add(scrollPane_1);
		
		BdetailTable = new JTable();
		scrollPane_1.setViewportView(BdetailTable);

		JButton btnShow_1 = new JButton("SHOW");
		btnShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				/*listsubBdtl.clear();
				listsubcodeBdtl.clear();*/
				try
				{
					con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");
					
					PreparedStatement ps=con.prepareStatement("select sub,subcode from branchdetail where sem=? and branch=?");
					ps.setString(1,cmbsem2Bdtl.getSelectedItem().toString());
					ps.setString(2,cmbbranch2bdtl.getSelectedItem().toString());
					
					rs=ps.executeQuery();
					//while(rs.next())
					{
						//listsubcodeBdtl.add(rs.getString("subcode"));
						//listsubBdtl.add(rs.getString("sub"));
						BdetailTable.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
					st.close();
					con.close();
					
				}
				catch(Exception ex)
				{
					//JOptionPane.showConfirmDialog(null, "Data Not Found For This Record: Plz Check All Detail");
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
				
			}
		});
		btnShow_1.setBounds(410, 473, 89, 23);
		pnlbranchdtl.add(btnShow_1);
		
		Label label_6 = new Label("*");
		label_6.setForeground(Color.BLACK);
		label_6.setBackground(Color.RED);
		label_6.setBounds(267, 56, 8, 14);
		pnlbranchdtl.add(label_6);
		
		Label label_8 = new Label("*");
		label_8.setForeground(Color.BLACK);
		label_8.setBackground(Color.RED);
		label_8.setBounds(267, 171, 8, 14);
		pnlbranchdtl.add(label_8);
		
		Label label_9 = new Label("*");
		label_9.setForeground(Color.BLACK);
		label_9.setBackground(Color.RED);
		label_9.setBounds(267, 266, 8, 14);
		pnlbranchdtl.add(label_9);
	
		JPanel pnlstudentdtl = new JPanel();						//Student Detail Panel
		pnlstudentdtl.setBackground(Color.PINK);
		masterpanel.add(pnlstudentdtl, "studentDtlPnl");			//Student Detail Panel Given Name
		pnlstudentdtl.setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("Student Registration");		//StudentRegistration label
		lblStudentRegistration.setForeground(Color.BLUE);
		lblStudentRegistration.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblStudentRegistration.setBounds(96, 21, 320, 35);
		pnlstudentdtl.add(lblStudentRegistration);
		
		JLabel lblStudentDetail = new JLabel("Student Detail");		//Student Detail Label
		lblStudentDetail.setForeground(Color.BLUE);
		lblStudentDetail.setFont(new Font("Calibri", Font.BOLD, 14));
		lblStudentDetail.setBounds(27, 114, 92, 14);
		pnlstudentdtl.add(lblStudentDetail);
		
		JLabel lblAdmisionDate = new JLabel("Admision Date");		//Admission Date Label
		lblAdmisionDate.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAdmisionDate.setBounds(27, 145, 87, 14);
		pnlstudentdtl.add(lblAdmisionDate);
		
		JDateChooser admdate = new JDateChooser();
		admdate.getCalendarButton().setToolTipText("CHOOSE DATE");
		admdate.setBounds(360,140, 21, 20);
		pnlstudentdtl.add(admdate);
	
		
		txtAdmisiondatereg = new JTextField();    //Admission Date TextField Key type
		txtAdmisiondatereg.setEditable(false);
		txtAdmisiondatereg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				try 
				   {
					txtAdmisiondatereg.setText("First Choose Date & Click Here");
					DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
					txtAdmisiondatereg.setText(df.format(admdate.getDate()));
				   }
					catch(NullPointerException npe)
					{
					JOptionPane.showMessageDialog(null, "First Choose Date");
					}	
			}
		});
		txtAdmisiondatereg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke)
			{

				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_SLASH))){
			
				ke.consume();
				}
			}
		});
		
		//final JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setBounds(160, 79, 221, 20);
		//pnlstudentdtl.add(dateChooser);
		
		txtAdmisiondatereg.setBounds(160, 142, 195, 20);				//Admission Date TextField
		pnlstudentdtl.add(txtAdmisiondatereg);
		txtAdmisiondatereg.setColumns(10);
		
		JLabel lblEnrollmentNo = new JLabel("Enrollment No.");		//Enrollment No Label
		lblEnrollmentNo.setFont(new Font("Calibri", Font.BOLD, 13));
		lblEnrollmentNo.setBounds(27, 182, 87, 14);
		pnlstudentdtl.add(lblEnrollmentNo);
		
		txtennoreg = new JTextField();								//Enrollment No Textfield Key Type
		txtennoreg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke)
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
				{
			
				ke.consume();
				}
			}
		});
		txtennoreg.setBounds(160, 179, 221, 20);					//Enrollment No Textfield
		pnlstudentdtl.add(txtennoreg);
		txtennoreg.setColumns(10);
		
		JLabel lblBranch_1 = new JLabel("Branch");				   //Branch Label
		lblBranch_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranch_1.setBounds(27, 213, 87, 14);
		pnlstudentdtl.add(lblBranch_1);
		
		final JComboBox cmbbranchreg = new JComboBox();		//Branch Combobox
		 	{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select DISTINCT branch from branchdetail ";
						st = con.createStatement();
						rs = st.executeQuery(sql);
						
						while(rs.next())
						{
							cmbbranchreg.addItem(rs.getString(1));
							
						}
				}
				catch(Exception e)
				{
					JOptionPane.showConfirmDialog(null,e);
				}
		 	}
		cmbbranchreg.setBounds(160, 210, 221, 20);
		pnlstudentdtl.add(cmbbranchreg);
		
		JLabel lblYear_1 = new JLabel("Year");					//Year Label
		lblYear_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblYear_1.setBounds(32, 249, 46, 14);
		pnlstudentdtl.add(lblYear_1);
		
		
		final JComboBox cmbyearreg = new JComboBox();					//Year Combobox
		cmbyearreg.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		cmbyearreg.setBounds(160, 246, 221, 20);
		pnlstudentdtl.add(cmbyearreg);
		
		
		
		
		
		JLabel lblRollNo = new JLabel("Roll No.");				//Roll No Label
		lblRollNo.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRollNo.setBounds(435, 145, 46, 14);
		pnlstudentdtl.add(lblRollNo);
		
		txtrollnoreg = new JTextField();						//Roll No Textfield Key Type
		txtrollnoreg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
				{
			
				ke.consume();
				}
			}
		});
		txtrollnoreg.setBounds(565, 142, 272, 20);				//Roll No Textfield
		pnlstudentdtl.add(txtrollnoreg);
		txtrollnoreg.setColumns(10);
				
		JLabel lblStudentName = new JLabel("Student Name");			//Student Name Label
		lblStudentName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblStudentName.setBounds(435, 191, 87, 14);
		pnlstudentdtl.add(lblStudentName);
		
		txtstudentnamereg = new JTextField();						//Student Name Textfield Key Type
		txtstudentnamereg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{

				char c=ke.getKeyChar();
				if(!(Character.isLetter(c)||c==KeyEvent.VK_SPACE)){
			
				ke.consume();
				}
			}
		});
		txtstudentnamereg.setBounds(565, 185, 272, 20);			//Student Name Textfield
		pnlstudentdtl.add(txtstudentnamereg);
		txtstudentnamereg.setColumns(10);

		JDateChooser dateChooserdob = new JDateChooser();
		dateChooserdob.setBounds(816, 280, 21, 20);
		pnlstudentdtl.add(dateChooserdob);
	
		
		txtdobSdtl = new JTextField();
		txtdobSdtl.setEditable(false);
		txtdobSdtl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try 
			   {
					txtdobSdtl.setText("First Choose Date & Click Here");
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				txtdobSdtl.setText(df.format(dateChooserdob.getDate()));
			   }
				catch(NullPointerException npe)
				{
				JOptionPane.showMessageDialog(null, "First Choose Date");
				}	
			}
		});
		txtdobSdtl.setBounds(565, 280, 241, 20);
		pnlstudentdtl.add(txtdobSdtl);
		txtdobSdtl.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");					//DOB Label
		lblDob.setFont(new Font("Calibri", Font.BOLD, 13));
		lblDob.setBounds(435, 280, 46, 14);
		pnlstudentdtl.add(lblDob);
		
		
		
		JLabel lblGender = new JLabel("Gender");			//Gender Label
		lblGender.setFont(new Font("Calibri", Font.BOLD, 13));
		lblGender.setBounds(435, 229, 46, 14);
		pnlstudentdtl.add(lblGender);
		
		final JComboBox cmbgenderreg = new JComboBox();				//Gender Combobox
		cmbgenderreg.setBounds(565, 226, 272, 20);
		pnlstudentdtl.add(cmbgenderreg);
		cmbgenderreg.addItem("MALE");
		cmbgenderreg.addItem("FEMALE");
		
		JLabel lblSem_reg = new JLabel("Sem");
		lblSem_reg.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSem_reg.setBounds(32, 280, 46, 14);
		pnlstudentdtl.add(lblSem_reg);
		
		final JComboBox cmbsemreg = new JComboBox();
		cmbsemreg.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsemreg.setBounds(160, 277, 221, 20);
		pnlstudentdtl.add(cmbsemreg);
		
		JLabel lblParentDetail = new JLabel("Parent Detail");		//Parent detail Label
		lblParentDetail.setForeground(Color.BLUE);
		lblParentDetail.setFont(new Font("Calibri", Font.BOLD, 14));
		lblParentDetail.setBounds(32, 322, 79, 14);
		pnlstudentdtl.add(lblParentDetail);
		
		JLabel lblFatherName = new JLabel("Father Name");			//Father Name LAbel
		lblFatherName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblFatherName.setBounds(32, 358, 87, 14);
		pnlstudentdtl.add(lblFatherName);
		
		txtfathernamereg = new JTextField();						//Father Name Textfield Key Type	
		txtfathernamereg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke)
			{
				char c=ke.getKeyChar();
				if(!(Character.isLetter(c)||c==KeyEvent.VK_SPACE)){
			
				ke.consume();
				}
			}
		});
		txtfathernamereg.setBounds(160, 355, 221, 20);			//Father Name Textfield
		pnlstudentdtl.add(txtfathernamereg);
		txtfathernamereg.setColumns(10);
		
		JLabel lblMono = new JLabel("MO.NO.");					//Father MOno Label
		lblMono.setFont(new Font("Calibri", Font.BOLD, 13));
		lblMono.setBounds(32, 403, 46, 14);
		pnlstudentdtl.add(lblMono);
		
		txtFmonoreg = new JTextField();							//Father MoNo Textfield Key Type
		txtFmonoreg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)){
			
				ke.consume();
			}
			}
		});
		txtFmonoreg.setBounds(160, 400, 221, 20);			//Father MoNo Textfield
		pnlstudentdtl.add(txtFmonoreg);
		txtFmonoreg.setColumns(10);
		
		JLabel lblMotherName = new JLabel("Mother Name");		//Mother Name Label
		lblMotherName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblMotherName.setBounds(435, 358, 87, 14);
		pnlstudentdtl.add(lblMotherName);
		
		txtmothernamereg = new JTextField();					//Mother Name Textfield Key Type
		txtmothernamereg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{

				char c=ke.getKeyChar();
				if(!(Character.isLetter(c)||c==KeyEvent.VK_SPACE)){
			
				ke.consume();
				}
			}
		});
		txtmothernamereg.setBounds(565, 355, 272, 20);				//Mother Name Textfield
		pnlstudentdtl.add(txtmothernamereg);
		txtmothernamereg.setColumns(10);
		
		JLabel lblMono_1 = new JLabel("MO.NO.");					//Mother MoNo Label
		lblMono_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblMono_1.setBounds(435, 403, 46, 14);
		pnlstudentdtl.add(lblMono_1);
		
		txtMmonoreg = new JTextField();								//Mother MoNo Textfield Key Type
		txtMmonoreg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke)
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)){
			
				ke.consume();
				}
			}
		});
		txtMmonoreg.setBounds(565, 400, 272, 20);				//Mother MoNo Textfield
		pnlstudentdtl.add(txtMmonoreg);
		txtMmonoreg.setColumns(10);
		
		JLabel lblCntactDetai = new JLabel("Contact Detail");			//Contact Detail Label
		lblCntactDetai.setForeground(Color.BLUE);
		lblCntactDetai.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCntactDetai.setBounds(32, 446, 87, 14);
		pnlstudentdtl.add(lblCntactDetai);
		
		JLabel lblStudentMono = new JLabel("Student MO.NO");			//Student MoNo Label
		lblStudentMono.setFont(new Font("Calibri", Font.BOLD, 13));
		lblStudentMono.setBounds(32, 489, 97, 14);
		pnlstudentdtl.add(lblStudentMono);
		
		txtstudentmonoreg = new JTextField();							//Student MoNo Textfield Key Type
		txtstudentmonoreg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)){
			
				ke.consume();
				}
			}
		});
		txtstudentmonoreg.setBounds(160, 486, 221, 20);				//Student MoNo Textfield
		pnlstudentdtl.add(txtstudentmonoreg);
		txtstudentmonoreg.setColumns(10);
		
		JLabel lblAddess = new JLabel("Address");				// Address Label
		lblAddess.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAddess.setBounds(32, 540, 46, 14);
		pnlstudentdtl.add(lblAddess);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 540, 221, 65);
		pnlstudentdtl.add(scrollPane);
		
		final JTextArea textAreaaddressreg = new JTextArea();
		scrollPane.setViewportView(textAreaaddressreg);
		
		JLabel lblEmailId = new JLabel("Email ID");				//Email ID Label
		lblEmailId.setFont(new Font("Calibri", Font.BOLD, 13));
		lblEmailId.setBounds(32, 627, 46, 14);
		pnlstudentdtl.add(lblEmailId);
		
		txtemailidreg = new JTextField();						//Email ID Textfield
		txtemailidreg.setBounds(160, 624, 221, 20);
		pnlstudentdtl.add(txtemailidreg);
		txtemailidreg.setColumns(10);
		
		final JLabel lbl_image = new JLabel("");
		//lbl_image.setIcon(new ImageIcon(samsApp.class.getResource("/java_file/no img.jpg")));
		lbl_image.setBounds(425, 2, 124, 132);
		pnlstudentdtl.add(lbl_image);
		 Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		 lbl_image.setBorder(border);
		
		
		       
		JButton btnUploadImage = new JButton("UPLOAD IMAGE");
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				//filter the file
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png","ico");
				file.addChoosableFileFilter(filter);
				int result=file.showSaveDialog(null);
				//if the user click on save in jfilechooser
				if(result==JFileChooser.APPROVE_OPTION)
				{
					File selectedFile =file.getSelectedFile();
					String path;
					// path=File.separator;
				
					path=file.getSelectedFile().getAbsolutePath().replace('\\', '/');
					//System.out.println("repalce path="+path);
					//path = 	selectedFile.getAbsolutePath();
					lbl_image.setIcon(ResizeImage(path,null));
							imgpath=path;
							//System.out.println("imgpath="+imgpath);
				
				}
				//if the user lick on cancle in jfilechooser
				else if(result==JFileChooser.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(null, "NO FILE SELECTED");
				}
			}
			
			
			public ImageIcon ResizeImage(String ImagePath, byte[] pic)
					{
				ImageIcon myimage=null;
				if(ImagePath != null)
				{
					myimage=new ImageIcon(ImagePath);
					//System.out.println("imagePath="+ImagePath);
				}
				else
				{
					myimage=new ImageIcon(pic);
				}
				Image img=myimage.getImage();
				Image newimg=img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon image=new ImageIcon(newimg);
				return image;
					}
			
		});
		btnUploadImage.setBounds(582, 61, 124, 23);
		pnlstudentdtl.add(btnUploadImage);
		
		JButton btnClearreg = new JButton("CLEAR");				//CLEAR Button
		btnClearreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				txtAdmisiondatereg.setText(null);
				txtennoreg.setText(null);
				txtfathernamereg.setText(null);
				txtFmonoreg.setText(null);
				txtmothernamereg.setText(null);
				txtMmonoreg.setText(null);
				txtrollnoreg.setText(null);
				txtstudentnamereg.setText(null);
				dateChooserdob.setDate(null);
				txtstudentmonoreg.setText(null);
				textAreaaddressreg.setText(null);
				txtemailidreg.setText(null);
				lbl_image.setIcon(null);
			}
			
		});
		btnClearreg.setBounds(412, 623, 89, 23);
		pnlstudentdtl.add(btnClearreg);
		
		JButton btnSavereg = new JButton("SAVE");				//SAVE Button
		btnSavereg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String dobdate=String.valueOf(dateChooserdob.getDate());
			
				try
				{
					
					if(txtrollnoreg.getText().equals("")|| txtennoreg.getText().equals("")|| txtstudentnamereg.getText().equals("")|| cmbyearreg.getSelectedItem().equals("")||cmbsemreg.getSelectedItem().equals(""))
					{
						JOptionPane.showMessageDialog(null, "plz fill all * field");

					}
					
					else{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					
					//int i=st.executeUpdate("insert into studentregistration values('"+txtAdmisiondatereg.getText().toString()+"','" 
					//+txtrollnoreg.getText().toString()+"','"+txtennoreg.getText().toString()+"','"+txtstudentnamereg.getText().toString()+"','"+cmbbranchreg.getSelectedItem()+"','"+txtdobreg.getText().toString()+"','"+cmbyearreg.getSelectedItem().toString()+"','"+cmbgenderreg.getSelectedItem()+"','"+cmbsemreg.getSelectedItem().toString()+"','"+txtfathernamereg.getText()+"','"+txtmothernamereg.getText()+"','"+txtFmonoreg.getText().toString()+"','"+txtMmonoreg.getText().toString()+"','"+txtstudentmonoreg.getText().toString()+"','"+textAreaaddressreg.getText().toString()+"','"+txtemailidreg.getText() +"')");
					
					FileInputStream fis = new FileInputStream(imgpath);
					
					
					   PreparedStatement pre =(PreparedStatement) con.prepareStatement("insert into studentregistration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					 
					   pre.setString(1,txtAdmisiondatereg.getText());
					   pre.setString(2, txtrollnoreg.getText());
					   pre.setString(3, txtennoreg.getText());
					   pre.setString(4, txtstudentnamereg.getText());
					   pre.setString(5, cmbbranchreg.getSelectedItem().toString());
					   pre.setString(6, dobdate);
					   pre.setString(7, cmbyearreg.getSelectedItem().toString());
					   pre.setString(8, cmbgenderreg.getSelectedItem().toString());
					   pre.setString(9, cmbsemreg.getSelectedItem().toString());
					   pre.setString(10, txtfathernamereg.getText());
					   pre.setString(11, txtmothernamereg.getText());
					   pre.setString(12, txtFmonoreg.getText());
					   pre.setString(13, txtMmonoreg.getText());
					   pre.setString(14, txtstudentmonoreg.getText());
					   pre.setString(15, textAreaaddressreg.getText());
					   pre.setString(16, txtemailidreg.getText());
					  
					   pre.setBlob(17, fis);
					  // pre.setBinaryStream(17,(InputStream)fin,(int)imgpath.length());
					   pre.executeUpdate();
					
						//System.out.println(" save fis="+fis);
				JOptionPane.showMessageDialog(null,"Record Inserted");
					
					
					 txtstudentnamereg.setText("");
					
					 dateChooserdob.cleanup();
					
					 txtfathernamereg.setText("");
					txtmothernamereg.setText("");
					txtFmonoreg.setText("");
					 
					 txtMmonoreg.setText("");
					 txtstudentmonoreg.setText("");
					 textAreaaddressreg.setText("");
					 txtemailidreg.setText("");
					
					st.close();
					con.close();
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnSavereg.setBounds(412, 536, 89, 23);
		pnlstudentdtl.add(btnSavereg);
		
		JButton btnEdite = new JButton("UPDATE");				//EDIT Button
		btnEdite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String dobdate=String.valueOf(dateChooserdob.getDate());
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
				    FileInputStream fis = new FileInputStream(imgpath);
				   PreparedStatement st=con.prepareStatement(("update studentregistration set admisiondate=?,enrollmentno=?,studentname=?,branch=?,dob=?,year=?,"
				   		+ "gender=?,sem=?,fathername=?,mothername=?,fathermono=?,mothermono=?,studentmono=?,address=?,email=?,image=? where  rollno=?"));
				 
				    st.setString(1, txtAdmisiondatereg.getText());
				    st.setString(2, txtennoreg.getText().toString());
					st.setString(3, txtstudentnamereg.getText());
					st.setString(4, cmbbranchreg.getSelectedItem().toString());
					st.setString(5, dobdate);
					st.setString(6, cmbyearreg.getSelectedItem().toString());
					st.setString(7, cmbgenderreg.getSelectedItem().toString());
					st.setString(8, cmbsemreg.getSelectedItem().toString());
					st.setString(9, txtfathernamereg.getText());
					st.setString(10, txtmothernamereg.getText());
					st.setString(11, txtFmonoreg.getText().toString());
					st.setString(12, txtMmonoreg.getText().toString());
					st.setString(13, txtstudentmonoreg.getText().toString());
					st.setString(14, textAreaaddressreg.getText());
					st.setString(15, txtemailidreg.getText());
					st.setBlob(16, fis);
					st.setString(17, txtrollnoreg.getText().toString());
					
			
					int i=st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record Updated");
					
					
					 txtAdmisiondatereg.setText(null);
					 txtrollnoreg.setText("");
					 txtennoreg.setText("");
					 txtstudentnamereg.setText("");
					
					 dateChooserdob.cleanup();
					
					 txtfathernamereg.setText("");
					 txtmothernamereg.setText("");
					 txtFmonoreg.setText("");
				     txtMmonoreg.setText("");
					 txtstudentmonoreg.setText("");
					 textAreaaddressreg.setText("");
					 txtemailidreg.setText("");
				lbl_image.setIcon(null);
					
					st.close();
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnEdite.setBounds(412, 578, 89, 23);
		pnlstudentdtl.add(btnEdite);
		
		
		JButton btnClose = new JButton("CLOSE");				//CLOSE Button
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnClose.setBounds(530, 623, 89, 23);
		pnlstudentdtl.add(btnClose);
		
		JButton btnSearch = new JButton("SEARCH");			//SEARCH Button
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				

				try{
					Class.forName("com.mysql.jdbc.Driver");
					con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
					String sql="select * from studentregistration where rollno='" + txtrollnoreg.getText().toString()+"'";
					st = con.createStatement();
					rs = st.executeQuery(sql);
					
					if(rs.next())
				{
				
				        	 
					txtAdmisiondatereg.setText(rs.getString("admisiondate"));
					txtrollnoreg.setText(rs.getString("rollno"));
					txtennoreg.setText(rs.getString("enrollmentno"));
					txtstudentnamereg.setText(rs.getString("studentname"));
					cmbbranchreg.setSelectedItem(rs.getString("branch"));
					txtdobSdtl.setText(rs.getString("dob"));
					cmbyearreg.setSelectedItem(rs.getString("year"));
					cmbgenderreg.setSelectedItem(rs.getString("gender"));
					cmbsemreg.setSelectedItem(rs.getString("sem"));
					txtfathernamereg.setText(rs.getString("fathername"));
					txtmothernamereg.setText(rs.getString("mothername"));
					txtFmonoreg.setText(rs.getString("fathermono"));
					txtMmonoreg.setText(rs.getString("mothermono"));
					txtstudentmonoreg.setText(rs.getString("studentmono"));
					textAreaaddressreg.setText(rs.getString("address"));
					txtemailidreg.setText(rs.getString("email"));
					 byte[] img=rs.getBytes("image");
		        	  ImageIcon image=new ImageIcon(img);
		        	  Image im=image.getImage();
		        	  Image myimage=im.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
		        	  ImageIcon newimage=new ImageIcon(myimage);
		        	  lbl_image.setIcon(newimage);  
				}
				else{
					JOptionPane.showMessageDialog(null, "NO RECORD FOR THIS ROLL NO");
				}
			}
			catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null, "OK");
			}
			}
		});
		btnSearch.setBounds(530, 578, 89, 23);
		pnlstudentdtl.add(btnSearch);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
			{
				String str=txtrollnoreg.getText();
				int conf = JOptionPane.showConfirmDialog (null, "Are you sure?","To Delete Student", JOptionPane.YES_NO_OPTION);
	            if(conf == 0) 
	            	{
				try
				{
					if(str.equals(""))
					{
						JOptionPane.showConfirmDialog(null, "plz give roll no");
					}else{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					st.executeUpdate("delete from studentregistration where rollno='"+txtrollnoreg.getText()+"' ");
					JOptionPane.showMessageDialog(null,"Record Deleted");
					/*txtAdmisiondatereg.setText("");
					txtennoreg.setText("");
					cmbbranchreg.setSelectedItem("");
					cmbyearreg.setSelectedItem("");*/
					txtrollnoreg.setText("");
					/*txtstudentnamereg.setText("");
					dateChooserdob.setDate();
					cmbgenderreg.setSelectedItem("");
					txtfathernamereg.setText("");
					txtFmonoreg.setText("");
					txtmothernamereg.setText("");
					txtMmonoreg.setText("");
					txtstudentmonoreg.setText("");
					textAreaaddressreg.setText("");
					txtemailidreg.setText("");*/
					
				
					st.close();
					con.close();
					
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Record Deleted");
				}
			}
	            else
					JOptionPane.showMessageDialog(null,"CANCLED");

			}
			
		});
		btnDelete.setBounds(530, 536, 89, 23);
		pnlstudentdtl.add(btnDelete);
		
		Label label = new Label("*");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.RED);
		label.setBounds(421, 145, 8, 14);
		
		pnlstudentdtl.add(label);
		
		Label label_1 = new Label("*");
		label_1.setBackground(Color.RED);
		label_1.setBounds(421, 191, 8, 14);
		pnlstudentdtl.add(label_1);
		
		Label label_2 = new Label("*");
		label_2.setBackground(Color.RED);
		label_2.setBounds(421, 229, 8, 14);
		pnlstudentdtl.add(label_2);
		
		Label label_3 = new Label("*");
		label_3.setBackground(Color.RED);
		label_3.setBounds(146, 185, 8, 14);
		pnlstudentdtl.add(label_3);
		
		Label label_4 = new Label("*");
		label_4.setBackground(Color.RED);
		label_4.setBounds(146, 249, 8, 14);
		pnlstudentdtl.add(label_4);
		
		Label label_5 = new Label("*");
		label_5.setBackground(Color.RED);
		label_5.setBounds(146, 213, 8, 14);
		pnlstudentdtl.add(label_5);
		
		JLabel lblNewLabel = new JLabel("DD-MM-YYYY");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel.setBounds(159, 114, 87, 14);
		pnlstudentdtl.add(lblNewLabel);
		
		Label label_7 = new Label("*");
		label_7.setBackground(Color.RED);
		label_7.setBounds(146, 280, 8, 14);
		pnlstudentdtl.add(label_7);
		
		JPanel pnlattendance = new JPanel();
		pnlattendance.setBackground(Color.PINK);
		masterpanel.add(pnlattendance, "pnlattendance");
		pnlattendance.setLayout(null);
		
		JLabel lblAttendanceDetail = new JLabel("Attendance ");
		lblAttendanceDetail.setForeground(Color.BLUE);
		lblAttendanceDetail.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblAttendanceDetail.setBounds(305, 49, 186, 29);
		pnlattendance.add(lblAttendanceDetail);
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 13));
		lblDate.setBounds(12, 241, 46, 14);
		pnlattendance.add(lblDate);
		
		JLabel lblSub = new JLabel("Branch");
		lblSub.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSub.setBounds(12, 342, 46, 14);
		pnlattendance.add(lblSub);
		
		final JComboBox cmbbranchatt = new JComboBox();
		{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select DISTINCT branch from branchdetail ";
						st = con.createStatement();
						rs = st.executeQuery(sql);
						
						while(rs.next())
						{
							cmbbranchatt.addItem(rs.getString(1));
							
						}
				}
				catch(Exception e)
				{
					JOptionPane.showConfirmDialog(null,e);
				}
			}
		
		cmbbranchatt.setBounds(65, 339, 105, 20);
		
		pnlattendance.add(cmbbranchatt);
		
		final List listrollnoAtt = new List();
		listrollnoAtt.setMultipleMode(true);
		listrollnoAtt.setFont(new Font("Calibri", Font.PLAIN, 14));
		listrollnoAtt.setBounds(328, 151, 110, 304);
		pnlattendance.add(listrollnoAtt);
		
		JLabel lblRollNo_4 = new JLabel("Roll No.");
		lblRollNo_4.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRollNo_4.setBounds(361, 127, 46, 14);
		pnlattendance.add(lblRollNo_4);
		
		
		JLabel lblStudentname = new JLabel("Student Name");
		lblStudentname.setFont(new Font("Calibri", Font.BOLD, 13));
		lblStudentname.setBounds(529, 127, 81, 14);
		pnlattendance.add(lblStudentname);
		
		final List liststudentnameAtt = new List();
		liststudentnameAtt.setFont(new Font("Calibri", Font.PLAIN, 14));
		liststudentnameAtt.setBounds(469, 151, 200, 301);
		pnlattendance.add(liststudentnameAtt);
		
		JLabel lblSem_1 = new JLabel("Sem");
		lblSem_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSem_1.setBounds(12, 392, 46, 14);
		pnlattendance.add(lblSem_1);
		
		JLabel lblMonth_1 = new JLabel("Month");
		lblMonth_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblMonth_1.setBounds(12, 187, 46, 14);
		pnlattendance.add(lblMonth_1);
		
		final JComboBox cmbmonthAtt = new JComboBox();
		cmbmonthAtt.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbmonthAtt.setBounds(68, 184, 102, 20);
		pnlattendance.add(cmbmonthAtt);
		
		JDateChooser datechooserAtt = new JDateChooser();
		datechooserAtt.setBounds(158, 235, 21, 20);
		pnlattendance.add(datechooserAtt);
		
		txtdateAtt = new JTextField();
		txtdateAtt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				try 
				   {
					txtdateAtt.setText("Click");
					DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
					txtdateAtt.setText(df.format(datechooserAtt.getDate()));
				   }
					catch(NullPointerException npe)
					{
					JOptionPane.showMessageDialog(null, "First Choose Date");
					}	
			}
		});
		txtdateAtt.setEditable(false);
		txtdateAtt.setBounds(68, 235, 86, 20);
		pnlattendance.add(txtdateAtt);
		txtdateAtt.setColumns(10);
		
		
		
		final JComboBox cmbsemAtt = new JComboBox();
		cmbsemAtt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				//String branch=cmbbranchatt.getSelectedItem().toString();
				//int sem=Integer.parseInt(listsematt.getSelectedItem());
				 listrollnoAtt.removeAll();
				 liststudentnameAtt.removeAll();
		    	  
		    		try {
						
						Class.forName("com.mysql.jdbc.Driver");  
						con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
						st=con.createStatement();
						rs=st.executeQuery("select * from studentregistration where branch='"+cmbbranchatt.getSelectedItem().toString()+"' AND sem='"+cmbsemAtt.getSelectedItem()+"'");
						while(rs.next())
						{ 		
							 listrollnoAtt.add(rs.getString(2));
							 liststudentnameAtt.add(rs.getString(4));
					    
							
						}
					
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		});
		
		JLabel lbltimeAtt = new JLabel("Time");
		lbltimeAtt.setBounds(10, 293, 46, 14);
		pnlattendance.add(lbltimeAtt);
		
		JTimeChooser timeChooserAtt = new JTimeChooser();
		timeChooserAtt.setBounds(65, 293, 50, 20);
		pnlattendance.add(timeChooserAtt);
		cmbsemAtt.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsemAtt.setBounds(65, 389, 105, 20);
		pnlattendance.add(cmbsemAtt);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSubject.setBounds(12, 436, 46, 14);
		pnlattendance.add(lblSubject);
		
		final JComboBox cmbsubjectAtt = new JComboBox();
		cmbsubjectAtt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
			cmbsubjectAtt.removeAllItems();	
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
							String sql="select DISTINCT sub from branchdetail where branch='"+cmbbranchatt.getSelectedItem().toString()+"' and sem='"+cmbsemAtt.getSelectedItem().toString()+"'";
							st = con.createStatement();
							rs = st.executeQuery(sql);
							
							while(rs.next())
							{
								cmbsubjectAtt.addItem(rs.getString(1));
								
							}
					}
					catch(Exception e)
					{
						JOptionPane.showConfirmDialog(null,e);
					}
				}
			
		});
	    cmbsubjectAtt.setBounds(69, 435, 153, 20);
		pnlattendance.add(cmbsubjectAtt);
		
		JLabel lblyearAtt = new JLabel("Year");
		lblyearAtt.setFont(new Font("Calibri", Font.BOLD, 13));
		lblyearAtt.setBounds(12, 142, 46, 14);
		pnlattendance.add(lblyearAtt);
		
		final TextField txtyearAtt = new TextField();
		txtyearAtt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				{
					char c=ke.getKeyChar();
					if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
					{
						ke.consume();
					}
				}
			}
		});
		txtyearAtt.setBounds(65, 142, 102, 20);
		pnlattendance.add(txtyearAtt);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				try
				{
					
						if(datechooserAtt.getDate().equals("")|| cmbmonthAtt.getSelectedItem().equals("")|| txtyearAtt.getText().equals("")|| cmbbranchatt.getSelectedItem().equals("")||cmbsemAtt.getSelectedItem().equals("")||cmbsubjectAtt.getSelectedItem().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Something Missing");
						}
					
					
						else
						{
							int conf=JOptionPane.showConfirmDialog(null, "Check All Fields Befor Saveing","CONFIRMATION BEFORE SAVING",JOptionPane.YES_NO_OPTION );
							if(conf==0)
							{
								Class.forName("com.mysql.jdbc.Driver");  
								con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
								st=con.createStatement();
					
				
									int j=0;
									while(j<listrollnoAtt.getItemCount())
									{
						
						
										if(listrollnoAtt.isSelected(j))
										{
						
											int i=st.executeUpdate("insert into attendance values('"+txtdateAtt.getText().toString()+"','"+cmbbranchatt.getSelectedItem().toString()+"','"+cmbsemAtt.getSelectedItem().toString()+"','"+cmbsubjectAtt.getSelectedItem()+"','"+listrollnoAtt.getItem(j)+"','"+liststudentnameAtt.getItem(j).toString()+"','"+cmbmonthAtt.getSelectedItem().toString()+"','"+txtyearAtt.getText().toString()+"')");
											//JOptionPane.showMessageDialog(null,"ok");
										}
											j++;
										
									}
										JOptionPane.showMessageDialog(null,"Record Inserted");
					
									txtdateAtt.setText(null);
										listrollnoAtt.removeAll();
										liststudentnameAtt.removeAll();
										st.close();
										con.close();
								}
											else 
											{
												JOptionPane.showMessageDialog(null, "CANCLED");
											}
						}
					
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
				
			}
		});
		
		
		
		btnSave.setBackground(Color.MAGENTA);
		btnSave.setFont(new Font("Calibri", Font.BOLD, 13));
		btnSave.setBounds(427, 506, 89, 23);
		pnlattendance.add(btnSave);
		
		
		

	    JPanel pnluserdtl = new JPanel();
		pnluserdtl.setBackground(Color.PINK);
		masterpanel.add(pnluserdtl, "pnluserdetail");		//user detail panel given name
		pnluserdtl.setLayout(null);
		
		JLabel lblUserDetail = new JLabel("User Detail");
		lblUserDetail.setForeground(new Color(0, 0, 255));
		lblUserDetail.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblUserDetail.setBounds(411, 11, 205, 32);
		pnluserdtl.add(lblUserDetail);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 14));
		lblUsername.setBounds(360, 65, 74, 24);
		pnluserdtl.add(lblUsername);
		
		txtundtl = new JTextField();
		txtundtl.setColumns(10);
		txtundtl.setBounds(449, 67, 167, 20);
		pnluserdtl.add(txtundtl);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPassword.setBounds(360, 111, 74, 14);
		pnluserdtl.add(lblPassword);
		
		txtpassdtl = new JTextField();
		txtpassdtl.setBounds(449, 108, 167, 20);
		pnluserdtl.add(txtpassdtl);
		txtpassdtl.setColumns(10);
		
		JLabel lblUserType = new JLabel("USER TYPE");
		lblUserType.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUserType.setBounds(360, 155, 74, 14);
		pnluserdtl.add(lblUserType);
		
		final JComboBox cmbtypedtl = new JComboBox();
		cmbtypedtl.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Teacher"}));
		cmbtypedtl.setBounds(449, 152, 167, 20);
		pnluserdtl.add(cmbtypedtl);
		
		JLabel lblQuestion = new JLabel("QUESTION");
		lblQuestion.setFont(new Font("Calibri", Font.BOLD, 14));
		lblQuestion.setBounds(360, 204, 72, 14);
		pnluserdtl.add(lblQuestion);
		
		final JComboBox cmbques = new JComboBox();
		cmbques.setModel(new DefaultComboBoxModel(new String[] {"", "WHAT IS YOUR BIRTH YEAR ?", "WHAT IS YOUR NICKNAME ?", "LAST 4 DIGITS OF YOUR MOBILE NO ?", "WHAT IS YOUR FAVORITE COLOR ?", "WHAT IS THE NAME OF YOUR FAVOTIE PET ?"}));
		cmbques.setBounds(449, 200, 447, 20);
		pnluserdtl.add(cmbques);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setFont(new Font("Calibri", Font.BOLD, 14));
		lblAnswer.setBounds(360, 243, 74, 14);
		pnluserdtl.add(lblAnswer);
		
		txtAnswer = new JTextField();
		txtAnswer.setBounds(449, 240, 169, 20);
		pnluserdtl.add(txtAnswer);
		txtAnswer.setColumns(10);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					int i=((java.sql.Statement) st).executeUpdate("insert into logintable values( '"+txtundtl.getText().toString() + "','" 
					+txtpassdtl.getText().toString() + "','"+cmbtypedtl.getSelectedItem()+"','"+cmbques.getSelectedItem().toString()+"','"+txtAnswer.getText().toString()+"')");
					JOptionPane.showMessageDialog(null,"USER CREATED");
					
					 txtundtl.setText("");
					 txtpassdtl.setText("");
					 txtAnswer.setText("");
					// cmbtypedtl.setSelectedItem("");
			
					
					st.close();
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
			
		});
		
		
		btnCreate.setBackground(SystemColor.control);
		btnCreate.setBounds(360, 288, 112, 23);
		pnluserdtl.add(btnCreate);
		
		JButton btnDelete_1 = new JButton("DELETE");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					String uname,password;
					uname=txtundtl.getText();
					password=txtpassdtl.getText();
					if(uname.equals("")||password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Plz Check Username & Password");
				}
				else 
				{
					int conf = JOptionPane.showConfirmDialog (null, "Are you sure?","To User Delete", JOptionPane.YES_NO_OPTION);
					if(conf == 0) 
	            	{
						String sql="DELETE FROM logintable WHERE username=? && password=?";
						try
						{	
					
							Class.forName("com.mysql.jdbc.Driver");
							con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
							String user=txtundtl.getText();
							String pass=txtpassdtl.getText();
				
		            	
							PreparedStatement ps=con.prepareStatement(sql);
							ps.setString(1,user);
							ps.setString(2, pass);
							int i=ps.executeUpdate();
						
							JOptionPane.showMessageDialog(null, "USER DELETED");
							txtundtl.setText("");
							txtpassdtl.setText("");
							txtAnswer.setText("");
						}
						
				
							catch(Exception e2)
							{
								JOptionPane.showConfirmDialog(null, e2);
							}
	            	}
				
							else
							{
								JOptionPane.showMessageDialog(null, "CANCLED");
							}
	           	}
				
			}
		});
		btnDelete_1.setBackground(SystemColor.control);
		btnDelete_1.setBounds(504, 288, 112, 23);
		pnluserdtl.add(btnDelete_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					
					String un=txtundtl.getText().toString();
					String pass=txtpassdtl.getText().toString();
					String type=(String) cmbtypedtl.getSelectedItem().toString();
					String quest=cmbques.getSelectedItem().toString();
					String answ=txtAnswer.getText().toString();
					String sql="update logintable set password=?,usertype=?,question=?,answer=? where username=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,pass);
					ps.setString(2,type);
					ps.setString(3,quest);
					ps.setString(4, answ);
					ps.setString(5,un);
					int update=ps.executeUpdate();
					if(update>0)
					
					//String qur="update logintable set password='"+(pass)+"',usertype='"+(type)+"' ,question='"+(quest)+"',answer='"+(answ)+"' where username='"+(un)+"'";
				//	st.executeUpdate(qur);
					{
						JOptionPane.showConfirmDialog(null, "An Existing user was updated");
						txtundtl.setText("");
						txtpassdtl.setText("");
						txtAnswer.setText("");
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "User Not Present");

					}
				}
				catch(Exception e3)
				{
					JOptionPane.showConfirmDialog(null, e3);
				}
			}
		});
		btnUpdate.setBackground(SystemColor.control);
		btnUpdate.setBounds(360, 322, 111, 23);
		pnluserdtl.add(btnUpdate);
		
		JButton btnClose_2 = new JButton("CLOSE");
		btnClose_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnClose_2.setBackground(SystemColor.control);
		btnClose_2.setBounds(504, 322, 112, 23);
		pnluserdtl.add(btnClose_2);
		
		JPanel panelstudentlist = new JPanel();
		panelstudentlist.setBackground(Color.PINK);
		masterpanel.add(panelstudentlist, "panelstudentlist");
		panelstudentlist.setLayout(null);
		
		JLabel lblListOfAll = new JLabel("List Of All Student");
		lblListOfAll.setForeground(Color.BLUE);
		lblListOfAll.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblListOfAll.setBounds(201, 11, 365, 36);
		panelstudentlist.add(lblListOfAll);
		
		JLabel lblSemallstd = new JLabel("Sem");
		lblSemallstd.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSemallstd.setBounds(201, 74, 46, 14);
		panelstudentlist.add(lblSemallstd);
		
		final JComboBox cmblsemliststd = new JComboBox();
		cmblsemliststd.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmblsemliststd.setBounds(257, 71, 90, 20);
		panelstudentlist.add(cmblsemliststd);
		
		JLabel lblBranch_2 = new JLabel("Branch");
		lblBranch_2.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranch_2.setBounds(357, 74, 46, 14);
		panelstudentlist.add(lblBranch_2);
		
		final JComboBox cmbbranchliststd = new JComboBox();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
				String sql="select DISTINCT branch from branchdetail ";
				st = con.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next())
				{
					cmbbranchliststd.addItem(rs.getString(1));
					
				}
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null,e);
		}
		
		cmbbranchliststd.setBounds(413, 71, 89, 20);
		panelstudentlist.add(cmbbranchliststd);
		
		final JLabel lbl_liststdimage = new JLabel("");
		lbl_liststdimage.setBounds(37, 37, 120, 132);
		panelstudentlist.add(lbl_liststdimage);
		lbl_liststdimage.setBorder(border);
		
		
		
		 
		
		JTable table=new JTable();
		table.setFont(new Font("Monospaced", Font.PLAIN, 18));
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(30);
		
	table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int index=table.getSelectedRow();
				int colindex=table.getSelectedColumn();
				String value=String.valueOf(table.getValueAt(index,colindex ));
				//System.out.println(value);
			
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					
					String qur1="select image from studentregistration where rollno=? ";
					ps=con.prepareStatement(qur1);
					ps.setString(1, value);
					rs=ps.executeQuery();
					if(rs.next())
					{
						 byte[] img=rs.getBytes("image");
				         ImageIcon image=new ImageIcon(img);
				         Image im=image.getImage();
				         Image myimage=im.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				    	 ImageIcon newimage=new ImageIcon(myimage);
				         lbl_liststdimage.setIcon(newimage);  
					}
				}
				catch(Exception exe)
				{
					JOptionPane.showMessageDialog(null, "IMAGE NOT FOUND");
				}
				
			}
		});
	 sp = new JScrollPane(table);			//Jtable object passing to JScrollpane
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JTableHeader Theader=table.getTableHeader();
		Theader.setFont(new Font("Tahome",Font.BOLD,20));
		
		sp.setBounds(10, 211, 653, 311);
		panelstudentlist.add(sp);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 174, 653, 14);
		panelstudentlist.add(separator_3);
		
		JLabel lblTotal = new JLabel("Total =");
		lblTotal.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotal.setBounds(279, 556, 46, 14);
		panelstudentlist.add(lblTotal);
		
		final JLabel lbltotalliststd = new JLabel("0");
		lbltotalliststd.setBounds(323, 556, 46, 14);
		panelstudentlist.add(lbltotalliststd);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
		
				lbl_liststdimage.setIcon(null);
				try
				{
					con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");
					
					PreparedStatement ps=con.prepareStatement("select rollno,studentname,enrollmentno from studentregistration where sem=? and branch=? ORDER BY rollno ");
					ps.setString(1,cmblsemliststd.getSelectedItem().toString());
					ps.setString(2,cmbbranchliststd.getSelectedItem().toString());
		
					rs=ps.executeQuery();
					
					//while(rs.next())
					
					{ 
						table.setModel(DbUtils.resultSetToTableModel(rs));
						 
					}
					int a=table.getRowCount();
					lbltotalliststd.setText(String.valueOf(a));
					
					st.close();
					con.close();
					
				}
				catch(Exception ex)
				{
					//JOptionPane.showConfirmDialog(null, "Data Not Found For This Record: Plz Check All Detail");
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		btnShow.setFont(new Font("Calibri", Font.BOLD, 13));
		btnShow.setBounds(253, 140, 89, 23);
		panelstudentlist.add(btnShow);
		
		
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					String branch,sem;
					
					branch=cmbbranchliststd.getSelectedItem().toString();
					sem=cmblsemliststd.getSelectedItem().toString();
					
					
				con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
				HashMap param =new HashMap();
				
				param.put("branch", branch);
				param.put("sem", sem);
			
				InputStream is=ClassLoader.getSystemResourceAsStream("ListStudent.jasper");
				JasperPrint jp=JasperFillManager.fillReport(is, param,con);
				JasperViewer jw=new JasperViewer(jp);
				jw.setVisible(true);
			      
				}catch(Exception exc)
				{
				JOptionPane.showMessageDialog(null, exc);
				}
				
			}
			
		});
		btnPrint.setFont(new Font("Calibri", Font.BOLD, 13));
		btnPrint.setBounds(491, 140, 89, 23);
		panelstudentlist.add(btnPrint);
		
		
		JPanel pnldayres = new JPanel();
		pnldayres.setBackground(Color.PINK);
		masterpanel.add(pnldayres, "pnldayres");
		pnldayres.setLayout(null);
		
		JLabel lbldailyAttendanceResult = new JLabel("Daily Attendance Result");
		lbldailyAttendanceResult.setForeground(Color.BLUE);
		lbldailyAttendanceResult.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lbldailyAttendanceResult.setBounds(245, 11, 398, 35);
		pnldayres.add(lbldailyAttendanceResult);
		
		JLabel lblDateDres = new JLabel("Date");
		lblDateDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblDateDres.setBounds(203, 101, 32, 14);
		pnldayres.add(lblDateDres);
		
		JDateChooser dateChooserDres = new JDateChooser();
		dateChooserDres.setBounds(347, 98, 21, 20);
		pnldayres.add(dateChooserDres);
		
		txtdateDres = new JTextField();
		
		txtdateDres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				try 
				   {
					txtdateDres.setText("Click Here");
					DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
					txtdateDres.setText(df.format(dateChooserDres.getDate()));
				   }
					catch(NullPointerException npe)
					{
					JOptionPane.showMessageDialog(null, "First Choose Date");
					}	
			}
		});
		
		
		txtdateDres.setEditable(false);
		txtdateDres.setBounds(245, 98, 101, 20);
		pnldayres.add(txtdateDres);
		txtdateDres.setColumns(10);
		
		JLabel lblBranchDres = new JLabel("Branch");
		lblBranchDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranchDres.setBounds(415, 101, 46, 14);
		pnldayres.add(lblBranchDres);
		
		final JComboBox cmbbranchDres = new JComboBox();
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
					String sql="select DISTINCT branch from branchdetail ";
					st = con.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next())
					{
						cmbbranchDres.addItem(rs.getString(1));
						
					}
			}
			catch(Exception e)
			{
				JOptionPane.showConfirmDialog(null,e);
			}
	 	}
		cmbbranchDres.setBounds(471, 98, 88, 20);
		pnldayres.add(cmbbranchDres);
		
		JLabel lblSemDres = new JLabel("Sem");
		lblSemDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSemDres.setBounds(591, 101, 52, 14);
		pnldayres.add(lblSemDres);
		
		final JComboBox cmbsemDres = new JComboBox();
		cmbsemDres.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsemDres.setBounds(633, 98, 88, 20);
		pnldayres.add(cmbsemDres);
		
		JLabel lblRollNoDres = new JLabel("Roll No");
		lblRollNoDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRollNoDres.setBounds(203, 155, 46, 14);
		pnldayres.add(lblRollNoDres);
		
		txtrollnoDres = new JTextField();
		txtrollnoDres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
			
				ke.consume();	
			}
		});
		txtrollnoDres.setBounds(274, 152, 101, 20);
		pnldayres.add(txtrollnoDres);
		txtrollnoDres.setColumns(10);
		
		JLabel lblSubDres = new JLabel("Subject");
		lblSubDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSubDres.setBounds(415, 155, 52, 14);
		pnldayres.add(lblSubDres);
		

		final JComboBox cmbsubjectDres = new JComboBox();
		cmbsubjectDres.addItem("Choose Branch & Sem");
		cmbsubjectDres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			cmbsubjectDres.removeAllItems();	
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select DISTINCT sub from branchdetail where branch='"+cmbbranchDres.getSelectedItem().toString()+"' and sem='"+cmbsemDres.getSelectedItem().toString()+"'";

							st = con.createStatement();
							rs = st.executeQuery(sql);
							
							while(rs.next())
							{
								cmbsubjectDres.addItem(rs.getString("sub"));
								
							}
					}
					catch(Exception e1)
					{
						JOptionPane.showConfirmDialog(null,e1);
					}
				}
			
		});
		cmbsubjectDres.setBounds(487, 152, 196, 20);
		pnldayres.add(cmbsubjectDres);
		
	
		JSeparator separator = new JSeparator();
		separator.setBounds(187, 234, 562, 14);
		pnldayres.add(separator);
		
		JLabel lblNameDres = new JLabel("Name");
		lblNameDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNameDres.setBounds(38, 255, 46, 14);
		pnldayres.add(lblNameDres);
		
		txtnameDres = new JTextField();
		txtnameDres.setBounds(48, 280, 240, 20);
		pnldayres.add(txtnameDres);
		txtnameDres.setColumns(10);
		
		JLabel lblDatesDres = new JLabel("Status");
		lblDatesDres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblDatesDres.setBounds(38, 330, 46, 14);
		pnldayres.add(lblDatesDres);
		
		final JTextField txtstatusDres = new JTextField();
		txtstatusDres.setBounds(48, 355, 141, 23);
		pnldayres.add(txtstatusDres);
	
		final JLabel lbl_Dimage = new JLabel("");
		lbl_Dimage.setBounds(20, 73, 120, 132);
		pnldayres.add(lbl_Dimage);
		lbl_Dimage.setBorder(border);
		
		
		JButton btnShowResult = new JButton("Show By RollNo");
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				txtnameDres.setText("");
				txtstatusDres.setText("");
				lbl_Dimage.setIcon(null);
				
				String dateD,branchD,semD,rollnoD,subjectD;
				dateD=txtdateDres.getText();
				branchD=cmbbranchDres.getSelectedItem().toString();
				semD=cmbsemDres.getSelectedItem().toString();
				rollnoD=txtrollnoDres.getText();
				subjectD=cmbsubjectDres.getSelectedItem().toString();
				
				if(dateD.equals("")||branchD.equals(null)||semD.equals(null)||rollnoD.equals("")||subjectD.equals(null))
				{
					JOptionPane.showMessageDialog(null, "Plz Check All Fields TO View Result");
				}
				else
				{
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
				
					String qur="select * from attendance where date=? and branch=? and sem=? and rollno=? and subject=? ";
					ps=con.prepareStatement(qur);
					ps.setString(1, txtdateDres.getText());
					ps.setString(2, cmbbranchDres.getSelectedItem().toString());
					ps.setString(3, cmbsemDres.getSelectedItem().toString());
					ps.setString(4, txtrollnoDres.getText());
					ps.setString(5, cmbsubjectDres.getSelectedItem().toString());
					
					rs=ps.executeQuery();
					if(rs.next())
					{
						txtstatusDres.setText("PRESENT");
						txtnameDres.setText(rs.getString(6));	
					}	
					else
					{
						txtstatusDres.setText("ABSENT");
						txtnameDres.setText("Student Not Available");	
					}
					String qur1="select image from studentregistration where rollno=? ";
					ps=con.prepareStatement(qur1);
					ps.setString(1, txtrollnoDres.getText());
					rs=ps.executeQuery();
					if(rs.next())
					{
						 byte[] img=rs.getBytes("image");
				         ImageIcon image=new ImageIcon(img);
				         Image im=image.getImage();
				         Image myimage=im.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				    	 ImageIcon newimage=new ImageIcon(myimage);
				         lbl_Dimage.setIcon(newimage);  
					}
					
			}
				
				
				catch(Exception ex)
				{
					
					
				}
		}
				}
		});
		btnShowResult.setFont(new Font("Calibri", Font.BOLD, 13));
		btnShowResult.setBounds(188, 200, 130, 23);
		pnldayres.add(btnShowResult);
		
		JLabel lblRollNo_1 = new JLabel("Roll No");
		lblRollNo_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRollNo_1.setBounds(436, 272, 46, 14);
		pnldayres.add(lblRollNo_1);
		
		 listrollnoDres = new List();
		 listrollnoDres.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent arg0) 
		 	{
		 		try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					
					String qur1="select image from studentregistration where rollno=? ";
					ps=con.prepareStatement(qur1);
					ps.setString(1, listrollnoDres.getSelectedItem().toString());
					rs=ps.executeQuery();
					if(rs.next())
					{
						 byte[] img=rs.getBytes("image");
				         ImageIcon image=new ImageIcon(img);
				         Image im=image.getImage();
				         Image myimage=im.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				    	 ImageIcon newimage=new ImageIcon(myimage);
				        lbl_Dimage.setIcon(newimage);  
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "IMAGE NOT FOUND");
				}
		 	}
		 });
		listrollnoDres.setBounds(407, 299, 92, 259);
		pnldayres.add(listrollnoDres);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblName.setBounds(620, 272, 46, 14);
		pnldayres.add(lblName);
		
		final List listnameDres = new List();
		listnameDres.setBounds(560, 299, 161, 259);
		pnldayres.add(listnameDres);
		
		JLabel lblTotaldayres = new JLabel("Total =");
		lblTotaldayres.setBounds(726, 396, 46, 14);
		pnldayres.add(lblTotaldayres);
		
		final JLabel lblcounttotdres = new JLabel("0");
		lblcounttotdres.setBounds(780, 396, 46, 14);
		pnldayres.add(lblcounttotdres);
		
		JButton btnShowByDate = new JButton("Show By Date");
		btnShowByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				listrollnoDres.clear();
				listnameDres.clear();
				lbl_Dimage.setIcon(null);
				int count;
				String dateD2,branchD2,semD2,subjectD2;
				dateD2=txtdateDres.getText();
				branchD2=cmbbranchDres.getSelectedItem().toString();
				semD2=cmbsemDres.getSelectedItem().toString();
				
				subjectD2=cmbsubjectDres.getSelectedItem().toString();
				
				if(dateD2.equals("")||branchD2.equals(null)||semD2.equals(null)||subjectD2.equals(null))
				{
					JOptionPane.showMessageDialog(null, "Plz Check All Fields TO View Result");
				}
			
				try
				{
					
			           
			         
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					String qur="select * from attendance where date=? and branch=? and sem=? and subject=? ";
					ps=con.prepareStatement(qur);
					ps.setString(1, txtdateDres.getText());
					ps.setString(2, cmbbranchDres.getSelectedItem().toString());
					ps.setString(3, cmbsemDres.getSelectedItem().toString());
					ps.setString(4, cmbsubjectDres.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next())
					{
						listrollnoDres.addItem(rs.getString("rollno"));
						listnameDres.addItem(rs.getString("studentname"));
						count=listrollnoDres.countItems();
						lblcounttotdres.setText(String.valueOf(count));
						
					}	
					
			}
				
				catch(Exception ex)
				{
					
				}
			}
		
		});
		btnShowByDate.setFont(new Font("Calibri", Font.BOLD, 13));
		btnShowByDate.setBounds(554, 200, 130, 23);
		pnldayres.add(btnShowByDate);
		
		JButton btnGenerteReport = new JButton("GENERTE REPORT");
		btnGenerteReport.setFont(new Font("Calibri", Font.BOLD, 13));
		btnGenerteReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				/*File report=new File("src\\java_file\\DailyReport.jrxml");
				
				try {
					
					Desktop desktop = Desktop.getDesktop();
					desktop.open(report);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}*/
				try {
					String date,branch,sem,subject;
					date=txtdateDres.getText();
					branch=cmbbranchDres.getSelectedItem().toString();
					sem=cmbsemDres.getSelectedItem().toString();
					subject=cmbsubjectDres.getSelectedItem().toString();
				con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
				HashMap param =new HashMap();
				param.put("date", date);
				param.put("branch", branch);
				param.put("sem", sem);
				param.put("subject", subject);
				InputStream is=ClassLoader.getSystemResourceAsStream("DailyReport.jasper");
				JasperPrint jp=JasperFillManager.fillReport(is, param,con);
				
				JasperViewer jw=new JasperViewer(jp);
				jw.setVisible(true);
				
			}catch(Exception exc)
				{
				JOptionPane.showMessageDialog(null, exc);
				}
			}
		});
		btnGenerteReport.setBounds(369, 200, 147, 23);
		pnldayres.add(btnGenerteReport);
		
		
	
		JPanel pnlmonthres = new JPanel();                     //start month result panel
		pnlmonthres.setBackground(Color.PINK);
		masterpanel.add(pnlmonthres, "pnlmonthres");
		pnlmonthres.setLayout(null);
		
		JLabel lblMonthlyAttendanceResult = new JLabel("Monthly Attendance Result");
		lblMonthlyAttendanceResult.setForeground(Color.BLUE);
		lblMonthlyAttendanceResult.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblMonthlyAttendanceResult.setBounds(250, 11, 418, 34);
		pnlmonthres.add(lblMonthlyAttendanceResult);
		
		JLabel lblMonthMres = new JLabel("Month");
		lblMonthMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblMonthMres.setBounds(253, 73, 46, 14);
		pnlmonthres.add(lblMonthMres);
		
		final JComboBox cmbmonthMres = new JComboBox();
		cmbmonthMres.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbmonthMres.setBounds(309, 70, 86, 20);
		pnlmonthres.add(cmbmonthMres);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Calibri", Font.BOLD, 13));
		lblYear.setBounds(497, 73, 46, 14);
		pnlmonthres.add(lblYear);
		
		txtyearMres = new JTextField();
		txtyearMres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
			
				ke.consume();
			}
		});
		txtyearMres.setBounds(566, 70, 86, 20);
		pnlmonthres.add(txtyearMres);
		txtyearMres.setColumns(10);
		
		
		JLabel lblBranchMres = new JLabel("Branch");
		lblBranchMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranchMres.setBounds(253, 141, 46, 14);
		pnlmonthres.add(lblBranchMres);
		
		final JComboBox cmbbranchMres = new JComboBox();
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
					String sql="select DISTINCT branch from branchdetail ";
					st = con.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next())
					{
						cmbbranchMres.addItem(rs.getString(1));
						
					}
			}
			catch(Exception e)
			{
				JOptionPane.showConfirmDialog(null,e);
			}
	 	}
		cmbbranchMres.setBounds(309, 138, 86, 20);
		pnlmonthres.add(cmbbranchMres);
		
		JLabel lblSemMres = new JLabel("Sem");
		lblSemMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSemMres.setBounds(497, 141, 31, 14);
		pnlmonthres.add(lblSemMres);
		
		final JComboBox cmbsemMres = new JComboBox();
		cmbsemMres.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsemMres.setBounds(566, 138, 86, 20);
		pnlmonthres.add(cmbsemMres);
		
		JLabel lblRollNoMres = new JLabel("Roll No");
		lblRollNoMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRollNoMres.setBounds(253, 211, 46, 14);
		pnlmonthres.add(lblRollNoMres);
		
		txtrollnoMres = new JTextField();
		txtrollnoMres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
				{
			
				ke.consume();
			}
			}
		});
		txtrollnoMres.setBounds(309, 208, 86, 20);
		pnlmonthres.add(txtrollnoMres);
		txtrollnoMres.setColumns(10);
		
		JLabel lblSubjectMres = new JLabel("Subject");
		lblSubjectMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSubjectMres.setBounds(497, 208, 46, 14);
		pnlmonthres.add(lblSubjectMres);
		
		final JComboBox cmbsubMres = new JComboBox();
		cmbsubMres.addItem("Check Branch & Sem");
		cmbsubMres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			cmbsubMres.removeAllItems();	
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select DISTINCT sub from branchdetail where branch='"+cmbbranchMres.getSelectedItem().toString()+"' and sem='"+cmbsemMres.getSelectedItem().toString()+"'";

							st = con.createStatement();
							rs = st.executeQuery(sql);
							
							while(rs.next())
							{
								cmbsubMres.addItem(rs.getString("sub"));
								
							}
					}
					catch(Exception e2)
					{
						JOptionPane.showConfirmDialog(null,e2);
					}
					
				}
			
		});
		
		cmbsubMres.setBounds(566, 208, 197, 20);
		pnlmonthres.add(cmbsubMres);
		
		
		JSeparator separatorMres = new JSeparator();
		separatorMres.setBounds(201, 278, 562, 2);
		pnlmonthres.add(separatorMres);
		
		JLabel lblNameMres = new JLabel("Name");
		lblNameMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNameMres.setBounds(449, 291, 46, 14);
		pnlmonthres.add(lblNameMres);
		
		txtnameMres = new JTextField();
		txtnameMres.setBounds(346, 316, 245, 20);
		pnlmonthres.add(txtnameMres);
		txtnameMres.setColumns(10);
		
		JLabel lblTotalLectureMres = new JLabel("Total Lecture");
		lblTotalLectureMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotalLectureMres.setBounds(285, 347, 98, 14);
		pnlmonthres.add(lblTotalLectureMres);
		
		final List listtotlecMres = new List();
		listtotlecMres.setBounds(268, 367, 110, 224);
		pnlmonthres.add(listtotlecMres);
		
		 JLabel lblAttendLecture = new JLabel("Attend Lecture");
		lblAttendLecture.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAttendLecture.setBounds(544, 347, 98, 14);
		pnlmonthres.add(lblAttendLecture);
		
		final List listattlecMres = new List();
		listattlecMres.setBounds(532, 367, 110, 224);
		pnlmonthres.add(listattlecMres);
		
		JLabel lblTotalMres = new JLabel("Total =");
		lblTotalMres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotalMres.setBounds(139, 463, 46, 14);
		pnlmonthres.add(lblTotalMres);
		
		final JLabel lbltotlecMres = new JLabel("0");
		lbltotlecMres.setBounds(195, 463, 46, 14);
		pnlmonthres.add(lbltotlecMres);
		
		JLabel lblTotal_2 = new JLabel("Total =");
		lblTotal_2.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotal_2.setBounds(666, 463, 46, 14);
		pnlmonthres.add(lblTotal_2);
		
		final JLabel lblattlecMres = new JLabel("0");
		lblattlecMres.setBounds(717, 463, 46, 14);
		pnlmonthres.add(lblattlecMres);
		
		final JLabel lbl_Mimage = new JLabel("");
		lbl_Mimage.setBounds(39, 73, 120, 132);
		pnlmonthres.add(lbl_Mimage);
		lbl_Mimage.setBorder(border);
		
		JButton btnShowResultMres = new JButton("Show Result");
		btnShowResultMres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				listattlecMres.clear();
				listtotlecMres.clear();
				txtnameSres.setText("");
				lbltotlecMres.setText("");
				lblattlecMres.setText("");
				lbl_Mimage.setIcon(null);
				
				String monthM,yearM,branchM,semM,rollnoM,subjectM; 
				monthM=cmbmonthMres.getSelectedItem().toString();
				yearM=txtyearMres.getText();
				branchM=cmbbranchMres.getSelectedItem().toString();
				semM=cmbsemMres.getSelectedItem().toString();
				rollnoM=txtrollnoMres.getText();
				subjectM=cmbsubMres.getSelectedItem().toString();
				
				if(monthM.equals(null)||yearM.equals("")||branchM.equals(null)||semM.equals(null)||rollnoM.equals("")||subjectM.equals(null))
					JOptionPane.showMessageDialog(null, "Plz Check All Fields Are Correct To View ResultS");
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					
					String imgqur="select image from studentregistration where rollno=? ";
					ps=con.prepareStatement(imgqur);
					ps.setString(1, txtrollnoMres.getText());
					rs=ps.executeQuery();
					if(rs.next())
					{
						 byte[] img=rs.getBytes("image");
				         ImageIcon image=new ImageIcon(img);
				         Image im=image.getImage();
				         Image myimage=im.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				    	 ImageIcon newimage=new ImageIcon(myimage);
				         lbl_Mimage.setIcon(newimage);  
					}
					
					
					String qur="select DISTINCT date,studentname from attendance where month=? and year=? and branch=? and sem=? and rollno=? and subject=? ";
					ps=con.prepareStatement(qur);
					ps.setString(1, cmbmonthMres.getSelectedItem().toString());
					ps.setString(2,txtyearMres.getText());
					ps.setString(3, cmbbranchMres.getSelectedItem().toString());
					ps.setString(4, cmbsemMres.getSelectedItem().toString());
					ps.setString(5, txtrollnoMres.getText());
				    ps.setString(6, cmbsubMres.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next())
					{
						txtnameMres.setText(rs.getString("studentname"));
						listattlecMres.addItem(rs.getString(1));
					String itm=String.valueOf(listattlecMres.countItems()); 
						lblattlecMres.setText(itm);
					}	
				String qur1="select DISTINCT date from attendance  where month=? and year=? and branch=? and sem=? and subject=? ";

					ps=con.prepareStatement(qur1);
					ps.setString(1, cmbmonthMres.getSelectedItem().toString());
					
					ps.setString(2, txtyearMres.getText());
					ps.setString(3, cmbbranchMres.getSelectedItem().toString());
					ps.setString(4, cmbsemMres.getSelectedItem().toString());
					ps.setString(5, cmbsubMres.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next())
					{
						listtotlecMres.addItem(rs.getString(1));
						String itm2=String.valueOf(listtotlecMres.countItems());
						lbltotlecMres.setText(itm2);
					}
				}
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "PLZ FILL ALL DETAIL");				}
			}
			
			
		});
		btnShowResultMres.setFont(new Font("Calibri", Font.BOLD, 13));
		btnShowResultMres.setBounds(309, 244, 143, 23);
		pnlmonthres.add(btnShowResultMres);
		
		JButton btnNewButton = new JButton("GENERATE REPORT");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
           /* File report=new File("src\\java_file\\monthlyReport.jrxml");
				
				try {
					
					Desktop desktop = Desktop.getDesktop();
					desktop.open(report);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}*/
				try {
					String month,year,branch,sem,rollno,subject;
					month=cmbmonthMres.getSelectedItem().toString();
					year=txtyearMres.getText();
					branch=cmbbranchMres.getSelectedItem().toString();
					sem=cmbsemMres.getSelectedItem().toString();
					rollno=txtrollnoMres.getText();
					subject=cmbsubMres.getSelectedItem().toString();
				con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
				HashMap param =new HashMap();
				param.put("month", month);
				param.put("branch", branch);
				param.put("sem", sem);
				param.put("year", year);
				param.put("rollno", rollno);
				param.put("subject", subject);
				InputStream is=ClassLoader.getSystemResourceAsStream("monthlyReport.jasper");
				JasperPrint jp=JasperFillManager.fillReport(is, param,con);
				JasperViewer jw=new JasperViewer(jp);
				jw.setVisible(true);
				
			}catch(Exception exc)
				{
				JOptionPane.showMessageDialog(null, exc);
				}
			}
			
		});
		btnNewButton.setBounds(497, 244, 135, 23);
		pnlmonthres.add(btnNewButton);
		
	
		JPanel pnlsemres = new JPanel();
		pnlsemres.setBackground(Color.PINK);
		masterpanel.add(pnlsemres, "pnlsemres");
		pnlsemres.setLayout(null);
		
		JLabel lblSemisterwiseAttendanceResult = new JLabel("Semisterwise Attendance Result");
		lblSemisterwiseAttendanceResult.setForeground(Color.BLUE);
		lblSemisterwiseAttendanceResult.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblSemisterwiseAttendanceResult.setBounds(190, 11, 480, 28);
		pnlsemres.add(lblSemisterwiseAttendanceResult);
		
		JLabel lblyearSres = new JLabel("Year");
		lblyearSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblyearSres.setBounds(376, 50, 46, 14);
		pnlsemres.add(lblyearSres);
		
		txtyearSres = new JTextField();
		txtyearSres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
			
				ke.consume();
			}
		});
		txtyearSres.setBounds(432, 47, 86, 20);
		pnlsemres.add(txtyearSres);
		txtyearSres.setColumns(10);
		
		
		JLabel lblSmSres = new JLabel("Start Month");
		lblSmSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSmSres.setBounds(219, 92, 75, 14);
		pnlsemres.add(lblSmSres);
		
		final JComboBox cmbSmonthSres = new JComboBox();
		cmbSmonthSres.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbSmonthSres.setBounds(322, 89, 95, 20);
		pnlsemres.add(cmbSmonthSres);
		
		JLabel lblEmonthSres = new JLabel("End Month");
		lblEmonthSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblEmonthSres.setBounds(458, 92, 68, 14);
		pnlsemres.add(lblEmonthSres);
		
		final JComboBox cmbEmonthSres = new JComboBox();
		cmbEmonthSres.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmbEmonthSres.setBounds(546, 89, 95, 20);
		pnlsemres.add(cmbEmonthSres);
		
		JLabel lblBranch_3 = new JLabel("Branch");
		lblBranch_3.setFont(new Font("Calibri", Font.BOLD, 13));
		lblBranch_3.setBounds(219, 138, 46, 14);
		pnlsemres.add(lblBranch_3);
		
		final JComboBox cmbbranchSres = new JComboBox();
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
					String sql="select DISTINCT branch from branchdetail ";
					st = con.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next())
					{
						cmbbranchSres.addItem(rs.getString(1));
						
					}
			}
			catch(Exception e)
			{
				JOptionPane.showConfirmDialog(null,e);
			}
	 	}
		cmbbranchSres.setBounds(322, 135, 95, 20);
		pnlsemres.add(cmbbranchSres);
		
		JLabel lblSemSres = new JLabel("Sem");
		lblSemSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSemSres.setBounds(458, 138, 46, 14);
		pnlsemres.add(lblSemSres);
		
		final JComboBox cmbsemSres = new JComboBox();
		cmbsemSres.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		cmbsemSres.setBounds(546, 135, 95, 20);
		pnlsemres.add(cmbsemSres);
		
		JLabel lblRollNoSres = new JLabel("Roll No");
		lblRollNoSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRollNoSres.setBounds(219, 188, 46, 14);
		pnlsemres.add(lblRollNoSres);
		
		txtrollnoSres = new JTextField();
		txtrollnoSres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) 
			{
				char c=ke.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
				
				ke.consume();
				
			}
		});
		txtrollnoSres.setBounds(322, 185, 95, 20);
		pnlsemres.add(txtrollnoSres);
		txtrollnoSres.setColumns(10);
		
		JLabel lblSubjectSres = new JLabel("Subject");
		lblSubjectSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSubjectSres.setBounds(458, 188, 46, 14);
		pnlsemres.add(lblSubjectSres);
		
		final JComboBox cmbsubSres = new JComboBox();
		cmbsubSres.addItem("Choose Branch & Sem");
		cmbsubSres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			cmbsubSres.removeAllItems();	
			
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select DISTINCT sub from branchdetail where branch='"+cmbbranchSres.getSelectedItem().toString()+"' and sem='"+cmbsemSres.getSelectedItem().toString()+"'";

							st = con.createStatement();
							rs = st.executeQuery(sql);
							
							while(rs.next())
							{
								cmbsubSres.addItem(rs.getString(1));
								
							}
					}
					catch(Exception e3)
					{
						JOptionPane.showConfirmDialog(null,e3);
					}
				}
			
		});
		cmbsubSres.setBounds(546, 185, 157, 20);
		pnlsemres.add(cmbsubSres);
		
		JSeparator separatorSres = new JSeparator();
		separatorSres.setBounds(117, 263, 586, 2);
		pnlsemres.add(separatorSres);
		
		JLabel lblNameSres = new JLabel("Name");
		lblNameSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNameSres.setBounds(258, 276, 46, 14);
		pnlsemres.add(lblNameSres);
		
		txtnameSres = new JTextField();
		txtnameSres.setText("");
		txtnameSres.setBounds(333, 273, 230, 20);
		pnlsemres.add(txtnameSres);
		txtnameSres.setColumns(10);
		
		JLabel lblTotalLectureSres = new JLabel("Total Lecture");
		lblTotalLectureSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotalLectureSres.setBounds(223, 304, 95, 14);
		pnlsemres.add(lblTotalLectureSres);
		
		final List listtotlecSres = new List();
		listtotlecSres.setBounds(208, 324, 110, 208);
		pnlsemres.add(listtotlecSres);
		
		JLabel lblAttendLecture_1 = new JLabel("Attend Lecture");
		lblAttendLecture_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblAttendLecture_1.setBounds(579, 304, 97, 14);
		pnlsemres.add(lblAttendLecture_1);
		
		final List listattlecSres = new List();
		listattlecSres.setBounds(566, 324, 110, 211);
		pnlsemres.add(listattlecSres);
		
		JLabel lblTotalSres = new JLabel("Total =");
		lblTotalSres.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotalSres.setBounds(190, 550, 46, 14);
		pnlsemres.add(lblTotalSres);
		
		final JLabel lbltotlecSres = new JLabel("0");
		lbltotlecSres.setBounds(261, 550, 57, 14);
		pnlsemres.add(lbltotlecSres);
		
		JLabel lblTotal2 = new JLabel("Total =");
		lblTotal2.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTotal2.setBounds(574, 550, 46, 14);
		pnlsemres.add(lblTotal2);
		
		final JLabel lblattlecSres = new JLabel("0");
		lblattlecSres.setBounds(630, 550, 46, 14);
		pnlsemres.add(lblattlecSres);
		
		final JLabel lblStatusSres = new JLabel("Status :");
		lblStatusSres.setFont(new Font("Calibri", Font.BOLD, 15));
		lblStatusSres.setBounds(390, 550, 60, 14);
		pnlsemres.add(lblStatusSres);
		
		final JLabel lblstsSres = new JLabel("0");
		lblstsSres.setBounds(445, 550, 38, 14);
		pnlsemres.add(lblstsSres);
		
		final JLabel lbl_Simage = new JLabel("");
		lbl_Simage.setBounds(27, 92, 120, 132);
		pnlsemres.add(lbl_Simage);
		lbl_Simage.setBorder(border);
		
		JButton btnShowResultSres = new JButton("Show Result");
		btnShowResultSres.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
			{
				listattlecSres.clear();
				listtotlecSres.clear();
				txtnameSres.setText("");
				lbltotlecSres.setText("");
				lblattlecSres.setText("");
				lbl_Simage.setIcon(null);
				
				String year,smonth,emonth,branch,sem,rollno,subject;
				year=txtyearSres.getText();
				smonth=cmbSmonthSres.getSelectedItem().toString();
				emonth=cmbEmonthSres.getSelectedItem().toString();
				branch=cmbbranchSres.getSelectedItem().toString();
				sem=cmbsemSres.getSelectedItem().toString();
				rollno=txtrollnoSres.getText();
				subject=cmbsubSres.getSelectedItem().toString();
				
				if(year.equals("")||smonth.equals(null)||emonth.equals(null)||branch.equals(null)||sem.equals(null)||rollno.equals("")||subject.equals(null))
				
					JOptionPane.showMessageDialog(null, "Plz Check All Fields Are Correct To View Result");
				try
				{
					Class.forName("com.mysql.jdbc.Driver");  
				    con=(Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/samsdatabase","root","admin");  
					st=con.createStatement();
					
					String imgqur="select image from studentregistration where rollno=? ";
					ps=con.prepareStatement(imgqur);
					ps.setString(1, txtrollnoSres.getText());
					rs=ps.executeQuery();
					if(rs.next())
					{
						 byte[] img=rs.getBytes("image");
				         ImageIcon image=new ImageIcon(img);
				         Image im=image.getImage();
				         Image myimage=im.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
				    	 ImageIcon newimage=new ImageIcon(myimage);
				         lbl_Simage.setIcon(newimage);  
					}
					
					String qur="select DISTINCT * from attendance where month between ? and ? and year=? and branch=? and sem=? and rollno=? and subject=? ";
					ps=con.prepareStatement(qur);
					ps.setString(1, cmbSmonthSres.getSelectedItem().toString());
					ps.setString(2, cmbEmonthSres.getSelectedItem().toString());
					ps.setString(3,txtyearSres.getText());
					ps.setString(4, cmbbranchSres.getSelectedItem().toString());
					ps.setString(5, cmbsemSres.getSelectedItem().toString());
					ps.setString(6, txtrollnoSres.getText());
				    ps.setString(7, cmbsubSres.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next())
					{
						txtnameSres.setText(rs.getString(6));
						listattlecSres.addItem(rs.getString(1));
					 itm=(listattlecSres.countItems());
						lblattlecSres.setText(String.valueOf(itm));
						
					}
					String qur1="select DISTINCT date from attendance  where month between ? and ? and year=? and branch=? and sem=? and subject=? ";
					ps=con.prepareStatement(qur1);
					ps.setString(1, cmbSmonthSres.getSelectedItem().toString());
					ps.setString(2, cmbEmonthSres.getSelectedItem().toString());
				    ps.setString(3, txtyearSres.getText());
					ps.setString(4, cmbbranchSres.getSelectedItem().toString());
					ps.setString(5, cmbsemSres.getSelectedItem().toString());
					ps.setString(6, cmbsubSres.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next())
					{
						listtotlecSres.addItem(rs.getString(1));
						 itm2=(listtotlecSres.countItems());
						lbltotlecSres.setText(String.valueOf(itm2));
						
						float status;
						status=itm*100/itm2;
						lblstsSres.setText(String.valueOf(status));
					}
				}
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex);
				}
			}
			
		});
		
		JLabel lblperSres = new JLabel("%");
		lblperSres.setBounds(493, 550, 11, 14);
		pnlsemres.add(lblperSres);
		
		
		btnShowResultSres.setFont(new Font("Calibri", Font.BOLD, 13));
		btnShowResultSres.setBounds(322, 229, 151, 23);
		pnlsemres.add(btnShowResultSres);
		
		JButton btnNewButton_1 = new JButton("GENERATE REPORT");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

		        try
		        {
		          String year = txtyearSres.getText();
		          String smonth = cmbSmonthSres.getSelectedItem().toString();
		          String emonth = cmbEmonthSres.getSelectedItem().toString();
		          String branch = cmbbranchSres.getSelectedItem().toString();
		          String sem = cmbsemSres.getSelectedItem().toString();
		          String rollno = txtrollnoSres.getText();
		          String subject = cmbsubSres.getSelectedItem().toString();
		          con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase", "root", "admin");
		          HashMap param = new HashMap();
		          param.put("year", year);
		          param.put("Start month", smonth);
		          param.put("End month", emonth);
		          param.put("branch", branch);
		          param.put("sem", sem);
		          param.put("rollno", rollno);
		          param.put("subject", subject);
		          InputStream is = ClassLoader.getSystemResourceAsStream("SemwiseReport.jasper");
		          JasperPrint jp = JasperFillManager.fillReport(is, param, con);
		          JasperViewer jw = new JasperViewer(jp);
		          jw.setVisible(true);
		        }
		        catch (Exception exc)
		        {
		          JOptionPane.showMessageDialog(null, exc);
		        }
		      
			}
		});
		btnNewButton_1.setBounds(506, 229, 135, 23);
		pnlsemres.add(btnNewButton_1);
		
		
		
			
	}
}
