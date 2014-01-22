package com.calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.calculator.model.Expression;

public class DivideOperationStrategy implements OperationStrategy {

	@Override
	public BigDecimal calculate(Expression expression) {
		BigDecimal leftOperand = expression.getLeftValue();
		BigDecimal rightOperand = expression.getRightValue();
		
		if(leftOperand == null || rightOperand == null || rightOperand.compareTo(new BigDecimal(0)) == 0){
			return null;
		}
		
		BigDecimal result = leftOperand.divide(rightOperand, 5, RoundingMode.HALF_UP);
		
		return result;
	}

}
