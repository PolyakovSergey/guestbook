package com.ps.guestbook.bean;

import com.ps.guestbook.entity.Message;
import com.ps.guestbook.service.MessageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ShowMessageBean implements Serializable {
    @Inject
    MessageService messageService;
    private List<Message> messages;

    @PostConstruct
    public void initMessages() {
        messages = messageService.getAll();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
