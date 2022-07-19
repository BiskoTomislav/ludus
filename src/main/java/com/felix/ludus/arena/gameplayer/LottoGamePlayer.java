package com.felix.ludus.arena.gameplayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * JSON for LOTTO game properties:
 *
 * {
 *     "name": "test",
 *     "type": "LOTTO",
 *     "properties": {
 *         "minMain": 1,
 *         "maxMain": 46,
 *         "mainNum": 5,
 *         "minBonus": 1,
 *         "maxBonus": 9,
 *         "bonusNum": 3,
 *         "mainPrize": 10000
 *     }
 * }
 */
public class LottoGamePlayer implements GamePlayer {

    @Override
    public Map<String, String> play(Map<String, String> properties) {
        Map<String, String> result = new HashMap<>();


        int minMain = Integer.valueOf(properties.get("minMain"));
        int maxMain = Integer.valueOf(properties.get("maxMain"));
        int mainNum = Integer.valueOf(properties.get("mainNum"));

        int minBonus = Integer.valueOf(properties.get("minBonus"));
        int maxBonus = Integer.valueOf(properties.get("maxBonus"));
        int bonusNum = Integer.valueOf(properties.get("bonusNum"));

        int mainPrize = Integer.valueOf(properties.get("mainPrize"));

        Random random = new Random();
        for (int i = 0; i < mainNum; i++) {
            result.put("main_" + i, String.valueOf(random.nextInt(maxMain) + minMain));
        }

        for (int i = 0; i < bonusNum; i++) {
            result.put("bonus_" + i, String.valueOf(random.nextInt(maxBonus) + minBonus));
        }


        return result;
    }
}
