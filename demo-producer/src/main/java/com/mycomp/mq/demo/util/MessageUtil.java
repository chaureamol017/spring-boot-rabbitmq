package com.mycomp.mq.demo.util;

import com.mycomp.mq.demo.model.MessagePayload;
import org.apache.commons.lang3.RandomStringUtils;

public class MessageUtil {

    public static MessagePayload createRandom() {
        final MessagePayload payload = new MessagePayload(RandomStringUtils.randomNumeric(10), RandomStringUtils.randomNumeric(10), RandomStringUtils.random(70));

        return payload;
    }
}
