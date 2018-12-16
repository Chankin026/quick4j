package com.chankin.ssms.web.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private Long id;

    @NotEmpty(message = "{user.username.null}")
    @Size(min = 6, message = "{user.username.length.illegal}")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,}$")
    private String username;

    @NotEmpty(message = "{user.password.null}")
    @Size(min = 6, max = 32, message = "{user.password.length.illegal}")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,32}$")
    private String password;

    private String state;

    private Date createTime;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}