# Money Transfer App

Welcome to the Money Transfer App! This project is a comprehensive solution for managing bank accounts and performing secure money transfers. Built with Jetpack Compose, Coroutines, and Retrofit, it offers a smooth and efficient user experience. Please follow the sequence of actions outlined below to ensure proper setup and usage.
# Simulation
-![Demo](https://github.com/MalakAmgad/MoneyTransfareApplicationBankMisrIntern/blob/master/Speedo%20Demo.gif)
-[Watch the demo video](https://vimeo.com/996309441?share=copy)

## Features
- **User Registration and Login:** Secure registration and authentication with email and password.
- **Account Balance Check:** View your current balance and track incoming transactions.
- **Money Transfer:** Transfer funds to other accounts with validation checks to prevent invalid transactions.
- **Transaction History:** Review and interact with your previous transactions.
- **Favorites Management:** Save and manage favorite recipients for quick transfers.
- **Security and Validation:** Ensures secure transactions with account verification and inactivity alerts.

## Project Requirements
1. **User Registration:** 
   - Create a new bank account with your name, email, and password.
   - Password must be at least 6 characters long, including one capital letter, one lowercase letter, and one special character (e.g., $%^).
   
2. **User Login:**
   - Login using your registered email and password.
   - Previously entered email and password will be auto-filled on app restart.
   
3. **Logout:**
   - Logout to switch accounts or register a new one.
   
4. **Inactivity Alert:**
   - Receive an alert after 30 minutes of inactivity that prompts you to login again.
   
5. **Balance Check:**
   - View your current balance to track incoming funds.

6. **Money Transfer:**
   - Transfer money with a limit of 5000 L.E. per transaction.
   - Verify recipient account details before proceeding with the transfer as the recipient account and name should be stored in the DB.
   - Ensure the transaction amount does not exceed your current balance.
   - Receive a notification after a successful transaction.
   
7. **Transaction History:**
   - Review your transaction history, with details available for each transaction.

8. **Support Options:**
   - Contact support via call or email if you encounter issues.
   
9. **Favorites Management (Optional):**
   - Save favorite recipients for quick access and delete them if needed.

## Getting Started
### Prerequisites
Ensure you have the following setup before running the project:
- **Android Studio** with the latest stable version.
- **Java JDK** 8 or higher.
- **Internet connection** for initial Retrofit setup (no longer needed post-server migration).

### Installation
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-repo/money-transfer-app.git
   ```
2. **Open in Android Studio:**
   - Import the project into Android Studio.
   
3. **Run the App:**
   - Use the Android Studio emulator or a physical device to run the app.

### Initial Setup
1. **Register:** 
   - Open the app and navigate to the registration screen.
   - Create a new account by providing your name, email, and password.
   
2. **Login:**
   - Use your registered email and password to log in.
   - The app will auto-fill these details on subsequent logins.

3. **Money Transfer:**
   - Ensure the recipient's account is valid before transferring funds.
   - Confirm that the transfer amount does not exceed 5000 L.E. or your current balance.

4. **View Balance and Transaction History:**
   - Check your balance on the main screen.
   - Navigate to the transaction history to review past transactions.

### App Architecture
- **UI:** Built with Jetpack Compose for a responsive and modern interface.
- **Data Handling:** Initially implemented with Retrofit for network requests, but later transitioned to Room with Coroutines for local database management.
- **ViewModels:** Two ViewModels were used initially for registration and login processes. Due to server challenges, we consolidated them into a single ViewModel managing all entities (User, Transaction, Favorite).

### Notes
- **Navigation:** The app uses a main navigation file for screens like Sign In, Sign Up, and the Main Screen (which hosts the bottom bar and other services).
- **Validation:** The app includes robust validation, ensuring all transactions are secure and meet the required conditions.

## Acknowledgements
We would like to thank our team for their hard work and dedication in building this application.

---

Please follow this README closely to set up and use the Money Transfer App. For further assistance, feel free to contact me. Enjoy seamless and secure money transfers!
