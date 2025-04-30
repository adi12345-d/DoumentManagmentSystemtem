package com.document.dmdemo.controller;

import com.document.dmdemo.model.RoleEntity;
import com.document.dmdemo.service.RoleService;
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
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createRole(@RequestBody RoleEntity role) {
        Response jsonResponse = new Response();
        try {
            roleService.createRole(role);
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

    @GetMapping(path = "/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getRoleById(@PathVariable Long roleId) {
        Response jsonResponse = new Response();
        try {
            RoleEntity role = roleService.getRoleById(roleId);
            jsonResponse.setSuccessObject(role);
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
    public ResponseEntity<Response> getAllRoles() {
        Response jsonResponse = new Response();
        try {
            List<RoleEntity> roles = roleService.getAllRoles();
            jsonResponse.setSuccessObject(roles);
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
    public ResponseEntity<Response> updateRole(@RequestBody RoleEntity role) {
        Response jsonResponse = new Response();
        try {
            roleService.updateRole(role);
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

    @DeleteMapping(path = "/delete/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteRole(@PathVariable Long roleId) {
        Response jsonResponse = new Response();
        try {
            roleService.deleteRole(roleId);
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