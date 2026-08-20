# 🔐 Password Analyzer

A Java-based password analyzer that evaluates user passwords against a set of security requirements and provides a secure password suggestion when the entered password does not meet the required criteria.

## Overview

The application prompts the user to enter a password and analyzes it based on several password security rules. If the password violates any of the requirements, the program identifies it as invalid and generates an alternative password that satisfies the defined security guidelines.

## Features

#### Validates password length between 8 and 16 characters
#### Detects and rejects passwords containing dictionary words
#### Detects repetitive characters or numbers
#### Detects sequential characters or numbers
#### Ensures the password contains at least:
  - One uppercase letter
  - One lowercase letter
  - One number
  - One special character
#### Rejects passwords that follow an email-like structure
#### Generates a secure password suggestion when the entered password is rejected

## Technologies Used

 - Java
 - Java Regular Expressions (Regex)
 - String manipulation and validation
 - Datasets
   
## How It Works

1. The user enters a password.
2. The program checks the password against all security requirements.
3. If all requirements are satisfied, the password is accepted.
4. If any requirement fails, the password is rejected.
5. The program generates and displays a stronger password suggestion.

## Example

Enter your password: password123
Password rejected.
Reasons:
- Contains a dictionary word
- Does not contain an uppercase letter
- Does not contain a special character
Suggested Password:
G7@mQ2#kLp9!

## Security Concepts

#### This project demonstrates basic password security concepts such as:
- Password complexity validation
- Pattern detection
- Dictionary-based password checking
- Sequential and repetitive character detection
- Secure password generation

## Future Improvements

#### Possible improvements include:
- Expanding the dictionary word database
- Adding password strength levels
- Creating a graphical user interface (GUI)
- Checking passwords against common breached-password lists
- Improving password generation using cryptographically secure randomness

