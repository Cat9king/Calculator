package com.calculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.calculator.model.Expression;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public String calculateExpression(Expression expression) {
		
		String operator = expression.getOperator();
		OperationStrategy opStrat = OperationStrategyFactory.getStrategy(operator);
		BigDecimal result = opStrat.calculate(expression);	
		
		if(result == null){
			return null;
		}
		
		return result.toString();
	}

}
