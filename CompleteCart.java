import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompleteCart extends JFrame {

	private JPanel contentPane;
	private JTable table;
	double totalAmount=0,priceAdded;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompleteCart frame = new CompleteCart();
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
	public CompleteCart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(172, 21, 0, 0);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Back to Products");
		btnNewButton.setBounds(30, 204, 144, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Product product = new Product();
				product.show();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(248, 204, 144, 47);
		contentPane.add(btnCheckout);
		setTitle("View your complete cart");
	}
}
