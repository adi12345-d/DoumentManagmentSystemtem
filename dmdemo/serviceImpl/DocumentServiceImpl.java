package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.DocumentNotFoundException;
import com.document.dmdemo.exception.InvalidDocumentException;
import com.document.dmdemo.model.DocumentEntity;
import com.document.dmdemo.repo.DocumentRepository;
import com.document.dmdemo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentEntity saveDocument(DocumentEntity document) throws InvalidDocumentException {
        validateDocument(document);
        return documentRepository.save(document);
    }

    @Override
    public DocumentEntity updateDocument(DocumentEntity document) throws InvalidDocumentException {
        if (!documentRepository.existsById(document.getId())) {
            throw new DocumentNotFoundException("Document not found with ID: " + document.getId());
        }
        validateDocument(document);
        return documentRepository.save(document);
    }

    @Override
    public void deleteDocument(Long documentId) {
        if (!documentRepository.existsById(documentId)) {
            throw new DocumentNotFoundException("Document not found with ID: " + documentId);
        }
        documentRepository.deleteById(documentId);
    }

    @Override
    public DocumentEntity getDocumentById(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new DocumentNotFoundException("Document not found with ID: " + documentId));
    }

    @Override
    public List<DocumentEntity> getAllDocuments() {
        return documentRepository.findAll();
    }

    private void validateDocument(DocumentEntity document) throws InvalidDocumentException {
        if (document.getTitle() == null || document.getTitle().isEmpty()) {
            throw new InvalidDocumentException("Document title cannot be empty.");
        }
        if (document.getContent() == null || document.getContent().isEmpty()) {
            throw new InvalidDocumentException("Document content cannot be empty.");
        }
        if (document.getAuthor() == null || document.getAuthor().isEmpty()) {
            throw new InvalidDocumentException("Document author cannot be empty.");
        }
    }
}