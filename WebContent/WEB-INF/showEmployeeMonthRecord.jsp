<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,com.lijio.domain.*,java.lang.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>学生考勤详细查看</title>
</head>  
<%! 
public List<AttendanceRecord> recordList;
public int year;
public int month;
public String employeeName; 
%>

<body>

<%
year=(Integer)request.getAttribute("year");
month=(Integer)request.getAttribute("month");
employeeName=(String)request.getAttribute("employeeName");
out.print("学生:"+employeeName+"   "+year+"年 "+month+"月        考勤详细时间表"); %>  <br/>  <br/>

<% 
recordList=(List<AttendanceRecord>)request.getAttribute("recordList");
for(AttendanceRecord oneRecord:recordList){
    out.print("日期:"+oneRecord.getClockingDate()+"<br/>"
            +"&nbsp;&nbsp;&nbsp;&nbsp;应该上课时间："+oneRecord.getShouldWorkTime()
            +"&nbsp;&nbsp;&nbsp;&nbsp;应该午休时间："+oneRecord.getShouldNoonBreakTime()
            +"&nbsp;&nbsp;&nbsp;&nbsp;应该下午上课时间："+oneRecord.getShouldAfternoonWorkTime()
            +"&nbsp;&nbsp;&nbsp;&nbsp;应该下课时间："+oneRecord.getShouldOffWorkTime()
            +"<br/>"
            +"&nbsp;&nbsp;&nbsp;&nbsp;实际上课时间："+oneRecord.getWorkTime()
            +"&nbsp;&nbsp;&nbsp;&nbsp;实际午休时间："+oneRecord.getNoonBreakTime()
            +"&nbsp;&nbsp;&nbsp;&nbsp;实际下午上课时间："+oneRecord.getAfternoonWorkTime()
            +"&nbsp;&nbsp;&nbsp;&nbsp;实际下课时间："+oneRecord.getOffWorkTime()
            +"<br/> <br/>");
}
%>


</body>  
</html>