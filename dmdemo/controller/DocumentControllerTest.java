package com.document.dmdemo.controller;

import com.document.dmdemo.model.DocumentEntity;
import com.document.dmdemo.service.DocumentService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;


@WebMvcTest(DocumentController.class)
public class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DocumentService documentService;

    private DocumentEntity document;

    @BeforeEach
    public void setup() {
        document = new DocumentEntity();
        document.setId(1L);
        document.setTitle("Sample Document");
        document.setContent("This is a sample document.");
    }

    @Test
    public void testGetDocumentById() throws Exception {
        // Given
        given(documentService.getDocumentById(1L)).willReturn(Optional.of(document));

        // When & Then
        mockMvc.perform(get("/documents/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveDocument() throws Exception {
        // Given
        given(documentService.saveDocument(document)).willReturn(document);

        // When & Then
        mockMvc.perform(post("/documents")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Sample Document\",\"content\":\"This is a sample document.\"}"))
                .andExpect(status().isCreated());
    }
}