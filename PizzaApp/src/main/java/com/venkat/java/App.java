package com.venkat.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import com.venkat.bal.BusinessLogic;
import com.venkat.bal.BusinessLogicInterface;
import com.venkat.dal.Dal;
import com.venkat.dal.DalInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class App {

	public static void main(String[] args) {
		String inFilePath = null;
		String outFilePath = null;
		try {
			if (args != null && args.length == 2){
				inFilePath = args[0];
				outFilePath = args[1];
				DalInterface dal = new Dal();
				BusinessLogicInterface bl = new BusinessLogic(dal);
				
				bl.operateData(inFilePath, outFilePath);
			} else {
				System.out.print("Please enter arguments, Please enter valid arguments");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
