package com.trivago.execution;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.trivago.SuiteTest.Practice;

public class TestRunner {
	   public static void main(String[] args) {
		   
	      Result result = JUnitCore.runClasses(Practice.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println("There are test failures: " + failure.toString());
	      }
	      System.out.println(result.wasSuccessful() + "No test failures");
	   }
	}  	
