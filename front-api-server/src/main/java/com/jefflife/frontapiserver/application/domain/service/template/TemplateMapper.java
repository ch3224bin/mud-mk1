package com.jefflife.frontapiserver.application.domain.service.template;

import com.jefflife.common.model.RoomCommonModel;
import lombok.Getter;

public enum TemplateMapper {
    ROOM("RoomModel", RoomCommonModel.class),
    ERROR("ErrorMessage", ErrorMessageModel.class);

    private final String templateName;
    @Getter
    private final Class<?> payloadType;

    TemplateMapper(String templateName, Class<?> payloadType) {
        this.templateName = templateName;
        this.payloadType = payloadType;
    }

    public static String findTemplateName(Class<?> payloadType) {
        for (TemplateMapper templateMapper : values()) {
            if (templateMapper.payloadType.equals(payloadType))
                return templateMapper.templateName;
        }

        throw new IllegalArgumentException("Not supported payload type: " + payloadType.getName());
    }

    public static TemplateMapper findTemplateMapper(String templateName) {
        for (TemplateMapper templateMapper : values()) {
            if (templateMapper.templateName.equals(templateName))
                return templateMapper;
        }

        throw new IllegalArgumentException("Not supported template name: " + templateName);
    }
}
