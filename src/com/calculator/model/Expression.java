package com.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class Expression implements Serializable{	
	
	private static final long serialVersionUID = -8484646306541324726L;
	
	private String leftOperand;
	private String rightOperand;
	private String operator;		
	
	public String getLeftOperand() {
		return leftOperand;
	}
	public void setLeftOperand(String leftOperand) {
		this.leftOperand = leftOperand;
	}
	public String getRightOperand() {
		return rightOperand;
	}
	public void setRightOperand(String rightOperand) {
		this.rightOperand = rightOperand;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public BigDecimal getLeftValue(){
		if(!StringUtils.isEmpty(this.leftOperand)){
			return new BigDecimal(this.leftOperand);
		}
		return null;
	}
	
	public BigDecimal getRightValue(){
		if(!StringUtils.isEmpty(this.rightOperand)){
			return new BigDecimal(this.rightOperand);
		}
		return null;
	}
}
