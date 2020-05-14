package com.github.nastyasivko.project_final.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "login_users")
public class LoginUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_login",unique = true)
    private String login;
    @Column
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "user_id", updatable = false, insertable = false)
    private Long userId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_order_room", joinColumns = {@JoinColumn(name = "user_login")},
            inverseJoinColumns = {@JoinColumn(name = "room_id")})
    private List<HotelRoomEntity> hotelRoomEntities = new ArrayList<>();

    public LoginUsersEntity(Long id, String login, String password, Long userId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
