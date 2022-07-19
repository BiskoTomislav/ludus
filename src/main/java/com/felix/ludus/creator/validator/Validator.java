package com.felix.ludus.creator.validator;

import java.util.List;
import java.util.Map;

public interface Validator {

    List<String> validate(Map<String, String> properties);
}
