<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
</head>

<body>
<h2> SimpleCrudProjectSerg </h2>
<h2> Starting.jsp </h2>

<form action="api/employees" method="post">
    <input id="log" name="login" placeholder="Enter login.." type="text"/>
    <input id="pas" name="password" placeholder="Enter password.." type="text"/>
    <input type="submit" value="Sign in">
</form>

<br>

<form action="home" method="get">
    <button> log in without registration</button>
</form>



</body>
</html>