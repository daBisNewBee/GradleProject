1. gradle的构建脚本生命周期：

运行结果:
settings.gradle ------- start
这里将执行在[初始化阶段(Initialization)].....
settings.gradle ------- end

Root Project build.gradle ---------- start.
这里将执行在[配置(Configuration)阶段].....
hello. out closure. [配置阶段]
helloNoDoLast world!
Root Project build.gradle ---------- end.

Hello world!..doFirst.. [执行阶段(Execution)]
Hello world!..doLast.. [执行阶段]

初始化阶段：
    1. 决定哪些项目需要加入构建（Gradle支持单项目、多项目构建）
    2. 为加入构建的项目分别创建实例
    3. 实质：执行"settings.gradle"

配置阶段：
    1. 确定整个build的project及Task的关系
    2. 建立有向图来描述Task之间的依赖关系
    3. 实质：解析每个加入构建项目下的"build.gradle"

执行阶段：
    1. 执行Gradle命令指定的Task及其依赖Task
    2. 最终构建目标的生成

2. Gradle的三种主要对象:

Gradle对象:
    构建初始化时创建，整个构建执行过程中只有这么一个对象，一般很少去修改这个默认配置脚本。
    获取Gradle对象方法：
        Project对象的getGradle()
    初始化脚本Init script:
        位置：
            /Users/user/.gradle/wrapper/dists/gradle-4.1-all/bzyivzo6n839fup2jbap0tjew/gradle-4.1/init.d/*.gradle
        作用：
            类似于Gradle的其他类型脚本，这种脚本在构建开始之前运行，主要的用途是为接下来的Build script做一些准备工作
        用法：
            在上述目录下，预置操作

Settings对象:
    每个settings.gradle会转换成一个Settings对象。

Project对象:
    每个build.gradle会转换成一个Project对象。
    重要：
        所谓的我们编写Gradle脚本，实质大多数时候都是在编写构建脚本Build script，所以说Project和Script对象的属性和方法等API非常重要。

3. 几种重要元素对应的API映射：
    Project:
        org.gradle.api.project
    Task:
        org.gradle.api.task

