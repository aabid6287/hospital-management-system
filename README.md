# 🏥 Hospital Management System (Console-Based)

A **console-based Hospital Management System** built using **Java** and **JDBC**. This project helps manage hospital operations such as patient records, doctor details, and database interactions through a simple command-line interface.

---

## 📌 Features

- 👨‍⚕️ Add new patients  
- 📋 View patient details  
- ✏️ Update patient information  
- ❌ Delete patient records  
- 🏥 Manage doctor details  
- 🔍 Search functionality  
- 💾 Database connectivity using JDBC  
- 🖥️ Simple console-based UI  

---

## 🛠️ Tech Stack

- **Language:** Java  
- **Database Connectivity:** JDBC  
- **Database:** MySQL  
- **IDE:** IntelliJ IDEA / Eclipse  

---

## 📂 Project Structure

```
hospital-management-system/
│── src/
│   ├── com/hospital/
│   │   ├── Patient.java
│   │   ├── Doctor.java
│   │   ├── Main.java
│   │   └── (other classes)
│
│── lib/
│   └── mysql-connector.jar
│
│── README.md
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/aabid6287/hospital-management-system.git
cd hospital-management-system
```

---

### 2️⃣ Setup Database

Open MySQL and run:

```sql
CREATE DATABASE hospital;
```

Example table:

```sql
CREATE TABLE patient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    disease VARCHAR(100)
);
```

---

### 3️⃣ Configure JDBC

Update your database credentials in code:

```java
String url = "jdbc:mysql://localhost:3306/hospital";
String username = "root";
String password = "your_password";
```

---

### 4️⃣ Run the Project

```bash
javac Main.java
java Main
```

Or run using your IDE.

---

## 📸 Sample Output

```
1. Add Patient
2. View Patients
3. Update Patient
4. Delete Patient
5. Exit

Enter your choice:
```

---

## 🚀 Future Enhancements

- Add GUI (Swing / JavaFX)  
- Doctor appointment system  
- Billing system  
- Login authentication  
- Convert to web app using Spring Boot  



If you like this project, give it a ⭐ on GitHub!
