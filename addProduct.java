package cpe513;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class addProduct extends JFrame implements ActionListener{

	JLabel pname= new JLabel("Enter the product name :");
	JLabel picture= new JLabel("Picture of the product :");
	JLabel quantity = new JLabel("Enter the quantity remain :");
	//JLabel quantity_to_buy = new JLabel("Enter the quantity to buy :");
	JLabel pcategory= new JLabel("Category of your product :");
	JLabel price = new JLabel("The price :");
	JLabel description = new JLabel("Detail of the product :");
	JTextField pnameTextField = new JTextField();
	JTextField pictureTextField = new JTextField();
	JButton pictureButton = new JButton("Choose your picture");
	JTextField quantityTextField= new JTextField();
	//JTextField buyTextField= new JTextField();
	JTextField categoryTextField = new JTextField();
	JTextField priceTextField = new JTextField();
	JTextArea descriptionArea= new JTextArea(150,50);
	JButton myAddButton = new JButton("Add Product");
	
	public addProduct() {
		// TODO Auto-generated constructor stub
		setTitle("Add Product Form");
		setLayout(null);
		setSize(400,350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    pname.setBounds(50, 50, 140, 15);
	    add(pname);
	    pnameTextField.setBounds(200, 48, 150, 20);
	    add( pnameTextField);
	    picture.setBounds(60, 73,140, 15);
	    add(picture);
	    pictureTextField.setBounds(200, 70, 150, 20);
	    pictureButton.setBounds(200, 100,150, 20);
	    add(pictureTextField);
	    add( pictureButton);
		quantity.setBounds(40, 130, 160,15);
		add(quantity);
        quantityTextField.setBounds(200, 128, 150, 20);
        add(quantityTextField);
        pcategory.setBounds(40, 170, 155,15);
        categoryTextField.setBounds(200, 170, 150, 20);
        add(pcategory);
        add(categoryTextField);
	 	price.setBounds(125, 190, 65,15);
	 	priceTextField.setBounds(200, 190, 150, 20);
	    add(price);
	 	add(priceTextField);
	 	description.setBounds(70, 220,120,15);
	 	descriptionArea.setBounds(200, 220, 150, 50);
	    add(description);
	 	add(descriptionArea);
	 	myAddButton.setBounds(200, 280, 130, 30);
	 	add(myAddButton);
	 	this.getContentPane().setBackground(Color.gray);
		setVisible(true);
		pictureButton.addActionListener(this);
		myAddButton.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == pictureButton){
			JFileChooser fc = new JFileChooser();
				   fc.setAcceptAllFileFilterUsed(false);
				   fc.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg") );
				   int isFileChooserActivated = fc.showOpenDialog(addProduct.this);
				   if (isFileChooserActivated == JFileChooser.APPROVE_OPTION)
				   {
				   File file = fc.getSelectedFile();
				   JOptionPane.showMessageDialog(null, file.getName() + " is opened! ");
				   String filePath = file.getAbsolutePath();
				   this.pictureTextField.setText(filePath);
			   }   
		}
		
		if(e.getSource() ==  myAddButton){
	        dbConnection db = new dbConnection();
	           try {
				db.insertDataintoProductDB(pnameTextField.getText(),pictureTextField.getText(), 
						   Integer.parseInt(quantityTextField.getText()), categoryTextField.getText(), 
						   Double.parseDouble(priceTextField.getText()),
						   descriptionArea.getText());
				dispose();
				AdminPanel admin = new AdminPanel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
	

