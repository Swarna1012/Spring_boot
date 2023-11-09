package com.example.demo.JWT.data;

import com.example.demo.JWT.common.PaginationMeta;
import com.example.demo.JWT.entity.User;

import java.util.List;

public class UserData {

    private List<User> users;
    private PaginationMeta pagination;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public PaginationMeta getPagination() {
        return pagination;
    }

    public void setPagination(PaginationMeta pagination) {
        this.pagination = pagination;
    }
}
