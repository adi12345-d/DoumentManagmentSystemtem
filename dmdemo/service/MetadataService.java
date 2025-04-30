package com.document.dmdemo.service;

import com.document.dmdemo.model.MetadataEntity;

import java.util.List;

public interface MetadataService {
    MetadataEntity createMetadata(MetadataEntity metadata);
    void deleteMetadata(Long metadataId);
    List<MetadataEntity> getMetadataByKeyword(String keyword);

    List<MetadataEntity> getAllMetadata();

    MetadataEntity updateMetadata(MetadataEntity metadata);

    MetadataEntity getMetadataById(Long metadataId);
}