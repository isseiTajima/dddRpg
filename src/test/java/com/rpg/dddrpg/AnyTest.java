package com.rpg.dddrpg;

import com.rpg.dddrpg.domain.repository.BattleHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnyTest {

    @Autowired
    private BattleHistoryRepository repository;

    @Test
    public void test() {
//
//        var entity = repository.findOneById();
//        System.out.println(entity.get(0).getName());

    }


}
