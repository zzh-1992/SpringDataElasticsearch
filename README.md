# Getting Started

### 说明
ElasticSearch 8.5.3需要使用高版依赖,同时基于springboot3,jdk20

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.6/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#web)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#data.nosql.elasticsearch)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.6/reference/htmlsingle/#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Spring Elastic Documentation
[spring-data/elasticsearch](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#upgrading)

## 2.Elasticsearch
### Elasticsearch Install
[install-macos](https://www.elastic.co/guide/en/elasticsearch/reference/7.17/targz.html#install-macos)
```shell
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.17.8-darwin-x86_64.tar.gz
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.17.8-darwin-x86_64.tar.gz.sha512
shasum -a 512 -c elasticsearch-7.17.8-darwin-x86_64.tar.gz.sha512 
tar -xzf elasticsearch-7.17.8-darwin-x86_64.tar.gz
cd elasticsearch-7.17.8/ 
```

### Set Password
[elasticsearch password](https://www.elastic.co/guide/en/elasticsearch/reference/7.17/setup-passwords.html#setup-passwords)

## 3.Logstash
### dependencies
```xml
        <dependency>
            <groupId>net.logstash.logback</groupId>
            <artifactId>logstash-logback-encoder</artifactId>
            <version>7.0</version>
        </dependency>
```
### server log
```java
Logger logger = LoggerFactory.getLogger(SpringDataElasticsearchApplication.class);

logger.error("my manual error");
```

### filename:springboot-log.conf
```conf
input{
	tcp {
        mode => "server"
        host => "0.0.0.0"
        port => 8888
        codec => json_lines
	}
}

output{
	elasticsearch{
	    hosts=>["127.0.0.1:9200"]
	    index => "springboot"
		user=>***
	    password=>***
    }
	stdout{
		codec => rubydebug
	}
}
```
### start
```shell
bin/logstash -f config/springboot-log.conf
```

## 4 filebeat
## 4.1 config
file path:{$filebeat}/filebeat.yml

### 4.2 start
copy from /{path}/filebeat-7.17.8-darwin-x86_64/README.md
```shell
./filebeat -c filebeat.yml -e
```
or
```shell
./filebeat -c filebeat-myconfig.yml -e
```
### 4.3 multiline config
```yaml
filebeat.inputs:
  - type: filestream
    enabled: true
    paths:
      - /Users/zhihuangzhang/Downloads/myLog/mykafka/*.log
    fields:
      module: springkafka
    parsers:
      # 多行日志合并
      - multiline:
          type: pattern
          # 正则表达 类似2022/12/25
          pattern: '^[0-9]{4}/[0-9]{2}/[0-9]{2}'
          negate: true
          match: after
```
