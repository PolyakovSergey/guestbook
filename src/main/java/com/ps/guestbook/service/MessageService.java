package com.ps.guestbook.service;

import com.ps.guestbook.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MessageService {

    public Message add(Message message);

    public void delete(long id);

    public Message getById(long id);

    public Message editMesage(Message message);

    public List<Message> getAll();

}
