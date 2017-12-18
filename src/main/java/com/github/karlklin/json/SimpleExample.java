package com.github.karlklin.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SimpleExample {

    private ObjectMapper mapper = new ObjectMapper();

    public SimplePerson toPojo(File simpleJsonFile) {
        try {
            return mapper.readValue(simpleJsonFile, SimplePerson.class);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> toPojoValue(File jsonFile) {
        try {
            return mapper.readValue(jsonFile, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toJson(SimplePerson person) {
        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
