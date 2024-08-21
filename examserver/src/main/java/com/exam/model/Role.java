package com.exam.model;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private Long roleId;
    private String roleName;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRole> UserRoles=new HashSet<>();


    public Set<UserRole> getUserRoles() {
        return UserRoles;
    }
    public void setUserRoles(Set<UserRole> userRoles) {
        UserRoles = userRoles;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
    public Role() {
    }
    
}
