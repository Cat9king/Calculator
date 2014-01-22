package com.calculator.service;

public class OperationStrategyFactory {
	
	public static OperationStrategy getStrategy(String operator){
		
		if("+".equals(operator)){
			return new AdditionOperationStrategy();
		}else if("-".equals(operator)){
			return new SubtractionOperationStrategy();
		}else if("*".equals(operator)){
			return new MultiplyOperationStrategy();
		}else if("/".equals(operator)){
			return new DivideOperationStrategy();
		}else{
			return null;
		}		
	}

}
