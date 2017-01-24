package com.venkat.bal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.venkat.dal.Dal;
import com.venkat.dal.DalInterface;
import com.venkat.model.OrderData;

public class BusinessLogic implements BusinessLogicInterface {
	private DalInterface dal;
	
	public BusinessLogic(DalInterface dal){
		this.dal = dal;
	}

    /**
     * 
     * @throws IOException
     */
	@Override
    public void operateData(String inFilePath, String outFilePath) {
		//this.dal = new Dal(inFilePath, outFilePath);
    	//read data from input file
    	List<OrderData> orderList = this.dal.readFileData(inFilePath, outFilePath);
    	//sort and arrange the data based on date
        Collections.sort(orderList, orderDataSort);
        List<String> recordList = new ArrayList<String>();
        recordList = this.getOutputList(orderList);
        //write data to output file
        this.dal.writeFileData(recordList, outFilePath);
    }
    
    
    /**
     * comparator for sorting OrderData based on time Lexicographically
     */
    private static Comparator<OrderData> orderDataSort = new Comparator<OrderData>() {
    
    	@Override
    	public int compare(OrderData o1, OrderData o2) {
    		return Long.compare(o1.getEpochTime(), o2.getEpochTime());
    	}
    };
    
    
    /**
     * returns a list of records with human readable strings to be written to a output file
     * @param orderDataList
     * @return
     */
    
    @Override
    public List<String> getOutputList(List<OrderData> orderDataList) {       
        List<String> list = new ArrayList<String>();
        if (orderDataList != null) {
            for (OrderData orderData : orderDataList) {
                String date = convertToReadableDate(orderData.getEpochTime());
                list.add(orderData.getPizzaType() + "\t" + date);
            }
        }
        return list;
    }
    
    
    /**
     * converts the Epoch time (i.e., 1474295087) to Java Date (Mon, 19 Sep 2016 14:24:47 GMT)
     * @param epochTime
     * @return
     */
    public static String convertToReadableDate(long epochTime) {
        Date date = new Date(epochTime * 1000L);
        DateFormat format = new SimpleDateFormat("EEE, MMM d, ''yy h:mm a");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String dateString = format.format(date);        
        return dateString;
    }
    
    
    
}
