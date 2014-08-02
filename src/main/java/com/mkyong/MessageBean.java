package com.mkyong;

import com.mkyong.entity.Message;
import com.mkyong.entity.User;
import com.mkyong.service.MessageService;
import com.mkyong.service.UserService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("session")
public class MessageBean {

    @Inject
    MessageService messageService;

    @Inject
    UserService userService;

    @Named
    User user;

    @Named
    Message message;

    @PostConstruct
    public void initNewUser() {
        user = new User();
        message = new Message();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String send(){
        User userFromBase = userService.add(user);
        message.setUser(userFromBase);
        messageService.add(message);
        return "";
    }
}
