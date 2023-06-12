
# V03

POST: http://localhost:9992/register
> {
"username":"BOSS",
"password":"123",
"nickname": "cai",
"role": "ADMIN"
}
> 
> {
"username":"user13",
"password":"123",
"nickname": "user13",
"role": "USER"
}

<hr>

POST: http://localhost:9992/login

> {
"username":"user7",
"password":"123",
"role": "USER"
}
> 
> {
"username":"BOSS",
"password":"123",
"role": "ADMIN"
}

get user
> http://localhost:9992/user

get admin
> http://localhost:9992/admin

logout
> http://localhost:9991/logout

Please check the `handler ... ` for handler classes.


# v02

The `th:action` attribute is a Thymeleaf attribute that specifies the action URL for the form. In this case, `@{/logout}` is used to generate the URL for the logout action.

```
    <div class="row">
        <div class="col-md-4">
            <h2>Github</h2>
            <p>Please check here</p>
            <p>
                <a class="btn btn-default" href=""> XXX &raquo;</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2></h2>
            <p>Please check here</p>
            <p>
                <a class="btn btn-default" href=""> XXX &raquo;</a>
            </p>
        </div>
    </div>
```