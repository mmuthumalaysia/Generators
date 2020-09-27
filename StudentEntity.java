/**
 * 
 */
package com.quickschools;

/**
 * @author Admin
 *
 */
public class StudentEntity {

	/**
	 * 
	 */
	public StudentEntity(String tabname , String[] fieldnames,String tabkey) {
		// TODO Auto-generated constructor stub
		this.tablename = tabname;
		this.fieldnames = fieldnames;
		this.tablekey = tabkey;
	}

	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String[] getFieldnames() {
		return fieldnames;
	}
	public void setFieldnames(String[] fieldnames) {
		this.fieldnames = fieldnames;
	}

	public String tablename;
	public String[] fieldnames;
	public String tablekey;
	/**
	 * @return the tablekey
	 */
	public String getTablekey() {
		return tablekey;
	}

	/**
	 * @param tablekey the tablekey to set
	 */
	public void setTablekey(String tablekey) {
		this.tablekey = tablekey;
	}
	

	
	
}
