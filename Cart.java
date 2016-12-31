import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;

public class Cart extends JFrame {

	private JPanel contentPane;
	private JTextField totalTextField;
	private JTextField qtyTextField;
	double total_price=0,product_price=1000;
	int qty,product_id; double price;
	String pIconPath = "images\\1.jpg",
			pName,pDescription;
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
		setBounds(100, 100, 417, 311);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("CART");
		
		JLabel lblProductJustAdded = new JLabel("Product just added");
		lblProductJustAdded.setForeground(new Color(102, 0, 255));
		lblProductJustAdded.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblProductJustAdded.setBounds(106, 11, 178, 25);
		contentPane.add(lblProductJustAdded);
		
		JButton btnClickToSee = new JButton("View Cart");
		btnClickToSee.setForeground(new Color(153, 0, 255));
		btnClickToSee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CompleteCart basket = new CompleteCart();
				basket.show();
			}
		});
		btnClickToSee.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClickToSee.setBounds(23, 137, 130, 45);
		contentPane.add(btnClickToSee);
		
		JLabel totalAmountLabel = new JLabel("Total amount to pay");
		totalAmountLabel.setForeground(Color.BLACK);
		totalAmountLabel.setFont(new Font("DokChampa", Font.PLAIN, 15));
		totalAmountLabel.setBounds(62, 203, 185, 14);
		contentPane.add(totalAmountLabel);
		
		totalTextField = new JTextField();
		totalTextField.setForeground(SystemColor.textHighlight);
		totalTextField.setEnabled(false);
		totalTextField.setBounds(237, 201, 104, 20);
		contentPane.add(totalTextField);
		totalTextField.setColumns(10);
		
		JButton btnCheckOtherProducts = new JButton("Check other products");
		btnCheckOtherProducts.setForeground(new Color(102, 0, 255));
		btnCheckOtherProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Navigate back to products screen
				dispose();
				Product products = new Product();
				products.show();
			}
		});
		btnCheckOtherProducts.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCheckOtherProducts.setBounds(23, 239, 168, 23);
		contentPane.add(btnCheckOtherProducts);
		
		JButton btnProceedToPayment = new JButton("Proceed to payment");
		btnProceedToPayment.setForeground(new Color(102, 0, 255));
		btnProceedToPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Checkout payment = new Checkout();
				payment.show();
			}
		});
		btnProceedToPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProceedToPayment.setBounds(216, 239, 163, 23);
		contentPane.add(btnProceedToPayment);
		
		JLabel piconLabel = new JLabel("");
		piconLabel.setIcon(new ImageIcon(pIconPath));
		piconLabel.setBounds(43, 47, 64, 66);
		contentPane.add(piconLabel);
		
		JLabel pnameLabel = new JLabel("Samsung Galaxy J1");
		pnameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnameLabel.setBounds(117, 47, 130, 14);
		contentPane.add(pnameLabel);
		
		JLabel pdescriptionLabel = new JLabel("This is a brand new Android phone");
		pdescriptionLabel.setBounds(117, 75, 178, 14);
		contentPane.add(pdescriptionLabel);
		
		JLabel priceLabel = new JLabel("Price: 1100TL");
		priceLabel.setBounds(122, 100, 96, 14);
		contentPane.add(priceLabel);
		
		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(214, 99, 51, 14);
		contentPane.add(quantityLabel);
		
		qtyTextField = new JTextField();
		qtyTextField.setBounds(275, 95, 28, 25);
		contentPane.add(qtyTextField);
		qtyTextField.setColumns(10);
		
		JButton btnUpdateQuantity = new JButton("Update Quantity");
		btnUpdateQuantity.setForeground(new Color(153, 0, 255));
		btnUpdateQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int productID = 1;
				try{
				qty = Integer.parseInt(qtyTextField.getText());
				total_price += product_price * qty;
				totalTextField.setText(""+total_price);
				Auxillary aux = new Auxillary();
				int chk = aux.checkQty(productID,qty);
				//do further/better check
				if(chk > 0)
					JOptionPane.showMessageDialog(null, "Only "+chk+"left in stock");
				else
					JOptionPane.showMessageDialog(null, "Quantity Updated");
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.toString());
				}
			}
		});
		btnUpdateQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateQuantity.setBounds(249, 137, 130, 45);
		contentPane.add(btnUpdateQuantity);
	}
	
}
