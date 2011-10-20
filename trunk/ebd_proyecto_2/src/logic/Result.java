package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class Result implements Iterable<String[]> {

	private int col_count = 0;
	private String row[];

	private ResultSet rs;

	//FIXME Add a successful result flag
	//FIXME Try to remove the most tries
	
	public Result(ResultSet resultSet) {
		this.rs = resultSet;
		try {
			col_count = rs.getMetaData().getColumnCount();
			row = new String[col_count];
		} catch (SQLException e) {
			System.out.println("Error en Result:result");
			//System.out.println(e.getMessage());
		}
	}

	public String[] getCurrentRow() {
		try {
			rs.next();
			for (int i = 0; i < col_count; i++) {
				row[i] = rs.getString(i + 1);
			}
		} catch (SQLException e) {
			System.out.println("Error en Result:getCurrentRow");
			System.exit(-1);
			//System.out.println(e.getMessage());
		}
		return row;
	}

	public String[] getColumnLabels() {
		String ret[] = new String[col_count];
		try {
			for (int i = 0; i < col_count; i++) {
				ret[i] = rs.getMetaData().getColumnLabel(i + 1);
			}
		} catch (SQLException e) {
			System.out.println("Error en Result:getColumLabels");
			//e.printStackTrace();
		}
		return ret;
	}

	public int getColumnCount() {
		return col_count;
	}

	public Iterator<String[]> iterator() {
		return new ResultIterator(this);
	}

	public boolean isLast() {
		boolean ret = false;
		try {
			ret = rs.isLast();
		} catch (SQLException e) {
			System.out.println("Error en Result:isLast");
			//System.out.println(e.getMessage());
		}
		return ret;
	}
	
	public boolean isEmpty(){
		try {
			if(rs.next()){
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Error en Result::isEmpty");
			//e.printStackTrace();
		}
		return true;
	}


	private class ResultIterator implements Iterator<String[]> {

		Result result;

		public ResultIterator(Result result) {
			this.result = result;
		}

		public boolean hasNext() {
			return !result.isLast();
		}

		public String[] next() {
			return getCurrentRow();
		}

		public void remove() {
		}
		
	}

}
