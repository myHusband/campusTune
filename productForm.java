package cpe513;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class productInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productInterface frame = new productInterface();
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
	public productInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 369);
		setTitle("Welcome To Campus Tunes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(5, 5, 673, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCampusTunes = new JLabel("Campus Tunes");
		lblCampusTunes.setToolTipText("Books");
		lblCampusTunes.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCampusTunes.setBounds(216, 11, 204, 38);
		panel.add(lblCampusTunes);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\login\\logo.png"));
		label.setBounds(25, 0, 54, 65);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 70, 673, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Campus tunes affords students the opportunity to search and download resources with relative ease on campus");
		lblNewLabel.setBounds(10, 11, 639, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
            
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 104, 673, 177);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel booksLabel = new JLabel("");
		booksLabel.setToolTipText("Click To See Books");
		booksLabel.setIcon(new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\books - Copy.jpg"));
		booksLabel.setBounds(0, 11, 135, 133);
		booksLabel.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	//Books books = new Books();
		    	//books.setVisible(true);
		    }  
		});
		panel_2.add(booksLabel);
		
		JLabel fashionLabel = new JLabel("");
		fashionLabel.setToolTipText("Click To See Fashion Products");
		fashionLabel.setIcon(new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\fashion1 - Copy.jpg"));
		fashionLabel.setBounds(138, 11, 135, 138);
		panel_2.add(fashionLabel);
		
		JLabel musicLabel = new JLabel("");
		musicLabel.setToolTipText("Click To See Music Tracks");
		musicLabel.setIcon(new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\music - Copy.jpg"));
		musicLabel.setBounds(276, 11, 135, 138);
		panel_2.add(musicLabel);
		
		JLabel moviesLabel = new JLabel("");
		moviesLabel.setToolTipText("Click To See Movies");
		moviesLabel.setIcon(new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\movies - Copy.jpg"));
		moviesLabel.setBounds(414, 11, 135, 138);
		panel_2.add(moviesLabel);
		
		JLabel techLabel = new JLabel("");
		techLabel.setToolTipText("Click To See Technology Products");
		techLabel.setIcon(new ImageIcon("C:\\Users\\Mutag\\workspace\\cpe513\\images\\technology - Copy.jpg"));
		techLabel.setBounds(554, 11, 119, 138);
		panel_2.add(techLabel);
		
		JLabel lblBooks = new JLabel("BOOKS");
		lblBooks.setBounds(30, 152, 46, 14);
		panel_2.add(lblBooks);
		
		JLabel lblFashion = new JLabel("FASHION");
		lblFashion.setBounds(172, 152, 64, 14);
		panel_2.add(lblFashion);
		
		JLabel lblMusic = new JLabel("MUSIC");
		lblMusic.setBounds(315, 152, 46, 14);
		panel_2.add(lblMusic);
		
		JLabel lblMovies = new JLabel("MOVIES");
		lblMovies.setBounds(469, 152, 46, 14);
		panel_2.add(lblMovies);
		
		JLabel lblTechnology = new JLabel("TECHNOLOGY");
		lblTechnology.setBounds(588, 152, 85, 14);
		panel_2.add(lblTechnology);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(5, 281, 673, 45);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(0, 11, 89, 23);
		panel_3.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(99, 11, 89, 23);
		panel_3.add(btnRegister);
		
		JButton btnViewCart = new JButton("View Cart");
		btnViewCart.setBounds(201, 11, 89, 23);
		panel_3.add(btnViewCart);
		
		textField = new JTextField();
		textField.setBounds(375, 11, 199, 23);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(584, 11, 89, 23);
		panel_3.add(btnSearch);
	}
}
