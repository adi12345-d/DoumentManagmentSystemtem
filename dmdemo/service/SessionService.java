package com.document.dmdemo.service;

import com.document.dmdemo.model.SessionEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SessionService {
    SessionEntity createSession(SessionEntity session);
    void deleteSession(Long sessionId);
    List<SessionEntity> getSessionsByUserId(Long userId);
}