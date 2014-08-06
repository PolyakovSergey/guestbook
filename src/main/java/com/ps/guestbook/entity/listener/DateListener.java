package com.ps.guestbook.entity.listener;

import com.ps.guestbook.entity.AbstractEntity;
import com.ps.guestbook.entity.Message;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class DateListener {

    @PrePersist
    public void prePersist(Message message) {
        message.setCreateDate(new Date());
    }
}
