# 📱 Compound Interest Calculator (Android - Kotlin)

## 📌 Overview
The Compound Interest Calculator is a Kotlin-based Android application that helps users compute compound interest and understand how money grows over time.

Unlike a basic calculator, this app also functions as a **learning tool**, showing step-by-step mathematical solutions for each computation.

---

## 🧠 Problem Statement
Many students and beginners struggle to understand how compound interest works and how different variables affect financial growth.

This app solves that by:
- Allowing users to compute missing values (A, P, r, or t)
- Showing detailed step-by-step solutions
- Demonstrating real compound interest formulas

---

## ⚙️ Features

### 🧮 Multi-Variable Solver
Users can calculate:
- Final Amount (A)
- Principal (P)
- Interest Rate (r)
- Time (t)

---

### 📊 Step-by-Step Solution Display
The app shows:
- Formula used
- Substitution of values
- Final computed result

---

### 🔄 Smart Input Handling
- Automatically hides the variable being solved
- Prevents invalid inputs
- Handles division by zero and logarithm errors safely

---

### 📐 Compound Interest Formula Used

A = P(1 + r/n)^(nt)

Where:
- P = Principal
- r = Annual interest rate
- n = Compounding frequency per year
- t = Time in years
- A = Final amount

---

## 🛠️ Tech Stack
- Kotlin
- Android Studio
- XML Layouts
- Git & GitHub

---

## 📱 App Behavior
1. User selects what to solve for (A, P, r, or t)
2. Inputs the known values
3. App calculates the missing variable
4. Displays step-by-step mathematical solution

---

## 🧪 Input Validation
The app handles:
- Empty inputs
- Zero or negative values
- Invalid logarithm operations
- Division by zero cases

---

## 🚀 Future Improvements
- Add Dark/Light mode toggle 🌙
- Add dropdown for compounding frequency (Monthly, Quarterly, etc.)
- Add graph visualization of growth 📈
- Improve UI using Material Design components

---

## 👨‍💻 Project Purpose
This project was created as part of a learning requirement for Android development using Kotlin, focusing on:
- Mathematical computation
- User interface design
- Input validation
- Git/GitHub workflow

---

## 📂 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
2. Open in Android Studio
3. Let Gradle sync
4. Run on emulator or physical device

📌 Author

Developed by: Aloba
