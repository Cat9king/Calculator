var expression ={"leftOperand": null, "rightOperand": null, "operator": null};
var input = '';
var opFlag = false;
var entireCalc = '';
$(function(){	
	
	
	$(".button").click(function(){
		
		if(opFlag){
			input = '';
			$("#numInput").val('');
			opFlag = false;
		}
		
		var num = $(this).val();		
		input = input.concat(num);		
		$("#numInput").val(input);
		
	});
	
	$(".buttonCalc").click(function(){
		
		var op = $(this).val();		
		var newOpFlag = false;
		
		setOperandValue();
		
		if(expression.operator == null){
			expression.operator = op;
			addToCalcStr(op);
		}else{
			newOpFlag = true;
		}		
		
		if(expression.leftOperand != null && expression.operator != null && expression.rightOperand != null){
			calculate();
			if(newOpFlag){
				expression.operator = op;
				addToCalcStr(op);
			}
		}
		
		opFlag = true;
		
	});	
	
	$("#buttonEqual").click(function(){
		
		if(entireCalc != ''){
			var eq = $(this).val();
			setOperandValue();		
					
			if(expression.leftOperand != null && expression.operator != null && expression.rightOperand != null){
				calculate();
				addToCalcStr(eq);
				var input = $("#numInput").val();
				addToCalcStr(input);
							
				var log = $("input[name='logRadio']:checked").val();
				if(log == "1" && entireCalc != ''){
					saveCalculation();
				}
				
				reset();
			}
		}
				
	});
	
	$("#buttonClear").click(function(){		
		reset();	
		$("#numInput").val('');
	});
	
	$("input[name='logRadio']").on("change", function () {
	    var log = $(this).val();	    
	    if(log == "1"){
	    	$("#log").show();
	    }else{
	    	$("#log").hide();
	    }
	});
	
	
	
});

var addToCalcStr = function(val){	
	entireCalc = entireCalc + val;
};

var setOperandValue = function(){
	
	var input = $("#numInput").val();
	
	if(input != ''){	
		if(expression.leftOperand == null){
			expression.leftOperand = input;
			addToCalcStr(input);
		}else if(expression.rightOperand == null){
			expression.rightOperand = input;
			addToCalcStr(input);
		}
	}
};

var calculate = function(){
		
	$.ajax({ 
		url: "/Calculator/calculate", 
		type:"GET",	
		data: {
			"leftOperand": expression.leftOperand,
			"rightOperand": expression.rightOperand,
			"operator": expression.operator			
		},
		contentType:"application/json; charset=utf-8",
		async: false,
		success: function(data){		    	
			if (data != null){
				expression.leftOperand = data;
				expression.rightOperand = null;					
				$("#numInput").val(data);
			} else {
				
			}				
		}
		
	}); 	
};

var saveCalculation = function(){	
	
	$.ajax({ 
		url: "/Calculator/calculate/save", 
		type:"GET",	
		data: { "value": JSON.stringify(entireCalc) },
		contentType:"application/json; charset=utf-8",			
		async: false,
		success: function(data){		    	
			if (data != null){
				var log = data.join("\n");				
				$("#logTextArea").val(log);
			} else {
				
			}				
		}
	}); 	
};

var reset = function(){
	input = '';
	entireCalc = '';
	expression.leftOperand = null;
	expression.rightOperand = null;
	expression.operator = null;
	opflag = false;	
};




