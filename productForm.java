import java.awt.*;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;

public class productForm extends JFrame implements ActionListener {
    JLabel label = new JLabel("Campus Tunes");
    JLabel label1 = new JLabel("Search our store");
    JLabel label2 = new JLabel(" <html> Campus tunes affords students the opportunity to search and download resources with relative ease from <br>"
            +  "the comfort of our home. This platform also present low proce edition of all resources that may be trending in the society. "
            + "All you need to do is search our store below for more information on the trending goods. click on cart, to view your packages and "
            + "follow the directions all the way to the payment point for a successful purchase of our items. ENJOY  ");
    JTextArea jtxt = new JTextArea(6, 20);
    JLabel userlabel = new JLabel("username :");
    JLabel passlabel = new JLabel("password :");
    
    
    
    JMenu men = new JMenu("Movies");
    JMenu men1 = new JMenu("Books");
    JMenu men2 = new JMenu("Technology");
    JMenu men3 = new JMenu("Music");
    JMenu men4 = new JMenu("Fashion");
    
    //JDialog jDialog = new JDialog(SwingUtilities.getWindowAncestor(search));
    JTextField txt = new JTextField(15);
    JTextField usernametxt = new JTextField(20);
    JTextField passwordtxt = new JTextField(20);
    
    JButton loginjb = new JButton("login");
    JButton Registerjb = new JButton("Register");
    JButton Cartjb = new JButton("Cart");
    JButton jb5 = new JButton("Tech");
    JButton jb6 = new JButton("Music");
    JButton search = new JButton("Search our store");
    JButton moremovies = new JButton("View More Movies");
    JButton morebooks = new JButton("View More Books");
    JButton moretechnology = new JButton("View More of our technology");
    JButton moremusic = new JButton("View More music");
    JButton morefashion = new JButton("View More Fashion");
    
    private JButton renderButton;
	private JButton editButton;
	private Object editorValue;
	private boolean isButtonColumnEditor;
    
    
    JPanel pan = new JPanel();
    JPanel pan1 = new JPanel();
    JPanel pan11 = new JPanel();
    JPanel pan12 = new JPanel();
    JPanel pan13 = new JPanel();
    JPanel pan14 = new JPanel();
    JPanel pan15 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();
    JPanel pan5 = new JPanel();
    JPanel pan6 = new JPanel();
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    
    ImageIcon ic = new ImageIcon();
    ImageIcon koala = new ImageIcon("Koala.jpg");
    
    
    Image cover;
    Dimension size;

    
    JLabel picLabel1 = new JLabel();
    JLabel picLabel2 = new JLabel();
    JLabel picLabel3 = new JLabel();
    JLabel picLabel4 = new JLabel();
    JLabel picLabel5 = new JLabel();
    JLabel picLabel6 = new JLabel();
    
    JTabbedPane jt = new JTabbedPane();
  
    //movies tab
    Object records[][] = {
    {"Romance", "12", "$12", "Adult movies for married couples"}, 
    {"Action", "8", "$20","Tales of war and revenge", "View"},
    {"Adventure", "16", "$17", " Chronicles of the ancient days "},
    {"Titanic", "16", "$17", " Chronicles of the ancient days " , "View"},
    {"Act like a lady, think like a man", "16", "$17", " Chronicles of the ancient days "}
    };

    Object columnNames[] = {"Item Name", "QTY Available", "Price","Discription"};
    
    JTable table = new JTable(records, columnNames);
    JScrollPane sPane = new JScrollPane(table);
    
    //Books tab
    Object recordsBooks[][] = {
    {"Architechture", "12", "$12", "Mordern Designs"}, 
    {"Mills & Booms", "8", "$20","Love inspired"},
    {"Literature", "16", "$17", "Research oriented"},
    {"Chike and the river", "100", "$17", " literature Studies"},
    {"Love and basketball", "25", "$17", "College life"}
    };

    Object columnNamesBooks[] = {"Item Name", "QTY Available", "Price","Discription"};
    
    JTable tableB = new JTable(recordsBooks, columnNamesBooks);
    JScrollPane sPaneB = new JScrollPane(tableB);
    
    //technology panel
    Object recordsTechnology[][] = {
    {"Play Station 4", "6", "$120", "Mordern Designs"}, 
    {"Flat Screen 32 inch", "8", "$80","High definition"},
    {"Xbox", "10", "$100", "Games "},
    {"Electric Heater", "15", "$20", " Room Heating "},
    {"Ipad", "10", "$10", " Mordern communication "}
    };

    Object columnNamesTechnology[] = {"Item Name", "QTY Available", "Price","Discription"};
    
    JTable tableT = new JTable(recordsTechnology, columnNamesTechnology);
    JScrollPane sPaneT = new JScrollPane(tableT);
    
