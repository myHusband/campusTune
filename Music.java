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


public class Music extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Music framemu = new Music();
					framemu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Music() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 Object columnNamesrecordsMusic[] = {"Item Name", "QTY Available", "Price","Discription"};
		Object recordsMusic[][] = {
			    {"Oh worship the King ", "100", "$12", "Christian"}, 
			    {"Lets get together", "8", "$20","Ragae"},
			    {"Freedom", "16", "$22", "Ragae"},
			    {"Swing low", "12", "$22", "Christmas"},
			    {"Merry Christmas", "20", "$20", "Christmas"}
			    };
		//DefaultTableModel dm = new DefaultTableModel();
		table = new JTable(recordsMusic,columnNamesrecordsMusic);
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
