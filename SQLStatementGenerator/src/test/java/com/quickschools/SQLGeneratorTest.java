/**
 * 
 */
package com.quickschools;

/**
 * @author Admin
 *
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import com.quickschools.*;
public class SQLGeneratorTest {

	/**
	 * 
	 */
	 
	 SQLGenerator sqg = null;
	 
	public SQLGeneratorTest() {
		// TODO Auto-generated constructor stub
		sqg = new SQLGenerator();
	}
	
	@BeforeClass
    public static void initEntities() {
		
       
    }
 
    @Before
    public void beforeEachTest() {
        System.out.println("The Test is going to execute");
    }
 
    @After
    public void afterEachTest() {
        System.out.println("This test is successfully completed");
    }
 
    @Test
    public  void testSqlGenerator() {
    	try {
      //  String sql = null;
        StudentField s1 = new StudentField("name","Student","String");
        StudentField s3 = new StudentField("email","Student","String");
        StudentField s2 = new StudentField("gradevalue","Grade","Long");
        StudentJoins sj = new StudentJoins("studid","gradeid"); 
       
       // SQLGenerator sqg = new SQLGenerator();
       
        List<StudentField> asf = new ArrayList<StudentField>();
        List<StudentJoins> asj = new ArrayList<StudentJoins>();
        asf.add(s1);
        asf.add(s2);
        asf.add(s3);
        asj.add(sj);
       String sql = sqg.generate(asf, asj);
       System.out.println("value of sql"+sql);
       Assert.assertNotNull(sql);
       
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
 
  
 
    @Test(expected = GeneratorException.class)
    public void testDivisionException() throws Exception {
    	//SQLGenerator sqg = new SQLGenerator();
    	sqg.generate(null, null);
    }
 
   
 
}
