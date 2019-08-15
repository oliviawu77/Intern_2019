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
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
            //取得div容器的id
                renderTo: 'test',
                zoomType: 'xy',
                //折線圖
                type: 'line',
                //右方間距
                marginRight: 130,
                //下方間距
                marginBottom: 25
            },
			  title: {
  			    "text": '會員每日步數',
  			  },
  			  subtitle: {
  			    "text": '每日步數',
  			  },
  			  xAxis: {
  			        categories: ['2019-07-01', '2019-07-02', '2019-07-03', '2019-07-04', '2019-07-05', '2019-07-06', '2019-07-07', '2019-07-08', '2019-07-09' ,'2019-07-10'],
                		title: {
	                	//X軸表頭
	                  	  text: '上班方式'
	                	},
  			    },
  	          yAxis: {
  	                title: {
  	                //Y軸表頭
  	                    text: '步數'
  	                },
  	            },
  			  series: [{
  			        data: [200, 300, 700, 1000, 2300, 500, 600, 1000, 230, 670]
  			    }],
  			  legend: {
  			        "enabled": false
  			      },
        });
    });
  
});
</script>
<title>折線圖</title>
</head>
<body>
<div id="test"> </div>
	<table>
	<thead>
	<tr>
		<th>會員代號</th>
		<th>職業等級</th>
		<th>職務類別</th>
		<th>工作型態</th>	
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
		<th>運動日期</th>
		<th>運動周期</th>
		<th>步數</th>
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