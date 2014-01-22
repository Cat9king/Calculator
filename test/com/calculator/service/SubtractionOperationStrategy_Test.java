package com.calculator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.calculator.model.Expression;


@RunWith(MockitoJUnitRunner.class)
public class SubtractionOperationStrategy_Test {
	
	@Mock
	SubtractionOperationStrategy subStrategy;
	
	@Before
	public void setup(){
		subStrategy = new SubtractionOperationStrategy();
	}
	
	@Test
	public void WhenBothOperandsAreNotEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("8");
		exp.setRightOperand("5");
		
		BigDecimal result = subStrategy.calculate(exp);
		assertEquals(new BigDecimal(3), result);
		
	}
	
	@Test
	public void WhenOneOperandIsEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("20");
		exp.setRightOperand("");
		
		BigDecimal result = subStrategy.calculate(exp);
		assertNull(result);
		
	}
	
	@Test
	public void WhenRightOperandIsLargerThanTheLeft(){
		
		Expression exp = new Expression();
		exp.setLeftOperand("13");
		exp.setRightOperand("63");
		
		BigDecimal result = subStrategy.calculate(exp);
		assertEquals(new BigDecimal(-50), result);
		
	}

}
