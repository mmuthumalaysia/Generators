package com.quickschools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

/**
 * Hello world!
 *
 */
public class SQLGenerator 
{
	private static final Logger logger = LogManager.getLogger(SQLGenerator.class);  
    public static void main( String[] args )
    {
    	try
    	{
    	BasicConfigurator.configure();
        System.out.println( "Hello World!" );
        StudentField s1 = new StudentField("name","Student","String");
        StudentField s2 = new StudentField("gradevalue","Grade","Long");
        StudentJoins sj = new StudentJoins("studid","gradeid");
        List<StudentField> asf = new ArrayList<StudentField>();
        List<StudentJoins> asj = new ArrayList<StudentJoins>();
        asf.add(s1);
        asf.add(s2);
        asj.add(sj);
        SQLGenerator sqg = new SQLGenerator();
        sqg.generate(asf,asj);
    	}catch(GeneratorException ge)
    	{
    		System.out.println("generator exception occurred"+ge);
    	}catch(Exception e){
    		//System.out.println("exception occurred"+e.getCause().getLocalizedMessage());
    		e.printStackTrace();
    	}
    }
    
    public String generate(List<StudentField> fields,List<StudentJoins> joins) throws GeneratorException
    {
    	
    	StudentEntityLookUp slook = new StudentEntityLookUp();
    	 List<StudentEntity> studentent = new ArrayList<StudentEntity>();
    	List<StudentField> studentfd = new ArrayList<StudentField>(), reportfd = new ArrayList<StudentField>();
    	List<StudentJoins> studentjs = new ArrayList<StudentJoins>(), reportjs = new ArrayList<StudentJoins>();
    	studentent = slook.studententity;
    	if(null != studentent)
    	logger.info(studentent);
    	
    	studentfd = slook.studentfields;
    	studentjs = slook.studentjoins;
    	if(null != studentfd)
        	logger.info(studentfd);
    	if(null != studentjs)
        	logger.info(studentjs);
    	StringBuilder squery = new StringBuilder("select");
    	
    	if(null != fields && fields.size() != 0)
    	{
    	
    	for(int i = 0 ; i < fields.size() ; i++){
    		for(int y = 0 ; y < studentfd.size() ; y++)
    		{
    			if(fields.get(i).getFieldname() == studentfd.get(y).getFieldname() && fields.get(i).getTableid() == studentfd.get(y).getTableid())
    			{
    				reportfd.add(fields.get(i));
    			}
    		}
    	 }
    	}else{
    		throw new GeneratorException();
    	}
    	if(null != joins && joins.size() != 0)
    	{
    	 
    	for(int i = 0 ; i < joins.size() ; i++){
    		for(int y = 0 ; y < studentjs.size() ; y++)
    		{
    			if(joins.get(i).getTableonepk() == studentjs.get(y).getTableonepk())
    			{
    				reportjs.add(joins.get(i));
    			}
    		}
    	}
    	}else {
    		throw new GeneratorException();
    	}
    	
    	String sqlquery = null;
    	if(null != reportfd)
    	logger.info("report fields size"+reportfd.size());
    	if(null != studentent)
        	logger.info("student entities size"+studentent.size());
    	if(null != reportjs)
    	logger.info("report joins size"+reportjs.size());
    	sqlquery = prepareQuery(reportfd,reportjs,studentent);
    	logger.info(sqlquery);
    	return sqlquery;
   }
    
    public String prepareQuery(List<StudentField>reportfd, List<StudentJoins>reportjs, List<StudentEntity> studentent)
    {
    	
    	StringBuilder squery = new StringBuilder("select");
    	Set<String> fSet = new HashSet<String>(); 
    	Set<String> tSet = new HashSet<String>(); 
    	
    	if(null != reportfd  && reportfd.size() > 0)
    	{
    		for(int i = 0 ; i < reportfd.size() ; i++)
    		{
    			if(i < (reportfd.size()-1)){
    			squery.append(" "+reportfd.get(i).getTableid()+"."+reportfd.get(i).getFieldname() + "," );}
    			else{
    			squery.append(reportfd.get(i).getTableid()+"."+reportfd.get(i).getFieldname()+" ");
    			}
    			tSet.add(reportfd.get(i).getTableid());
    		}
    	}
    		
    		if((null != tSet) && !(tSet.isEmpty())) {
    			squery.append("from ");
    			String[] strArray = tSet.toArray(new String[tSet.size()]);
    			for (int y = 0 ; y < strArray.length ; y++)
    			{
    				if( y < (strArray.length - 1))
    				{
    					squery.append(strArray[y]+",");
    				}else{
    					squery.append(strArray[y]);
    				}
    			}
    			
    		}
    				
    	/*	if((null != reportjs) && !(reportjs.isEmpty())) {
    			
    			StudentField fieldjs = null;
    			for(int i = 0 ; i < reportfd.size() ; i++)
    			{
    				for(int y = 0 ; y < reportjs.size() ; y++)
    				{
    				if(reportfd.get(i).getFieldname().equalsIgnoreCase(reportjs.get(y).getTabletwopk()))
    				{
    					squery.append("inner join "+reportfd.get(i).getTableid());
    					
    					fieldjs = (StudentField)reportfd.get(i);
    				}
    				if(reportfd.get(i).getFieldname().equalsIgnoreCase(reportjs.get(y).getTableonepk()))
    				{
    					squery.append("ON "+reportfd.get(i).getTableid()+"."+reportfd.get(i).getFieldname()+"=");
    					
    				}
    				if((null != fieldjs))
    				{
    					
    					   squery.append(fieldjs.getTableid()+"."+fieldjs.getFieldname());
    					
    				}
    				
    				}
					
    			}
    				
    				
    		} */
    		
          if((null != reportjs) && !(reportjs.isEmpty())) {
    			
    			StudentField fieldjs = null;
    			String[] sf = null;
    			for(int y = 0 ; y < reportjs.size() ; y++) {
    			for(int i = 0 ; i < studentent.size() ; i++)
    			{
    				      		    
    		      
    		    	  if(studentent.get(i).getTablekey() == reportjs.get(y).getTabletwopk())
    		    	  {
    		    		  squery.append(" inner join "+studentent.get(i).getTablename());
    		    		  squery.append(" on "+studentent.get(i).getTablename()+"."+reportjs.get(y).getTabletwopk());
    		    	  }
    			}
    			     for(int i = 0 ; i < studentent.size() ; i++)
    			    {
    		    	  if(studentent.get(i).getTablekey() == reportjs.get(y).getTableonepk())
    		    	  {
    		    		 
    		    		  squery.append(" = "+studentent.get(i).getTablename()+"."+reportjs.get(y).getTabletwopk());
    		    	  }
    		      
    			      }
    			   }
    			}
          
        return squery.toString();
    	
    }

}
