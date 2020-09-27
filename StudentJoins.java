/**
 * 
 */
package com.quickschools;

/**
 * @author Admin
 *
 */
public class StudentJoins {

	/**
	 * 
	 */
	public StudentJoins(String pk1 , String pk2) {
		// TODO Auto-generated constructor stub
		this.tableonepk = pk1;
		this.tabletwopk = pk2;
	}
	
	public String tableonepk;
	public String tabletwopk;
	/**
	 * @return the tableonepk
	 */
	public String getTableonepk() {
		return tableonepk;
	}
	/**
	 * @param tableonepk the tableonepk to set
	 */
	public void setTableonepk(String tableonepk) {
		this.tableonepk = tableonepk;
	}
	/**
	 * @return the tabletwopk
	 */
	public String getTabletwopk() {
		return tabletwopk;
	}
	/**
	 * @param tabletwopk the tabletwopk to set
	 */
	public void setTabletwopk(String tabletwopk) {
		this.tabletwopk = tabletwopk;
	}
	
}
