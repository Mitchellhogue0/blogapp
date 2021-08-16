export default function Login(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<h3>Sign up today!</h3>
<form id="sign-form">
    <label for="sign-name1">First name</label>
     <input id="sign-name1" name="first-name" type="text"/>
     <label for="sign-name2">Last name</label>
     <input id="sign-name2" name="last-name" type="text"/>
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