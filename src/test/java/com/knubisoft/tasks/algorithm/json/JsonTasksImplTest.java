package com.knubisoft.tasks.algorithm.json;

import com.knubisoft.tasks.algorithm.ModelRoot;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class JsonTasksImplTest {

    private final JsonTasks object = new JsonTasksImpl();
    private final String content;

    public JsonTasksImplTest() throws IOException {
        content = IOUtils.toString(Objects.requireNonNull(
                getClass().getClassLoader().getResourceAsStream("json.json")), StandardCharsets.UTF_8);
    }

    @Test
    void parseJsonSuccess() {
        ModelRoot result = object.parseJson(content);
        assertEquals(3, result.items.size());
    }

    @Test
    void parseJsonFail(){
        assertThrows(NullPointerException.class, ()-> object.parseJson(""));
        assertThrows(NullPointerException.class, ()-> object.parseJson(null));
    }
    @Test
    void getAllIdsSuccess() {
        List<Integer> result = object.getAllIds(content);
        assertEquals(Arrays.asList(1,2,3), result);
    }

    @Test
    void getAllIdsFail(){
        assertThrows(NullPointerException.class, ()-> object.getAllIds(""));
        assertThrows(NullPointerException.class, ()-> object.getAllIds(null));
    }

    @Test
    void getNameWithIdMoreThan1Success() {
        List<String> result = object.getNameWithIdMoreThan1(content);
        assertEquals(Arrays.asList("Cake2","Cake3"), result);
    }

    @Test
    void getNameWithIdMoreThan1Fail(){
        assertThrows(NullPointerException.class, ()-> object.getNameWithIdMoreThan1(""));
        assertThrows(NullPointerException.class, ()-> object.getNameWithIdMoreThan1(null));
    }

    @Test
    void getAllItemsSuccess() {
        List<Map<String, String>> result = object.getAllItems(content);
        assertEquals(3, result.size());
        assertTrue(result.get(0).containsKey("batters"));
        assertTrue(result.get(1).containsKey("id"));
        assertTrue(result.get(2).containsKey("topping"));
        assertTrue(result.get(1).containsKey("ppu"));
    }

    @Test
    void getAllItemsFail(){
        assertThrows(NullPointerException.class, ()-> object.getAllItems(""));
        assertThrows(NullPointerException.class, ()-> object.getAllItems(null));
    }
}