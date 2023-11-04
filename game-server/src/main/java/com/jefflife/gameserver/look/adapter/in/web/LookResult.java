package com.jefflife.gameserver.look.adapter.in.web;

import com.jefflife.common.model.LookResultCommonModel;
import com.jefflife.common.model.VisibleObject;

public record LookResult(String className, VisibleObject payload) implements LookResultCommonModel {
    static LookResult of(VisibleObject visibleObject) {
        return new LookResult(visibleObject.getClass().getSimpleName(), visibleObject);
    }
}
