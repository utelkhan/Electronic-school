package kz.greetgo.eschool.service;

import kz.greetgo.eschool.model.AppUser;

public interface UserService {
    AppUser findByUserName(String userName);
}
