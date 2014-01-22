package com.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.calculator.model.Calculation;
import com.calculator.model.Expression;
import com.calculator.service.CalculatorService;
import com.calculator.service.LoggerService;

@Controller
public class CalculatorController {	
	
	@Autowired
	private CalculatorService calculatorService;	
	
	@Autowired	
	private LoggerService loggerService;
	
	@RequestMapping("/home")
    public ModelAndView calculator() { 
        String message = "My Calculator";
        return new ModelAndView("calculator", "message", message);
	}	
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getCalculation(Expression expression){		
		String result = calculatorService.calculateExpression(expression);			
		return result;
	}	
	
	//This should be a post but I'm missing a config setting or jar
	@RequestMapping(value = "/calculate/save",  method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String saveCalculation(Calculation calculation){		
		loggerService.write(calculation.getValue());
		List<String> log = loggerService.read();
		return log.toString();
	}		
	
}
