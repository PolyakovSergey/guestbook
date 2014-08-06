package com.ps.guestbook.entity;

import com.ps.guestbook.entity.listener.DateListener;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "\"message\"")
@EntityListeners({DateListener.class})
public class Message extends AbstractEntity {

    @Column(name = "text")
    @Type(type = "text")
    private String text;

    @Column(name = "homepage")
    private String homepage;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Message() {
    }

    public Message(String text, String homepage, Date createDate, User user) {
        this.text = text;
        this.homepage = homepage;
        this.createDate = createDate;
        this.user = user;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Message){
            Message message = (Message) obj;
            return message.getId() == getId();
        }
        return false;
    }

}
