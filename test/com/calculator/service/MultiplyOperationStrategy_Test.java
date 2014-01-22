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
public class MultiplyOperationStrategy_Test {
	
	@Mock
	MultiplyOperationStrategy multiStrategy;
	
	@Before
	public void setup(){
		multiStrategy = new MultiplyOperationStrategy();
	}
	
	@Test
	public void WhenBothOperandsAreNotEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("8");
		exp.setRightOperand("5");
		
		BigDecimal result = multiStrategy.calculate(exp);
		assertEquals(new BigDecimal(40), result);
		
	}
	
	@Test
	public void WhenOneOperandIsEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("20");
		exp.setRightOperand("");
		
		BigDecimal result = multiStrategy.calculate(exp);
		assertNull(result);
		
	}

}
