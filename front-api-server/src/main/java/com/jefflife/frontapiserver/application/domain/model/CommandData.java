package com.jefflife.frontapiserver.application.domain.model;

import com.jefflife.common.model.CommandDataCommonModel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CommandData implements CommandDataCommonModel {
    private final String target;
    private final String content;
    private final String adverb;
    private final String action;

    @Builder
    public CommandData(String target, String content, String adverb, String action) {
        this.target = target;
        this.content = content;
        this.adverb = adverb;
        this.action = action;
    }
}
