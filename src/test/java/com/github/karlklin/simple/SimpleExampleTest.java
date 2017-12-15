package com.github.karlklin.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleExampleTest {
    private SimpleExample simpleExample;
    private File simpleJsonFile;

    @BeforeEach
    void setUp() throws URISyntaxException {
        simpleExample = new SimpleExample();

        Path actualPath = Paths.get(SimpleExample.class.getClassLoader().getResource("simple.json").toURI());
        simpleJsonFile = actualPath.toFile();
    }

    @Test
    void testToPojo() throws URISyntaxException {
        SimplePerson expected = new SimplePerson("Bob", 13);

        assertThat(simpleExample.toPojo(simpleJsonFile)).isEqualToComparingFieldByField(expected);
    }

    @Test
    void testToJson() throws URISyntaxException, IOException {
        String expected = "{\"name\":\"Bob\",\"age\":13}";
        String actual = simpleExample.toJson(new SimplePerson("Bob", 13));

        assertThat(actual).contains(expected);
    }
}
