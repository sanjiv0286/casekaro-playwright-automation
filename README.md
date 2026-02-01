# CaseKaro Mobile Cover Booking Automation

## 📌 Project Overview

This project automates the **mobile cover purchase flow** on the CaseKaro website using **Java, Playwright, Maven, and Cucumber (BDD)**.

The automation validates product search, negative brand validation, material selection, cart management, and ensures all three material variants are correctly added. It also prints item details including material, price, and link in the console.

---

## 🛠 Tech Stack

- **Language:** Java (JDK 18)
- **Automation Tool:** Playwright (Java)
- **BDD Framework:** Cucumber
- **Test Runner:** JUnit
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA
- **Version Control:** Git & GitHub

---
## 🧪 Automated Test Scenario

**Feature:** CaseKaro Mobile Cover Purchase

**Scenario:** Search, select materials and validate cart

- Navigate to CaseKaro website
- Click on Mobile Covers category
- Search for Apple using the search button
- Validate that other brands are not visible after search (negative validation)
- Select Apple and search for iPhone 16 Pro model
- Click Choose Options for the first item
- Add all 3 material variants (Hard, Soft, Glass) to the cart
- Open the cart
- Validate all 3 items are present in the cart
- Print material, price, and link of each item in the console

---

## ▶️ How to Run the Tests

### Prerequisites

- Java 18 installed
- Maven installed
- Git installed

### Steps

```bash
git clone <repository-url>
cd case-karo
mvn clean test
```

---

## 📸 Test Execution Results

Below are the actual execution screenshots from the automation run:

### ✅ Test Result 1
![Test Result](result/TestResult.png)

### 📌 Execution Summary
- **Scenarios Executed:** 1  
- **Scenarios Passed:** 1  
- **Steps Executed:** 10  
- **Steps Passed:** 10  
- **Execution Time:** ~25 seconds
---

## ✅ Key Validations

- Product search filtering for Apple brand
- Negative validation ensuring other brands are not visible after search
- iPhone 16 Pro model selection validation
- All 3 material variants (Hard, Soft, Glass) added to cart
- Cart item count and details validation
- Console logging of material, price, and product link

---

## 🧠 Best Practices Followed

- BDD with Cucumber Feature files
- Page interaction using Playwright locators
- Assertions for validations at every critical step
- Negative validation to ensure search accuracy
- Clean Maven project structure
- No use of try-catch blocks
- Readable and maintainable code

---

## 👤 Author

**Sanjiv Kushwaha**

GitHub: https://github.com/sanjiv0286

---

⭐ If you found this project useful, feel free to star the repository!
