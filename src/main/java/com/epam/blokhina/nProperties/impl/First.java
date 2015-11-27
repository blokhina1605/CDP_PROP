package com.epam.blokhina.nProperties.impl;

import com.epam.blokhina.nProperties.AbstractEntityReader;
import jfork.nproperty.Cfg;

import java.util.ArrayList;
import java.util.List;

public class First extends AbstractEntityReader {

    @Cfg("first.user.login")
    private String login;

    @Cfg("first.user.psw")
    private String password;

    @Cfg(value = "first.categories", splitter = ";")
    private static List<String> categories = new ArrayList<>();

    public First(String filename) {
        super(filename);
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPsw() {
        return password;
    }

    @Override
    public List<String> getCategories() {
        return categories;
    }
}
