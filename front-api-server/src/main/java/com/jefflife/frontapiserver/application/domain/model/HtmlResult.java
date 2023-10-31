package com.jefflife.frontapiserver.application.domain.model;

import lombok.Getter;

@Getter
public class HtmlResult {
    private final String html;

    public HtmlResult(String html) {
        this.html = html;
    }
}
