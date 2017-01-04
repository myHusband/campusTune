import java.awt.BorderLayout;
import java.awt.Dimension;
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


public class Books extends productForm {

	private JPanel contentPane;
	private JTable table;
	private JButton btnCart;
        private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Books frame = new Books();
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
	public Books() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Object columnNamesBooks[] = {"Item Name", "QTY Available", "Price","Discription"};
		 Object recordsBooks[][] = {
				    {"Architechture", "12", "$12", "Mordern Designs"}, 
				    {"Mills & Booms", "8", "$20","Love inspired"},
				    {"Literature", "16", "$17", "Research oriented"},
				    {"Chike and the river", "100", "$17", " literature Studies"},
				    {"Love and basketball", "25", "$17", "College life"}
				    };
		//DefaultTableModel dm = new DefaultTableModel();
		table = new JTable(recordsBooks,columnNamesBooks);
		JScrollPane sPane = new JScrollPane(table);
		//contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(sPane);
		
                btnGoBack = new JButton("Go Back");
		btnCart = new JButton("Add To Cart");
                
                btnCart.setPreferredSize(new Dimension(50, 300));
                        
                
                btnGoBack.addActionListener(this);
		btnCart.addActionListener(new ActionListener() {
                    
                    
		public void actionPerformed(ActionEvent e) {
		try{
		//check if row was selected
		int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity you want to buy"));
		}catch(Exception ex){
		System.out.print(ex.toString());
		}		
			}
		});
                contentPane.add(btnGoBack, BorderLayout.SOUTH);
		contentPane.add(btnCart, BorderLayout.SOUTH);
	}

}
