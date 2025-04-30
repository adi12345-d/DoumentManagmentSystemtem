package com.document.dmdemo.service;

import com.document.dmdemo.exception.InvalidDocumentException;
import com.document.dmdemo.model.DocumentEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DocumentService {
    DocumentEntity saveDocument(DocumentEntity document) throws InvalidDocumentException;
    DocumentEntity updateDocument(DocumentEntity document) throws InvalidDocumentException;
    void deleteDocument(Long documentId);
    DocumentEntity getDocumentById(Long documentId);
    List<DocumentEntity> searchDocuments(String query);
    List<DocumentEntity> getDocumentsByAuthor(String author);

    List<DocumentEntity> getAllDocuments();
}