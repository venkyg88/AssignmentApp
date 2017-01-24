package com.venkat.bal;

import java.util.List;

import com.venkat.model.OrderData;

public interface BusinessLogicInterface {
	//public void operateData(String inFilePath, String outFilePath);
	public List<String> getOutputList(List<OrderData> orderDataList);
	public void operateData(String inFilePath, String outFilePath);
}
