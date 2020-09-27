/**
 * 
 */
package com.quickschools;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Admin
 *
 */
public class StudentEntityLookUp {

	/**
	 * 
	 */
	private static final Logger logger = LogManager.getLogger(StudentEntityLookUp.class);  
	
	
	public List<StudentEntity> studententity;
	public List<StudentField> studentfields;
	public List<StudentJoins> studentjoins;
	
	
	public StudentEntityLookUp() {
		// TODO Auto-generated constructor stub
		logger.info("entered into studententitylookup");
		this.studententity = generateEntities();
		this.studentfields = generateFields();
		this.studentjoins = generateJoins();
	}
   
	private List<StudentEntity> generateEntities(){
		
		List<StudentEntity> genentity =  new ArrayList<StudentEntity>(); 
		String[] fieldarray1 = {"name","email","studid","gradeid"};
		String[] fieldarray2 = {"name","gradevalue","gradeid"};
		StudentEntity s1 = new StudentEntity("Student",fieldarray1,"studid");
		StudentEntity s2 = new StudentEntity("Grade",fieldarray2,"gradeid");
		//StudentEntity s3 = new StudentEntity("Student",fieldarray1,123L);
		genentity.add(s1);
		genentity.add(s2);
		return genentity;		
		
	}
	private List<StudentField> generateFields(){
		
		List<StudentField> genfield = new ArrayList<StudentField>();
		StudentField s1 = null;
		Long y = null;
		String[] fieldarrayvals1 = {"name","email","studid","gradeid"};
		String[] fieldtypes1 = {"String","String","Long","Long"};
		String[] fieldarrayvals2 = {"name","gradevalue","gradeid"};
		String[] fieldtypes2 = {"String","String","Long"};
		if(null != fieldarrayvals1 && fieldarrayvals1.length != 0 )
		{
			
			for(int i = 0 ; i < fieldarrayvals1.length ; i++)
			{
				s1=null;
				s1 = new StudentField(fieldarrayvals1[i],"Student",fieldtypes1[i]);
				genfield.add(s1);
			}
		 	
		}
		if(null != fieldarrayvals2 && fieldarrayvals2.length != 0 )
		{
			
			for(int i = 0 ; i < fieldarrayvals2.length ; i++)
			{
				s1 = null;
				s1 = new StudentField(fieldarrayvals2[i],"Grade",fieldtypes2[i]);
				genfield.add(s1);
			}
		 	
		}
		logger.info("genfield object value"+genfield);
		if(null != genfield)
			logger.info("genfield size"+genfield.size());
		return genfield;
	}
	private  List<StudentJoins>generateJoins(){
		
	    StudentJoins sj = null;	
		List<StudentJoins> listjoin = new ArrayList<StudentJoins>();
		sj = new StudentJoins("studid","gradeid");
		listjoin.add(sj);
		logger.info("joins size"+listjoin.size());
		return listjoin;
		
		
	}
 }
