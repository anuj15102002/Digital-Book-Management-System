->Introduction

The Digital Book Management System is a Java-based application that allows users to manage a collection of digital books efficiently. The system provides features for adding, updating, deleting, and searching for books.

->Project Structure

Digital-Book-Management-System/

├── src/                # Source code files

│   ├── Main.java       # Entry point of the application

│   ├── Book.java       # Model class for book entity

│   ├── BookManager.java # Handles book operations

│   └── ...

├── README.md          # Project documentation

└── .gitignore         # Git ignore file

->How to Run the Project

1. Using IntelliJ IDEA

* Clone the Repository

* git clone https://github.com/anuj15102002/Digital-Book-Management-System.git

* Open IntelliJ IDEA and select File → Open.

* Choose the Digital-Book-Management-System folder.

* Set Up Java SDK:

* Go to File → Project Structure → SDKs.

* Select an installed JDK (JDK 8 or higher).

* Run the Application:

* Open Main.java and click the Run ▶ button.

2. Using Eclipse

* Open Eclipse and go to File → Import → Existing Projects into Workspace.

* Select the cloned project folder and click Finish.

* Open Main.java and click Run.

3. Using VS Code

* Open the project folder in VS Code.

* Install the Java Extension Pack (if not installed).

* Open Main.java and click Run ▶.

4. Running via Terminal (Without an IDE)

* Open a terminal in the project folder.

* Compile the Java files: javac -d out src/*.java

* Run the application: java -cp out Main

## Challenges Faced

1. **Handling User Input & Validation**
    - Ensuring all required fields (Book ID, Title, Author, Genre, Status) are provided.
    - Preventing duplicate Book IDs and invalid availability status.

2. **Managing In-Memory Data Storage**
    - Storing book details in a collection instead of a database.
    - Ensuring books can be searched, updated, and deleted efficiently.

3. **Error Handling & User Experience**
    - Handling invalid inputs to prevent program crashes.
    - Implementing a user-friendly menu-driven system for ease of navigation.  