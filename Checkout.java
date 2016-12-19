import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Checkout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 343, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Checkout");
		
		JLabel lblNewLabel = new JLabel("Click Cancel to edit or Proceed to continue");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 38, 259, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseCheckYour = new JLabel("Please check your card details to verify");
		lblPleaseCheckYour.setBounds(21, 10, 286, 17);
		lblPleaseCheckYour.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblPleaseCheckYour);
		
		JLabel lblCardNumber = new JLabel("Card number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCardNumber.setBounds(10, 80, 84, 14);
		contentPane.add(lblCardNumber);
		
		JLabel lblNameOnCard = new JLabel("Name on Card:");
		lblNameOnCard.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNameOnCard.setBounds(10, 117, 84, 14);
		contentPane.add(lblNameOnCard);
		
		JLabel lblCvc = new JLabel("CVC Number:");
		lblCvc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCvc.setBounds(10, 149, 84, 14);
		contentPane.add(lblCvc);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(131, 78, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(131, 114, 160, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(131, 146, 84, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 201, 84, 33);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(230, 201, 84, 33);
		contentPane.add(btnCancel);
	}

}
