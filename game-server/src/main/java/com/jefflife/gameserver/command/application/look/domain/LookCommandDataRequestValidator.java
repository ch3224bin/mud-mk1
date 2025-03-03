package com.jefflife.gameserver.command.application.look.domain;

import com.jefflife.common.model.CommandConstants;
import com.jefflife.common.model.CommandDataCommonModel;

public class LookCommandDataRequestValidator {

    private static final LookCommandDataRequestValidator INSTANCE = new LookCommandDataRequestValidator();

    public static LookCommandDataRequestValidator getInstance() {
        return INSTANCE;
    }

    private LookCommandDataRequestValidator() {
    }

    public void validate(CommandDataCommonModel commandData) {
        if (commandData.getAction() == null || commandData.getAction().isEmpty()) {
            throw new IllegalArgumentException("parameter의 action 값이 비어있습니다.");
        }
        if (!CommandConstants.LOOK.matched(commandData.getAction())) {
            throw new IllegalArgumentException("잘못된 명령어가 요청되었습니다. action=" + commandData.getAction());
        }
    }
}
