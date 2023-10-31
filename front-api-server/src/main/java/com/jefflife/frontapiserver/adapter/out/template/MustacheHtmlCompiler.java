package com.jefflife.frontapiserver.adapter.out.template;

import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import com.jefflife.frontapiserver.application.port.out.HtmlCompilePort;
import com.samskivert.mustache.Mustache;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MustacheHtmlCompiler implements HtmlCompilePort {
    private final Mustache.Compiler mustacheCompiler;

    public MustacheHtmlCompiler(Mustache.Compiler mustacheCompiler) {
        this.mustacheCompiler = mustacheCompiler;
    }

    @Override
    public Mono<HtmlResult> compile(String templateName, Object context) {
        return Mono.fromCallable(() -> mustacheCompiler
                        .compile(templateName)
                        .execute(context))
                .map(HtmlResult::new);
    }
}
