# 🚀 UI Test Automation Framework

This project is a test automation framework designed to test the **MERN Auth & User Management App** ([GitHub](https://github.com/bradtraversy/mern-auth)) using:

- 🧪 **Selenium WebDriver**
- 📚 **Cucumber (BDD)**
- 🔧 **TestNG**
- 🧰 **Maven**
- 📸 **ExtentReports** for reporting
- 🧼 **Thread-safe driver setup**
- 🧾 **Config-driven architecture**

---

## 📁 Project Structure
```
demo-automation/
├── src
│ ├── main
│ │ └── resources
│ │ └── config/test-config.properties
│ └── test
│ ├── java
│ │ ├── pages/ # Page Object classes
│ │ ├── stepdefinitions/ # Step Definitions (BDD)
│ │ ├── hooks/ # Cucumber Hooks
│ │ └── utils/ # Reusable utilities (driver, wait, reports)
│ └── resources/features/ # Cucumber .feature files
├── pom.xml
└── README.md
```

---

## ✅ Features Covered

- Login with valid/invalid credentials
- Create a new item
- Edit an existing item
- Delete an item
- Assert expected data on dashboard

---

## ⚙️ Setup Instructions

### 1. 📦 Prerequisites

- Java JDK 11+
- Maven
- Chrome browser (for now)
- Node.js + npm (for backend/frontend if running locally)

### 2. 🔧 Install Project Dependencies

```mvn clean install```

---

## ✅ Features Covered

- Login with valid/invalid credentials
- Create a new item
- Edit an existing item
- Delete an item
- Assert expected data on dashboard

---

## ⚙️ Setup Instructions

### 1. 📦 Prerequisites
```
- Java JDK 11+
- Maven
- Chrome browser (for now)
- Node.js + npm (for backend/frontend if running locally)
```

### 2. 🔧 Install Project Dependencies
``` mvn clean install ```

### 3. ⚙️ Configuration
Update the following file with environment-specific values:

### 4. properties
src/main/resources/config/test-config.properties
```
base.url=http://localhost:3000
api.url=http://localhost:5000/api

valid.username=testuser@example.com
valid.password=123456

invalid.username=wrong@example.com
invalid.password=wrongpass
```

## Run all scenarios:
```mvn test```

## Run tests by tag:
``` mvn test -Dcucumber.filter.tags="@Login" ```

## 📊 Reporting
After execution, open:
target/extent-report.html
