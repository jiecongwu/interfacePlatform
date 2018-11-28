package io.renren.common.utils.outter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * SmsReport
 *
 * @author chenwenlong@foresee.com.cn
 * @version 1.0
 * @date 2017/12/24
 */
public class SmsReportRequest {

    /**
     * 短信id
     */
    @NotNull @Min(value = 100000000000000000L, message = "非法msgId") //18位
    private Long msgId;

    public Long getMsgId() {
        return msgId;
    }

    public SmsReportRequest setMsgId(Long msgId) {
        this.msgId = msgId;
        return this;
    }
}
