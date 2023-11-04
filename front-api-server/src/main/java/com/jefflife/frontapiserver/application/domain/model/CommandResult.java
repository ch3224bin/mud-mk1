package com.jefflife.frontapiserver.application.domain.model;

import com.jefflife.common.model.VisibleObject;
import lombok.Getter;

import java.util.List;

@Getter
public class CommandResult {
    private final List<String> receivers;
    private final VisibleObject payload;

    public CommandResult(List<String> receivers, VisibleObject payload) {
        this.receivers = receivers;
        this.payload = payload;
    }
}
