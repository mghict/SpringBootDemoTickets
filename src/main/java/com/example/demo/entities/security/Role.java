package com.example.demo.entities.security;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Role {
    @Id
    private long id;

    @Column(nullable = false,unique = true,length = 50)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    protected Role() {}

    public Role(Long id,String name) {
        this.name = name;
        this.id = id;
    }

    public Role(Long id,String name, Set<User> users) {
        this.name = name;
        this.users = users;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
