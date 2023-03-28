package com.rpg.dddrpg.application.service;

import com.rpg.dddrpg.domain.model.battle.BattleDetailHistory;
import com.rpg.dddrpg.domain.model.battle.BattleDetailsHistory;
import com.rpg.dddrpg.domain.model.battle.BattleHistory;
import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.model.enemy.Enemy;
import com.rpg.dddrpg.domain.model.enemy.EnemyStatus;
import com.rpg.dddrpg.domain.repository.BattleHistoryRepository;
import com.rpg.dddrpg.domain.type.ActionType;
import com.rpg.dddrpg.domain.type.FhaseType;
import com.rpg.dddrpg.domain.value.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * 戦闘開始に関するサービス
 */
@Service
@Transactional
public class BattleService {

    private BattleHistoryRepository battleHistoryRepository;

    /**
     * バトル開始
     *
     * @param character  キャラクター
     * @param enemy      　敵
     * @param actionType 　行動タイプ
     */
    public void execute(Character character,
                        Enemy enemy, ActionType actionType) {

        // 敵の行動タイプを決定
        ActionType enemyActionType = ActionType.randomType();

        // どちらのフェーズか決定
        FhaseType fhaseType = getFhaseType(character, enemy);

        // 攻撃に応じてHPを減算
        Character turnedCharacter;
        if (enemyActionType.isDefence()) {
            // turnedCharacter
            turnedCharacter = character;
        } else {
            turnedCharacter = attackEnemyFor(character, actionType, enemy);
        }

        // 攻撃に応じてHPを減算
        Enemy turnedEnemy;
        if (enemyActionType.isDefence()) {
            // 防御の場合はそのまま
            turnedEnemy = enemy;
        } else {
            turnedEnemy = attackAllyFor(character, actionType, enemy);
        }


        // 戦闘履歴の保存
        battleHistoryRepository.save(createBattleHistory(turnedCharacter, turnedEnemy,
                actionType, enemyActionType));

    }

    /**
     * 戦闘履歴を作成する
     *
     * @param turnedCharacter ターン後のキャラクター
     * @param turnedEnemy     　ターン後の敵
     * @param actionType      キャラクターの行動
     * @param enemyActionType 　敵の行動
     * @return 戦闘履歴
     */
    BattleHistory createBattleHistory(Character turnedCharacter, Enemy turnedEnemy, ActionType actionType, ActionType enemyActionType) {

        var builder = BattleHistory.builder();
        var id = UUID.randomUUID();
        builder.id(id);
        builder.battleDetailsHistory(createBattleDetail(turnedCharacter, turnedEnemy, id,
                actionType, enemyActionType));
        return builder.build();

    }

    /**
     * 戦闘履歴明細を作成する
     *
     * @param turnedCharacter 　ターン後のキャラクター
     * @param turnedEnemy     　ターン後の敵
     * @param id              戦闘履歴ID
     * @param actionType      キャラクターの行動
     * @param enemyActionType 　敵の行動
     * @return　戦闘履歴明細
     */
    BattleDetailsHistory createBattleDetail(Character turnedCharacter, Enemy turnedEnemy, UUID id, ActionType actionType, ActionType enemyActionType) {

        var builder = BattleDetailHistory.builder();
        builder.id(UUID.randomUUID());
        builder.battleHistoryId(id);
        builder.hp(turnedCharacter.getStatus().getHp());
        builder.actionType(actionType);
        builder.enemyHp(turnedEnemy.getStatus().getHp());
        builder.enemyActionType(enemyActionType);
        return BattleDetailsHistory.of(new ArrayList<>(Arrays.asList(builder.build())));
    }

    /**
     * 敵の攻撃
     *
     * @param character  攻撃されるキャラクター
     * @param actionType 　キャラの行動タイプ
     * @param enemy
     * @return 攻撃後のキャラクター
     */
    Character attackEnemyFor(Character character, ActionType actionType, Enemy enemy) {

        var builder = character.toBuilder();
        var statusBuilder = character.getStatus().toBuilder();
        Hp hp;
        if (actionType.isAttack()) {
            // 通常攻撃時
            hp = character.getStatus().attackedHp(enemy.getStatus().getAttack());
        } else {
            //　防御時
            hp = character.getStatus().attackedDefenceHp(enemy.getStatus().getAttack());
        }
        // hpのみ設定しなおして再ビルド
        statusBuilder.hp(hp);
        return builder.status(statusBuilder.build()).build();
    }

    /**
     * 敵の攻撃
     *
     * @param character  攻撃するキャラクター
     * @param actionType 　敵の行動タイプ
     * @param enemy      　攻撃される敵
     * @return 攻撃後のキャラクター
     */
    Enemy attackAllyFor(Character character, ActionType actionType, Enemy enemy) {

        var builder = enemy.toBuilder();
        var statusBuilder = enemy.getStatus().toBuilder();
        Hp hp;
        if (actionType.isAttack()) {
            // 通常攻撃時
            hp = enemy.getStatus().attackedHp(character.getStatus().getAttack());
        } else {
            //　防御時
            hp = enemy.getStatus().attackedDefenceHp(character.getStatus().getAttack());
        }
        // hpのみ設定しなおして再ビルド
        statusBuilder.hp(hp);
        return builder.status(statusBuilder.build()).build();
    }

    /**
     * 行動タイプを取得する
     *
     * @param character 　キャラクター
     * @param enemy     敵
     * @return 行動タイプ
     */
    FhaseType getFhaseType(Character character, Enemy enemy) {

        Speed speed = character.getStatus().getSpeed();
        Speed enemySpeed = enemy.getStatus().getSpeed();

        /**
         * スピードを比較して値が大きい方のフェーズを返却する
         */
        if (speed.moreThenEqualFrom(enemySpeed)) {
            return FhaseType.enemy;
        }
        return FhaseType.ally;

    }

    EnemyStatus createStatus(UUID enemyId) {
        return EnemyStatus.builder()
                .id(UUID.randomUUID())
                .enemyId(enemyId)
                .level(Level.initial())
                .hp(Hp.randomInitial())
                .attack(Attack.randomInitial())
                .defence(Defence.randomInitial())
                .speed(Speed.randomInitial())
                .build();
    }

}
