package com.microprac.springsecurityJWT;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFooRepository extends JpaRepository<Foo, Long> {
}
