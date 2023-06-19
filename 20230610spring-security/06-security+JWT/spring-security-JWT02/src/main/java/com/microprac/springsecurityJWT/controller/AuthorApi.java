package com.microprac.springsecurityJWT.controller;

import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path = "api/author")

public class AuthorApi {

    // Details omitted for brevity

    @RolesAllowed(Role.AUTHOR_ADMIN)
    @PostMapping
    public void create() { }

    @RolesAllowed(Role.AUTHOR_ADMIN)
    @PutMapping("{id}")
    public void edit() { }

    @RolesAllowed(Role.AUTHOR_ADMIN)
    @DeleteMapping("{id}")
    public void delete() { }

    @GetMapping("{id}")
    public void get() { }

    @GetMapping("{id}/book")
    public void getBooks() { }

    @PostMapping("search")
    public void search() { }

}
