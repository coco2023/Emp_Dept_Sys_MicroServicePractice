package com.microprac.springsecurityJWT.controller;

import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path = "api/book")

public class BookApi {

    // Details omitted for brevity

    @RolesAllowed(Role.BOOK_ADMIN)
    @PostMapping
    public BookView create() { }

    @RolesAllowed(Role.BOOK_ADMIN)
    @PutMapping("{id}")
    public void edit() { }

    @RolesAllowed(Role.BOOK_ADMIN)
    @DeleteMapping("{id}")
    public void delete() { }

    @GetMapping("{id}")
    public void get() { }

    @GetMapping("{id}/author")
    public void getAuthors() { }

    @PostMapping("search")
    public void search() { }

}
