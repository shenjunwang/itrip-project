package com.cskt.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 申钧旺
 * @Description: MyBatisPlus自动填充处理器
 * @create 2021-01-06 15:16
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final Logger log = LoggerFactory.getLogger(MyMetaObjectHandler.class);
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "creationDate", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "modifyDate", LocalDateTime::now, LocalDateTime.class);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "modifyDate", LocalDateTime::now, LocalDateTime.class);
    }
}