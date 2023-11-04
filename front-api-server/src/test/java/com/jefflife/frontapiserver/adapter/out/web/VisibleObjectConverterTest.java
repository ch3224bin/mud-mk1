package com.jefflife.frontapiserver.adapter.out.web;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.common.model.VisibleObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VisibleObjectConverterTest {
    @Test
    void name() {
        // given
        String json = "{\"className\":\"RoomModel\"," +
                "\"payload\": {\"id\":1,\"summary\":\"test\",\"description\":\"test\"}}";

        // when
        VisibleObject result = VisibleObjectConverter.jsonToVisibleObject(json);

        // then
        assertThat(result).isInstanceOf(RoomCommonModel.class);
        assertThat(((RoomCommonModel) result).getId()).isEqualTo(1L);
    }
}