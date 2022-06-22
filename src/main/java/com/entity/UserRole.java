package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roleName;
   @OneToMany(mappedBy = "role")
   private List<UserRoleToPrivilege> userRoleToPrivileges;

   //Role
   public String getRoleName() {
    return roleName;
    }
    public void setRoleName(String roleName) {
    this.roleName = roleName;
    }

    //UserRoleToPrivilege
    public List<UserRoleToPrivilege> getUserRoleToPrivileges() {
    return userRoleToPrivileges;
    }
    public void setUserRoleToPrivileges(List<UserRoleToPrivilege> userRoleToPrivileges) {
        this.userRoleToPrivileges = userRoleToPrivileges;
    }

}