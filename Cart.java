import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Cart extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
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
	public Cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("CART");
		
		JLabel lblProductJustAdded = new JLabel("Product just added");
		lblProductJustAdded.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblProductJustAdded.setBounds(106, 0, 178, 25);
		contentPane.add(lblProductJustAdded);
		
		JButton btnClickToSee = new JButton("Click to see complete cart");
		btnClickToSee.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClickToSee.setBounds(104, 135, 180, 23);
		contentPane.add(btnClickToSee);
		
		JLabel lblTotalAmountTo = new JLabel("Total amount to pay ->");
		lblTotalAmountTo.setFont(new Font("DokChampa", Font.BOLD, 14));
		lblTotalAmountTo.setBounds(33, 193, 185, 14);
		contentPane.add(lblTotalAmountTo);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(214, 191, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCheckOtherProducts = new JButton("Check other products");
		btnCheckOtherProducts.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheckOtherProducts.setBounds(10, 228, 168, 23);
		contentPane.add(btnCheckOtherProducts);
		
		JButton btnProceedToPayment = new JButton("Proceed to payment");
		btnProceedToPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProceedToPayment.setBounds(201, 228, 163, 23);
		contentPane.add(btnProceedToPayment);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Desktop\\CampusTunes\\samsung-galaxy-j1-2016.jpg"));
		label.setBounds(43, 47, 64, 66);
		contentPane.add(label);
		
		JLabel lblSamsungGalaxyJ = new JLabel("Samsung Galaxy J1");
		lblSamsungGalaxyJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSamsungGalaxyJ.setBounds(117, 47, 130, 14);
		contentPane.add(lblSamsungGalaxyJ);
		
		JLabel lblThisIsA = new JLabel("This is a brand new Android phone");
		lblThisIsA.setBounds(117, 75, 178, 14);
		contentPane.add(lblThisIsA);
		
		JLabel lblPricetl = new JLabel("Price: 1100TL");
		lblPricetl.setBounds(122, 100, 71, 14);
		contentPane.add(lblPricetl);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(201, 100, 46, 14);
		contentPane.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 99, 28, 14);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
