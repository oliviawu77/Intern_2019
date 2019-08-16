<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet type="text/css" href="jsp/style.css">
<title><spring:message code="welcome_title" /></title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart1 = new Highcharts.Chart(
        		{
                      chart: {
                        //取得div容器的id
                            renderTo: 'steps_grade',
                            zoomType: 'xy',
                            //折線圖
                            type: 'column',
                        },            		
        			  title: {
        			    "text": '一般員工與主管平均步數',
        			  },
        			  subtitle: {
        			    "text": '平均步數',
        			  },
        			  xAxis: {
        			        categories: ['員工', '主管'],
  	                		title: {
    	                	//X軸表頭
    	                  	  text: '職務'
    	                	},
        			    },
        	          yAxis: {
        	                title: {
        	                //Y軸表頭
        	                    text: '步數'
        	                },
        	                
        	            },
        			  series: [{
        			        data: [400, 200]
        			    }],
        			  legend: {
        			        "enabled": false
        			      },
 
});
        chart2 = new Highcharts.Chart(
        		{
                      chart: {
                        //取得div容器的id
                            renderTo: 'steps_work_shift',
                            zoomType: 'xy',
                            //折線圖
                            type: 'column',
                        },            		
        			  title: {
        			    "text": '一般上下班與輪班制平均步數',
        			  },
        			  subtitle: {
        			    "text": '平均步數',
        			  },
        			  xAxis: {
        			        categories: ['一般上下班', '輪班制'],
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
        			        data: [200, 300]
        			    }],
        			  legend: {
        			        "enabled": false
        			      },
 
});
        chart3 = new Highcharts.Chart(
        		{
                      chart: {
                        //取得div容器的id
                            renderTo: 'brand',
                            //折線圖
                            type: 'pie',
                        },            		
        			  title: {
        			    "text": '會員平均步數',
        			  },
        			  subtitle: {
        			    "text": '平均步數',
        			  },
        			   series: [{
        			        name: 'Brands',
        			        colorByPoint: true,
        			        data: [{
        			            name: '小於5000',
        			            y: 25
        			        }, {
        			            name: '5001~7500',
        			            y: 25
        			        }, {
        			            name: '7501~10000',
        			            y: 30
        			        }, {
        			            name: '大於10001',
        			            y: 20
        			        }]
        			    }],
        			  tooltip: {
        			    "pointFormat": "{series.name}: <b>{point.percentage:.1f}%</b>"
        			    },
        			  plotOptions: {
        			    	    pie: {
        			    	      "allowPointSelect": true,
        			    	      "cursor": "pointer",
        			    	      "dataLabels": {
        			    	        "enabled": true,
        			    	        "format": "<b>{point.name}</b>: {point.percentage:.1f} %",
        			    	        "style": {
        			    	         "color": "black"
        			    	        }
        			    	      }
        			    	    },
        			  },
 
});        
});
});
</script>
</head>
<body>
<div id="steps_grade"></div><br>
<div id="steps_work_shift"></div><br>
<div id="brand"> </div><br>
	<h1>請選擇使用者</h1>

	<table>
	<tbody>
	   <c:forEach var="list" items="${employeelist}">   
	   <tr>  
	   <td>${list.id}</td>  
	   <td><a href="viewUser?id=${list.id}">閱讀圖表</a></td>
	   </tr>
	   </c:forEach>    	
	</tbody>
	</table>
</body>
</html>