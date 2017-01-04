import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Technology extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	Technology framet = new Technology();{
        framet.setVisible(true);
			
		}
	}

	/**
	 * Create the frame.
	 */
	public Technology() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Object columnNamesTechnology[] = {"Item Name", "QTY Available", "Price","Discription"};
	    Object recordsTechnology[][] = {
	    	    {"Play Station 4", "6", "$120", "Mordern Designs"}, 
	    	    {"Flat Screen 32 inch", "8", "$80","High definition"},
	    	    {"Xbox", "10", "$100", "Games "},
	    	    {"Electric Heater", "15", "$20", " Room Heating "},
	    	    {"Ipad", "10", "$10", " Mordern communication "}
	    	    };
		//DefaultTableModel dm = new DefaultTableModel();
		table = new JTable(recordsTechnology,columnNamesTechnology);
		JScrollPane sPane = new JScrollPane(table);
		//contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(sPane);
		
		btnNewButton = new JButton("Add To Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//check if row was selected
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity you want to buy"));
				}catch(Exception ex){
					System.out.print(ex.toString());
				}		
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

}
