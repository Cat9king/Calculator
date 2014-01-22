package com.calculator.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.calculator.model.Expression;

@RunWith(MockitoJUnitRunner.class)
public class AdditionOperationStrategy_Test {
	
	@Mock
	AdditionOperationStrategy addStrategy;
	
	@Before
	public void setup(){
		addStrategy = new AdditionOperationStrategy();
	}
	
	
	@Test
	public void WhenBothOperandsAreNotEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("25");
		exp.setRightOperand("30");
		
		BigDecimal result = addStrategy.calculate(exp);
		assertEquals(new BigDecimal(55), result);
		
	}
	
	@Test
	public void WhenOneOperandIsEmpty(){	
		
		Expression exp = new Expression();
		exp.setLeftOperand("25");
		exp.setRightOperand("");
		
		BigDecimal result = addStrategy.calculate(exp);
		assertNull(result);
		
	}

}
