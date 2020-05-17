package org.chance.sample.boot.config;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.session.SqlSessionFactory;
import org.chance.jpamapper.core.MapperScanner;
import org.chance.jpamapper.core.mapper.register.MappedStatementRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper 配置
 *
 * @author cff
 */
@Configuration
public class JpaMapperConfig {

    @Bean
    @Order
    public MapperScanner mapperScanner(List<SqlSessionFactory> sqlSessionFactoryList){

        MapperScanner mapperScanner = new MapperScanner();

        try{
            for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
                org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
                MapperRegistry mapperRegistry = configuration.getMapperRegistry();
                List<Class<?>> mappers = new ArrayList<>(mapperRegistry.getMappers());
                MappedStatementRegister mappedStatementRegister = new MappedStatementRegister(configuration);
                mappedStatementRegister.addMappers(mappers);
                mapperScanner.addMappedStatementRegister(mappedStatementRegister);
            }
            mapperScanner.scanAndRegisterJpaMethod();
        }catch(Exception e){
            e.printStackTrace();
        }

        return mapperScanner;
    }

}
