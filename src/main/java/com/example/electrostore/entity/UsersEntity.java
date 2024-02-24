package com.example.electrostore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RolesEntity idRole;

    @OneToMany(mappedBy = "idUser")
    private List<OrderdetailEntity> listOrder;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolesEntity getIdRole() {
        return idRole;
    }

    public void setIdRole(RolesEntity idRole) {
        this.idRole = idRole;
    }
}
