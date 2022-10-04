package com.example.studyboard.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration //자바 기반의 설정파일로 인식
@PropertySource("classpath:application.properties") //참조할 프로퍼티스 파일 위치 지정
public class DatabaseConfig {

    @Autowired //빈으로 등록된 인스턴스를 클래스에 주입하는데 사용
    private ApplicationContext context; //스프링컨테이너. bean의 lifecycle 관리

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari") //" "로 시작하는 설정을 모두 읽어들여 해당 메서드에 매핑함.
    public HikariConfig hikariConfig() { //히카리 cp를 생성
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() { //커넥션 풀을 지원하기 위한 인터페이스. 커넥션객체를 생성해두고 db에 접근하는 사용자에게 미리 생성한 연결을 제공했다 돌려받는 방법
        return new HikariDataSource(hikariConfig());
    }

    /**
     * mybatis xml매퍼, 설정파일위치 지정.
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml")); //스프링이 mapper를 인식할 수 있도록 해줌.
        factoryBean.setConfiguration(mybatisConfig());
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception { //sql실행에 필요한 모든 메서드를 갖는 객체
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    @Bean
    @ConfigurationProperties(prefix="mybatis.configuration")//어플리케이션프로퍼티스에서 mybatis.configuration으로 시작되는 모든 설정을 읽어 빈으로 등록
    public org.apache.ibatis.session.Configuration mybatisConfig(){
        return new org.apache.ibatis.session.Configuration();
    }

}