package com.github.karlklin.json;

import com.github.karlklin.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class JsonPersonParserTest {
    private JsonPersonParser simpleExample;
    private File simpleJsonFile;

    @BeforeEach
    void setUp() throws URISyntaxException {
        simpleExample = new JsonPersonParser();

        Path actualPath = Paths.get(getClass().getClassLoader().getResource("simple.json").toURI());
        simpleJsonFile = actualPath.toFile();
    }

    @Test
    void testToPojo() throws URISyntaxException {
        Person expected = new Person("Bob", 13);

        assertThat(simpleExample.toPojo(simpleJsonFile)).isEqualToComparingFieldByField(expected);
    }

    @Test
    void testToJson() throws URISyntaxException, IOException {
        String expected = "{\"name\":\"Bob\",\"age\":13}";
        String actual = simpleExample.toJson(new Person("Bob", 13));

        assertThat(actual).contains(expected);
    }
}
