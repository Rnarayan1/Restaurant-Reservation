<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<title>Restaurant Reservation Home Page</title>
<style type="text/css">
body {
	width: 90%;
	margin: 0 auto;
}

.content {
	padding: 1rem;
	outline: auto;
	margin-bottom: 50px;
}

.navbar {
	background-color: #333;
	overflow: hidden;
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-radius: 8px;
	padding: 10px 30px;
	/* Adjust as needed */
}

.navbar a {
	color: #f2f2f2;
	text-decoration: none;
	padding: 8px 12px;
	/* Adjusted padding */
	font-size: 14px;
	/* Adjusted font size */
	transition: color 0.3s;
}

.navbar a:hover {
	color: #ddd;
}

.navbar-right .open-popup {
	padding: 8px 12px;
	/* Adjusted padding */
	font-size: 14px;
	/* Adjusted font size */
	margin: 0 6px;
	/* Adjusted margin */
	border-radius: 5px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	transition: background-color 0.3s;
}

.navbar-right .open-popup:hover {
	background-color: #0056b3;
}

/* Style for Buttons */
.btn {
	padding: 10px 20px;
	font-size: 16px;
	margin: 0 10px;
	border-radius: 5px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
}

.btn:hover {
	background-color: #0056b3;
}

.popup-form {
	text-align: left;
	/* Align form elements to the left */
	display: none;
	/* Initially hide the pop-up forms */
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #f7f7f7;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	max-width: 400px;
	/* Set a maximum width for the forms */
	width: 100%;
	z-index: 999;
}

.popup-form h2 {
	margin-top: 0;
}

.popup-form form label {
	display: block;
	margin-bottom: 8px;
}

.popup-form input[type="text"], .popup-form input[type="number"],
	.popup-form input[type="password"], .popup-form input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	font-size: 14px;
}

.popup-form input[type="submit"] {
	background-color: #007bff;
	color: white;
	cursor: pointer;
	transition: background-color 0.3s;
}

.popup-form input[type="submit"]:hover {
	background-color: #0056b3;
}

.popup-form .close-button {
	position: absolute;
	top: 10px;
	right: 10px;
	background: none;
	border: none;
	font-size: 16px;
	cursor: pointer;
}

.card {
	/* You may adjust this based on your layout requirements */
	height: 500px;
	/* Set a fixed height for the cards */
	display: inline-block;
	vertical-align: top;
	box-sizing: border-box;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: calc(30% - 40px);
	/* Calculate width with margins included */
	margin: 20px;
	/* Set margin for each card */
	box-sizing: border-box;
	transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
}

