/**
 * 
 */
package com.quickschools;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Admin
 *
 */
public class SQLReportTest {
	
	SQLGenerator sqg = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		sqg = new SQLGenerator();
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
	 
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		sqg = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
