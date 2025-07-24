# Voting System Program

This repository contains the codebase for a straightforward yet practical voting system designed for conducting elections. Developed in Java using the BlueJ IDE, this system aims to provide a secure, efficient, and user-friendly platform for voters and administrators.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [System Design](#system-design)
- [Requirements](#requirements)
- [Object-Oriented Principles](#object-oriented-principles)
- [Local Setup Instructions](#local-setup-instructions)
- [Group Members](#group-members)
- [Contact](#contact)

## Project Overview

The Voting System project allows eligible users to cast their votes electronically, ensuring transparency, accuracy, and ease of use. It includes essential features such as voter registration, candidate selection, vote submission, and result tabulation. The system prioritizes security, scalability, and usability to facilitate a reliable election process. For more informayion check out the "Voting System Requirements Document" word document in voting-system-program repository.

## Features

### Functional Requirements:
-   **User Registration and Authentication:**
    -   Users must register with valid credentials.
    -   Authentication mechanisms (e.g., username-password) are implemented.
-   **Candidate Management:**
    -   Admins can add, edit, and delete candidate profiles.
    -   Candidates’ information (name, party, photo) is stored.
-   **Voting Process:**
    -   Voters can select candidates.
    -   Votes are recorded securely and anonymously.
    -   Multiple voting by the same user is prevented.
-   **Result Calculation:**
    -   Calculates and displays real-time voting results.
    -   Ensures accuracy and integrity of results.

### Non-Functional Requirements:
-   **Security:** Protects against unauthorized access, data tampering, and fraud; implements encryption for sensitive data.
-   **Scalability:** Designed to handle a large number of users during peak voting times; scalable architecture is considered.
-   **Usability:** Intuitive user interfaces for voters and administrators with clear instructions.
-   **Compatibility:** Compatible with different operating systems (Windows, Mac, iOS, Android) to accommodate a diverse user base.
-   **Legal and Compliance:** Ensures compliance with relevant election laws and data privacy regulations; protects voter anonymity and privacy.

## Object-Oriented Principles

The system demonstrates key OOP principles:

-   **Inheritance:** Classes like `Candidate` inherit common functionality and attributes (e.g., `firstName`, `lastName`) from an abstract `VotingSystem` class, promoting code reuse and a hierarchical structure.
-   **Polymorphism:** Methods like `validateUser()` are overridden in subclasses (e.g., `Voter` class) to implement specific validation logic tailored to their requirements.
-   **Encapsulation:** Instance variables (e.g., `firstName`, `lastName` in `VotingSystem`) are declared as `private` and accessed via `public` getter and setter methods, protecting data integrity.
-   **Abstraction:** The `VotingSystem` abstract class defines essential common attributes and methods, leaving implementation details to concrete subclasses, providing a simplified interface.

## Local Setup Instructions

To set up and run this Java project using BlueJ:

1.  **Prerequisites:**
    * **Java Development Kit (JDK):** Ensure you have a compatible JDK installed on your system.
    * **BlueJ IDE:** Download and install BlueJ from its official website ([https://www.bluej.org/](https://www.bluej.org/)).

2.  **Clone the repository:**
    ```bash
    git clone https://github.com/kl99-chi/voting-system-program.git
    ```
    (This URL uses your specific GitHub username and repository name.)

3.  **Navigate to the project directory:**
    ```bash
    cd voting-system-program
    ```

4.  **Open the project in BlueJ:**
    * Launch BlueJ.
    * Go to `Project` > `Open Non BlueJ Project...` (or `Open Project...`).
    * Navigate to the `voting-system-program` directory you just cloned and select it. BlueJ should then load all the Java source files.

5.  **Compile the project:**
    * In BlueJ, click the **"Compile"** button to compile all the Java classes.

6.  **Run the application:**
    * Locate the main class (e.g., `ElectionTest` or `Main` if you have one) in the BlueJ class diagram.
    * Right-click on the main class and select `void main(String[] args)` (or the appropriate main method) to run the application.

## Group Members

This project was developed collaboratively by the following individuals:

-   Keletso Ramothibe (Group Leader) - [https://github.com/kl99-chi](https://github.com/kl99-chi)
-   Phomolo Legobye
-   Total Van Wyk
-   Nokukhanya Mlilwana
-   Ndwandwa Ngazibini
-   Kgalalelo Mokotedi
-   Nkululeko Mayisa
-   Olwethu Dingiswayo
-   Khalishwayo Nkululeko
-   Thembinkosi Mnchunu


## Contact

For any questions or inquiries regarding this project, please contact:
-   **Keletso Ramothibe:** keletsoramothibe99@gmail.com
-   **LinkedIn:** [https://www.linkedin.com/in/keletso-ramothibe-793583376](https://www.linkedin.com/in/keletso-ramothibe-793583376)

---
© 2025 The Voting System Project Group. All rights reserved.
