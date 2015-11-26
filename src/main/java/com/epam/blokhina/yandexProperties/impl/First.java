package com.epam.blokhina.yandexProperties.impl;

import com.epam.blokhina.Paths;
import com.epam.blokhina.yandexProperties.YandexInterfaceProp;
import ru.qatools.properties.*;
import ru.qatools.properties.Resource;

import java.util.List;


@Resource.Classpath(Paths.PROPERTIES_YANDEX_PATH)
public class First implements YandexInterfaceProp {
    public First() {
        PropertyLoader.newInstance().populate(this);
    }

    @Property("first.user.login")
    private String login;

    @Property("first.user.psw")
    private String password;

    @Property("first.categories")
    private List<String> categories;

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<String> getCategories() {
        return categories;
    }
}
