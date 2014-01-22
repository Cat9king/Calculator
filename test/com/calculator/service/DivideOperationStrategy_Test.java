package com.calculator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.calculator.model.Expression;

@RunWith(MockitoJUnitRunner.class)
public class DivideOperationStrategy_Test {

	@Mock
	DivideOperationStrategy divStrategy;
	
	@Before
	public void setup(){
		divStrategy = new DivideOperationStrategy();
	}	
	
	@Test
	public void WhenPrecisionOutFivePlaces(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("25");
		exp.setRightOperand("30");
		
		BigDecimal result = divStrategy.calculate(exp);
		assertEquals(new BigDecimal(0.83333).setScale(5, RoundingMode.HALF_UP), result);
		
	}
	
	@Test
	public void WhenOneOperandIsEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("25");
		exp.setRightOperand("");
		
		BigDecimal result = divStrategy.calculate(exp);
		assertNull(result);
		
	}
	
	@Test
	public void WhenRightOperandIsZero(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("25");
		exp.setRightOperand("0");
		
		BigDecimal result = divStrategy.calculate(exp);
		assertNull(result);
		
	}
}
