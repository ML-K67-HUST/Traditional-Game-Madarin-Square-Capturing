# Traditional Game: Mandarin Square Capturing

Welcome to the Mandarin Square Capturing game! This project is a digital implementation of the traditional Mandarin Square Capturing game, developed using Java and JavaFX. The game involves capturing squares on a board by placing stones, aiming to capture the most territory.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Rules](#rules)
- [Installation](#installation)
- [Contributing](#contributing)
  
## Introduction

Mandarin Square Capturing is a strategic board game that challenges players to capture squares on the board by placing stones. This digital version brings the classic game to your computer, allowing you to play against friends or AI.

## Features

- Classic game rules
- Two-player mode on the same device
- Interactive graphical interface using JavaFX
- Score tracking

## Rules
<p>
The gameboard consists of 10 squares, divided into 2 rows, and 2 half-circle on the 2 ends of the board:

- In mandarin capturing square for two players, there are two types of pieces: small gems and big gems. The number of big gems is fixed at 2. The number of small gems is fixed at 50.
		
- Initially, each square has 5 small gems, and each half-circle has 1 big gem. Each small gem equals I point, and each big gem equals 5 points.
		
- For each turn, a player will select a square and a direction to spread the gems. He got points when after finishing spreading, there is one empty square followed by a square with gems. The score they got for that turn is equal to the number of gems in that followed square.
		
- The game is considered ended when all the gems on the board have been captured. If there are no gems left on the. squares with. big gems but there are still gems left on the squares with small gems, the player who controls those squares will get them.
</p>

## Installation

### Prerequisites

- Eclipse (or other java IDE)
- Java Development Kit (JDK) 8 or later
- Apache Maven (optional, for building the project)
- JavaFX

### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ML-K67-HUST/Traditional-Game-Madarin-Square-Capturing.git

2. **Lunch the game:**

   Launch the game by running the main class `Main.java` in *Eclipse* (or other Java IDE).
   
## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, feel free to open an issue or submit a pull request.
