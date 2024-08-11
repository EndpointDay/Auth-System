# Auth System

## Overview

This Java application performs hardware ID (HWID) verification to ensure that only authorized users can access the application. It includes a simple login interface and a backend HWID check to verify the user's machine. The HWID check is based on a SHA-1 hash of system-specific properties.

## Features

- **Login Interface**: Basic GUI for user authentication.
- **HWID Verification**: Checks the machine's hardware ID against a list of authorized HWIDs fetched from a remote URL.
- **Error Handling**: Displays messages if HWID verification fails or if there are issues with encoding or algorithm.

## Prerequisites

- Java Development Kit (JDK) 8 or higher.
- Maven (optional, if using Maven for build and dependency management).

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/hwid-verification-app.git
   cd JavaAuthSystem
   ```

2. **Compile the code**:

   ```bash
   javac -d bin src/Main.java
   ```

   Alternatively, you can use Maven to build the project if a `pom.xml` file is provided.

3. **Run the application**:

   ```bash
   java -cp bin src.Main
   ```

## Configuration

1. **HWID Manager Configuration**:
   - Open the `HWIDManager.java` file.
   - Set the `pastebinURL` constant to the URL of your HWID list (e.g., `https://pastebin.com/raw/yourpasteid`).

2. **Login Credentials**:
   - Update the `USERNAME` and `PASSWORD` constants in `LoginFrame.java` to your desired credentials.

## Usage

1. **Start the Application**:
   Run the application using the command mentioned above.

2. **Login**:
   - Enter the username and password.
   - If the credentials are correct and the HWID matches an authorized HWID, you will gain access.
   - If the HWID does not match or an exception occurs, a message will be displayed.

## Contribution

If you'd like to contribute to this project:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request on GitHub.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
