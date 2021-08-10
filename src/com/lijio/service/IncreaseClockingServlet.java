package com.lijio.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijio.dao.DaoFactory;
import com.lijio.domain.ClockingTemplate;
import com.lijio.util.JsonUtil;

/**
 * 新增排班
 */
@WebServlet(name="increaseClocking",urlPatterns="/increaseClocking")
public class IncreaseClockingServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("HH:mm");
        
        String workTime=request.getParameter("workTime");
        String offWorkTime=request.getParameter("offWorkTime");
        
        PrintWriter outer=response.getWriter();
        
        try {
            ClockingTemplate clockingTemplate=new ClockingTemplate();
            clockingTemplate.setWorkTime(LocalTime.parse(workTime, dateTimeFormatter));
            clockingTemplate.setOffWorkTime(LocalTime.parse(offWorkTime, dateTimeFormatter));
            DaoFactory.getClockingTemplateDao().insert(clockingTemplate);
            outer.print(JsonUtil.commonResultCodeJson(0));
        } catch (Exception e) {
            e.printStackTrace();
            outer.print(JsonUtil.commonResultCodeJson(1));
        }
    }
}
