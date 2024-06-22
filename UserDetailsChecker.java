package bankingGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// This class checks for duplicates in user details files.
public class UserDetailsChecker {

    // Checks if a username already exists in any user_details*.txt file.
    public boolean isDuplicate(String username) {
        File directory = new File(".");
        // Find all files matching user_details*.txt in the current directory
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        // Check each file for the username
        for (File file : files) {
            if (containsUsername(file, username)) {
                return true; // Username found in this file, return true
            }
        }

        return false; // Username not found in any file
    }

    // Checks if a first name already exists in any user_details*.txt file.
    public boolean isDuplicateFirstName(String firstName) {
        File directory = new File(".");
        // Find all files matching user_details*.txt in the current directory
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        // Check each file for the first name
        for (File file : files) {
            if (containsFirstName(file, firstName)) {
                return true; // First name found in this file, return true
            }
        }

        return false; // First name not found in any file
    }

    // Checks if a middle name already exists in any user_details*.txt file.
    public boolean isDuplicateMiddleName(String middleName) {
        File directory = new File(".");
        // Find all files matching user_details*.txt in the current directory
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        // Check each file for the middle name
        for (File file : files) {
            if (containsMiddleName(file, middleName)) {
                return true; // Middle name found in this file, return true
            }
        }

        return false; // Middle name not found in any file
    }

    // Checks if a last name already exists in any user_details*.txt file.
    public boolean isDuplicateLastName(String lastName) {
        File directory = new File(".");
        // Find all files matching user_details*.txt in the current directory
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        // Check each file for the last name
        for (File file : files) {
            if (containsLastName(file, lastName)) {
                return true; // Last name found in this file, return true
            }
        }

        return false; // Last name not found in any file
    }

    // Private helper method to check if a specific value exists in a file
    private boolean containsValueInFile(File file, String value) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line of the file
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the value
                if (line.trim().equals(value)) {
                    return true; // Value found in the file, return true
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException (e.g., file not found)
        }
        return false; // Value not found in the file
    }

    // Private methods to check for specific values (username, first name, middle name, last name)
    private boolean containsUsername(File file, String username) {
        return containsValueInFile(file, username);
    }

    private boolean containsFirstName(File file, String firstName) {
        return containsValueInFile(file, firstName);
    }

    private boolean containsMiddleName(File file, String middleName) {
        return containsValueInFile(file, middleName);
    }

    private boolean containsLastName(File file, String lastName) {
        return containsValueInFile(file, lastName);
    }
}
