package com.test.kladr.dadata.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class RemoteDatabaseService {

    protected Properties properties;

    public RemoteDatabaseService() {
        try {
            InputStream inputStream = RemoteDatabaseService.class.getClassLoader().getResourceAsStream("dadata.properties");

            this.properties = new Properties();

            this.properties.load(inputStream);
        } catch (IOException e) {
            //TODO: exception handling
            e.printStackTrace();
        }
    }
}