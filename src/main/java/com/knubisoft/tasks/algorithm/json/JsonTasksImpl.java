package com.knubisoft.tasks.algorithm.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;

import java.util.*;

public class JsonTasksImpl implements JsonTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseJson(String json) {
        if (json == null || json.isEmpty())
            throw new NullPointerException();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper.readValue(json, ModelRoot.class);
    }

    @SneakyThrows
    @Override
    public List<Integer> getAllIds(String json) {
        if (json == null || json.isEmpty())
            throw new NullPointerException();
        List<Integer> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        ModelRoot modelRoot = mapper.readValue(json, ModelRoot.class);
        for (ModelRoot.Item item : modelRoot.getItems()) {
            list.add(item.id);
        }
        return list;
    }

    @SneakyThrows
    @Override
    public List<String> getNameWithIdMoreThan1(String json) {
        if (json == null || json.isEmpty())
            throw new NullPointerException();
        List<String> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        ModelRoot modelRoot = mapper.readValue(json, ModelRoot.class);
        for (ModelRoot.Item item : modelRoot.getItems()) {
            if (item.id > 1)
                list.add(item.name);
        }
        return list;
    }

    @SneakyThrows
    @Override
    public List<Map<String,String>> getAllItems(String json) {
        if (json == null || json.isEmpty())
            throw new NullPointerException();
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        ModelRoot modelRoot = mapper.readValue(json, ModelRoot.class);
        for (ModelRoot.Item item : modelRoot.getItems()) {
            map.put("id", String.valueOf(item.id));
            map.put("name", item.name);
            map.put("type", item.type);
            map.put("ppu", String.valueOf(item.ppu));
            map.put("batters", item.batters.toString());
            map.put("topping", item.topping.toString());
            list.add(map);
        }
        return list;
    }
}
