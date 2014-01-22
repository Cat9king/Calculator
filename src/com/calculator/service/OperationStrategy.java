package com.calculator.service;

import java.math.BigDecimal;

import com.calculator.model.Expression;

public interface OperationStrategy {
	
	public BigDecimal calculate(Expression expression);

}
