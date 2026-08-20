/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordanalyzerproject;

/**
 *
 * @author groub 6 444008474 فاطمة الصفي شيخة الكلثم 444008417 لين ال مجري
 * 444008462 444008463نجور المسلم هديل الرشيدي 444010690
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.security.SecureRandom;

public class PasswordAnalyzerProject {

    private static final String CharPicker = "ABCDEFGKIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@#$%^&*()";

    private static final int DefaultLength = 12;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter you password :");
        String password = input.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("The password is rejected ! ");
        }
        if (isValidPassword(password)) {
            System.out.println("The password is valid!");
        }
        checkPasswordLength(password);

        if (containsDictionaryWords(password)) {
            System.out.println("Dictionary Words are not allowed.");
        }
        if (!ContainsRepetitiveCharacters(password)) {
            System.out.println("repetitive characters or numbers are not allowed.");
        }
        if (SequentialCharacters(password)) {
            System.out.println("Sequential characters are not allowed.");
        }
        UpLowLetterNumSymbol(password);
        if (isSimilarToEmail(password)) {
            System.out.println("Passwords similar to email structure are not allowed.");
        }

        if (!isValidPassword(password)) {
            System.out.println("A good password suggetion :" + GenratePassword(16));
        }

    }

    private static boolean containsDictionaryWords(String password) {
        File dictionary = new File("C:\\Users\\Shiro\\Downloads\\wordlist.10000.txt");

        try ( BufferedReader fileReader = new BufferedReader(new FileReader(dictionary))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String commonPassword = line.trim();

                // Filter out numbers from the entered password
                String filteredPassword = password.replaceAll("[\\d\\W_@\\.]", "");

                // Check if the filtered password matches a common password
                if (filteredPassword.equalsIgnoreCase(commonPassword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read common passwords file.");
        }

        return false;
    }

    public static boolean SequentialCharacters(String password) {
        
   password = password.replaceAll("[^a-zA-Z0-9]", "");
    for (int i = 0; i < password.length() - 1; i++) {
        char charI = password.charAt(i);
        char nextChar = password.charAt(i + 1);
        if ((Character.isLetter(charI) && Character.isLetter(nextChar) && (charI + 1 == nextChar || charI - 1 == nextChar))
                || (Character.isDigit(charI) && Character.isDigit(nextChar) && (charI + 1 == nextChar || charI - 1 == nextChar))) {
            return true;
        }
    }
    return false;
    }

    public static boolean UpLowLetterNumSymbol(String password) {

        char[] passwordArray = password.toCharArray();
        int uppercaseLetter = 0, lowercaseLetter = 0, dight = 0, symbol = 0;
        for (char c : passwordArray) {
            if (c >= 65 && c <= 90) {
                uppercaseLetter++;
            } else if (c >= 97 && c <= 122) {
                lowercaseLetter++;

            } else if (c >= 48 && c <= 57) {
                dight++;

            } else {

                symbol++;
            }

        }
        if (uppercaseLetter == 0) {
            System.out.println("an uppercase letter is missing ");
        }
        if (lowercaseLetter == 0) {
            System.out.println("a lowercase letter is missing ");
        }
        if (dight == 0) {
            System.out.println("a dight is missing ");
        }
        if (symbol == 0) {
            System.out.println("a symbol is missing ");

        }

        if (uppercaseLetter == 0 || lowercaseLetter == 0 || dight == 0 || symbol == 0) {
            return false;

        } else {
            return true;
        }

    }

    public static String GenratePassword(int length) {
        if (length < 8) {
            length = DefaultLength;

        }
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CharPicker.length());
            password.append(CharPicker.charAt(index));

        }

        return password.toString();
    }

    public static boolean isValidPassword(String password) {
        return !containsDictionaryWords(password)
                && ContainsRepetitiveCharacters(password)
                && !SequentialCharacters(password)
                && checkPasswordLength(password)
                && UpLowLetterNumSymbol(password)
                && !isSimilarToEmail(password);

    }

    public static boolean ContainsRepetitiveCharacters(String password) {
        // Check for repetitive characters
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }

        // Check for repetitive numbers
        for (int i = 0; i < password.length() - 1; i++) {
            if (Character.isDigit(password.charAt(i))
                    && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSimilarToEmail(String password) {
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        if (pattern.matcher(password).matches()) {

            return true;
        }
        return false;
    }

    public static boolean checkPasswordLength(String password) {
        int passwordLength = password.length();
        if (passwordLength < 8) {
            System.out.println("short passwords are not allowed.");

            return false;
        }
        if (passwordLength > 16) {
            System.out.println("Passwords length is above 16 ");

            return false;

        }
        return true;
    }

}
