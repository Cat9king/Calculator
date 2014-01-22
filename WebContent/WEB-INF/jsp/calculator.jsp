<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/general.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/calculator.js"></script>
    <title>Calculator</title>
</head>
<body>
	<h2>
    ${message}
 	</h2>   
 	<div class="left">
    <table>
    	<tr>
	    	<td colspan="4">
	    		<input type="text" size="30" id="numInput" disabled="disabled" class="disabled"/>
	    	</td>
    	</tr>
    	<tr>
	    	<td colspan="3">
	    		Log Calcs<input type="radio" name="logRadio" value="1"> On
	    		   <input type="radio" name="logRadio" value="0" checked="checked"> Off
	    	</td>	    	
	    	<td>
	    		<input type="button" id="buttonClear" class="buttonAction" value="C">
	    	</td>
    	</tr>
    	<tr>
    		<td>
    			<input type="button" class="button" value="7">
    		</td>
    		<td>
    			<input type="button" class="button" value="8">
    		</td>
    		<td>
    			<input type="button" class="button" value="9">
    		</td>
    		<td>
    			<input type="button" class="buttonCalc buttonAction" value="/">
    		</td>    		
    	</tr>
    	<tr>
    		<td>
    			<input type="button" class="button" value="4">
    		</td>
    		<td>
    			<input type="button" class="button" value="5">
    		</td>
    		<td>
    			<input type="button" class="button" value="6">
    		</td>
    		<td>
    			<input type="button" class="buttonCalc buttonAction" value="*">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input type="button" class="button" value="1">
    		</td>
    		<td>
    			<input type="button" class="button" value="2">
    		</td>
    		<td>
    			<input type="button" class="button" value="3">
    		</td>
    		<td>
    			<input type="button" class="buttonCalc buttonAction" value="-">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input type="button" class="button" value="0">
    		</td>
    		<td>
    			<input type="button" class="button" value=".">
    		</td>
    		<td>
    			<input type="button" id="buttonEqual" class="buttonAction" value="=">
    		</td>
    		<td>
    			<input type="button" class="buttonCalc buttonAction" value="+">    			
    		</td>
    	</tr>   
    </table>    
    </div>
    <div class="left" id="log" style="display:none;">
	    <div style="vertical-align: top;">
	     Calculation Log
	     </div>
     <textarea rows="20" cols="30" id="logTextArea"></textarea>
    </div>
    <br class="clearBoth" />
</body>
</html>