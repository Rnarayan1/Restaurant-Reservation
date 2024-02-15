<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
    <title>Restaurant Reservation Home Page</title>
    <link rel="stylesheet" href="./TablesHomePage.css">
</head>

<body>
    <div class="navbar">
        <div class="navbar-left">
            <a href="../MainHome/MainHomePage.html">Home</a>
            <!-- Add more links as needed -->
        </div>
        <div class="navbar-right">
            <!-- Button to open Register Customer Popup -->
            <button class="open-popup" onclick="openProfilePopup()">Profile</button>
        </div>
    </div>

    <div class="content">
        <h2 class="restaurantName"></h2>
        <div class="Table-cards">
            <!-- Example Card 1 -->
            <div class="card" data-table-id="twoTable"
                onclick="populateReservationForm('twoTable', '2 seater Table', 'A party size of 2 can seat at this table.')">
                <img src="RestaurantImages/Restaurant1.jpeg" alt="Restaurant 1">
                <div class="card-info">
                    <h3>2 seater Table</h3>
                    <p>A party size of 2 table can seat in this table</p>
                </div>
            </div>

            <!-- Example Card 2 -->
            <div class="card" data-table-id="twoTable"
                onclick="populateReservationForm('fourTable', '4 seater Table', 'A party size of 4 can seat at this table.')">
                <img src="RestaurantImages/Restaurant2.jpeg" alt="Restaurant 2">
                <div class="card-info">
                    <h3>4 seater Table</h3>
                    <p>A party size of 4 table can seat in this table</p>
                </div>
            </div>

            <div class="card" data-table-id="sixTable" onclick="populateReservationForm('sixTable', '6 seater Table', 'A party size of 6 can seat at this table.')">
                <img src="RestaurantImages/Restaurant2.jpeg" alt="Restaurant 3">
                <div class="card-info">
                    <h3>6 seater Table</h3>
                    <p>A party size of 6 table can seat in this table</p>
                </div>
            </div>

            <div class="card" data-table-id="twelveTable" onclick="populateReservationForm('twelveTable', '12 seater Table', 'A party size of 12 can seat at this table.')">
                <img src="RestaurantImages/Restaurant2.jpeg" alt="Restaurant 4">
                <div class="card-info">
                    <h3>12 seater Table</h3>
                    <p>A party size of 12 table can seat in this table</p>
                </div>
            </div>


            <div class="popup-form" id="reservationModal">
                <h2>Reservation Form</h2>
                <form action="reservationServlet" method="post">
                    <input type="hidden" id="tableId" name="tableId">
                    <input type="hidden" id="tableName" name="tableName">
                    <input type="hidden" id="tableDescription" name="tableDescription">

                    <label for="date">Date:</label>
                    <input type="date" id="date" name="date" required>

                    <label for="time">Time:</label>
                    <select id="time" name="time" required>
                        <option value="">Select Time</option>
                        <option value="09:00">9:00 AM</option>
                        <option value="10:00">10:00 AM</option>
                        <option value="11:00">11:00 AM</option>
                        <option value="12:00">12:00 PM</option>
                        <option value="1:00">1:00 PM</option>
                        <option value="2:00">2:00 PM</option>
                        <option value="3:00">3:00 PM</option>
                        <option value="4:00">4:00 PM</option>
                        <option value="5:00">5:00 PM</option>
                        <option value="6:00">6:00 PM</option>

                    </select>

                    <label for="fullName">Full Name:</label>
                    <input type="text" id="fullName" name="fullName" required>

                    <label for="email">Email:</label>
                    <input type="text" id="username" name="email" required>

                    <label for="phoneno">Phone Number:</label>
                    <input type="number" id="phoneno" name="phoneno" required>

                    <label for="partySize">Party Size:</label>
                    <input type="number" id="partySize" name="partySize" required>

                    <input type="submit" value="Reserve">
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2023 Restaurant Reservation. All Rights Reserved.</p>
    </div>

    <script>
        // Function to get URL parameters
        function getParameterByName(name, url) {
            if (!url) url = window.location.href;
            name = name.replace(/[\[\]]/g, "\\$&");
            var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                results = regex.exec(url);
            if (!results) return null;
            if (!results[2]) return '';
            return decodeURIComponent(results[2].replace(/\+/g, " "));
        }

        // Get the restaurant name parameter from the URL
        var restaurantName = getParameterByName('restaurant');

        if (restaurantName) {
            // Set the restaurant name in the HTML
            document.querySelector('.restaurantName').innerText = restaurantName;

            // Fetch restaurant details based on the restaurantName using AJAX or fetch requests
            // Example: Fetch restaurant details using fetch and update table cards
            fetch('/api/getRestaurantDetails?name=' + restaurantName)
                .then(response => response.json())
                .then(data => {
                    // Update table cards based on fetched data
                    const tableCards = document.querySelectorAll('.card[data-table-id]');

                    data.tables.forEach((table, index) => {
                        // Update table card information
                        tableCards[index].querySelector('h3').innerText = table.name;
                        tableCards[index].querySelector('p').innerText = table.description;
                        // Update other table card details accordingly...
                    });
                })
                .catch(error => {
                    console.error('Error fetching restaurant details:', error);
                    // Handle errors fetching restaurant details
                });
        }

        // Function to open the reservation modal
        function openReservationModal() {
            document.getElementById('reservationModal').style.display = 'block';
        }

        // Function to close the reservation modal
        function closeReservationModal() {
            document.getElementById('reservationModal').style.display = 'none';
        }

        const tableCards = document.querySelectorAll('.card[data-table-id]');

        tableCards.forEach(card => {
            card.addEventListener('click', () => {
                const tableId = card.getAttribute('data-table-id');
                const tableName = card.querySelector('h3').innerText;
                const tableDescription = card.querySelector('p').innerText;

                populateReservationForm(tableId, tableName, tableDescription);
                openReservationModal(); // Open the reservation modal
            });
        });

        // Function to populate reservation form with table details
        function populateReservationForm(tableId, tableName, tableDescription) {
            // Get elements in the reservation form and set their values
            document.getElementById('tableId').value = tableId;
            document.getElementById('tableName').value = tableName;
            document.getElementById('tableDescription').value = tableDescription;
        }

        // Function to handle form submission (you may need to add validation and submission logic)
        document.getElementById('reservationForm').addEventListener('submit', event => {
            event.preventDefault();
            // Handle form submission (e.g., send data to the server)
            // Close modal after successful submission: closeReservationModal();
        });

    </script>

</body>

</html>