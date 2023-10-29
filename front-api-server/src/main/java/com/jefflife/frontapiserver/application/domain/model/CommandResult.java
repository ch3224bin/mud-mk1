package com.jefflife.frontapiserver.application.domain.model;

import lombok.Getter;

import java.util.List;

@Getter
public class CommandResult {
    private final List<String> receivers;
    private final Object payload;
    private final String templateId;

    public CommandResult(List<String> receivers, Object payload, String templateId) {
        this.receivers = receivers;
        this.payload = payload;
        this.templateId = templateId;
    }
}
