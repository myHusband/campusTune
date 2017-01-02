package cpe513;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {
	
	private String [] columns ;
	private Object [][] rows;
	
	
	public Model() {
		// TODO Auto-generated constructor stub
	}

	
	public Model(Object[][] data,String[] columnName) {
		// TODO Auto-generated constructor stub
		
		this.rows = data ;
		this.columns = columnName;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rows.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return this.rows[arg0][arg1];
	}
	
    public String getColumnName(int col){
        return this.columns[col];
    }

	
	public Class getColumnClass(int column){
		
		if(column == 6)
			return Icon.class;
		
		else 
			return getValueAt(0, column).getClass();
	}

}
