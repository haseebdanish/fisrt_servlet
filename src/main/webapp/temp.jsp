<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Placement Management - Home</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            background: url('https://media.licdn.com/dms/image/v2/C561BAQHA2-sfph3y7Q/company-background_10000/company-background_10000/0/1585975556591/presidency_university_india_cover?e=2147483647&v=beta&t=bv5_-VcDsp3nj033crDV92i-DFP_fk70MlBUq3i_me4') no-repeat center center/cover;
            color: white;
            text-align: center;
            position: relative;
            overflow-x: hidden;
            height: 130vh;
        }

        /* Overlay */
        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
            z-index: -1;
        }

        /* Navbar */
        .navbar {
            background: rgba(0, 0, 0, 0.8);
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3);
            position: sticky;
            top: 0;
            z-index: 100;
        }

        .navbar h1 {
            font-size: 26px;
            font-weight: bold;
            color: #ffd700;
        }

        .nav-links {
            list-style: none;
            display: flex;
        }

        .nav-links li {
            margin: 0 15px;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
            transition: 0.3s;
            padding: 8px 12px;
        }

        .nav-links a:hover {
            background: #ffd700;
            color: black;
            border-radius: 5px;
            transition: all 0.3s ease-in-out;
        }

        /* Hero Section */
        .hero {
            padding: 150px 20px;
            max-width: 800px;
            margin: auto;
            text-align: center;
            animation: fadeIn 1.5s ease-in-out;
        }

        .hero h2 {
            font-size: 42px;
            font-weight: 600;
            margin-bottom: 15px;
            text-shadow: 2px 2px 10px rgba(255, 255, 255, 0.5);
        }

        .hero p {
            font-size: 18px;
            margin-bottom: 30px;
        }

        .btn {
            display: inline-block;
            padding: 12px 28px;
            background-color: #ffcc00;
            color: black;
            font-weight: bold;
            font-size: 18px;
            border-radius: 30px;
            text-decoration: none;
            transition: 0.3s;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
        }

        .btn:hover {
            background-color: #ff9900;
            transform: scale(1.05);
        }

        /* Features Section */
        .features {
            display: flex;
            justify-content: center;
            gap: 30px;
            margin: 50px auto;
            padding: 20px;
            flex-wrap: wrap;
            max-width: 1000px;
        }

        .feature-box {
            background: black;
            padding: 25px;
            border-radius: 15px;
            text-align: center;
            width: 280px;
            box-shadow: 0px 4px 15px rgba(255, 215, 0, 0.5);
            transition: 0.4s;
            border: 2px solid gold;
        }

        .feature-box h3 {
            font-size: 22px;
            font-weight: 600;
            color: gold;
            text-shadow: 0px 0px 10px rgba(255, 215, 0, 0.8);
        }

        .feature-box p {
            font-size: 16px;
            font-weight: bold;
            color: white;
        }

        .feature-box:hover {
            transform: scale(1.1);
            background: rgba(0, 0, 0, 0.9);
            border: 2px solid white;
            box-shadow: 0px 4px 20px rgba(255, 255, 255, 0.8);
        }

        /* Footer */
        .footer {
            background: rgba(0, 0, 0, 0.8);
            padding: 15px;
            margin-top: 50px;
            text-align: center;
            font-size: 14px;
            color: white;
        }

        /* Animations */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .navbar {
                flex-direction: column;
                text-align: center;
            }
            .nav-links {
                margin-top: 10px;
                flex-wrap: wrap;
                justify-content: center;
            }
            .nav-links li {
                margin: 10px;
            }
            .hero {
                padding: 80px 15px;
            }
            .features {
                flex-direction: column;
                align-items: center;
            }
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar">
        <h1>Placement Management</h1>
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">Jobs</a></li>
            <li><a href="#">Companies</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </nav>

    <!-- Hero Section -->
    <section class="hero">
        <h2>Welcome to the Placement Management System</h2>
        <p>Find your dream job and explore opportunities with top companies.</p>
        <a href="#" class="btn">Explore Jobs</a>
    </section>

    <!-- Features Section -->
    <section class="features">
        <div class="feature-box">
            <h3>🔍 Job Search</h3>
            <p>Find jobs that match your skills.</p>
        </div>
        <div class="feature-box">
            <h3>🏢 Top Companies</h3>
            <p>Get placed in leading organizations.</p>
        </div>
        <div class="feature-box">
            <h3>📈 Career Growth</h3>
            <p>Advance your career with the best opportunities.</p>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        &copy; 2025 Placement Management System | All Rights Reserved
    </footer>

</body>
</html>