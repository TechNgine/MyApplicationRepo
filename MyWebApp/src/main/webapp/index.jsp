<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Security-Policy" content="default-src 'self'; script-src 'self'; style-src 'self';">
    <title>Interactive Secure Web App</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(45deg, #ff7e5f, #feb47b);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 50%;
            padding: 20px;
            background: white;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            text-align: center;
            animation: fadeIn 1s ease-in-out;
        }
        h2 {
            color: #333;
        }
        input, button {
            padding: 10px;
            margin: 10px 0;
            width: 80%;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        button {
            background: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
            transition: background 0.3s ease-in-out;
        }
        button:hover {
            background: #0056b3;
        }
        .message {
            margin-top: 20px;
            font-size: 18px;
            color: #28a745;
            display: none;
            animation: fadeIn 0.5s ease-in-out;
        }

        /* Animation */
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
    <script>
        function showMessage(event) {
            event.preventDefault();
            const username = document.getElementById("username").value;
            if (username.trim() !== "") {
                const messageDiv = document.getElementById("message");
                messageDiv.style.display = "block";
                messageDiv.textContent = `Hello, ${username}! Welcome to our secure web app.`;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Welcome to My Secure Web App</h2>
        <form onsubmit="showMessage(event)">
            <label for="username">Enter Your Name:</label>
            <input type="text" id="username" name="username" required>
            <button type="submit">Submit</button>
        </form>
        <div id="message" class="message"></div>
    </div>
</body>
</html>
