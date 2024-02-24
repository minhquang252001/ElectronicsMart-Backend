package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idRole")
    private List<UsersEntity> listUser;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UsersEntity> getListUser() {
        return listUser;
    }

    public void setListUser(List<UsersEntity> listUser) {
        this.listUser = listUser;
    }
}
