package com.felix.ludus.creator.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class LottoValidator implements Validator {

    @Override
    public List<String> validate(Map<String, String> properties) {
        List<String> errorMessages = new ArrayList<>();

        if(!properties.containsKey("minMain")) errorMessages.add("Missing minMain");
        if(!properties.containsKey("maxMain")) errorMessages.add("Missing maxMain");
        if(!properties.containsKey("mainNum")) errorMessages.add("Missing mainNum");
        if(!properties.containsKey("minBonus")) errorMessages.add("Missing minBonus");
        if(!properties.containsKey("maxBonus")) errorMessages.add("Missing maxBonus");
        if(!properties.containsKey("bonusNum")) errorMessages.add("Missing bonusNum");
        if(!properties.containsKey("mainPrize")) errorMessages.add("Missing mainPrize");

        if(properties.containsKey("minMain") && properties.containsKey("maxMain")) {
            int minMain = Integer.valueOf(properties.get("minMain"));
            int maxMain = Integer.valueOf(properties.get("maxMain"));
            if(minMain < maxMain) {
                errorMessages.add("minMain bigger than maxMain");
            }
        }

        if(properties.containsKey("minMain") && properties.containsKey("maxMain")) {
            int minMain = Integer.valueOf(properties.get("minBonus"));
            int maxMain = Integer.valueOf(properties.get("maxBonus"));
            if(minMain > maxMain) {
                errorMessages.add("minBonus bigger than maxBonus");
            }
        }

        return errorMessages;
    }
}
