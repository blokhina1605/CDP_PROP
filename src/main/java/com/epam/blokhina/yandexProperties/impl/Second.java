package com.epam.blokhina.yandexProperties.impl;

import com.epam.blokhina.Paths;
import com.epam.blokhina.yandexProperties.YandexInterfaceProp;
import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

import java.util.List;


@Resource.Classpath(Paths.PROPERTIES_YANDEX_PATH)
public class Second implements YandexInterfaceProp {

    @Property("second.user.login")
    private String login;

    @Property("second.user.psw")
    private String password;

    @Property("second.categories")
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
