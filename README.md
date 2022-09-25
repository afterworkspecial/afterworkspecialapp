# afterworkspecialapp

login: king
password: kong

GET http://localhost:8080/users/{username} - return user with matching username
POST http://localhost:8080/register - to register new user, 400 if user or email exists
     sample body: 
            {
            "username": "Harry",
            "password": "Potter",
            "email": "hari.pota@gmail.com",
            "role": "USER_ROLE"
            }
