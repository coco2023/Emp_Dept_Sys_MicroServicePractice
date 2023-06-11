package com.microprac.rbacauthprac.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class ResourceRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resourceRoleId;

    private long resourceId;

    private long roleId;

}
