package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.sql.*;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	private static String password = "admin123"; // Security: Hardcoded password
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		// Code smell: Unused variable
		int unusedVar = 10;
		
		// Bug: Potential null pointer
		String name = null;
		System.out.println(name.length()); // Will throw NullPointerException
	}
	
	// Security vulnerability: SQL Injection
	@GetMapping("/search")
	public String search(@RequestParam String query) {
		String sql = "SELECT * FROM users WHERE name = '" + query + "'";
		return executeQuery(sql);
	}
	
	// Bug: Resource leak - Connection not closed
	public String executeQuery(String query) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs.toString();
		} catch (Exception e) {
			e.printStackTrace(); // Code smell: Should use logger
			return null;
		}
	}
	
	// Code smell: High complexity, code duplication, magic numbers
	@GetMapping("/discount")
	public double calculateDiscount(@RequestParam String type, @RequestParam double price) {
		if (type.equals("GOLD")) {
			double discount = price * 0.2;
			return price - discount;
		} else if (type.equals("SILVER")) {
			double discount = price * 0.15;
			return price - discount;
		} else if (type.equals("BRONZE")) {
			double discount = price * 0.1;
			return price - discount;
		} else {
			return price;
		}
	}
	
	// Code smell: Empty catch block
	@GetMapping("/process")
	public String process(@RequestParam String data) {
		try {
			return data.toUpperCase();
		} catch (Exception e) {
			// Empty catch - code smell
		}
		return "";
	}
}