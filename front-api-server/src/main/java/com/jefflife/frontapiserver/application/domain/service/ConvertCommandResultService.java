package com.jefflife.frontapiserver.application.domain.service;

import com.jefflife.frontapiserver.application.domain.model.CommandResult;
import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import com.jefflife.frontapiserver.application.domain.service.template.TemplateNameResolver;
import com.jefflife.frontapiserver.application.port.in.HtmlConverter;
import com.jefflife.frontapiserver.application.port.out.HtmlCompilePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ConvertCommandResultService implements HtmlConverter {
    private final HtmlCompilePort htmlCompilePort;
    private final TemplateNameResolver templateNameResolver;

    public ConvertCommandResultService(HtmlCompilePort htmlCompilePort, TemplateNameResolver templateNameResolver) {
        this.htmlCompilePort = htmlCompilePort;
        this.templateNameResolver = templateNameResolver;
    }

    @Override
    public Mono<HtmlResult> convert(CommandResult commandResult) {
        return templateNameResolver.resolve(commandResult.getPayload())
                .flatMap(templateName -> htmlCompilePort.compile(templateName, commandResult.getPayload()));
    }
}
