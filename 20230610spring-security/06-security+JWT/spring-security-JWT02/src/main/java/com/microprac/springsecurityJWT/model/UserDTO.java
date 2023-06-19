package com.microprac.springsecurityJWT.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class UserDTO {

    private Long userId;

    private String userName;
}
