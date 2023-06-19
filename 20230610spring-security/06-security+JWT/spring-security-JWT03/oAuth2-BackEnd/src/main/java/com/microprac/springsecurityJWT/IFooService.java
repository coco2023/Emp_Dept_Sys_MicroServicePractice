package com.microprac.springsecurityJWT;

import java.util.Optional;

public interface IFooService {

    Optional<Foo> findById(Long id);

    Foo save(Foo foo);

    Iterable<Foo> findAll();

}
