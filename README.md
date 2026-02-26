## 🎮 Project Overview

This project is a simplified strategy game inspired by *Clash of Clans*.  
It was developed as a final project for the Advanced Programming course using **Java** and **JavaFX**.

The game allows players to manage heroes, select maps, and attack enemy bases in a turn-based battle simulation.

---

## 🧱 Core Entities

The main object-oriented structure of the project includes:

- 👤 `Player`
- 🗺 `Map`
- 🏢 `Building`
- ⚔️ `Hero`

The design follows OOP principles such as inheritance, abstraction, and encapsulation.

---

## 👤 Player Features

- Registration & Login
- Player level
- Win/Loss tracking
- Profile view
- Stored game data (loaded at startup)

Each player selects a predefined map during registration.

---

## ⚔️ Battle System

- Random opponent map selection
- Hero selection based on player level
- Heroes move toward the nearest building
- Buildings defend if they are defensive types
- Health and damage system implemented
- Victory/Defeat detection
- Player profile updates after each battle

The attack continues until:
- All heroes are destroyed ❌  
or  
- All buildings are destroyed ✅  

---

## 🏢 Buildings

- Normal and Defensive types
- Health system
- Defensive buildings deal damage within attack range

---

## 🦸 Heroes

- Multiple hero types
- Different attack ranges
- Different damage values
- Target nearest building automatically

---

## 💾 Data Persistence

Player information is saved to file and loaded when the program starts.

---

## 🖥️ Technology Stack

- ☕ Java
- 🎨 JavaFX
- 🧩 Object-Oriented Programming (OOP)
- 🗄 SQL Database  
- 🔧 Git for version control
