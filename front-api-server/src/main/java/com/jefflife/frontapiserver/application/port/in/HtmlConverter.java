package com.jefflife.frontapiserver.application.port.in;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.HtmlResult;

public interface HtmlConverter {
    HtmlResult convert(CommandResult commandResult);
}