    //Music
    Object recordsMusic[][] = {
    {"Oh worship the King ", "100", "$12", "Christian"}, 
    {"Lets get together", "8", "$20","Ragae"},
    {"Freedom", "16", "$22", "Ragae"},
    {"Swing low", "12", "$22", "Christmas"},
    {"Merry Christmas", "20", "$20", "Christmas"}
    };

    Object columnNamesrecordsMusic[] = {"Item Name", "QTY Available", "Price","Discription"};
    
    JTable tableM = new JTable(recordsMusic, columnNamesrecordsMusic);
    JScrollPane sPaneM = new JScrollPane(tableM);
    
    //Fashion
    Object recordsFashion[][] = {
    {"TimberLand", "12", "$25", "Foot wear"}, 
    {"All Star", "8", "$11","Foot wear"},
    {"Scarf", "16", "$10", "Clothing"},
    {"Jeans", "16", "$15", "Clothing "},
    {"T'shirts", "20", "$18", "Clothing"}
    };

    Object columnNamesrecordsFashion[] = {"Item Name", "QTY Available", "Price","Discription"};
    
    JTable tableF = new JTable(recordsFashion, columnNamesrecordsFashion);
    JScrollPane sPaneF = new JScrollPane(tableF);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productForm framep = new productForm();
					framep.setVisible(true);
                                        Books frame = new Books();
                                        fashion framef = new fashion();
                                        movies framem = new movies();
                                        Music framemu = new Music();
                                        Technology framet = new Technology();
                                        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public productForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                //getContentPane().setBackground(Color.GRAY);
                
		
		DoConnect();
		

		
		JLabel campusLabel = new JLabel("\t\t\t\t\t\t\t\t\tCampus Tunes");
		campusLabel.setFont(new Font("Georgia", Font.BOLD, 17));
		campusLabel.setBackground(Color.WHITE);
		campusLabel.setBounds(186, 11, 139, 29);
		contentPane.add(campusLabel);
		
		JPanel productPanel = new JPanel();
		productPanel.setBounds(87, 130, 350, 197);
        //Movies panel
	
       
        
        table.setPreferredSize(new Dimension(340, 50));
        pan1.setPreferredSize(new Dimension(340, 70));
        sPane.setPreferredSize(new Dimension (340,70));
        //sPane.setLayout(new FlowLayout());
        pan1.add(sPane);
        //pan1.setBackground(Color.GRAY);
        pan1.add(moremovies) ;  
        moremovies.addActionListener(this);
        add(pan1);
        
        
        //Books panel
        
 
        tableB.setPreferredSize(new Dimension(340, 240));
        pan12.setPreferredSize(new Dimension(340, 240));
        sPaneB.setPreferredSize(new Dimension (340,70));
        //pan12.setBackground(Color.GRAY);
        pan12.add(sPaneB);
        morebooks.addActionListener(this);
        pan12.add(morebooks) ;   
        add(pan12);
        
        
        //Technology
        
        tableT.setPreferredSize(new Dimension(340, 240));
        pan13.setPreferredSize(new Dimension(340, 240));
        sPaneT.setPreferredSize(new Dimension (340,70));
        //pan13.setBackground(Color.GRAY);
        pan13.add(sPaneT);
        
        pan13.add(moretechnology);
        add(pan13);
        moretechnology.addActionListener(this);
        
        //Music
        tableM.setPreferredSize(new Dimension(340, 240));
        pan14.setPreferredSize(new Dimension(340, 240));
        sPaneM.setPreferredSize(new Dimension (340,70));
        //pan14.setBackground(Color.GRAY);
        pan14.add(sPaneM);
        
        pan14.add(moremusic);
        add(pan14);
        moremusic.addActionListener(this);
        
        //Fashion
        tableF.setPreferredSize(new Dimension(340, 240));
        pan15.setPreferredSize(new Dimension(340, 240));
        sPaneF.setPreferredSize(new Dimension (340,70));
        //pan15.setBackground(Color.GRAY);
        pan15.add(sPaneF);
        
        pan15.add(morefashion);
        add(pan15);
        morefashion.addActionListener(this);
        
        
        jt.setPreferredSize(new Dimension(350,150));
        jt.addTab("Movies", ic, pan1, "Tab One");
        jt.addTab("Books", ic, pan12, "Details");
        jt.addTab("Technology", ic, pan13, "Count");
        jt.addTab("Music", ic, pan14, "Count");
        jt.addTab("fashion", ic, pan15, "Count");
        
        add(jt);
        productPanel.add(jt);
		contentPane.add(productPanel);
                //productPanel.setBackground(Color.GRAY);
		
		JPanel TextPanel = new JPanel();
                //TextPanel.setBackground(Color.GRAY);
		TextPanel.setBounds(106, 90, 309, 40);
		TextPanel.add(txt);
		TextPanel.add(search);
		contentPane.add(TextPanel);
		
