package cpe513;

import javax.swing.Icon;

public class Product {
	
	private int p_id;
	private String p_name;
	private byte[] image;
	private int pquantityleft;
	private int  pquantityToBuy;
	private static String pcategory;
	private int price;
	private String description;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String product_name,int quantity,String category,int price, String descprit) {
		// TODO Auto-generated constructor stub
		this.p_name = product_name;
		this.pquantityleft = quantity;
		this.pcategory = category;
		this.price = price;
		this.description = descprit;
	}
	
	
	public Product(String product_name,byte[] pic,int quantity,String category,int price, String descprit) {
		// TODO Auto-generated constructor stub
		this.p_name = product_name;
		this.pquantityleft = quantity;
		this.image = pic;
		this.pcategory = category;
		this.price = price;
		this.description = descprit;
	}
	
	
	
	public  void setProductName(String name){this.p_name=name;}
	public String getProductName(){return this.p_name;}
	public  void setQuantity(int  value){this.pquantityleft=value;}
	public int getQuantity(){return this.pquantityleft;}
	public  void setCategory(String categeory){this.pcategory=categeory;}
	public String getCategory(){return this.pcategory;}
	public  void setPrice(int  p){this.price=p;}
	public int getPrice(){return this.price;}
	//public  void setImage(byte[] img){this.image=img;}
	public byte[] getMyImage(){return this.image;}
	public  void setDescription(String describe){this.description=describe;}
	public String getDescription(){return this.description;}
	

}
