package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import com.jefflife.frontapiserver.application.port.in.HtmlConverter;
import org.springframework.stereotype.Service;

@Service
public class ConvertCommandResultService implements HtmlConverter {
    @Override
    public HtmlResult convert(CommandResult commandResult) {
        return new HtmlResult("test message");
    }
}
