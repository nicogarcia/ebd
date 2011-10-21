package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class Result implements Iterable<String[]> {

	private int col_count = 0;
	private String row[];
	private boolean hasFailed = false;
	private ResultSet rs;
	private boolean isUpdateCommand;
	private String errorDetail = "";

	public Result(ResultSet resultSet, boolean modifies, boolean failed) {
		this.rs = resultSet;
		isUpdateCommand = modifies;
		hasFailed = failed;
		try {
			if (!isUpdateCommand() && !hasFailed()) {
				col_count = rs.getMetaData().getColumnCount();
				row = new String[col_count];
			}
		} catch (SQLException e) {
		}
	}
	
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public String[] getCurrentRow() {
		try {
			if (!rs.isLast()) {
				rs.next();
				for (int i = 0; i < col_count; i++) {
					row[i] = rs.getString(i + 1);
				}
			}
		} catch (SQLException e) {
			return null;
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
			e.printStackTrace();
		}
		return ret;
	}

	public void closeQuery() {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
		}
	}

	public boolean isUpdateCommand() {
		return isUpdateCommand;
	}

	public int getColumnCount() {
		return col_count;
	}

	public boolean hasFailed() {
		return hasFailed;
	}

	public Iterator<String[]> iterator() {
		return new ResultIterator(this);
	}

	public boolean isLast() {
		boolean ret = false;
		try {
			ret = rs.isLast();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public void setFailed(boolean failed) {
		hasFailed = failed;
	}

	public boolean isEmpty() {
		try {
			return !rs.next();
		} catch (SQLException e) {
		}
		return false;
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
