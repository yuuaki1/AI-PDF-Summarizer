package com.ds.rep.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.rep.entity.Chat;

public interface ChatRepo extends JpaRepository<Chat, Long> {
    //List<Chat> findByUser(User user);
}
