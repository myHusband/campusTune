package cpe513;
package cpe513;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminPanel  extends JFrame implements ActionListener{
	
	JPanel headerPanel = new JPanel();
	JPanel contentPanel = new JPanel();
	ImageIcon icon = new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\Admin.png");
	
	JButton viewProduct = new JButton("viewAllProduct");
	JButton addProduct = new JButton("addProduct");
	JButton removeProduct = new JButton("removeProduct");
	JButton updateProduct = new JButton("updateProduct");
	JButton deleteProduct = new JButton("deleteProduct");
	
	JLabel headerLabel = new JLabel("");
	JLabel secondheaderLabel = new JLabel("");
	JLabel productLabel = new JLabel("Enter Your Productc Here :");
	JTextField productText = new JTextField(20);
	JLabel headerTableLabel = new JLabel("");
	JLabel contentLabel = new JLabel("");
	
	JTable productTable = new JTable();
	
	
	public AdminPanel() {
		// TODO Auto-generated constructor stub
		pack();
		setTitle("Admin ");
		setLayout(null);
		setSize(630,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	  // headerPanel.add(icon);
	  
	   headerPanel.setBounds(0, 0, 630, 110);
       add(headerPanel);
       headerPanel.setLayout(null);
       headerPanel.setBackground(Color.white);
       
       headerLabel.setBounds(470, 0, 160, 130);
       headerPanel.add(headerLabel);
       headerLabel.setIcon(icon);
       
       secondheaderLabel.setBounds(120, 0, 320, 110);
       headerPanel.add(secondheaderLabel);
       secondheaderLabel.setText("Manage your Product From here ");
       secondheaderLabel.setFont(new Font("Gungsuh", Font.PLAIN, 22));
       //secondheaderLabel.setIcon(icon);
       
       
       
       contentPanel.setBounds(450, 150, 170, 300);
       add(contentPanel);
       contentPanel.setLayout(null);
       contentPanel.setBackground(Color.gray);
       contentPanel.add(viewProduct);
       contentPanel.add(addProduct);
       contentPanel.add(removeProduct);
       contentPanel.add(deleteProduct);
       
       
       viewProduct.setBounds(465, 200, 130,25);
 	   add(viewProduct);
 	   viewProduct.addActionListener(this);
 	   
 	  addProduct.setBounds(465, 227, 130,25);
	   add(addProduct);
	  addProduct.addActionListener(this);
	   
	   updateProduct.setBounds(465, 255, 130,25);
	   add( updateProduct);
	   updateProduct.addActionListener(this);
	   
	   deleteProduct.setBounds(465, 285, 130,25);
	   add( deleteProduct);
	  deleteProduct.addActionListener(this);
 	   
       
       
       headerTableLabel.setBounds(170, 115, 400, 30);
       add(headerTableLabel);
       headerTableLabel.setText("View Your Product here");
       headerTableLabel.setForeground(Color.blue);
       
       contentLabel.setBounds(470, 115, 200, 30);
       add(contentLabel);
       contentLabel.setText("Manage Content");
       contentLabel.setForeground(Color.blue);
       
       
       
       
      
    
       
       JScrollPane js = new JScrollPane(productTable);
       js.setBounds(0, 150, 468, 300);
       js.setPreferredSize(new Dimension (468,80));
       js.setBackground(Color.pink);
       add(js);
       

		
 	 // this.getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource() == viewProduct){
			
			
		}
		
      if(arg0.getSource() == addProduct){
    	  dispose();
    	  new addProduct();
			
		}
      
      if(arg0.getSource() == deleteProduct){
    	  dispose();
    	  new deleteProduct();
			
		}
      if(arg0.getSource() == updateProduct){
    	  dispose();
    	  new updateProduct();
		}
      
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminPanel();

	}

}

