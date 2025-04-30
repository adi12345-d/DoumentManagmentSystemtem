package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.InvalidTagException;
import com.document.dmdemo.exception.TagNotFoundException;
import com.document.dmdemo.model.TagEntity;
import com.document.dmdemo.repo.TagRepository;
import com.document.dmdemo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public TagEntity createTag(TagEntity tag) throws InvalidTagException {
        validateTag(tag); // Validate the tag before saving
        return tagRepository.save(tag); // Save the tag and return the saved entity
    }

    @Override
    public TagEntity updateTag(TagEntity tag) throws InvalidTagException {
        if (tag.getId() == null) {
            throw new IllegalArgumentException("Tag ID cannot be null.");
        }
        if (!tagRepository.existsById(tag.getId())) {
            throw new TagNotFoundException("Tag not found with ID: " + tag.getId());
        }
        validateTag(tag);
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long tagId) {
        Long longTagId;
        try {
            longTagId = Long.parseLong(String.valueOf(tagId)); // Convert String to Long
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid tag ID format: " + tagId);
        }

        if (!tagRepository.existsById(longTagId)) {
            throw new TagNotFoundException("Tag not found with ID: " + longTagId);
        }
        tagRepository.deleteById(longTagId);
    }

    @Override
    public TagEntity getTagById(String tagId) {
        Long longTagId;
        try {
            longTagId = Long.parseLong(tagId); // Convert String to Long
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid tag ID format: " + tagId);
        }

        return tagRepository.findById(longTagId)
                .orElseThrow(() -> new TagNotFoundException("Tag not found with ID: " + longTagId));
    }



    @Override
    public TagEntity getTagByName(String name) {
        // Assuming you have a method in TagRepository to find by name
        return tagRepository.findByName(name)
                .orElseThrow(() -> new TagNotFoundException("Tag not found with name: " + name));
    }

    @Override
    public List<TagEntity> getAllTags() {
        return tagRepository.findAll();
    }

    private void validateTag(TagEntity tag) throws InvalidTagException {
        if (tag.getName() == null || tag.getName().isEmpty()) {
            throw new InvalidTagException("Tag name cannot be empty.");
        }
    }
}