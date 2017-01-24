package com.venkat.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.venkat.bal.BusinessLogic;
import com.venkat.dal.Dal;
import com.venkat.model.OrderData;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AppTest extends TestCase{
	private Dal dal;
	private BusinessLogic bl;
	private List<OrderData> listData;
	private OrderData data;
	private List<String> records;
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Override
	protected void setUp() throws Exception {
		dal = new Dal();
		bl = new BusinessLogic(dal);
		
		/*listData = new ArrayList<OrderData>();
		data = new OrderData();
		data.setEpochTime(1506176687);
		data.setPizzaType("Meat");
		listData.add(data);
		
		//adding records to list
		records.add("Meat 123232323");
		records.add("veg 12321321");
		records.add("veg 15789239");*/
		
	}
	
	/*@Test
	public void checkTheOutputList() throws Exception {		
		
		//assertEquals(2,bl.getOutputList(listData).size());
	}*/
	
	
	@Test
	public void testForFalseDate(){
        String desired = "Mon, Sep 09, '16 09:04 PM";
        String expected = BusinessLogic.convertToReadableDate(1232123);
        assertFalse(desired.equals(expected));
    }
	
	@Test
	public void testForCorrectDate() {
        String desired = "Mon, Sep 19, '16 2:24 PM";
        String expected = BusinessLogic.convertToReadableDate(1474295087);
        assertEquals(desired, expected);
    }
	
	/*@Test
	public void testReadInputFile() throws Exception {
		File file = folder.newFile("testFile.txt");
		
		//populate the file
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			for(String record: records){
	    		writer.write(record.toString());
	    		writer.write(System.lineSeparator());
	    	}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//run your test
		assertTrue(file.length() > 0);
	} */
	
	
	
	//Arrange
	
	//Act
	
	//Assert
    
    /*private List<OrderData> orderList = new ArrayList<OrderData>();
    
    public void testOutputDate() {
        String desired = "Mon, Sep 19, '16 2:24 PM";
        String expected = App.convertToReadableDate(1474295087);
        assertEquals(desired, expected);
    }
    
    
    public void testForDate(){
        String desired = "Mon, Sep 09, '16 09:04 PM";
        String expected = App.convertToReadableDate(56);
        assertFalse(desired.equals(expected));
    }
    
    public void test() throws Exception {
        final File file = new File("/Users/venkat/Documents/workspace/assignmentApp/PizzaApp/src/test_file.txt");
        List<OrderData> value = new ArrayList<OrderData>();
        value = App.readLinesAndSort(file);
        boolean flag = value.equals(orderList);
        assertEquals(false, flag); 
    }
    
   
    *//**
     * we can create and pass a record with Epoch time as input and expect readable date in the output
     * desired input: 1506176687
     * expected output: Sat, Sep 23, '17 2:24 PM
     *//*
    public void testForOutputList() {	
    	long time = 1506176687;
    	OrderData order = new OrderData();
    	order.setEpochTime(time);
    	order.setPizzaType("Meat");
        orderList.add(order);
        String row = App.getOutputList(orderList).get(0).toString();
        String[] splited = row.split("\\s+");
        assertEquals("Sat, Sep 23, '17 2:24 PM", splited[1]);
    }*/
    
   
}
