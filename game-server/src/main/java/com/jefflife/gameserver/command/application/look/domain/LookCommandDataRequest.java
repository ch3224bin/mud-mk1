package com.jefflife.gameserver.command.application.look.domain;

import com.jefflife.common.model.CommandDataCommonModel;
import lombok.Getter;

@Getter
public class LookCommandDataRequest implements CommandDataCommonModel {
    private final String target;
    private final String content;
    private final String adverb;
    private final String action;

    public LookCommandDataRequest(CommandDataCommonModel commandData, LookCommandDataRequestValidator validator) {
        validator.validate(commandData);
        this.target = commandData.getTarget();
        this.content = commandData.getContent();
        this.adverb = commandData.getAdverb();
        this.action = commandData.getAction();
    }

    public boolean hasTarget() {
        return target != null && !target.isEmpty();
    }
}
