1. 启动eureka_server命令  
java -jar .\eureka_server-0.0.1-SNAPSHOT.jar  --spring.profiles.active=localhost  
2. 启动eureka_client命令
java -jar .\eureka_client-0.0.1-SNAPSHOT.jar --server.port=8763
java -jar .\eureka_client-0.0.1-SNAPSHOT.jar --server.port=8764 
3.启动eureka_ribbon_client
java -jar .\eureka_ribbon_client-0.0.1-SNAPSHOT.jar 
4. 启动eureka_feign_client
java -jar .\eureka-feign-client-0.0.1-SNAPSHOT.jar
5. 启动eureka-zuul-client
java -jar .\eureka-zuul-client-0.0.1-SNAPSHOT.jar