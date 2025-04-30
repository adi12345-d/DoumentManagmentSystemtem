package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.model.DocumentEntity;
import com.document.dmdemo.repo.DocumentRepository;
import dmdemo.model.DocumentEntity;
import dmdemo.repo.DocumentRepository;
import dmdemo.service.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DocumentServiceImplTest {

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentServiceImpl documentService;

    private DocumentEntity document;

    @BeforeEach
    public void setup() {
        document = new DocumentEntity();
        document.setId(1L);
        document.setTitle("Sample Document");
        document.setContent("This is a sample document.");
    }

    @Test
    public void testGetDocumentById() {
        // Given
        given(documentRepository.findById(1L)).willReturn(Optional.of(document));

        // When
        DocumentEntity foundDocument = documentService.getDocumentById(1L).orElse(null);

        // Then
        assertThat(foundDocument).isNotNull();
        assertThat(foundDocument.getTitle()).isEqualTo("Sample Document");
    }

    @Test
    public void testSaveDocument() {
        // Given
        given(documentRepository.save(document)).willReturn(document);

        // When
        DocumentEntity savedDocument = documentService.saveDocument(document);

        // Then
        assertThat(savedDocument).isNotNull();
        assertThat(savedDocument.getTitle()).isEqualTo("Sample Document");
    }
}