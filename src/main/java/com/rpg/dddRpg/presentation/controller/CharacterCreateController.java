package com.rpg.dddRpg.presentation.controller;

import com.rpg.dddRpg.application.service.CharacterRecordService;
import com.rpg.dddRpg.presentation.controller.request.CharacterCreateRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/character/create", consumes = {
        MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class CharacterCreateController {


    private final CharacterRecordService characterRecordService;

    public CharacterCreateController(CharacterRecordService characterRecordService) {
        this.characterRecordService = characterRecordService;
    }

    @PostMapping(path = "/findBy", consumes = {
            MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void create(@RequestBody CharacterCreateRequest characterCreateRequest) {
        characterRecordService.create(characterCreateRequest);
    }
}
