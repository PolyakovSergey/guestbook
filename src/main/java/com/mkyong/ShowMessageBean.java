package com.mkyong;

import com.mkyong.entity.Message;
import com.mkyong.service.MessageService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ShowMessageBean implements Serializable {


    private List<Message> messages;

    @Inject
    MessageService messageService;

    @PostConstruct
    public void init() {
        messages = messageService.getAll();

    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


}
