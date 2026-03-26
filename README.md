# 🗳️ Voting App (Spring Boot + Angular)

## 📌 Project Overview

This is a **full-stack Voting Application** built using **Spring Boot (Backend)** and **Angular (Frontend)**.
Users can create polls, add multiple options, and vote on them. Each vote increases the count in real-time.

---

## 🚀 Features

* 🆕 Create new polls
* ➕ Add multiple options (minimum 2 required)
* ❌ Delete options
* 🗳️ Vote on poll options
* 📊 Vote count increases dynamically (+1 on each vote)
* 🔄 Full integration between frontend and backend APIs

---

## 🛠️ Tech Stack

### 🔹 Backend

* Java
* Spring Boot
* Maven
* REST API

### 🔹 Frontend

* Angular
* TypeScript
* HTML / CSS

---

## 📂 Project Structure

```
spring-angular-voteApp/
 ├── backend/    (Spring Boot Application)
 └── frontend/   (Angular Application)
```

---

## ⚙️ How to Run the Project

### 🔹 Backend (Spring Boot)

```
cd backend/Voting
mvn spring-boot:run
```

👉 Backend will run on:

```
http://localhost:8080
```

---

### 🔹 Frontend (Angular)

```
cd frontend/poll-app
npm install
ng serve
```

👉 Frontend will run on:

```
http://localhost:4200
```

---


## 🔗 API Example

* `GET /polls` → Get all polls
* `POST /polls` → Create a new poll
* `POST /vote` → Vote for an option

---

## 💡 Key Learnings

* Full-stack development (Angular + Spring Boot)
* REST API integration
* State management in frontend
* CRUD operations
* Real-time UI updates

---

## 👨‍💻 Author

**Ayush Mittal**

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
