Java Run Jersey3 in Jetty as Jar Demo
====================================

这里面有一个天坑：jersey是jax的一个实现，而jax从2.x升级到3.x后，包名由`javax.ws.rs`变成了`jakarta.ws.rs`，导致定义的resource不生效而始终找不到原因。

```
mvn clean package
java -jar target/demo.jar
```