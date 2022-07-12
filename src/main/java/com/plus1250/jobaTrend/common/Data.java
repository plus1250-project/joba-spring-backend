package com.plus1250.jobaTrend.common;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.catalina.connector.Response;

@Getter
@AllArgsConstructor
// 제네릭 파라미터로 사용
public class Data<T> extends Response {
    private T result;
}