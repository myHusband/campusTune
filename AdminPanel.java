package cpe513;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminPanel  extends JFrame implements ActionListener{
	
	JPanel headerPanel = new JPanel();
	JPanel contentPanel = new JPanel();
	ImageIcon icon = new ImageIcon("images\\login\\Admin.png");
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
		setSize(900,485);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	    headerPanel.setBounds(0, 0, 900, 110);
        add(headerPanel);
        headerPanel.setLayout(null);
        headerPanel.setBackground(Color.gray);
        headerLabel.setBounds(740, 0, 160, 130);
        headerPanel.add(headerLabel);
        headerLabel.setIcon(icon);
        secondheaderLabel.setBounds(120, 0, 320, 110);
        headerPanel.add(secondheaderLabel);
        secondheaderLabel.setText("Manage your Product From here ");
        secondheaderLabel.setFont(new Font("Gungsuh", Font.PLAIN, 22));
        contentPanel.setBounds(739, 150, 170, 300);
        add(contentPanel);
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.gray);
        contentPanel.add(viewProduct);
        contentPanel.add(addProduct);
        contentPanel.add(removeProduct);
        contentPanel.add(deleteProduct);
        viewProduct.setBounds(754, 200, 130,25);
 	    add(viewProduct);
 	    viewProduct.addActionListener(this);  
 	    addProduct.setBounds(754, 227, 130,25);
	    add(addProduct);
	    addProduct.addActionListener(this);
	    updateProduct.setBounds(754, 255, 130,25);
	    add( updateProduct);
	    updateProduct.addActionListener(this);
	    deleteProduct.setBounds(754, 285, 130,25);
	    add( deleteProduct);
	    deleteProduct.addActionListener(this); 
        headerTableLabel.setBounds(300, 115, 400, 30);
        add(headerTableLabel);
        headerTableLabel.setText("View Your Product here");
        headerTableLabel.setForeground(Color.blue);    
        contentLabel.setBounds(740, 115, 200, 30);
        add(contentLabel);
        contentLabel.setText("Manage Content");
        contentLabel.setForeground(Color.blue);
        JScrollPane js = new JScrollPane(productTable);
        js.setBounds(2, 150, 737, 300);
        //productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        js.setPreferredSize(new Dimension (738,450));
        productTable.setBackground(Color.white);
        add(js);
	    setVisible(true);	
	}
	void makeTable(){
		dbConnection db = new dbConnection();
		try {
			productTable.setModel(db.getDataFromProductDB());
			productTable.getColumnModel().getColumn(2).setCellRenderer(productTable.getDefaultRenderer(ImageIcon.class));
			productTable.getColumnModel().getColumn(2).setPreferredWidth(70);
			productTable.setRowHeight(80);
			productTable.setRowSelectionAllowed(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource() == viewProduct){
			makeTable();				
		}
		
      if(arg0.getSource() == addProduct){
    	  dispose();
    	  new addProduct();
			
		}
      
      if(arg0.getSource() == deleteProduct){
    		dbConnection dbConn = new dbConnection();
    		String pidTextField = JOptionPane.showInputDialog("Enter the product id to be deleted :");
			try {
				dbConn.deleteProductDB(Integer.parseInt(pidTextField));
				JOptionPane.showMessageDialog(null, "  delete was successfully ");
				makeTable();
				AdminPanel admin = new AdminPanel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
      
      if(arg0.getSource() == updateProduct){
    	  //dispose();
    	  //new updateProduct();
    	  productTable.addMouseListener(new MouseAdapter() {
    		    @Override
    		    public void mouseClicked(final MouseEvent e) {
    		        if (e.getClickCount() == 1) {
    		            final JTable target = (JTable)e.getSource();
    		            final int row = target.getSelectedRow();
    		            final int column = target.getSelectedColumn();
    		            String colName = productTable.getModel().getColumnName(column);
    		            if(colName.equals("Picture")){
    		            	   JFileChooser fc = new JFileChooser();
    						   fc.setAcceptAllFileFilterUsed(false);
    						   fc.addChoosableFileFilter(new FileNameExtensionFilter("*.jpg", "jpg") );
    						   int isFileChooserActivated = fc.showOpenDialog(AdminPanel.this);
    						   if (isFileChooserActivated == JFileChooser.APPROVE_OPTION)
    						   {
    						   File file = fc.getSelectedFile();
    						   JOptionPane.showMessageDialog(null, file.getName() + " is opened! ");
    						   String filePath = file.getAbsolutePath();
    						   //this.pictureTextField.setText(filePath);
    					   }  
    		            }
    		            else{
    		            	String updateValue = JOptionPane.showInputDialog("Enter new value");
    		            	dbConnection dbconn = new dbConnection();
    		            	int pID = Integer.parseInt((String) productTable.getModel().getValueAt(0, column));
    		            	dbconn.updateProductDB(pID, updateValue);
    		            	makeTable();
    		            }
    		            
    		            // Cast to ur Object type
    		            //final String valueInCell = (String)productTable.getValueAt(row, column);
    		            // TODO WHAT U WANT!
    		        }
    		    }
    		});
		}
     
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdminPanel();

	}

}
