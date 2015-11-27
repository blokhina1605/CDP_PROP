package com.epam.blokhina.nProperties.impl;

import com.epam.blokhina.nProperties.AbstractEntityReader;
import jfork.nproperty.Cfg;

import java.util.ArrayList;
import java.util.List;

public class Second extends AbstractEntityReader{
    @Cfg("second.user.login")
    private String login;

    @Cfg("second.user.psw")
    private String password;

    @Cfg(value = "second.categories", splitter = ";")
    private static List<String> categories = new ArrayList<>();

    public Second(String filename) {
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
