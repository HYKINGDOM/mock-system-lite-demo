package com.java.metaadmin.service;

public interface MessageService {



    void convertAndSend(Object object);


    void syncSend(Object object);


    void asyncSend(Object object);
}
