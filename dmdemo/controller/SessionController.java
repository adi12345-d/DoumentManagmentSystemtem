package com.document.dmdemo.controller;

import com.document.dmdemo.model.SessionEntity;
import com.document.dmdemo.service.SessionService;
import com.document.dmdemo.exception.CommonException;
import com.document.dmdemo.constants.CommonConstants;
import com.document.dmdemo.constants.MessageConstants;
import com.document.dmdemo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createSession(@RequestBody SessionEntity session) {
        Response jsonResponse = new Response();
        try {
            sessionService.createSession(session);
            jsonResponse.setResponseCode(CommonConstants.SUCCESS_CODE);
            jsonResponse.setResponseMessage(MessageConstants.SUCCESS_SAVE_MSG);
            return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
        } catch (CommonException e) {
            jsonResponse.setResponseCode(CommonConstants.ERROR_CODE);
            jsonResponse.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            jsonResponse.setResponseCode(CommonConstants.ERROR_CODE);
            jsonResponse.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/delete/{sessionId }", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteSession(@PathVariable Long sessionId) {
        Response jsonResponse = new Response();
        try {
            sessionService.deleteSession(sessionId);
            jsonResponse.setResponseCode(CommonConstants.SUCCESS_CODE);
            jsonResponse.setResponseMessage(MessageConstants.SUCCESS_DELETE_MSG);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (CommonException e) {
            jsonResponse.setResponseCode(CommonConstants.ERROR_CODE);
            jsonResponse.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            jsonResponse.setResponseCode(CommonConstants.ERROR_CODE);
            jsonResponse.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getSessionsByUserId(@PathVariable Long userId) {
        Response jsonResponse = new Response();
        try {
            List<SessionEntity> sessions = sessionService.getSessionsByUserId(userId);
            jsonResponse.setSuccessObject(sessions);
            jsonResponse.setResponseCode(CommonConstants.SUCCESS_CODE);
            jsonResponse.setResponseMessage(MessageConstants.SUCCESS_FETCH_MSG);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (Exception e) {
            jsonResponse.setResponseCode(CommonConstants.ERROR_CODE);
            jsonResponse.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}