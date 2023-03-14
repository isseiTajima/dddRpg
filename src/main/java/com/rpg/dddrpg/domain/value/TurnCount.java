package com.rpg.dddrpg.domain.value;

import lombok.Value;

/**
 * ターン数
 */
@Value(staticConstructor = "of")
public class TurnCount {
    Integer value;

}


