package com.jefflife.frontapiserver.application.domain.model;

import lombok.Getter;

import java.util.List;

@Getter
public class CommandResult {
    private final List<String> receivers;
    private final Object payload;

    public CommandResult(List<String> receivers, Object payload) {
        this.receivers = receivers;
        this.payload = payload;
    }
}
