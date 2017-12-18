package com.github.karlklin.yaml;

import com.github.karlklin.Person;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

public class YamlExampleTest {

    @Test
    void testLoadListTest() {
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        List<String> list = yaml().loadAs(document, List.class);

        assertThat(list).containsExactly("Hesperiidae", "Papilionidae", "Apatelodidae", "Epiplemidae");
    }

    @Test
    void testLoadFromString() {
        String document = "hello: 25";
        Map<String, Integer> map = yaml().loadAs(document, Map.class);

        assertThat(map).containsExactly(entry("hello", 25));
    }

    @Test
    void testLoadSimpleYaml() throws URISyntaxException, FileNotFoundException {
        Person simplePerson = yaml(Person.class).load(file("simple.yaml"));

        assertThat(simplePerson).isEqualToComparingFieldByField(new Person("Bob", 13));
    }

    @Test
    void testLoadAdvancedYaml() throws ParseException {
        Invoice invoice = yaml(Invoice.class).load(file("advancedIterative.yaml"));

        Date date = (new SimpleDateFormat("yyy-MM-dd HH:mm")).parse("2001-01-23 01:00");
        Address address = new Address("Chris", "Dumars", "458 Walkman Dr.");
        List<Product> products = Arrays.asList(new Product("BL394D", 4, "Basketball", 450.00), new Product("BL4438H", 1, "Super Hoop", 2392.00));

        assertThat(invoice).isEqualToComparingFieldByFieldRecursively(new Invoice(34843, date, 4443.52, 251.42, address, address, products, "Late afternoon is best. " +"Backup contact is Nancy Billsmer @ 338-4338."));
    }

    private Yaml yaml() {
        return new Yaml();
    }

    private Yaml yaml (Class clazz) {
        return new Yaml(new Constructor(clazz));
    }

    private InputStream file(String fileName) {
        try {
            Path actualPath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());

            return new FileInputStream(actualPath.toFile());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
