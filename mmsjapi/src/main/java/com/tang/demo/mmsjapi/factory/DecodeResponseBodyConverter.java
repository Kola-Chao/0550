package com.tang.demo.mmsjapi.factory;

import com.google.gson.TypeAdapter;
import com.tang.demo.mmsjapi.utils.EncodeUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Introduce:
 * Author：mac
 * Date：2017/3/1
 * Time: 下午4:01
 */

public class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    DecodeResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //解密字符串
        return adapter.fromJson(String.valueOf(EncodeUtils.base64Decode(value.string())));
    }
}
