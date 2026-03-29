# Hospital Management System (Java Swing)

A GUI-based Hospital Management System developed using Java Swing.
This project demonstrates the implementation of Object-Oriented Programming (OOP) concepts along with file handling and graphical user interface design in Java.

This project was developed and submitted as a **2nd Semester Final Project**.

---

## Overview

The system is designed to simulate basic hospital operations in a structured and user-friendly way. It integrates multiple modules such as patient management, appointment handling, staff information, medicine inventory, and fee management into a single application.

All functionalities are accessible through a central reception dashboard.

---

## User Interface Note

The graphical interface of this project is designed using Java Swing with absolute positioning.

* The size and layout of each frame are based on the developer’s screen resolution.
* The application does not use responsive layouts.
* UI appearance may vary on different systems or screen sizes.
* Minor adjustments may be required for optimal display on other devices.

---

## Features

### Patient Management

* Add new patients with complete details
* Store patient information including ID, name, gender, disease, room, deposit, and time
* View saved patient records
* Delete patient records from the system

### Appointment System

* Automatically generates appointments when a patient is added
* Displays appointments in tabular form
* Maintains appointment records in a file

### Doctor Information

* Displays detailed doctor profiles including:

  * Name
  * Department
  * Designation
  * Schedule
  * Working days
  * Contact information
  * Assigned room

### Faculty and Staff Information

* Displays non-doctor staff details such as:

  * Nurses
  * Technicians
  * Administrative staff
  * Security personnel

### Medicine Inventory

* Displays available medicines
* Allows adding new medicines
* Tracks availability and out-of-stock status
* Updates inventory in a file

### Department Directory

* Lists all hospital departments
* Includes department heads, locations, and operating hours

### Room Management

* Displays room details and categories
* Shows assigned staff and doctors for each room

### Fee Structure

* Displays doctor consultation fees
* Displays room charges
* Provides overview of hospital expenses

### Login System

* Basic authentication system with predefined users
* Grants access to the reception dashboard upon successful login

### Reception Dashboard

* Central navigation panel for accessing all modules
* Provides entry point to all system functionalities

---

## Technologies Used

* Java
* Java Swing (GUI Development)
* AWT
* File Handling (BufferedReader, BufferedWriter)

---

## Object-Oriented Programming Concepts

* Encapsulation: Data is organized within classes such as `DoctorInfo` and `FacultyInfo`
* Abstraction: Separation of data models and UI logic
* Composition: UI built using multiple components within frames
* Event Handling: User interactions managed through ActionListeners

---

## Project Structure

```id="project-structure"
Hospital-Management-System/
│── out.java              # Main entry point (launches LoginPage)
│
├── Authentication
│   └── LoginPage.java
│
├── Core Dashboard
│   └── Reception.java
│
├── Patient Management
│   ├── AddPatient.java
│   ├── ShowPatient.java
│   └── Appointment.java
│
├── Staff Management
│   ├── Doctor.java
│   ├── DoctorInfo.java
│   ├── Faculty.java
│   └── FacultyInfo.java
│
├── Hospital Information
│   ├── Department.java
│   ├── RoomStatus.java
│   └── ProjectInfo.java
│
├── Fee Management
│   ├── FeeStructure.java
│   ├── DoctorFee.java
│   └── RoomFee.java
│
├── Medicine Management
│   ├── Medicine.java
│   └── newMedicine.java
│
├── Employee Panel
│   └── Employee.java
```

---

## Getting Started

### Requirements

* Java JDK 8 or higher

### Compile and Run

```bash id="run-instructions"
javac *.java
java out
```

---

## How It Works

1. The application starts from `out.java`
2. The login page is displayed
3. Upon successful authentication, the reception dashboard is launched
4. Users can navigate to different modules using buttons
5. Data is stored and retrieved using text files:

   * Patients.txt
   * ShowData.txt
   * Appointment.txt
   * Med.txt

---

## Limitations

* Uses text files instead of a database system
* User interface is not responsive
* Limited input validation
* Hardcoded data for doctors and staff
* Basic authentication without role-based access control

---

## Future Improvements

* Integration with a database system (MySQL or SQLite)
* Migration to JavaFX for improved UI
* Implementation of role-based authentication
* Enhanced search and filtering features
* Improved UI responsiveness and layout management
* Addition of reporting and analytics features

---

## Project Status

Completed (Academic Project) <br>
Submitted as a 2nd Semester Final Project<br>
Open for further improvements and enhancements

---

## Author

Muhammad Jaffer<br>
Hospital Management System – Java Project

---

## License

This project is intended for educational purposes and is open for academic use.

---
