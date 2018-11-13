package com.yuanlin.wrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageWrapper {
    public int status=0;
    public String message="成功";

    public MessageWrapper() {
    }

    public MessageWrapper(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
