package com.rpg.dddrpg.presentation.controller;

import com.rpg.dddrpg.application.service.EnemyRegisterService;
import com.rpg.dddrpg.domain.value.Name;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/create", consumes = {
        MediaType.APPLICATION_JSON_VALUE},
        produces = {
                MediaType.APPLICATION_JSON_VALUE})
public class EnemyController implements EnemyApi {

    private final EnemyRegisterService enemyRegisterService;


    public EnemyController(EnemyRegisterService enemyRegisterService) {
        this.enemyRegisterService = enemyRegisterService;
    }

    @Override
    public ResponseEntity<Object> enemyCreatePost(
            @Parameter(name = "EnemyCreateRequest", description = "") @Valid @RequestBody(required = false) EnemyCreateRequest enemyCreateRequest
    ) {

        enemyRegisterService.execute(Name.of(enemyCreateRequest.getName()));

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
