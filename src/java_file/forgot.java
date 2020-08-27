package java_file;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;

public class forgot  {

	JFrame frmforgot;
	private JTextField txtforgot;
	private JTextField txtforgotpass;
	private JTextField txtforgotconpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgot window = new forgot();
					window.frmforgot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public forgot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmforgot = new JFrame();
		frmforgot.setFont(null);
		frmforgot.setTitle("Reset Password");
		frmforgot.getContentPane().setBackground(Color.PINK);
		frmforgot.setBounds(100, 100, 597, 381);
		frmforgot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmforgot.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Security Ques :");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 24, 98, 14);
		frmforgot.getContentPane().add(lblNewLabel);
		
		final JComboBox cmbforgot = new JComboBox();
		cmbforgot.setToolTipText("CHOOSE YOUR SECURITY QUESTION");
		cmbforgot.setFont(new Font("Calibri", Font.BOLD, 12));
		cmbforgot.setModel(new DefaultComboBoxModel(new String[] {"", "WHAT IS YOUR BIRTH YEAR ?", "WHAT IS YOUR NICKNAME ?", "LAST 4 DIGITS OF YOUR MOBILE NO ?", "WHAT IS YOUR FAVORITE COLOR ?", "WHAT IS THE NAME OF YOUR FAVOTIE PET ?"}));
		cmbforgot.setBounds(156, 22, 415, 20);
		frmforgot.getContentPane().add(cmbforgot);
		
		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setFont(new Font("Calibri", Font.BOLD, 14));
		lblAnswer.setBounds(32, 70, 58, 14);
		frmforgot.getContentPane().add(lblAnswer);
		
		txtforgot = new JTextField();
		txtforgot.setBounds(156, 67, 230, 20);
		frmforgot.getContentPane().add(txtforgot);
		txtforgot.setColumns(10);
		

		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewPassword.setBounds(32, 132, 98, 14);
		frmforgot.getContentPane().add(lblNewPassword);
		
		txtforgotpass = new JTextField();
		txtforgotpass.setBounds(156, 129, 230, 20);
		frmforgot.getContentPane().add(txtforgotpass);
		txtforgotpass.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		lblConfirmPassword.setBounds(32, 185, 114, 14);
		frmforgot.getContentPane().add(lblConfirmPassword);
		
		txtforgotconpass = new JTextField();
		txtforgotconpass.setColumns(10);
		txtforgotconpass.setBounds(156, 182, 230, 20);
		frmforgot.getContentPane().add(txtforgotconpass);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					login lg=new login();
					String un=lg.user;
					
					
					Class.forName("com.mysql.jdbc.Driver");
			Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/samsdatabase","root","admin");
						String sql="select * from logintable where username='"+un+"'  AND question='" +cmbforgot.getSelectedItem().toString() +"' AND answer='"+txtforgot.getText().toString()+"'";	
					Statement 	st = (Statement) con.createStatement();
					ResultSet	rs = st.executeQuery(sql);
					
					if(rs.next())
					{
						
						String newpass=txtforgotpass.getText().toString();
						String conpass=txtforgotconpass.getText().toString();
							if(newpass.equals(conpass))
						{
						PreparedStatement stmt=(PreparedStatement) con.prepareStatement(("update logintable set password=? where username=?"));
						stmt.setString(1,conpass);
						stmt.setString(2,un);
						//stmt.setString(3,un);
						int i=stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Plz login next time"+"\n" +"Username="+un+"\n"+ "Pssword="+conpass);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "New & Confirm Password Must Be Same");
						}
					
							lg.frmLoginForm.setVisible(true);
							frmforgot.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Q & A ");
					}
					  
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}

			
		});
		btnSubmit.setFont(new Font("Calibri", Font.BOLD, 12));
		btnSubmit.setBounds(215, 213, 89, 23);
		frmforgot.getContentPane().add(btnSubmit);
		
	}
}
