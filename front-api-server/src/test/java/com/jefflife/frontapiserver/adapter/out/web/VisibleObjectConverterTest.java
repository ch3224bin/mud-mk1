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
                "\"payload\": {\"id\":1,\"summary\":\"테스트 중앙\",\"description\":\"흰 빛으로 가득한 공간입니다.\",\"wayOuts\":[{\"id\":1,\"roomId\":1,\"nextRoomId\":2,\"direction\":\"동\",\"locked\":false,\"visible\":true},{\"id\":3,\"roomId\":1,\"nextRoomId\":3,\"direction\":\"서\",\"locked\":false,\"visible\":true},{\"id\":5,\"roomId\":1,\"nextRoomId\":4,\"direction\":\"남\",\"locked\":false,\"visible\":true},{\"id\":7,\"roomId\":1,\"nextRoomId\":5,\"direction\":\"북\",\"locked\":true,\"visible\":true}],\"exitString\":\"동 서 남 북(잠김)\"}" +
                "}";

        // when
        VisibleObject result = VisibleObjectConverter.jsonToVisibleObject(json);

        // then
        assertThat(result).isInstanceOf(RoomCommonModel.class);
        assertThat(((RoomCommonModel) result).getId()).isEqualTo(1L);
    }
}