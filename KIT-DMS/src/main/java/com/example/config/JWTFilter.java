package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.example.serviceimpl.TokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class JWTFilter extends GenericFilterBean {

    private TokenService tokenService;

    JWTFilter() {
        this.tokenService = new TokenService();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String token = request.getHeader("Authorization");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.sendError(HttpServletResponse.SC_OK, "success");
            return;
        }

        if (allowRequestWithoutToken(request)) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(req, res);
        } else {
            if (token != null && !tokenService.isTokenValid(token)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }if(token == null){
            	response.setStatus(HttpServletResponse.SC_OK);
                filterChain.doFilter(req, res);
            }
            else {
                //ObjectId userId = new ObjectId(tokenService.getUserIdFromToken(token));
            	Object userId = tokenService.getUserIdFromToken(token);
                request.setAttribute("userId", userId);
                filterChain.doFilter(req, res);

            }
        }

    }

    public boolean allowRequestWithoutToken(HttpServletRequest request) {
        //System.out.println(request.getRequestURI());
        if (request.getRequestURI().contains("/verifyImei")|| request.getRequestURI().contains("/validateUser")||request.getRequestURI().contains("/authentication")) {
            return true;
        }else if(request.getRequestURI().contains("/login")|| request.getRequestURI().contains("/setPassword")) {
        	 return true;
        } else if (request.getRequestURI().contains("/WEB-INF")
        		|| request.getRequestURI().contains("/css") || request.getRequestURI().contains("/fonts")
        		|| request.getRequestURI().contains("/images") || request.getRequestURI().contains("/js")
        		|| request.getRequestURI().contains("/favicon.ico") || request.getRequestURI().contains("/ajaxJs")
        		|| request.getRequestURI().contains("/functionJs") || request.getRequestURI().contains("/configJs")
        		|| request.getRequestURI().contains("/login") || request.getRequestURI().contains("/hubsListView")
        		|| request.getRequestURI().contains("/createHubView") || request.getRequestURI().contains("/hubView")
        		|| request.getRequestURI().contains("/editHubView") || request.getRequestURI().contains("/userListView")
        		|| request.getRequestURI().contains("/createUserView") || request.getRequestURI().contains("/userView")
        		|| request.getRequestURI().contains("/editUserView") || request.getRequestURI().contains("/leaveListView")
        		|| request.getRequestURI().contains("/createLeaveView") || request.getRequestURI().contains("/feAttendanceListView")
        		|| request.getRequestURI().contains("/supervisorAttendanceListView") || request.getRequestURI().contains("/feAttendanceView")
        		|| request.getRequestURI().contains("/feUserListView") || request.getRequestURI().contains("/supervisorUserListView")
        		|| request.getRequestURI().contains("/supervisorAttendanceView") || request.getRequestURI().contains("/supervisorHubAttendanceView")
        		|| request.getRequestURI().contains("/editLeaveTypeview") 
        		//|| request.getRequestURI().contains("/dashboardView")
        		|| request.getRequestURI().contains("/feDashboard") || request.getRequestURI().contains("/supervisorDashboard")
        		|| request.getRequestURI().contains("/userTracker")
        		|| request.getRequestURI().contains("/dashboard") || request.getRequestURI().contains("/transferUser")
        		|| request.getRequestURI().contains("/adminLogin") || request.getRequestURI().contains("/getHubDetails")
        		|| request.getRequestURI().contains("/getHubsByState") || request.getRequestURI().contains("/getStates"))
        		{
        	return true;
        }
        return false;
    }
}