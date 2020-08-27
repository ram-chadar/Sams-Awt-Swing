package java_file;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTable;

public class login  {

	JFrame frmLoginForm;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps;
	static public String type ="";
	static public String user="";
	static String ques="";
	static String ans="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					//System.exit(0);
					login window = new login();
					window.frmLoginForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmLoginForm = new JFrame();
		frmLoginForm.getContentPane().setBackground(Color.PINK);
		frmLoginForm.setResizable(false);
		frmLoginForm.setTitle("LOGIN FORM");
		frmLoginForm.setBounds(100, 100, 625, 413);
		frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForm.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME  :");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUsername.setBounds(184, 59, 85, 14);
		frmLoginForm.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD  :");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPassword.setBounds(184, 104, 85, 14);
		frmLoginForm.getContentPane().add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(307, 56, 194, 20);
		frmLoginForm.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(307, 101, 194, 20);
		frmLoginForm.getContentPane().add(txtpassword);
		txtpassword.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(new Color(0, 0, 255));
		lblLogin.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		lblLogin.setBounds(332, 11, 131, 20);
		frmLoginForm.getContentPane().add(lblLogin);
		
		
		JLabel lblUserType = new JLabel("USER TYPE :");
		lblUserType.setFont(new Font("Calibri", Font.BOLD, 15));
		lblUserType.setBounds(184, 146, 85, 14);
		frmLoginForm.getContentPane().add(lblUserType);
		
		final JComboBox cmbusertypelogin = new JComboBox();
		cmbusertypelogin.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Admin"}));
		//cmbusertypelogin.addItem("Teacher");
		//cmbusertypelogin.addItem("Admin");
		cmbusertypelogin.setBounds(307, 143, 194, 20);
		frmLoginForm.getContentPane().add(cmbusertypelogin);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
				st = (Statement) con.createStatement();
				//String sql="select username,password,usertype from logintable where username='" + txtusername.getText().toString() +"' AND password='"
				//		+ txtpassword.getText().toString() +"' AND usertype='"+cmbusertypelogin.getSelectedItem().toString() +"'";
					//rs = st.executeQuery(sql);
				String qur="select * from logintable where username=? and password=? and usertype=?";
				 ps=(PreparedStatement) con.prepareStatement(qur);
				 ps.setString(1, txtusername.getText());
				 ps.setString(2,txtpassword.getText());
				 ps.setString(3, cmbusertypelogin.getSelectedItem().toString());
				rs=ps.executeQuery();
					user=txtusername.getText();
					type=(String) cmbusertypelogin.getSelectedItem();
					if(rs.next())
					{
						
					samsApp window = new samsApp();
					window.frmStudentAttendanceSystem.setVisible(true);
					
					frmLoginForm.dispose();
							//break;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Plz chcek Username And Password");
					}
				} catch (Exception e)
				{
				 JOptionPane.showMessageDialog(null, e);
				} 
					
			
			}
		});
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSubmit.setBounds(180, 181, 89, 23);
		frmLoginForm.getContentPane().add(btnSubmit);
		
		JButton button = new JButton("FORGOT");
		button.setFont(new Font("Calibri", Font.BOLD, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				user=txtusername.getText();
				//type=cmbusertypelogin.getSelectedItem().toString();
                try
                {
                	Class.forName("com.mysql.jdbc.Driver");
				con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
				st = (Statement) con.createStatement();
                
                 String qur="select * from logintable where username=?";
   				 ps=(PreparedStatement) con.prepareStatement(qur);
   				 ps.setString(1, txtusername.getText());
   				
   				rs=ps.executeQuery();
   					
   					if(rs.next())
   					{
   						forgot fg=new forgot();
   						fg.frmforgot.setVisible(true);
   						frmLoginForm.dispose();
   					}
   					else 
   					{
   						JOptionPane.showMessageDialog(null, "User Does Not Exits ");
   					}
   					
                 }
                catch(Exception e)
                {
                	JOptionPane.showMessageDialog(null, e);
                }

			}
		});
		button.setBounds(414, 181, 89, 23);
		frmLoginForm.getContentPane().add(button);
		
		
		
		
	}
}
