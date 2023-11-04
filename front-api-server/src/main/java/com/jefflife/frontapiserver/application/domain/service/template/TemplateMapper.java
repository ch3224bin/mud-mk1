package com.jefflife.frontapiserver.application.domain.service.template;

import com.jefflife.common.model.RoomCommonModel;

public enum TemplateMapper {
    ROOM("room", RoomCommonModel.class),
    ERROR("room", ErrorMessageModel.class);

    private final String templateName;
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
}
