# 编程刷题网
前端：https://github.com/HalcyonJX/codeOJ-frontend

后端：https://github.com/HalcyonJX/codeOJ-backend

微服务：https://github.com/HalcyonJX/codeoj-backend-microservice
## 项目介绍
基于Vue3+Spring Boot+Spring Cloud微服务+Docker的编程题目在线评测系统(简称OJ)

在系统前台，管理员可以创建、管理题目；用户可以自由搜索题目、阅读题目、编写并提交代码。

在系统后端，能够根据管理员设定的题目测试，用例在 代码沙箱 中对代码进行编译、运行、判断输出是否正确。

其中，代码沙箱可以作为独立服务，提供给其他开发者使用。

## 主要工作
### 前端
+ 使用Vue3 + cursor 辅助完成前端页面。

### 后端
1. 自主设计判题机模块的架构，定义了代码沙箱的抽象调用接口和多种实现类（比如远程 / 第三方代码沙箱），并通过 静态工厂模式 + Spring 配置化 的方式实现了对多种代码沙箱的灵活调用。

2. 使用 代理模式 对代码沙箱接口进行能力增强，统一实现了对代码沙箱调用前后的日志记录，减少重复代码。

3. 为保证项目各模块的稳定性，选用 Spring Cloud Alibaba 重构单体项目，（使用 Redis 分布式 Session 存储登录用户信息，并将项目）划分为用户服务、题目服务、判题服务、公共模块。

4. 通过 Nacos + OpenFeign 实现了各模块之间的相互调用，如判题服务调用题目服务来获取题目信息。

5. 使用 Spring Cloud Gateway 对各服务接口进行聚合和路由。

6. 为防止判题操作执行时间较长，系统选用异步的方式，在题目服务中将用户提交 id 发送给 RabbitMQ 消息队列，并通过 Direct 交换机转发给判题队列，由判题服务进行消费，异步更新提交状态。