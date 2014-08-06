package com.ps.guestbook.repository;

import com.ps.guestbook.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    public Page<Message> findAll (Pageable pageable);

    public List<Message> findAll ();

    public long count();
}
