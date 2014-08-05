package com.ps.guestbook.bean;

import com.ps.guestbook.entity.Message;
import com.ps.guestbook.entity.User;
import com.ps.guestbook.service.MessageService;
import com.ps.guestbook.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("request")
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

    private String getUserIpAddress() {
        /*HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ip = httpServletRequest.getRemoteAddr();*/
        String remoteAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRemoteAddr();
        return remoteAddress;
    }

    private String getUserBrowserInfo() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String userAgent = externalContext.getRequestHeaderMap().get("User-Agent");

        if (userAgent.contains("MSIE")) {
            return "Internet Explorer";
        }
        if (userAgent.contains("Firefox")) {
            return "Firefox";
        }
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        }
        if (userAgent.contains("Opera")) {
            return "Opera";
        }
        if (userAgent.contains("Safari")) {
            return "Safari";
        }
        return "Unknown";
    }

    public void send() {
        user.setBrowser(getUserBrowserInfo());
        user.setIpAddress(getUserIpAddress());
        User userFromBase = userService.add(user);
        message.setUser(userFromBase);
        messageService.add(message);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message is sent!", "Done!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        initNewUser();
    }
}
