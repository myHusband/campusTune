import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Checkout extends JFrame {

	private JPanel contentPane;
	private JTextField cardNumberTextField;
	private JTextField cardNumber1TextField;
	private JTextField cvcTextField;
	private JTextField cardNumber3TextField;
	private JTextField cardNumber4TextField;
	private JTextField cardNumber2TextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkout frame = new Checkout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton checkoutButton = new JButton("Checkout");
		checkoutButton.setForeground(new Color(138, 43, 226));
		checkoutButton.setBackground(new Color(230, 230, 250));
		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					long cnumber = concatCardTxt();// = Long.parseLong(cardNumberTextField.getText());
					String cname = cardNumberTextField.getText();
					int ccvc = Integer.parseInt(cvcTextField.getText());
					Auxillary aux = new Auxillary();
					aux.validateDetails(cnumber,cname,ccvc);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"ERROR: Check your entries.");
				}
				//validate();
			}
		});
		checkoutButton.setBounds(21, 168, 89, 37);
		contentPane.add(checkoutButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(new Color(138, 43, 226));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cart cart = new Cart();
				cart.show();
			}
		});
		cancelButton.setBounds(315, 168, 89, 37);
		contentPane.add(cancelButton);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your credit card details below and click Checkout");
		lblPleaseEnterYour.setForeground(new Color(139, 0, 139));
		lblPleaseEnterYour.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblPleaseEnterYour.setBounds(21, 11, 344, 14);
		contentPane.add(lblPleaseEnterYour);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setText("Name on Card");
		cardNumberTextField.setBounds(21, 36, 383, 33);
		contentPane.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, cardNumberTextField.getText());
            }});
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 124, 383, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCardNumber = new JLabel("Card number");
		lblCardNumber.setBounds(0, 8, 86, 14);
		panel.add(lblCardNumber);
		
		cardNumber1TextField = new JTextField();
		cardNumber1TextField.setBounds(96, 5, 38, 20);
		panel.add(cardNumber1TextField);
		cardNumber1TextField.setText("####");
		cardNumber1TextField.setColumns(10);
		cardNumber1TextField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (cardNumber1TextField.getText().length() >= 4 )
		            e.consume(); 
		    }  
		});
		
		cardNumber2TextField = new JTextField();
		cardNumber2TextField.setBounds(144, 5, 38, 20);
		panel.add(cardNumber2TextField);
		cardNumber2TextField.setText("####");
		cardNumber2TextField.setColumns(10);
		cardNumber2TextField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (cardNumber2TextField.getText().length() >= 4 ) 
		            e.consume(); 
		    }  
		});
		
		cardNumber3TextField = new JTextField();
		cardNumber3TextField.setBounds(240, 5, 38, 20);
		panel.add(cardNumber3TextField);
		cardNumber3TextField.setText("####");
		cardNumber3TextField.setColumns(10);
		cardNumber3TextField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (cardNumber3TextField.getText().length() >= 4 ) 
		            e.consume(); 
		    }  
		});
		
		cardNumber4TextField = new JTextField();
		cardNumber4TextField.setBounds(192, 5, 38, 20);
		panel.add(cardNumber4TextField);
		cardNumber4TextField.setText("####");
		cardNumber4TextField.setColumns(10);
		cardNumber4TextField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (cardNumber4TextField.getText().length() >= 4 ) 
		            e.consume(); 
		    }  
		});
		
		cvcTextField = new JTextField();
		cvcTextField.setBounds(288, 5, 86, 20);
		panel.add(cvcTextField);
		cvcTextField.setText("CVC");
		cvcTextField.setColumns(10);
		cvcTextField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (cvcTextField.getText().length() >= 3 ) 
		            e.consume(); 
		    }  
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 80, 383, 33);
		contentPane.add(panel_1);
		
		JLabel lblCreditCardsAccepted = new JLabel("Credit Cards Accepted");
		lblCreditCardsAccepted.setBounds(0, 5, 144, 22);
		
		JLabel cardLabel = new JLabel("");
		cardLabel.setBounds(169, 5, 108, 22);
		cardLabel.setIcon(new ImageIcon("D:\\Desktop\\CampusTunes\\acceptance_marks_offline_trays_clear_UK_198x50mm.jpg"));
		panel_1.setLayout(null);
		panel_1.add(lblCreditCardsAccepted);
		panel_1.add(cardLabel);
		setTitle("Payment Info");
	}
	
	long concatCardTxt(){
		String cardNumber = cardNumber1TextField.getText()+""+cardNumber2TextField.getText()+""+cardNumber3TextField+""+cardNumber4TextField;
		return Long.parseLong(cardNumber);
	}
		
}
