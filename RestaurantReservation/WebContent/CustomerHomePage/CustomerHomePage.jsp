<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
    <title>Restaurant Reservation Home Page</title>
    <link rel="stylesheet" href="./CustomerHomePage.css">
</head>

<body>
    <div class="navbar">
        <div class="navbar-left">
            <a href="./MainHomePage.html">Home</a>
            <!-- Add more links as needed -->
        </div>
        <div class="navbar-right">
            <!-- Button to open Profile Dropdown -->
            <div class="dropdown">
                <button class="dropbtn" onclick="toggleDropdown()">Profile</button>
                <div class="dropdown-content" id="profileDropdown">
                    <ul class="dropdown_menu dropdown_menu--animated dropdown_menu-6">
                        <li class="dropdown_item-1"><a href="#" onclick="viewUserDetails()">User Details</a></li>
                        <li class="dropdown_item-2"><a href="#" onclick="viewMyReservations()">My Reservations</a></li>
                        <li class="dropdown_item-3"><a href="#" onclick="logout()">Logout</a></li>
                    </ul>
                </div>
                <li class="dropdown dropdown-6">
                    Scale Down
                        
                    </li>
            </div>
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


    <!-- Footer -->
    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2023 Restaurant Reservation. All Rights Reserved.</p>
    </div>

    <script>
        const restaurantCards = document.querySelectorAll('.card');

        // Function to handle card clicks
        function redirectToTablesHomePage(restaurantId) {
            // Redirect to TablesHomePage.html passing the restaurantId as a query parameter
            window.location.href = `../TablesHome/TablesHomePage.html?restaurantId=${restaurantId}`;
        }

        // Attach click event listeners to each restaurant card
        restaurantCards.forEach(card => {
            card.addEventListener('click', () => {
                const restaurantId = card.getAttribute('data-restaurant-id');
                redirectToTablesHomePage(restaurantId);
            });
        });

        function toggleDropdown() {
            var dropdown = document.getElementById("profileDropdown");
            dropdown.classList.toggle("show");
        }

        // Close dropdown when clicking outside
        window.onclick = function (event) {
            if (!event.target.matches('.dropbtn')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                for (var i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains('show')) {
                        openDropdown.classList.remove('show');
                    }
                }
            }
        }

        // Handle clicking the options in the dropdown
        function viewUserDetails() {
            // Redirect or perform action for user details
            console.log("View User Details");
            // Example: window.location.href = 'user-details.html';
        }

        function viewMyReservations() {
            // Redirect or perform action for viewing reservations
            console.log("View My Reservations");
            // Example: window.location.href = 'my-reservations.html';
        }

        function logout() {
            // Perform logout action
            console.log("Logout");
            // Example: window.location.href = 'logout.html';
        }


    </script>

</body>

</html>