		JPanel ButtonPanel = new JPanel();
                //ButtonPanel.setBackground(Color.GRAY);
		ButtonPanel.setBounds(91, 330, 330, 54);
		ButtonPanel.add(loginjb);
		ButtonPanel.add(Registerjb);
		ButtonPanel.add(Cartjb);
		contentPane.add(ButtonPanel);
		
		JPanel picPanel = new JPanel();
                //picPanel.setBackground(Color.GRAY);
		picPanel.setBounds(10, 27, 79, 105);
		/*java.net.URL imageURL = getClass().getResource("images.jpg");
		picLabel1 = new JLabel(new ImageIcon(imageURL));
		picPanel.add(picLabel1);*/
		picLabel1.setIcon(new ImageIcon("C:\\Users\\collins\\Documents\\NetBeansProjects\\campusTunes\\src\\images\\music.png"));
		picPanel.add(picLabel1);
		contentPane.add(picPanel);
		
		JPanel picPanel1 = new JPanel();
                //picPanel1.setBackground(Color.GRAY);
		picPanel1.setBounds(10, 145, 79, 105);
		picLabel2.setIcon(new ImageIcon("C:\\Users\\collins\\Documents\\NetBeansProjects\\campusTunes\\src\\images\\books.png"));
		picPanel1.add(picLabel2);
		contentPane.add(picPanel1);
		
		JPanel picPanel2 = new JPanel();
                //picPanel2.setBackground(Color.GRAY);
		picPanel2.setBounds(10, 266, 75, 90);
		picLabel3.setIcon(new ImageIcon("C:\\Users\\collins\\Documents\\NetBeansProjects\\campusTunes\\src\\images\\fashion.png"));
		picPanel2.add(picLabel3);
		contentPane.add(picPanel2);
		
		JPanel picPanel3 = new JPanel();
                //picPanel3.setBackground(Color.GRAY);
		picPanel3.setBounds(431, 11, 79, 105);
		picLabel4.setIcon(new ImageIcon("C:\\Users\\collins\\Documents\\NetBeansProjects\\campusTunes\\src\\images\\technology.png"));
		picPanel3.add(picLabel4);
		contentPane.add(picPanel3);
		
		JPanel picPanel4 = new JPanel();
                //picPanel4.setBackground(Color.GRAY);
		picPanel4.setBounds(431, 145, 79, 105);
		picLabel5.setIcon(new ImageIcon("C:\\Users\\collins\\Documents\\NetBeansProjects\\campusTunes\\src\\images\\movies.png"));
		picPanel4.add(picLabel5);
		contentPane.add(picPanel4);
		
		JPanel picPanel5 = new JPanel();
                //picPanel5.setBackground(Color.GRAY);
		picPanel5.setBounds(431, 266, 79, 105);
		picLabel6.setIcon(new ImageIcon("C:\\Users\\collins\\Documents\\NetBeansProjects\\campusTunes\\src\\images\\fashion1.png"));
		picPanel5.add(picLabel6);
		contentPane.add(picPanel5);
	}
        
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==morebooks){
                Books frame = new Books();
                frame.setVisible(true);
            }
            if(e.getSource()==morefashion){
                fashion framef = new fashion();
                framef.setVisible(true);
            }
            if (e.getSource()==moremovies){
                movies framem = new movies();
                framem.setVisible(true);
            }
            if(e.getSource()==moremusic){
                Music framemu = new Music();
                framemu.setVisible(true);
            }
            if(e.getSource()==moretechnology){
                Technology framet = new Technology();
                framet.setVisible(true);
            }
        }
	
	public void DoConnect(){
		try{
			//Connection to database
			String host = "jdbc:derby://localhost:1527/Products";
			String UName = "Your_Username_Here";
			String UPass = "Your_Password_here";
			con = DriverManager.getConnection(host, UName, UPass);
			
			//Execute some load and insert into database
			stmt = (Statement) con.createStatement();
			String SQL = "SELECT * FROM Product";
			rs = ((java.sql.Statement) stmt).executeQuery(SQL);
			
			//Move to the first records and get data
			rs.next();
			//int id_col = rs.getInt("Product_Name");
			//String id = Integer.toString(id_col);
			String ProductName = rs.getString("item Name");
			int QTY_Available = rs.getInt("QTY Available");
			String QTY = Integer.toString(QTY_Available);
			int price = rs.getInt("Price");
			String item_price = Integer.toString(price);
			String item_Description = rs.getString("Item Description");
			
			//Display the first record in the fields
			//textID.settext(id);
			//textFirstName.setText(first_name);
			//textLastname.setText(last_Name);
			//textJobTitle.setText(job);
			
			
						
			
		}catch( SQLException err) {
			JOptionPane.showMessageDialog(this, err.getMessage());
		}
		
	}	
	
}
