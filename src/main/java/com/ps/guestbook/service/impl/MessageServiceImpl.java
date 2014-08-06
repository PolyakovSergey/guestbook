package com.ps.guestbook.service.impl;

import com.ps.guestbook.entity.Message;
import com.ps.guestbook.repository.MessageRepository;
import com.ps.guestbook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    @Transactional
    public Message add(Message message) {
        return messageRepository.save(message);
    }

    @Override
    @Transactional
    public void delete(long id) {
        messageRepository.delete(id);
    }

    @Override
    @Transactional
    public Message getById(long id) {
        return messageRepository.findOne(id);
    }

    @Override
    @Transactional
    public Message editMesage(Message message) {
        return messageRepository.saveAndFlush(message);
    }

    @Override
    @Transactional
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

}
