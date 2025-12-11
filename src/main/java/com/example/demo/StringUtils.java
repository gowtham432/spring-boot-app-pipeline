package com.example.demo;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Utility class with various code quality issues for SonarCloud detection
 */
public class StringUtils {
    
    // Code smell: Public static mutable field
    public static String DEFAULT_ENCODING = "UTF-8";
    
    // Security: Hardcoded credentials
    private static final String API_KEY = "sk-1234567890abcdef";
    private static final String DATABASE_PASSWORD = "admin@123";
    
    // Code smell: Unused private field
    private String unusedField = "never used";
    
    /**
     * Bug: Potential null pointer - no null check
     * Code smell: Too many parameters
     */
    public static String formatString(String input, String prefix, String suffix, 
                                     boolean uppercase, boolean trim, int maxLength,
                                     String replacement, boolean addTimestamp) {
        // Bug: No null check on input
        String result = input.trim(); // Will throw NPE if input is null
        
        if (uppercase) {
            result = result.toUpperCase();
        }
        
        if (prefix != null) {
            result = prefix + result;
        }
        
        if (suffix != null) {
            result = result + suffix;
        }
        
        if (result.length() > maxLength) {
            result = result.substring(0, maxLength);
        }
        
        return result;
    }
    
    /**
     * Bug: Resource leak - BufferedReader not closed
     * Security: Path traversal vulnerability
     */
    public static String readFile(String filename) {
        try {
            // Security: No path validation - path traversal
            File file = new File("/data/" + filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            // Bug: Reader never closed - resource leak
            return line;
        } catch (IOException e) {
            e.printStackTrace(); // Code smell: Should use logger
            return null;
        }
    }
    
    /**
     * Code smell: High cognitive complexity, nested if statements
     * Code smell: Magic numbers
     */
    public static boolean validateInput(String input, String type) {
        if (input != null) {
            if (type.equals("email")) {
                if (input.contains("@")) {
                    if (input.length() > 5) {
                        if (input.length() < 100) {
                            if (input.indexOf("@") > 0) {
                                if (input.indexOf("@") < input.length() - 1) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else if (type.equals("phone")) {
                if (input.length() == 10) {
                    return true;
                }
            } else if (type.equals("zip")) {
                if (input.length() == 5) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Code smell: Code duplication
     * Bug: Potential division by zero
     */
    public static double calculateAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i);
        }
        
        // Bug: No check if size is 0 (though checked above, pattern is bad)
        return sum / numbers.size();
    }
    
    public static double calculateWeightedAverage(List<Integer> numbers, List<Integer> weights) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        
        int sum = 0;
        int weightSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i) * weights.get(i); // Bug: No size check on weights
            weightSum = weightSum + weights.get(i);
        }
        
        // Bug: Potential division by zero if weightSum is 0
        return sum / weightSum;
    }
    
    /**
     * Code smell: Empty catch block
     * Bug: Swallowing exceptions
     */
    public static int parseIntSafe(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Code smell: Empty catch block
        }
        return 0;
    }
    
    /**
     * Code smell: Method too long, does too many things
     * Security: SQL injection vulnerability (example)
     */
    public static String processUserData(String username, String email, String phone, String address) {
        StringBuilder result = new StringBuilder();
        
        // Validate username
        if (username == null || username.isEmpty()) {
            result.append("Invalid username. ");
        } else if (username.length() < 3) {
            result.append("Username too short. ");
        } else if (username.length() > 20) {
            result.append("Username too long. ");
        } else if (!username.matches("[a-zA-Z0-9]+")) {
            result.append("Username contains invalid characters. ");
        }
        
        // Validate email
        if (email == null || email.isEmpty()) {
            result.append("Invalid email. ");
        } else if (!email.contains("@")) {
            result.append("Email missing @. ");
        } else if (email.length() > 100) {
            result.append("Email too long. ");
        }
        
        // Validate phone
        if (phone == null || phone.isEmpty()) {
            result.append("Invalid phone. ");
        } else if (phone.length() != 10) {
            result.append("Phone must be 10 digits. ");
        }
        
        // Security: SQL injection vulnerability
        String query = "INSERT INTO users (username, email) VALUES ('" + username + "', '" + email + "')";
        result.append("Query: ").append(query);
        
        return result.toString();
    }
    
    /**
     * Code smell: Using SimpleDateFormat (not thread-safe)
     * Bug: SimpleDateFormat is not thread-safe in static context
     */
    public static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    /**
     * Code smell: Comparing strings with ==
     * Bug: Should use .equals() for string comparison
     */
    public static boolean compareStrings(String str1, String str2) {
        if (str1 == str2) { // Bug: Should use .equals()
            return true;
        }
        return false;
    }
    
    /**
     * Code smell: Unused private method
     */
    private static void unusedMethod() {
        System.out.println("This method is never called");
    }
    
    /**
     * Bug: Array index out of bounds - no bounds checking
     */
    public static String getFirstWord(String sentence) {
        String[] words = sentence.split(" ");
        return words[0]; // Bug: No check if array is empty
    }
    
    /**
     * Code smell: Switch statement that could be simplified
     * Code smell: Magic strings
     */
    public static String getStatusMessage(int code) {
        String message = "";
        switch (code) {
            case 200:
                message = "OK";
                break;
            case 201:
                message = "Created";
                break;
            case 400:
                message = "Bad Request";
                break;
            case 401:
                message = "Unauthorized";
                break;
            case 403:
                message = "Forbidden";
                break;
            case 404:
                message = "Not Found";
                break;
            case 500:
                message = "Internal Server Error";
                break;
            default:
                message = "Unknown";
        }
        return message;
    }
}