.card:hover {
	/* Apply scaling and box shadow on hover */
	transform: scale(1.05);
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.card img {
	width: 100%;
	height: 60%;
	border-bottom: 1px solid #ccc;
}

.card-info {
	padding: 10px;
}

.card-info h3 {
	margin-top: 0;
}

.card-info p {
	margin-bottom: 0;
}

.restaurant-cards {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	/* Center align the cards */
	gap: 20px;
	/* Adjust as needed */
}

/* Styles for Footer */
.footer {
	position: fixed;
	bottom: 0;
	width: 90%;
	margin: 0 auto;
	/* Extend the footer width */
	background-color: #333;
	color: white;
	text-align: center;
	padding: 6px 0;
	z-index: 999;
	border-radius: 0px 0px 8px 8px;
}

.footer p {
	margin: 0;
	padding: 5px;
}

@media screen and (max-width: 768px) {
	.navbar {
		padding: 10px 15px;
		/* Adjusted padding for smaller screens */
	}
	.navbar a {
		padding: 8px;
		/* Adjusted padding for links */
	}
	.navbar-right .open-popup {
		padding: 8px;
		/* Adjusted padding for buttons */
		margin: 0 4px;
		/* Adjusted margin for buttons */
	}
	.card {
		width: calc(50% - 20px);
		/* Adjusted width for smaller screens */
		margin: 10px;
		/* Adjusted margin for cards */
	}
	.footer {
		padding: 4px 0;
		/* Adjusted padding for footer */
	}
}

/* Add styles for even smaller screens (e.g., mobile) */
@media screen and (max-width: 480px) {
	.navbar {
		padding: 8px;
		/* Further adjusted padding for navbar */
	}
	.navbar a {
		font-size: 12px;
		/* Adjusted font size for links */
	}
	.navbar-right .open-popup {
		padding: 6px;
		/* Adjusted padding for buttons */
		margin: 0 2px;
		/* Adjusted margin for buttons */
		font-size: 12px;
		/* Adjusted font size for buttons */
	}
	.card {
		width: calc(100% - 20px);
		/* Adjusted width for mobile screens */
		margin: 8px 0;
		/* Adjusted margin for mobile screens */
	}
}
</style>
</head>

<body>
	<div class="navbar">
		<div class="navbar-left">
			<a href="../MainHome/MainHomePage.jsp">Home</a>
			<!-- Add more links as needed -->
		</div>
		<div class="navbar-right">
			<!-- Button to open Register Customer Popup -->
			<button class="open-popup" onclick="openRegisterCustomerForm()">Register
				as Customer</button>

			<!-- Button to open Register Restaurant Popup -->
			<button class="open-popup" onclick="openRegisterRestaurantForm()">Register
				as Restaurant</button>

			<!-- Button to open Customer Login Popup -->
			<button class="open-popup" onclick="openCustomerLoginForm()">Customer
				Login</button>

			<!-- Button to open Restaurant Login Popup -->
			<button class="open-popup" onclick="openRestaurantLogin()">Restaurant
				Login</button>
		</div>
	</div>

	<div class="Content">
		<h1>Welcome to Restaurant Reservation</h1>

		<div class="restaurant-cards">
			<!-- Example Card 1 -->
			<div class="card" data-restaurant-id="restaurant1">
				<img src="RestaurantImages/Restaurant1.jpeg" alt="Restaurant 1">
				<div class="card-info">
					<h3>Restaurant Name 1</h3>
					<p>Description of Restaurant 1.</p>
				</div>
			</div>

			<!-- Example Card 2 -->
			<div class="card" data-restaurant-id="restaurant2">
				<img src="RestaurantImages/Restaurant2.jpeg" alt="Restaurant 2">
				<div class="card-info">
					<h3>Restaurant Name 2</h3>
					<p>Description of Restaurant 2.</p>
				</div>
			</div>
		</div>
	</div>

	<div class="popup-form" id="registerCustomerPopup">
		<h2>Customer Registration</h2>
		<button class="close-button"
			onclick="closePopup('registerCustomerPopup')">x</button>
		<form action="<%=request.getContextPath()%> /registerCustomerServlet" method="post" >
			<label for="fullName">Full Name:</label> <input type="text"
				id="fullName" name="fullName" required> <label for="email">Email:</label>
			<input type="text" id="email" name="email" required> <label
				for="password">Password:</label> <input type="password"
				id="password" name="password" required> <label for="address">Address:</label>
			<input type="text" id="address" name="address" required> <label
				for="phoneno">Phone Number:</label> <input type="text" id="phoneno"
				name="phoneno" required> <input type="submit"
				id="registerCustomer" value="Register" required>
		</form>
	</div>

	<!-- Register Popup for Restaurant -->
	<div class="popup-form" id="registerRestaurantPopup">
		<h2>Restaurant Registration</h2>
		<button class="close-button"
			onclick="closePopup('registerRestaurantPopup')">x</button>

		<form action="RestaurantRegisterController" method="post">
			<label for="restaurantName">Restaurant Name:</label> <input
				type="text" id="restaurantName" name="restaurantName" required>

			<label for="numberOfTables">Total Capacity:</label> <input
				type="number" id="numberOfTables" name="numberOfTables" required>

			<label for="email">Email:</label> <input type="text" id="email"
				name="email" required> <label for="password">Password:</label>
			<input type="password" id="password" name="password" required>

			<label for="address">Address:</label> <input type="text" id="address"
				name="address" required> <label for="phoneno">Phone
				Number:</label> <input type="text" id="phoneno" name="phoneno" required>

			<input type="submit" id="registerRestaurant" value="Register"
				required>
		</form>
	</div>

	<!-- Customer Login Popup -->
	<div class="popup-form" id="customerLoginPopup">
		<!-- Your Login form content goes here -->
		<h2>Customer Login Form</h2>
		<button class="close-button"
			onclick="closePopup('customerLoginPopup')">x</button>

		<form action="<%=request.getContextPath()%> /customerLoginServlet" method="post">

			<label for="email">Email:</label> <input type="text" id="email"
				name="email" required> <label for="password">Password:
			</label> <input type="password" id="password" name="password" required>

			<input type="submit" value="Login">
		</form>
	</div>

	<!-- Restaurant Login Popup -->
	<div class="popup-form" id="restaurantLoginPopup">
		<!-- Your Restaurant Login form content goes here -->
		<h2>Restaurant Login Form</h2>
		<button class="close-button" onclick="closePopup('restaurantLogin')">x</button>

		<form action="RestaurantLoginForm">
			<label for="restaurantUsername">Username:</label> <input type="text"
				id="restaurantUsername" name="restaurantUsername" required>

			<label for="restaurantPassword">Password:</label> <input
				type="password" id="restaurantPassword" name="restaurantPassword"
				required> <input type="submit" value="Login">
		</form>
	</div>

	<!-- Footer -->
	<div class="footer">
		<!-- Footer content goes here -->
		<p>&copy; 2023 Restaurant Reservation. All Rights Reserved.</p>
	</div>

	<script>
		// Function to open the customer registration popup
		function openRegisterCustomerForm() {
			closeAllPopups();
			document.getElementById("registerCustomerPopup").style.display = "block";
		}

		// Function to open the restaurant registration popup
		function openRegisterRestaurantForm() {
			closeAllPopups();
			document.getElementById("registerRestaurantPopup").style.display = "block";
		}

		// Function to open the customer login popup
		 function openCustomerLoginForm() {
			closeAllPopups();
			document.getElementById("customerLoginPopup").style.display = "block";
		} 

		// Function to open the restaurant login popup
		function openRestaurantLogin() {
			closeAllPopups();
			document.getElementById("restaurantLoginPopup").style.display = "block";
		}

		// Function to close all popups
		function closeAllPopups() {
			var popups = document.getElementsByClassName("popup-form");
			for (var i = 0; i < popups.length; i++) {
				popups[i].style.display = "none";
			}
		}

		// Function to handle closing a single popup by ID
		function closePopup(popupId) {
			var popup = document.getElementById(popupId);
			if (popup) {
				popup.style.display = "none";
			}
		}

		// Add event listeners to close buttons in each popup
		var closeButtons = document.getElementsByClassName("close-button");
		for (var i = 0; i < closeButtons.length; i++) {
			closeButtons[i].addEventListener("click", function() {
				closeAllPopups();
			});
		}

		function redirectToSuccessfullyRegisteredPage() {
			window.location.href = '../SuccessfulHome/SuccessfullyRegistered.jsp';
			return false;
		}

		function redirectToCustomerHomePage() {
			window.location.href = 'CustomerHome/CustomerHomePage.jsp';
			return false;
		}

		document.getElementById("customerLoginPopup").addEventListener(
				"submit", function(event) {
					event.preventDefault(); // Prevents the form from actually submitting (for testing purposes)

					var email = document.getElementById("email").value;
					var password = document.getElementById("password").value;

					console.log("Email:", email);
					console.log("Password:", password);

					// Here, you might also want to perform the actual form submission.
					// For testing purposes, it's prevented to see the logged values.
				});
	</script>

</body>

</html>
