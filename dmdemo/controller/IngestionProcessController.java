package com.document.dmdemo.controller;

import com.document.dmdemo.model.IngestionProcessEntity;
import com.document.dmdemo.service.IngestionProcessService;
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
@RequestMapping("/api/ingestion-processes")
public class IngestionProcessController {

    @Autowired
    private IngestionProcessService ingestionProcessService;

    @PostMapping(path = "/start", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> startIngestionProcess(@RequestBody IngestionProcessEntity ingestionProcess) {
        Response jsonResponse = new Response();
        try {
            ingestionProcessService.startIngestionProcess(ingestionProcess);
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

    @GetMapping(path = "/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getIngestionProcessesByStatus(@PathVariable String status) {
        Response jsonResponse = new Response();
        try {
            List<IngestionProcessEntity> processes = ingestionProcessService.getIngestionProcessesByStatus(status);
            jsonResponse.setSuccessObject(processes);
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