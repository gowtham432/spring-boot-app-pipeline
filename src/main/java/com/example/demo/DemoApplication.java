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
		
		// Call utility methods with issues
		String result = StringUtils.formatString(null, "Hello", "World", true, true, 10, "", false);
		System.out.println(result);
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
	
	// Using StringUtils - demonstrates calling utility class
	@GetMapping("/format")
	public String formatText(@RequestParam String text) {
		return StringUtils.formatString(text, "[", "]", true, true, 100, "", false);
	}
	
	@GetMapping("/validate")
	public boolean validateEmail(@RequestParam String email) {
		return StringUtils.validateInput(email, "email");
	}
	
	@GetMapping("/average")
	public double getAverage(@RequestParam List<Integer> numbers) {
		return StringUtils.calculateAverage(numbers);
	}
	
	@GetMapping("/file")
	public String readFile(@RequestParam String filename) {
		return StringUtils.readFile(filename); // Security: Path traversal
	}
	
	@GetMapping("/timestamp")
	public String getTimestamp() {
		return StringUtils.getCurrentTimestamp();
	}
	
	@GetMapping("/process")
	public String processUser(
		@RequestParam String username,
		@RequestParam String email,
		@RequestParam String phone,
		@RequestParam String address
	) {
		return StringUtils.processUserData(username, email, phone, address);
	}
	
	@GetMapping("/status")
	public String getStatus(@RequestParam int code) {
		return StringUtils.getStatusMessage(code);
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
	@GetMapping("/parse")
	public String parseNumber(@RequestParam String value) {
		try {
			int number = StringUtils.parseIntSafe(value);
			return "Parsed: " + number;
		} catch (Exception e) {
			// Empty catch - code smell
		}
		return "";
	}
	
	// Bug: Comparing strings incorrectly
	@GetMapping("/compare")
	public boolean compareTexts(@RequestParam String text1, @RequestParam String text2) {
		return StringUtils.compareStrings(text1, text2);
	}
}