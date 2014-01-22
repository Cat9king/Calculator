package com.calculator.service;

import java.math.BigDecimal;

import com.calculator.model.Expression;

public class AdditionOperationStrategy implements OperationStrategy {

	@Override
	public BigDecimal calculate(Expression expression) {
		BigDecimal leftOperand = expression.getLeftValue();
		BigDecimal rightOperand = expression.getRightValue();
		
		if(leftOperand == null || rightOperand == null){
			return null;
		}
		
		BigDecimal result = leftOperand.add(rightOperand);		
		return result;
	}

}
