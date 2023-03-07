package com.rpg.dddRpg.domain.value;

import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HpTest {

    @Test
    void initial() {

        var value = Hp.initial(GenderType.man,
                RaceType.human, JobType.hero);
        System.out.println(value.getValue());

    }

    @Test
    void calcRandomDiffValue() {

        var value = Hp.calcRandomDiffValue(5, 10);

        assertThat(value).isGreaterThanOrEqualTo(0);
        assertThat(value).isLessThanOrEqualTo(5);

    }
}