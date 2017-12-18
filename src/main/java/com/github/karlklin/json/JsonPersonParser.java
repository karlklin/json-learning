package com.github.karlklin.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.karlklin.Person;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonPersonParser {

    private ObjectMapper mapper = new ObjectMapper();

    public Person toPojo(File simpleJsonFile) {
        try {
            return mapper.readValue(simpleJsonFile, Person.class);
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

    public String toJson(Person person) {
        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
