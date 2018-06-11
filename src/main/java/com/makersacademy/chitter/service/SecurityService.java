package com.makersacademy.chitter.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
