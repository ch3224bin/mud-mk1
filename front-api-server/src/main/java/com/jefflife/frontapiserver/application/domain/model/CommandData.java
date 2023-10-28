package com.jefflife.frontapiserver.application.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CommandData {
    private final String target;
    private final String payload;
    private final String adverb;
    private final String action;

    @Builder
    public CommandData(String target, String payload, String adverb, String action) {
        this.target = target;
        this.payload = payload;
        this.adverb = adverb;
        this.action = action;
    }
}
