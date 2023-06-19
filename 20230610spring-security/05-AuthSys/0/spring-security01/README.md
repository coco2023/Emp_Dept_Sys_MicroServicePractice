
# Not know why this project can not run (02 can run)

> error:  Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.NullPointerException: Cannot invoke "java.security.Principal.getName()" because "principal" is null] with root cause
> 
> java.lang.NullPointerException: Cannot invoke "java.security.Principal.getName()" because "principal" is null

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