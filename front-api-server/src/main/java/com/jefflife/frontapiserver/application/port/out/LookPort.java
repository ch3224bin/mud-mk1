package com.jefflife.frontapiserver.application.port.out;

import com.jefflife.common.model.VisibleObject;
import com.jefflife.frontapiserver.application.domain.model.CommandData;
import reactor.core.publisher.Mono;

public interface LookPort {
    Mono<VisibleObject> look(long playerId, CommandData commandData);
}
