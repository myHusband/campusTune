package cpe513;

import javax.swing.JFrame;

public class ProductForm extends JFrame {

	
	
	public ProductForm() {
		// TODO Auto-generated constructor stub
		
		setTitle("Product Panel");
		setLayout(null);
		setSize(600,450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ProductForm();

	}
}
