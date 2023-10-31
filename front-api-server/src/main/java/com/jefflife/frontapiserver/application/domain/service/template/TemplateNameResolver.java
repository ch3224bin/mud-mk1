package com.jefflife.frontapiserver.application.domain.service.template;

import org.springframework.stereotype.Component;

@Component
public class TemplateNameResolver {
    public String resolve(Object payload) {
        return TemplateMapper.findTemplateName(payload.getClass());
    }
}
