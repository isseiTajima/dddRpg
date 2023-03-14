package com.rpg.dddrpg.presentation.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/battle", consumes = {
        MediaType.APPLICATION_JSON_VALUE},
        produces = {
                MediaType.APPLICATION_JSON_VALUE})
public class BattleController implements BattleApi {


    public BattleController() {
    }

    @Override
    public ResponseEntity<Object> battleTurnstartPost(
            @Parameter(name = "BattleRequest", description = "") @Valid @RequestBody(required = false) BattleRequest battleRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


}
