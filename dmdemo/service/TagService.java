package com.document.dmdemo.service;

import com.document.dmdemo.exception.InvalidTagException;
import com.document.dmdemo.model.TagEntity;

import java.util.List;

public interface TagService {
    TagEntity createTag(TagEntity tag) throws InvalidTagException;
    TagEntity updateTag(TagEntity tag) throws InvalidTagException;
    void deleteTag(Long tagId);
    TagEntity getTagById(Long tagId);
    TagEntity getTagByName(String name);
    List<TagEntity> getAllTags();
}