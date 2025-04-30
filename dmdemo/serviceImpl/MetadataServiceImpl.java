package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.MetadataNotFoundException;
import com.document.dmdemo.model.MetadataEntity;
import com.document.dmdemo.repo.MetadataRepository;
import com.document.dmdemo.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.InvalidMetadataException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    private MetadataRepository metadataRepository;

    @Override
    public MetadataEntity saveMetadata(MetadataEntity metadata) {
        validateMetadata(metadata);
        return metadataRepository.save(metadata);
    }

    @Override
    public MetadataEntity updateMetadata(MetadataEntity metadata) {
        if (!metadataRepository.existsById(metadata.getId())) {
            throw new MetadataNotFoundException("Metadata not found with ID: " + metadata.getId());
        }
        validateMetadata(metadata);
        return metadataRepository.save(metadata);
    }

    @Override
    public void deleteMetadata(Long metadataId) {
        if (!metadataRepository.existsById(metadataId)) {
            throw new MetadataNotFoundException("Metadata not found with ID: " + metadataId);
        }
        metadataRepository.deleteById(metadataId);
    }

    @Override
    public MetadataEntity getMetadataById(Long metadataId) {
        return metadataRepository.findById(metadataId)
                .orElseThrow(() -> new MetadataNotFoundException("Metadata not found with ID: " + metadataId));
    }

    @Override
    public List<MetadataEntity> getAllMetadata() {
        return metadataRepository.findAll();
    }

    private void validateMetadata(MetadataEntity metadata) {
        if (metadata.getKey() == null || metadata.getKey().isEmpty()) {
            throw new InvalidMetadataException("Metadata key cannot be empty.");
        }
        if (metadata.getValue() == null || metadata.getValue().isEmpty()) {
            throw new InvalidMetadataException("Metadata value cannot be empty.");
        }
    }
}