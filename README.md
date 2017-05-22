# AndroidAPPLauchingAop

团队：Plausible Psychiatrists

队员：郭浩闻、李瑜、崔利嘉

---

Team: Plausible Psychiatrists

Team members: Guo Haowen, Li Yu, Cui Lijia

## 项目介绍(Project Intro.)
李鹏老师的编译原理课程实践项目，使用AspectJ 框架在Android App中进行织入，对安卓应用启动流程进行分析。

在com.biulibiuli.lee.aj.aspectj.TestAspect.java 中提供了监听了三种事件的AspectJ 代码
* 对象创建
* 方法执行
* 方法调用

---

This repository is the curriculum practice of Compiler Theory course of BIT(Beijing Institute of Technology), Using AspectJ
to weave advises into Android applications and monitor the launching process.

The file of com.biulibiuli.lee.aj.aspectj.TestAspect.java provide methods to listen to three different events

* Object Create
* Method Executed
* Method Called

## 项目配置(Configuration)

项目配置分为如下的步骤
1. 在安卓项目中，创建一个Android Library的 Module，本项目中被命名为aj
2. 参照项目的build.gradle 配置该Module
3. 在目录下编写带有@Aspect注解的类
4. 参考[该项目](https://github.com/android10/Android-AOPExample) ，对原Module的 build.gradle进行配置
5. 编译项目后，可以在Android ADB中的LogCat 查看对应的输出

> Configure Procedure
> 1. Create a new Module in an Android project, in this repository named the module *'aj'*
> 2. reference the build.gradle file to configure the Module
> 3. Make a *.java* file with @Aspect annotation
> 4. reference [this repository](https://github.com/android10/Android-AOPExample) to configure original Module
> 5. Build and Run the Project, and you will get the result from LogCat of Android ADB
===


## 特别感谢(Special Thanks)

该项目的配置参考了[https://github.com/android10/Android-AOPExample](https://github.com/android10/Android-AOPExample)项目，
使我们能够成功的在Android APP 中实现了AspectJ 框架的织入

We referenced the repository [https://github.com/android10/Android-AOPExample](https://github.com/android10/Android-AOPExample)
to managed using AspectJ in Android
