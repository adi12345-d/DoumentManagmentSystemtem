package com.document.dmdemo.controller;

import com.document.dmdemo.model.MetadataEntity;
import com.document.dmdemo.service.MetadataService;
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
@RequestMapping("/api/metadata")
public class MetadataController {

    @Autowired
    private MetadataService metadataService;

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createMetadata(@RequestBody MetadataEntity metadata) {
        Response jsonResponse = new Response();
        try {
            metadataService.createMetadata(metadata);
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

    @GetMapping(path = "/{metadataId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getMetadataById(@PathVariable Long metadataId) {
        Response jsonResponse = new Response();
        try {
            MetadataEntity metadata = metadataService.getMetadataById(metadataId);
            jsonResponse.setSuccessObject(metadata);
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
    public ResponseEntity<Response> getAllMetadata() {
        Response jsonResponse = new Response();
        try {
            List<MetadataEntity> metadataList = metadataService.getAllMetadata();
            jsonResponse.setSuccessObject(metadataList);
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
    public ResponseEntity<Response> updateMetadata(@RequestBody MetadataEntity metadata) {
        Response jsonResponse = new Response();
        try {
            metadataService.updateMetadata(metadata);
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

    @DeleteMapping(path = "/delete/{metadataId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteMetadata(@PathVariable Long metadataId) {
        Response jsonResponse = new Response();
        try {
            metadataService.deleteMetadata(metadataId);
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