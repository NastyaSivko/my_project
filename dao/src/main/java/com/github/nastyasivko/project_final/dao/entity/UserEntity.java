package com.github.nastyasivko.project_final.dao.entity;

import javax.persistence.*;

@Cacheable
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;

    @OneToOne(mappedBy = "userEntity", fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private LoginUsersEntity loginUsersEntity;

    public UserEntity(Long id, String name, String surname, String phone, LoginUsersEntity loginUsersEntity) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LoginUsersEntity getLoginUsersEntity() {
        return loginUsersEntity;
    }

    public void setLoginUsersEntity(LoginUsersEntity loginUsersEntity) {
        this.loginUsersEntity = loginUsersEntity;
    }

}
