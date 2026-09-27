# codealpha-java2
# 🎓 Student Grade Tracker

A modern and attractive **Student Grade Tracker desktop application built using Java Swing**.
The application provides a web-dashboard-style user interface for managing students, calculating grades, viewing academic performance, and generating performance reports.

---

## ✨ Features

### 📊 Dashboard

* Modern web-style dashboard UI
* Total number of students
* Average score
* Highest score
* Lowest score
* Recent student records
* Quick access to add students

### 👨‍🎓 Student Management

* Add new students
* Enter Student ID, Name, and Marks
* Duplicate Student ID validation
* Marks validation from **0 to 100**
* View all student records
* Search students by ID or name

### 🏆 Grade Calculation

The application automatically calculates grades based on student marks:

|   Marks | Grade |
| ------: | :---: |
|    > 90 |   O   |
| 80 – 90 |   A+  |
| 70 – 79 |   A   |
| 60 – 69 |   B   |
| 50 – 59 |   C   |
|    < 50 |   F   |

### 📈 Performance Analysis

* Average score calculation
* Highest-scoring student
* Lowest-scoring student
* Performance classification
* Student performance report

### 🎨 Modern UI

* Web-dashboard-inspired design
* Dark sidebar navigation
* Purple gradient hero section
* Modern cards
* Rounded and clean layouts
* Attractive typography
* Search interface
* Responsive/resizable desktop window
* Hover effects
* Professional color scheme

---

## 🖥️ Application Preview

```text
┌──────────────────┬──────────────────────────────────────────────┐
│ 🎓 GradeFlow     │ Student Grade Tracker        ● System Active│
│                  ├──────────────────────────────────────────────┤
│ MENU             │                                              │
│                  │  Welcome back! 👋             + Add Student   │
│ ⌂ Dashboard      │                                              │
│                  │ ┌────────┐ ┌────────┐ ┌────────┐ ┌────────┐ │
│ 👨‍🎓 Students      │ │ TOTAL  │ │AVERAGE │ │HIGHEST │ │ LOWEST │ │
│                  │ │   25   │ │ 82.45  │ │ 98.00  │ │ 45.00  │ │
│ ＋ Add Student    │ └────────┘ └────────┘ └────────┘ └────────┘ │
│                  │                                              │
│ ▣ Reports        │ Recent Students       🔍 Search student...  │
│                  │ ──────────────────────────────────────────── │
│                  │ ID │ STUDENT │ MARKS │ GRADE │ PERFORMANCE  │
│                  │ 01 │ Rajasri │ 92.00 │ O     │ Excellent    │
│                  │ 02 │ Arun    │ 84.00 │ A+    │ Very Good    │
│                  │ 03 │ Priya   │ 76.00 │ A     │ Very Good    │
│                  │                                              │
│ 👤 Admin         │                                              │
└──────────────────┴──────────────────────────────────────────────┘
```

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **AWT**
* **ArrayList**
* **Object-Oriented Programming**
* **JTable**
* **JFrame**
* **JPanel**
* **GridLayout**
* **BorderLayout**
* **Event Handling**

---

## 📂 Project Structure

```text
Student-Grade-Tracker/
│
├── StudentGradeTracker.java
│
└── README.md
```

---

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/student-grade-tracker.git
```

### 2. Open the Project

Open the project in:

* IntelliJ IDEA
* Eclipse
* NetBeans
* VS Code

### 3. Compile the Program

Open the terminal in the project directory:

```bash
javac StudentGradeTracker.java
```

### 4. Run the Application

```bash
java StudentGradeTracker
```

---

## 🧑‍💻 How to Use

### Step 1 – Dashboard

When the application starts, the dashboard displays:

* Total Students
* Average Score
* Highest Score
* Lowest Score
* Recent Student Records

### Step 2 – Add Student

Click:

```text
＋ Add Student
```

Enter:

```text
Student ID
Student Name
Marks
```

The application automatically calculates the student's grade.

### Step 3 – View Students

Select:

```text
👨‍🎓 Students
```

to view all registered students.

You can search students using:

```text
Student Name
Student ID
```

### Step 4 – Reports

Select:

```text
▣ Reports
```

to view:

* Total students
* Average score
* Top performer
* Lowest score

---

## 🧠 OOP Concepts Used

This project demonstrates several important Java concepts:

### Class and Objects

```java
static class Student {
    int id;
    String name;
    double marks;
}
```

Each student is represented as an object.

### Encapsulation

Student information is stored inside the `Student` class.

### Constructor

```java
Student(int id, String name, double marks)
```

The constructor initializes student details.

### ArrayList

```java
static ArrayList<Student> students =
        new ArrayList<>();
```

The application uses an `ArrayList` to store student records.

### Methods

The application uses separate methods for:

* Adding students
* Calculating grades
* Searching students
* Updating statistics
* Displaying reports

### Event Handling

Java Swing event listeners are used for:

* Button clicks
* Search
* Navigation
* Form submission
* Mouse hover effects

---

## 📊 Grade Calculation Logic

```java
if (marks > 90)
    return "O";
else if (marks >= 80)
    return "A+";
else if (marks >= 70)
    return "A";
else if (marks >= 60)
    return "B";
else if (marks >= 50)
    return "C";
else
    return "F";
```

---

## 🔐 Input Validation

The application validates:

* Empty student fields
* Invalid Student ID
* Invalid marks
* Marks outside the range `0–100`
* Duplicate Student IDs

---

## 🎯 Project Objectives

The main objectives of this project are:

* To develop a student management application using Java.
* To demonstrate Java Swing GUI development.
* To implement object-oriented programming concepts.
* To calculate and track student grades.
* To provide an attractive dashboard-style interface.
* To analyze student academic performance.
* To practice Java event handling and collections.

---

## 🔮 Future Enhancements

Possible future improvements include:

* 💾 MySQL database integration
* 🔐 Admin login and authentication
* ✏️ Edit student records
* 🗑️ Delete student records
* 📄 Export reports to PDF
* 📊 Charts and graphs
* 📥 Export student data to Excel
* 🌙 Dark/Light theme switch
* ☁️ Cloud database integration
* 📧 Email performance reports

---

## 👩‍💻 Author

**Rajasri R K**

Computer Science & Engineering
Java | Full Stack Development | React | MongoDB | REST APIs

---

## ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.

---

## 📜 License

This project is created for **educational and academic purposes**.
