<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        #popup-container {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        #overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 900;
        }
    </style>
</head>

<body>

    <div id="overlay"></div>

    <div id="popup-container">
        <p>You have successfully registered</p>
        <button id="HomePage-button" onclick="redirectToHomePage()">HomePage</button>
        <button id="Login-button" onclick="redirectToLoginPage()">Login</button>
    </div>

    <div class="popup-form" id="customerLoginPopup">
        <!-- Your Login form content goes here -->
        <h2>Customer Login Form</h2>
        <button class="close-button" onclick="closePopup('customerLoginPopup')">x</button>

        <form action="customerLoginServlet" method="post" onsubmit="redirectToCustomerHomePage(); return false">

            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>

            <label for="password">Password: </label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
    </div>

    <script>
        var popupContainer = document.getElementById('popup-container');
        var overlay = document.getElementById('overlay');
        var homeButton = document.getElementById('HomePage-button');
        var loginButton = document.getElementById('Login-button');

        // Show the popup
        popupContainer.style.display = 'block';
        overlay.style.display = 'block';

        // Add event listeners to close the popup
        homeButton.addEventListener('click', closePopup);
        loginButton.addEventListener('click', closePopup);

        function closePopup() {
            popupContainer.style.display = 'none';
            overlay.style.display = 'none';
        }

        function redirectToHomePage() {
            window.location.href = '../MainHome/MainHomePage.html'; // Replace 'home.html' with your actual home page URL
        }

        function redirectToCustomerHomePage() {
            window.location.href = '../CustomerHome/CustomerHomePage.html';
            return false;
        }

    </script>

</body>

</html>