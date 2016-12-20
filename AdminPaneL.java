package cpe513;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

public class AdminPaneL extends JFrame implements ActionListener {
	

	JButton submitButton = new JButton("submit");
	JButton clearButton = new JButton("clear");
	
	

	
	public AdminPaneL() {
		// TODO Auto-generated constructor stub
		setTitle("Admin Panel");
		setLayout(null);
		setSize(600,450);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//pack();
	
	 	 
	 	submitButton.setBounds(200, 350, 80, 20);
	 	add(submitButton);
	 	submitButton.addActionListener(this);
	 	
	 	clearButton.setBounds(285, 350, 70, 20);
	 	add(clearButton);
	 	clearButton.addActionListener(this);
	 	this.getContentPane().setBackground(Color.gray);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminPaneL();

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()== clearButton){dispose();new AdminPaneL();}
		
		if(e.getSource() ==   submitButton){
			
			  
		}
		
		
	}

}
