# 慕课秒杀教学课程源码
## 相关技术
1. Spring&SpringMVC
2. MyBatis
2. MySQL
3. Restful
4. Bootstrap&jQuery

## 知识点
1. Mybatis使用与整合Spring技巧
2. SpringIOC与声明式事务理解
3. 业务接口封装技巧
4. SpringMVC和Restful理解和运用
5. 交互分析和JS模块化开发
6. 高并发秒杀系统瓶颈点分析
7. 事务,行级锁,网络延迟等理解
8. 前端,CDN,缓存理解

## 课程视频
名称              | 地址
------------      | ------------- 
业务分析与DAO实现 | http://www.imooc.com/learn/587
Service层实现     | http://www.imooc.com/learn/631
WEB层实现         | http://www.imooc.com/learn/630
并发优化          | http://www.imooc.com/learn/632

基于以上修改为基础项目框架
修改如下
1. 修改原项目中执行错误问题（sql脚本）
2. 更新项目依赖和版本
3. 增加测试工具（api测试，并发测试）
4. 代码生成器和示例模板（基于tk mapper）
5. 使用FastJsonHttpMessageConverter，提高JSON序列化速度
6. 通用Mapper插件、PageHelper分页插件，实现单表业务零SQL
7. 统一响应结果封装及生成工具
8. 统一异常处理
9. 简单的接口签名认证
10. 常用基础方法抽象封装
11. todo 整合jsp、文件上传
12. todo jedis优化、Lettuce、RedisTemplate
13. todo 拆分精简核心框架、辅助工具类
