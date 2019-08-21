<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<link rel=stylesheet type="text/css" href="jsp/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script type="text/javascript">

var dateList = [];
var stepsList = [];
<c:forEach items="${employee}" var="listItem">
  var arr_date = [];
  var arr_steps = [];
  arr_date.push("<c:out value="${listItem.exercise_date}" />");
  dateList.push(arr_date);
  arr_steps.push("<c:out value="${listItem.step}" />");
  stepsList.push(parseInt(arr_steps));  
</c:forEach>

var chart;

$(function () {
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
            //取得div容器的id
                renderTo: 'userSteps',
                zoomType: 'xy',
                //折線圖
                type: 'line',
                //右方間距
                marginRight: 130,
                //下方間距
                marginBottom: 100
            },
			  title: {
  			    "text": '會員每日步數',
  			  },
  			  subtitle: {
  			    "text": '每日步數',
  			  },
  			  xAxis: {
  			        categories: dateList,
                		title: {
	                	//X軸表頭
	                  	  text: '日期'
	                	},
  			    },
  	          yAxis: {
  	                title: {
  	                //Y軸表頭
  	                    text: '步數'
  	                },
  	            },
  			  series: [{
  			       data:stepsList
  			    }],
  			  legend: {
  			        "enabled": false
  			      },
        });
    });
  
});

</script>
<title><spring:message code="viewUser_title" /></title>
</head>
<body>
<div id="userSteps"> </div>
	<table>
	<thead>
	<tr>
		<th><spring:message code="viewUser_ID" /></th>
		<th><spring:message code="viewUser_JobGrade" /></th>
		<th><spring:message code="viewUser_JobPosition" /></th>
		<th><spring:message code="viewUser_WorkShift" /></th>	
	</tr>
	</thead>
	<tr>
		<td>${ID}</td> 
		<td>${Job_grade}</td> 
		<td>${Job_position}</td>
		<td>${Work_shift}</td>
	</tr>	
	</table>
	<table>
	<thead>
	<tr>
		<th><spring:message code="viewUser_ExerciseDate" /></th>
		<th><spring:message code="viewUser_ExerciseWeek" /></th>
		<th><spring:message code="viewUser_Steps" /></th>
	</tr>
	</thead>	
	<tbody>
	   <c:forEach var="list" items="${employee}">   
	   <tr>
	   <td>${list.exercise_date}</td> 
	   <td>${list.exercise_week}</td> 
	   <td>${list.step}</td> 
	   </tr>
	   </c:forEach>    	
	</tbody>
	</table> 
</body>
</html>