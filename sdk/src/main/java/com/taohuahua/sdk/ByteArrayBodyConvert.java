package com.taohuahua.sdk;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * {@link Retrofit}类中使用的byte[]类型的{@link Converter.Factory}
 * Created by mayongnan on 2016/10/8.
 */

public class ByteArrayBodyConvert extends Converter.Factory {

    public static ByteArrayBodyConvert create() {
        return new ByteArrayBodyConvert();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if ("byte[]".equals(type.toString())) {
            return new ByteArrayResponseBodyConverter();
        }
        return null;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        if ("byte[]".equals(type.toString())) {
            return new ByteArrayRequestBodyConverter();
        }
        return null;
    }

    private final class ByteArrayRequestBodyConverter implements Converter<byte[], RequestBody> {
        @Override
        public RequestBody convert(byte[] value) throws IOException {
            return RequestBody.create(MediaType.parse("application/octet-stream;charset=UTF-8"), value);
        }
    }

    private final class ByteArrayResponseBodyConverter implements Converter<ResponseBody, byte[]> {
        @Override
        public byte[] convert(ResponseBody value) throws IOException {
            return value.bytes();
        }
    }
}