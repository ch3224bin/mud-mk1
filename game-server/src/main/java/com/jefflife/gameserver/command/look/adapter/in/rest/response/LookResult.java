package com.jefflife.gameserver.command.look.adapter.in.rest.response;

import com.jefflife.common.model.LookResultCommonModel;
import com.jefflife.common.model.VisibleObject;

public record LookResult(String className, VisibleObject payload) implements LookResultCommonModel {
        public static LookResult of(VisibleObject visibleObject) {
            return new LookResult(visibleObject.getClass().getSimpleName(), visibleObject);
        }
    }