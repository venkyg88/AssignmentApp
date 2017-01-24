/*package com.venkat.java;

import java.io.File;
import java.util.List;
import junit.framework.TestCase;

import java.util.ArrayList;

public class AppTest extends TestCase{
    
    private List<OrderData> orderList = new ArrayList<OrderData>();
    
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
    }
    
   
}*/

