export default function Login(props) {
    return `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<br>
<hr>
<h3>Sign up today!</h3>
<form id="sign-form">
     <label for="sign-email">Email</label>
     <input id="sign-email" name="email" type="text"/>
    <label for="sign-username">Username</label>
    <input id="sign-username" name="username" type="text"/>
    <label for="sign-password">Password</label>
    <input id="sign-password" name="password" type="password"/>
    <input id="sign-btn" type="submit" value="Sign Up"/>
</form></body>
</html>`;

}