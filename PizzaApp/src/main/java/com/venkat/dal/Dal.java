package com.venkat.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.venkat.model.OrderData;

public class Dal implements DalInterface {
	
	
	public Dal() {
		
	}
	

	/**
     * Reads from a text file them stores in OrderData model class object
     * @param file
     * @return
     * @throws Exception
     */
	@Override
	public List<OrderData> readFileData(String inFilePath, String outFilePath) {
		List<OrderData> orderList = new ArrayList<OrderData>();
        File file = new File(inFilePath);
        if (!file.exists()) {
            return orderList;
        }
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
	        //skipping first line
	        line = reader.readLine();
	        while (line != null) {
	            String[] splited = line.split("\\s+");
	            
	            if (splited.length > 1) {
	                OrderData data = new OrderData();
	                data.setPizzaType(splited[0]);
	                data.setEpochTime(Long.parseLong(splited[1]));
	                orderList.add(data);
	            }
	            line = reader.readLine();
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Collections.sort(orderList, orderDataSort);
        return orderList;
	}
	
	/**
     * this method writes to an external file
     * @throws IOException
     */
	@Override
	public void writeFileData(List<String> records, String outFilePath) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(outFilePath);
			for(String record: records){
	    		writer.write(record.toString());
	    		writer.write(System.lineSeparator());
	    		System.out.println(record.toString());
	    	}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
