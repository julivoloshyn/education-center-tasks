package com.knubisoft.tasks.algorithm.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;

import java.util.*;
import java.util.stream.Collectors;

public class JsonTasksImpl implements JsonTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseJson(String json) {

        if (json.isEmpty()) {
            throw new NullPointerException();
        }

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.findAndRegisterModules();

        return jsonMapper.readValue(json, ModelRoot.class);
    }

    @Override
    public List<Integer> getAllIds(String json) {

        ModelRoot modelRoot = parseJson(json);

        List<Integer> idsList = new ArrayList<>();

        int i = 0;
        for (ModelRoot.Item item : modelRoot.getItems()) {
            idsList.add(i, item.id);
            i++;
        }
        return idsList;
    }

    @Override
    public List<String> getNameWithIdMoreThan1(String json) {

        ModelRoot modelRoot = parseJson(json);

        List<String> namesList = new ArrayList<>();

        for (ModelRoot.Item item : modelRoot.getItems()) {
            if (item.id > 1) {
                namesList.add(item.name);
            }
        }

        return namesList;
    }

    @SneakyThrows
    @Override
    public List<Map<String, String>> getAllItems(String json) {

        if (json.isEmpty()) {
            throw new NullPointerException();
        }

        ObjectMapper mapper = new ObjectMapper();
        ModelRoot modelRoot = mapper.readValue(json, ModelRoot.class);

        List<ModelRoot.Item> items = modelRoot.getItems();
        Map<String, String> map = new HashMap<>();

        return items.stream().map(item -> getMap(item, map)).collect(Collectors.toList());
    }

    private Map<String, String> getMap(ModelRoot.Item item, Map<String, String> map) {
        map.put(item.getName(), item.toString());

        return map;
    }

}
