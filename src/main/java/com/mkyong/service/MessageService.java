package com.mkyong.service;

import com.mkyong.entity.Message;

import java.util.List;

public interface MessageService {

    public Message add(Message message);

    public void delete(long id);

    public Message getById(long id);

    public Message editMesage(Message message);

    public List<Message> getAll();
}
