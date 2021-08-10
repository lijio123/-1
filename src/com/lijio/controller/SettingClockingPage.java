package com.lijio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijio.annotation.Immutable;
import com.lijio.domain.ClockingTemplate;
import com.lijio.domain.ClockingTemplateCache;

@WebServlet(name="settingClockingPage",urlPatterns="/settingClockingPage")
@Immutable
public class SettingClockingPage extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/settingClocking.jsp");
        ClockingTemplate clockingTemplate=ClockingTemplateCache.getInstance().getDefaultClocking();
        request.setAttribute("nowClocking",clockingTemplate);
        dispatcher.forward(request, response);
    }
}
