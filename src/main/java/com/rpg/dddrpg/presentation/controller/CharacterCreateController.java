package com.rpg.dddrpg.presentation.controller;

import com.rpg.dddrpg.application.service.CharacterRecordService;
import com.rpg.dddrpg.presentation.controller.request.CharacterCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/character", consumes = {
        MediaType.APPLICATION_JSON_VALUE},
        produces = {
                MediaType.APPLICATION_JSON_VALUE})
public class CharacterCreateController {


    @Autowired
    private final CharacterRecordService characterRecordService;

    public CharacterCreateController(CharacterRecordService characterRecordService) {
        this.characterRecordService = characterRecordService;
    }

    @PostMapping(path = "/create", consumes = {
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE})
    // urlencodedの場合@RequestBodyは付けない
    @Operation(summary = "キャラクターを作成します。")
    @ResponseBody
    public void create(@RequestBody CharacterCreateRequest characterCreateRequest) {
        characterRecordService.create
                (characterCreateRequest);
    }
}
