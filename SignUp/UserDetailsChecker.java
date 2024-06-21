package javaSwing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserDetailsChecker {

    public boolean isDuplicate(String username) {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        for (File file : files) {
            if (containsUsername(file, username)) {
                return true;
            }
        }

        return false;
    }

    public boolean isDuplicateFirstName(String firstName) {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        for (File file : files) {
            if (containsFirstName(file, firstName)) {
                return true;
            }
        }

        return false;
    }

    public boolean isDuplicateMiddleName(String middleName) {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        for (File file : files) {
            if (containsMiddleName(file, middleName)) {
                return true;
            }
        }

        return false;
    }

    public boolean isDuplicateLastName(String lastName) {
        File directory = new File(".");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("user_details") && name.endsWith(".txt"));

        for (File file : files) {
            if (containsLastName(file, lastName)) {
                return true;
            }
        }

        return false;
    }

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

    private boolean containsValueInFile(File file, String value) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(value)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
