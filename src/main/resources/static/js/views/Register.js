import createView from "../createView.js";

export default function Register(props) {
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
    <button id="sign-btn" type="button">Sign Up</button>
</form></body>
</html>`;

}


export function RegisterEvent() {
    $("#sign-btn").click(function () {
        let user = {
            username: $("#sign-username").val(),
            email: $("#sign-email").val(),
            password: $("#sign-password").val()
        };
        console.log(user)

        let request = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        }

        fetch("http://localhost:8080/api/users/create", request)
            .then(res => {
                console.log(res.status)
                createView("/")
            }).catch(error => {
            console.log(error);
            createView("/register");
        });
    })
}