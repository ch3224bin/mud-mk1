package com.jefflife.gameserver.look.application.port.in;

import com.jefflife.common.model.CommandDataCommonModel;
import lombok.Getter;

@Getter
public class LookCommandDataRequest implements CommandDataCommonModel {
    private final String target;
    private final String payload;
    private final String adverb;
    private final String action;

    public LookCommandDataRequest(CommandDataCommonModel commandData, LookCommandDataRequestValidator validator) {
        validator.validate(commandData);
        this.target = commandData.getTarget();
        this.payload = commandData.getPayload();
        this.adverb = commandData.getAdverb();
        this.action = commandData.getAction();
    }

    public boolean hasTarget() {
        return target != null && !target.isEmpty();
    }
}
