package com.bav.airneisbackend.config


import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter

@Configuration
class MongoDbConfiguration(@Lazy private val mappingMongoConverter: MappingMongoConverter) : InitializingBean {

    override fun afterPropertiesSet() {
        mappingMongoConverter.setTypeMapper(DefaultMongoTypeMapper(null))
    }
}