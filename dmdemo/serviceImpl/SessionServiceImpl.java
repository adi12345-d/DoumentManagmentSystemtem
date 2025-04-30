package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.SessionNotFoundException;
import com.document.dmdemo.model.SessionEntity;
import com.document.dmdemo.repo.SessionRepository;
import com.document.dmdemo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public SessionEntity saveSession(SessionEntity session) {
        return sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Long sessionId) {
        if (!sessionRepository.existsById(sessionId)) {
            throw new SessionNotFoundException("Session not found with ID: " + sessionId);
        }
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public SessionEntity getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException("Session not found with ID: " + sessionId));
    }

    @Override
    public List<SessionEntity> getAllSessions() {
        return sessionRepository.findAll();
    }
}