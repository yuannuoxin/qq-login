package com.yuanlin.wrapper;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EntityWrapper<E> {
    public E e;
    public String message="成功";
    public int status=0;

    @Override
    public String toString() {
        return "EntityWrapper{" +
                "e=" + e +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
