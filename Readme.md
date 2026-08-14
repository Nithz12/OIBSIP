# ATM Interface

## 📌 Project Overview

The ATM Interface is a console-based Java application that simulates the basic operations of an Automated Teller Machine (ATM).

The application allows users to securely log in using a User ID and PIN and perform common banking transactions such as checking balance, withdrawing money, depositing money, transferring money, and viewing transaction history.

This project was developed as part of the **Oasis Infobyte Java Development Internship**.

## 🎯 Objective

To develop a Java-based ATM simulation that demonstrates object-oriented programming concepts, user authentication, transaction processing, and data management using Java collections.

## ✨ Features

* 🔐 User authentication with User ID and PIN
* 🔒 Maximum of 3 login attempts
* 💰 Balance checking
* 💸 Cash withdrawal
* 💵 Cash deposit
* 🔄 Money transfer between accounts
* 📋 Transaction history
* ⚠️ Insufficient funds validation
* ❌ Invalid input and account validation
* 🚪 Secure logout and exit
* 📊 Transaction records maintained using `ArrayList`

## 🛠 Technologies Used

* Java
* Java OOP
* ArrayList
* Scanner
* VS Code

## 📂 Project Structure

```text
Java-Task3-ATMInterface
│
├── Main.java
├── ATM.java
├── Account.java
├── Transaction.java
├── Bank.java
└── README.md
```

## 🧩 Java Classes

### Main.java

Starts the application and creates the Bank and ATM objects.

### ATM.java

Handles the login process and ATM menu operations such as withdrawal, deposit, transfer, and transaction history.

### Account.java

Stores account information such as account ID, User ID, PIN, and balance.

### Transaction.java

Stores individual transaction details.

### Bank.java

Maintains the available accounts and handles account authentication and account searching.

## 🔑 Test Login Credentials

### Account 1

```text
User ID: user1
PIN: 1234
```

### Account 2

```text
User ID: user2
PIN: 5678
```

## ▶️ How to Run

### Step 1: Open the project

Open the `Java-Task3-ATMInterface` folder in VS Code.

### Step 2: Compile the program

Open the terminal and run:

```bash
javac *.java
```

### Step 3: Run the program

```bash
java Main
```

### Step 4: Login

Enter a valid User ID and PIN.

### Step 5: Select an operation

Choose from the ATM menu:

```text
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Balance Check
6. Quit
```

## 📸 Screenshots

The project contains screenshots demonstrating:

* Login screen
* ATM main menu
* Withdrawal
* Deposit
* Money transfer
* Transaction history
* Balance checking
* Invalid login/access denied

## 📚 Concepts Demonstrated

* Classes and Objects
* Encapsulation
* Constructors
* Methods
* `ArrayList`
* `Scanner`
* `if-else`
* `switch-case`
* Loops
* User authentication
* Basic transaction processing

## 👨‍💻 Author

**Nithish Kumar KB**

Java Development Intern
Oasis Infobyte

## 📄 Internship Task

**Track:** Java Development
**Task:** ATM Interface
**Organization:** Oasis Infobyte
