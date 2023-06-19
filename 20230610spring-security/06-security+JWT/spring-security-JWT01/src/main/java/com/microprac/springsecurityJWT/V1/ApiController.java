package com.microprac.springsecurityJWT.V1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ApiController {

    @GetMapping("/api/public")
    public String publicEndpoint() {
        return "This is Public API";
    }

    @GetMapping("/api/private")
    public String privateEndpoint() {
        return "This is Private API";
    }


}
