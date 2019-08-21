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
<title><spring:message code="viewChart_title" /></title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script type="text/javascript">

var Avg_Employee = <c:out value="${Avg_Employee}"/>;
var Avg_Boss = <c:out value="${Avg_Boss}"/>;
var Avg_NoShift = <c:out value="${Avg_NoShift}"/>;
var Avg_Shift = <c:out value="${Avg_Shift}"/>;
var Percent1 = <c:out value="${Percent1}"/>;
var Percent2 = <c:out value="${Percent2}"/>;
var Percent3 = <c:out value="${Percent3}"/>;
var Percent4 = <c:out value="${Percent4}"/>;

var top50List_ID = [];
var top50List_step = [];
<c:forEach items="${Top50}" var="listItem">
  var arr_id = [];
  var arr_steps = [];
  arr_id.push("<c:out value="${listItem.id}" />");
  top50List_ID.push(arr_id);
  arr_steps.push("<c:out value="${listItem.step}" />");
  top50List_step.push(parseInt(arr_steps));  
</c:forEach>

$(function () {
    var chart1, chart2, chart3, test;
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
        				  	name: "平均步數",
        			        data: [Avg_Employee, Avg_Boss]
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
            			  	name: "平均步數",
        			        data: [Avg_NoShift, Avg_Shift]
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
        			        name: '百分比',
        			        colorByPoint: true,
        			        data: [{
        			            name: '小於5000',
        			            y: Percent1
        			        }, {
        			            name: '5001~7500',
        			            y: Percent2
        			        }, {
        			            name: '7501~10000',
        			            y: Percent3
        			        }, {
        			            name: '大於10001',
        			            y: Percent4
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
        test = new Highcharts.Chart(
        		{
                      chart: {
                        //取得div容器的id
                            renderTo: 'testtest',
                            zoomType: 'xy',
                            //折線圖
                            type: 'column',
                        },            		
        			  title: {
        			    "text": 'Top 50 會員平均步數排名',
        			  },
        			  subtitle: {
        			    "text": '平均步數排名',
        			  },
        			  xAxis: {
        			        categories: ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34','35','36','37','38','39','40','41','42','43','44','45','46','47','48','49','50'],
  	                		title: {
    	                	//X軸表頭
    	                  	  text: '名次'
    	                	},
        			    },
        	          yAxis: {
        	                title: {
        	                //Y軸表頭
        	                    text: '平均步數'
        	                },
        	                
        	            },
        			  series: [{
            			  	name: "平均步數",
        			        data: top50List_step
        			    }],
        			  legend: {
        			        "enabled": false
        			      },
 
});
});
});
</script>
</head>
<body>
	<spring:message code="page.cl" /><br>
	<a href="?lang=en">English</a>
	<a href="?lang=zh_TW">繁體中文</a>
	<a href="?lang=zh_CN">简体中文</a>
<div id="steps_grade"></div><br>
<div id="steps_work_shift"></div><br>
<div id="brand"></div><br>
<div id="testtest"></div><br>
	<h1><spring:message code="viewChart_ChooseUser"/></h1>

	<table>
	<tbody>
	   <c:forEach var="list" items="${employeelist}">   
	   <tr>  
	   <td>${list.id}</td>  
	   <td><a href="viewUser?id=${list.id}"><spring:message code="viewChart_viewUser"/></a></td>
	   </tr>
	   </c:forEach>    	
	</tbody>
	</table>
</body>
</html>