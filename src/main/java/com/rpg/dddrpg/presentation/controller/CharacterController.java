package com.rpg.dddrpg.presentation.controller;

import com.rpg.dddrpg.application.service.CharacterRegisterService;
import com.rpg.dddrpg.application.service.CharacterSearchService;
import com.rpg.dddrpg.application.service.request.CharacterRegisterServiceRequest;
import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.model.character.Status;
import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.Name;
import com.rpg.dddrpg.presentation.controller.request.CharacterCreateRequest;
import com.rpg.dddrpg.presentation.controller.request.CharacterSearchRequest;
import com.rpg.dddrpg.presentation.controller.response.CharacterSearchResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/character", consumes = {
        MediaType.APPLICATION_JSON_VALUE},
        produces = {
                MediaType.APPLICATION_JSON_VALUE})
public class CharacterController {


    private final CharacterRegisterService characterRegisterService;
    private final CharacterSearchService characterSearchService;

    public CharacterController(CharacterRegisterService characterRegisterService,
                               CharacterSearchService characterSearchService) {
        this.characterRegisterService = characterRegisterService;
        this.characterSearchService = characterSearchService;
    }

    @PostMapping(path = "/create", consumes = {
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE})
    // Note:urlencodedの場合@RequestBodyは付けない
    @Operation(summary = "キャラクターを作成します。")
    @ResponseBody
    public void create(@RequestBody CharacterCreateRequest characterCreateRequest) {
        characterRegisterService.execute
                (convertRegisterServiceRequest(characterCreateRequest));
    }

    @PostMapping(path = "/search", consumes = {
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "キャラクターを検索します。")
    @ResponseBody
    public ResponseEntity<CharacterSearchResponse> create(@RequestBody CharacterSearchRequest request) {
        return new ResponseEntity<>(createSearchResponse(characterSearchService.execute
                (request)), HttpStatus.OK);
    }

    /**
     * サービスのリクエストを作成する
     *
     * @param request リクエスト
     * @return サービスリクエスト
     */
    CharacterRegisterServiceRequest convertRegisterServiceRequest(CharacterCreateRequest request) {
        var serviceRequest = CharacterRegisterServiceRequest.of(
                request.getId(), Name.of(request.getName()), CharacterType.findByName(request.getCharacterTypeName()),
                GenderType.findByName(request.getGenderTypeName()), RaceType.findByName(request.getRaceTypeName()),
                JobType.findByName(request.getJobTypeName()));
        return serviceRequest;
    }

    /**
     * キャラクターからresponseを作成
     *
     * @param character キャラクター
     * @return キャラクターレスポンス
     */
    CharacterSearchResponse createSearchResponse(Character character) {
        var response = new CharacterSearchResponse();
        response.setId(character.getId());
        response.setName(character.getName().getValue());
        response.setCharacterTypeName(character.getCharacterType().getName());
        response.setGenderTypeName(character.getGenderType().getName());
        response.setRaceTypeName(character.getRaceType().getName());
        response.setJobTypeName(character.getJobType().getName());
        response.setLevel(character.getLevel().getValue());
        Status status = character.getStatus();
        response.setHp(status.getHp().getValue());
        response.setAttack(status.getAttack().getValue());
        response.setDefence(status.getDefence().getValue());
        response.setSpeed(status.getSpeed().getValue());
        return response;
    }

}
