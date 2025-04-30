package com.document.dmdemo.controller;

import com.document.dmdemo.model.UserEntity;
import com.document.dmdemo.service.UserService;
import com.document.dmdemo.util.ResponseUtil;
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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createUser (@RequestBody UserEntity user) {
        Response jsonResponse = new Response();
        try {
            userService.createUser (user);
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

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getUserById(@PathVariable Long userId) {
        Response jsonResponse = new Response();
        try {
            UserEntity user = userService.getUserById(userId);
            jsonResponse.setSuccessObject(user);
            jsonResponse.setResponseCode(CommonConstants.SUCCESS_CODE);
            jsonResponse.setResponseMessage(MessageConstants.SUCCESS_FETCH_MSG);
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllUsers() {
        Response jsonResponse = new Response();
        try {
            List<UserEntity> users = userService.getAllUsers();
            jsonResponse.setSuccessObject(users);
            jsonResponse.setResponseCode(CommonConstants.SUCCESS_CODE);
            jsonResponse.setResponseMessage(MessageConstants.SUCCESS_FETCH_MSG);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (Exception e) {
            jsonResponse.setResponseCode(CommonConstants.ERROR_CODE);
            jsonResponse.setResponseMessage(e.getMessage());
            return new ResponseEntity<>(jsonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateUser (@RequestBody UserEntity user) {
        Response jsonResponse = new Response();
        try {
            userService.updateUser (user);
            jsonResponse.setResponseCode(CommonConstants.SUCCESS_CODE);
            jsonResponse.setResponseMessage(MessageConstants.SUCCESS_UPDATE_MSG);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
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

    @DeleteMapping(path = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteUser (@PathVariable Long userId) {
        Response jsonResponse = new Response();
        try {
            userService.deleteUser (userId);
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
}