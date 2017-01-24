package com.venkat.dal;

import java.util.List;

import com.venkat.model.OrderData;

public interface DalInterface {
	public List<OrderData> readFileData(String inFilePath, String outFilePath);
	public void writeFileData(List<String> records, String outFilePath);
}
