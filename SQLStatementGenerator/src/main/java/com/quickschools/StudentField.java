/**
 * 
 */
package com.quickschools;

/**
 * @author Admin
 *
 */
public class StudentField {

	/**
	 * 
	 */
	
	public String fieldname ;
	public String tableid;
	public long fieldkey;
	public String fieldtype;
	
	public StudentField(String field , String tableid  , String type) {
		// TODO Auto-generated constructor stub
		this.fieldname = field;
		this.tableid =  tableid;
		//this.fieldkey = fieldid;
		this.fieldtype = type;
	}
	
	
	
	
	/**
	 * @return the tableid
	 */
	public String getTableid() {
		return tableid;
	}




	/**
	 * @param tableid the tableid to set
	 */
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}




	/**
	 * @return the fieldtype
	 */
	public String getFieldtype() {
		return fieldtype;
	}




	/**
	 * @param fieldtype the fieldtype to set
	 */
	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}




	/**
	 * @return the fieldkey
	 */
	public long getFieldkey() {
		return fieldkey;
	}
	/**
	 * @param fieldkey the fieldkey to set
	 */
	public void setFieldkey(long fieldkey) {
		this.fieldkey = fieldkey;
	}
	/**
	 * @return the fieldname
	 */
	public String getFieldname() {
		return fieldname;
	}
	/**
	 * @param fieldname the fieldname to set
	 */
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

}
