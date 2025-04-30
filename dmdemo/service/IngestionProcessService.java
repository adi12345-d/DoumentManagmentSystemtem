package com.document.dmdemo.service;

import com.document.dmdemo.model.IngestionProcessEntity;

import java.util.List;

public interface IngestionProcessService {
    IngestionProcessEntity startIngestionProcess(IngestionProcessEntity ingestionProcess);
    List<IngestionProcessEntity> getIngestionProcessesByStatus(String status);
}