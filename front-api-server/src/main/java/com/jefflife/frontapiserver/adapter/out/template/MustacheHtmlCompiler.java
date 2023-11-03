package com.jefflife.frontapiserver.adapter.out.template;

import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import com.jefflife.frontapiserver.application.port.out.HtmlCompilePort;
import com.samskivert.mustache.Mustache;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Component
public class MustacheHtmlCompiler implements HtmlCompilePort {
    private final Mustache.Compiler mustacheCompiler;
    private final ThreadPoolTaskExecutor templateEngineTaskExecutor;

    public MustacheHtmlCompiler(Mustache.Compiler mustacheCompiler, ThreadPoolTaskExecutor templateEngineTaskExecutor) {
        this.mustacheCompiler = mustacheCompiler;
        this.templateEngineTaskExecutor = templateEngineTaskExecutor;
    }

    @Override
    public Mono<HtmlResult> compile(String templateName, Object context) {
        return Mono.fromFuture(
                CompletableFuture.supplyAsync(() -> mustacheCompiler
                        .compile(templateName)
                        .execute(context), templateEngineTaskExecutor))
                .map(HtmlResult::new);
    }
}
