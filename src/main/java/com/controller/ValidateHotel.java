package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Hotel;
import com.exception.DatabaseException;

import dao.HotelDao;

@WebServlet("/validateHotel")
public class ValidateHotel extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String city = req.getParameter("city");
		Date checkIn = Date.valueOf(req.getParameter("checkIn"));
		Date checkOut = Date.valueOf(req.getParameter("checkOut"));
		int numRoom = Integer.parseInt(req.getParameter("numRoom"));
		LocalDate now = LocalDate.now();
		Date nowDate = Date.valueOf(now);
		System.out.println("===========================");
		if(city == null|| numRoom <= 0 || checkIn.compareTo(checkOut) > 0 || checkIn.before(nowDate)){
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			req.getRequestDispatcher("Hotel.jsp").include(req, resp);
			out.println("Please enter valid information");
		} else {
			List<Hotel> hotals = new ArrayList<>();
			try {
				hotals = HotelDao.getHotel(city, checkIn, checkOut);
				req.setAttribute("list", hotals);
				req.getRequestDispatcher("/displayHotel.jsp").forward(req, resp);
			} catch (DatabaseException e) {
				req.setAttribute("error", e.getMessage());
				req.getRequestDispatcher("/Error.jsp").forward(req, resp);
			}
		}
		
		
	}
}
