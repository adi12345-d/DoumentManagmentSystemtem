package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.IngestionProcessNotFoundException;
import com.document.dmdemo.model.IngestionProcessEntity;
import com.document.dmdemo.repo.IngestionProcessRepository;
import com.document.dmdemo.service.IngestionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngestionProcessServiceImpl implements IngestionProcessService {

    @Autowired
    private IngestionProcessRepository ingestionProcessRepository;

    @Override
    public IngestionProcessEntity saveIngestionProcess(IngestionProcessEntity ingestionProcess) {
        return ingestionProcessRepository.save(ingestionProcess);
    }

    @Override
    public void deleteIngestionProcess(Long ingestionProcessId) {
        if (!ingestionProcessRepository.existsById(ingestionProcessId)) {
            throw new IngestionProcessNotFoundException("Ingestion process not found with ID: " + ingestionProcessId);
        }
        ingestionProcessRepository.deleteById(ingestionProcessId);
    }

    @Override
    public IngestionProcessEntity getIngestionProcessById(Long ingestionProcessId) {
        return ingestionProcessRepository.findById(ingestionProcessId)
                .orElseThrow(() -> new IngestionProcessNotFoundException("Ingestion process not found with ID: " + ingestionProcessId));
    }

    @Override
    public List<IngestionProcessEntity> getAllIngestionProcesses() {
        return ingestionProcessRepository.findAll();
    }
}