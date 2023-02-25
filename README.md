# backend サンプルプロジェクト

### 概要

Java (Spring Boot), MyBatisを使用した実装サンプルです。

### 構成

- postgresql のDockerImageを使用しています。
  - ./database 直下で docker-compose up で起動します

### その他

- MyBatisのアノテーションベースのSQLの実装サンプル
  - \src\main\java\com\sample\adapter\mapper\OrderMapper.java
