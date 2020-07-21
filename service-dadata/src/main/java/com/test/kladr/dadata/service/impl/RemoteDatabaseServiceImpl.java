package com.test.kladr.dadata.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class RemoteDatabaseServiceImpl {

    protected Properties properties;

    public RemoteDatabaseServiceImpl() {
        try {
            InputStream inputStream = RemoteDatabaseServiceImpl.class.getClassLoader().getResourceAsStream("dadata.properties");

            this.properties = new Properties();

            this.properties.load(inputStream);
        } catch (IOException e) {
            //TODO: exception handling
            e.printStackTrace();
        }
    }
}