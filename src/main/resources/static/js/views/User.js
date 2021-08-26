export default function user(props) {
    return `<!DOCTYPE html>
<html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Profile</title>
            </head>
            <body>
            
           <h1>Profile</h1>
           <br>
           <hr>
                <h1>Change Password</h1>

                <form id="pass-form">
                    <label for="pass-username">Username</label>
                    <input id="pass-username" name="username" type="text"/>
                    <label for="pass-password-old">Enter Old Password</label>
                    <input id="pass-password-old" name="old-password" type="password"/>
                    <label for="pass-password-new">Enter New Password</label>
                    <input id="pass-password-new" name="new-password" type="password"/>
                    <input id="pass-btn" type="submit" value="Submit"/>
                </form>
            </body>
        </html>`;

}