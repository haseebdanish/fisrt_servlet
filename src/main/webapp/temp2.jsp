<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Placement Management - Login/Signup</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            transition: background 0.6s ease-in-out;
        }

        /* Backgrounds */
        .login-bg {
            background: url('https://img.freepik.com/free-vector/geometric-gradient-futuristic-background_23-2149116406.jpg') no-repeat center center/cover;
        }
        
        .signup-bg {
            background: url('https://www.bdu.ac.in/cde/cms/users/assets/img/login-bg.jpg') no-repeat center center/cover;
        }

        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 0;
        }

        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.3);
            text-align: center;
            width: 360px;
            animation: fadeIn 0.6s ease-in-out;
            position: relative;
            z-index: 1;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        .input-container {
            width: 100%;
        }

        input {
            width: calc(100% - 20px);
            padding: 12px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            text-align: center;
            transition: 0.3s ease-in-out;
        }

        input:focus {
            border-color: #5a67d8;
            outline: none;
            box-shadow: 0px 0px 8px rgba(90, 103, 216, 0.5);
        }

        .password-container {
            position: relative;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .toggle-password {
            position: absolute;
            right: 18px;
            cursor: pointer;
            font-size: 18px;
            color: #666;
        }

        button {
            background-color: #5a67d8;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            transition: 0.3s;
            margin-top: 10px;
        }

        button:hover {
            background-color: #4c51bf;
        }

        .toggle {
            color: #5a67d8;
            cursor: pointer;
            margin-top: 15px;
            display: block;
            font-size: 14px;
        }

        .toggle:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 12px;
            margin-top: 5px;
            display: none;
        }
    </style>
</head>
<body class="login-bg" id="background">

    <div class="overlay"></div>

    <div class="container" id="loginContainer">
        <h2>Login</h2>
        <div class="input-container">
            <input type="text" placeholder="Username" id="loginUser">
            <span class="error" id="loginUserError">Username is required</span>
        </div>
        <div class="input-container password-container">
            <input type="password" placeholder="Password" id="loginPass">
            <span class="toggle-password" onclick="togglePassword('loginPass')">👁</span>
            <span class="error" id="loginPassError">Password is required</span>
        </div>
        <button onclick="login()">Login</button>
        <span class="toggle" onclick="toggleForm()">Don't have an account? Sign up</span>
    </div>
    
    <div class="container" id="signupContainer" style="display: none;">
        <h2>Sign Up</h2>
        <div class="input-container">
            <input type="text" placeholder="Username" id="signupUser">
            <span class="error" id="signupUserError">Username is required</span>
        </div>
        <div class="input-container">
            <input type="email" placeholder="Email" id="signupEmail">
            <span class="error" id="signupEmailError">Valid email is required</span>
        </div>
        <div class="input-container password-container">
            <input type="password" placeholder="Password" id="signupPass">
            <span class="toggle-password" onclick="togglePassword('signupPass')">👁</span>
            <span class="error" id="signupPassError">Password must be at least 6 characters</span>
        </div>
        <button onclick="signup()">Sign Up</button>
        <span class="toggle" onclick="toggleForm()">Already have an account? Login</span>
    </div>

    <script>
        function toggleForm() {
            let loginContainer = document.getElementById('loginContainer');
            let signupContainer = document.getElementById('signupContainer');
            let background = document.getElementById('background');

            if (loginContainer.style.display === 'none') {
                loginContainer.style.display = 'block';
                signupContainer.style.display = 'none';
                background.classList.remove("signup-bg");
                background.classList.add("login-bg");
            } else {
                loginContainer.style.display = 'none';
                signupContainer.style.display = 'block';
                background.classList.remove("login-bg");
                background.classList.add("signup-bg");
            }
        }

        function togglePassword(fieldId) {
            let field = document.getElementById(fieldId);
            field.type = field.type === "password" ? "text" : "password";
        }

        function showError(id, message) {
            let errorElement = document.getElementById(id);
            errorElement.style.display = "block";
            errorElement.innerText = message;
        }

        function hideErrors() {
            let errors = document.querySelectorAll(".error");
            errors.forEach(error => error.style.display = "none");
        }

        function login() {
            hideErrors();
            let username = document.getElementById("loginUser").value.trim();
            let password = document.getElementById("loginPass").value.trim();
            
            if (username === "") {
                showError("loginUserError", "Username is required");
                return;
            }
            if (password === "") {
                showError("loginPassError", "Password is required");
                return;
            }
            alert("Login successful (Functionality to be implemented)");
        }
        
        function signup() {
            hideErrors();
            let username = document.getElementById("signupUser").value.trim();
            let email = document.getElementById("signupEmail").value.trim();
            let password = document.getElementById("signupPass").value.trim();

            if (username === "") {
                showError("signupUserError", "Username is required");
                return;
            }
            if (!validateEmail(email)) {
                showError("signupEmailError", "Valid email is required");
                return;
            }
            if (password.length < 6) {
                showError("signupPassError", "Password must be at least 6 characters");
                return;
            }
            alert("Signup successful (Functionality to be implemented)");
        }

        function validateEmail(email) {
            return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
        }
    </script>
</body>
</html>


