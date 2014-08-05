package com.ps.guestbook.service.impl;

import com.ps.guestbook.entity.Message;
import com.ps.guestbook.repository.MessageRepository;
import com.ps.guestbook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message add(Message message) {
        message.setCreateDate(new Date());
        return messageRepository.save(message);
    }

    @Override
    public void delete(long id) {
        messageRepository.delete(id);
    }

    @Override
    public Message getById(long id) {
        return messageRepository.findOne(id);
    }

    @Override
    public Message editMesage(Message message) {
        return messageRepository.saveAndFlush(message);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }
}
