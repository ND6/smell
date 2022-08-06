package com.smell.core.config;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.smell.core.Constants;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * JACKSON 接口层时间参数序列化插件
 *
 * @author lenovo
 */
public class DateTimeModule extends SimpleModule {

    /**
     * 构造方法，设置默认的时间序列化、反序列化组件
     */
    public DateTimeModule() {
        super(PackageVersion.VERSION);
        this.addSerializer(LocalDateTime.class, new TsLocalDateTimeSerializer());
        this.addDeserializer(LocalDateTime.class, new TsLocalDateDeserializer());
    }

    /**
     * 默认采用字符串形式格式化时间
     */
    public static class TsLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
        /**
         * 序列化时间方法
         *
         * @param value    时间对象值
         * @param g        JSON对象生成器
         * @param provider 可提供默认包含的可序列化组件的提供对象
         * @throws IOException
         */
        @Override
        public void serialize(LocalDateTime value, JsonGenerator g, SerializerProvider provider) throws IOException {
            g.writeString(LocalDateTimeUtil.format(value, Constants.DATE_FORMAT));
        }
    }

    /**
     * 默认将字符串时间输出成LocalDateTime
     */
    public static class TsLocalDateDeserializer extends JsonDeserializer<LocalDateTime> {

        /**
         * 将字符串反序列化成时间对象
         *
         * @param p    JSON对象解析器
         * @param ctxt 需要反序列化对象的上下文
         * @return
         * @throws IOException
         * @throws JsonProcessingException
         */
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            String time = p.getValueAsString();
            return LocalDateTimeUtil.parse(time, Constants.DATE_FORMAT);
        }
    }
}