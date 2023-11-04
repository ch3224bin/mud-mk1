package com.jefflife.frontapiserver.adapter.out.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jefflife.common.model.VisibleObject;
import com.jefflife.frontapiserver.application.domain.service.template.TemplateMapper;
import reactor.core.publisher.SynchronousSink;

import java.util.function.BiConsumer;

public class VisibleObjectConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static BiConsumer<String, SynchronousSink<VisibleObject>> jsonToVisibleObject() {
        return (json, sink) -> {
            try {
                sink.next(jsonToVisibleObject(json));
            } catch (RuntimeException e) {
                sink.error(e);
            }
        };
    }

    public static VisibleObject jsonToVisibleObject(String json) {
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            String className = jsonNode.get("className").asText();
            String payload = jsonNode.get("payload").toString();
            TemplateMapper templateMapper = TemplateMapper.findTemplateMapper(className);
            return (VisibleObject) objectMapper.readValue(payload, templateMapper.getPayloadType());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
