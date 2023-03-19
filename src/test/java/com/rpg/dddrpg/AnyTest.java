package com.rpg.dddrpg;

import com.rpg.dddrpg.domain.mapper.enemy.EnemyMapperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class AnyTest {

    @Autowired
    private EnemyMapperRepository repository;

    @Test
    public void test() {

        var entity = repository.findById(UUID.randomUUID().toString());
        System.out.println(entity.getId());

    }


}
