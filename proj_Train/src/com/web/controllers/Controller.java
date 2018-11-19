package com.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String doController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;	
}