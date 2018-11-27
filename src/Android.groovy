/*
*
* 如何使用"闭包"配置实体对象？
*
* 参考：
* [Android Gradle] 搞定Groovy闭包这一篇就够了
* https://www.jianshu.com/p/6dc2074480b8
*
* */
class Android {

    private int mCompileSdkVersion
    private String mBuildToolsVersion
    private ProductFlavor mProductFlavor

    Android() {
        mProductFlavor = new ProductFlavor()
    }

    // 使用"def"也可以
    void compileSdkVersion(int compileSdkVersion){
        mCompileSdkVersion = compileSdkVersion
    }

    void buildToolsVersion(String buildToolsVersion){
        mBuildToolsVersion = buildToolsVersion
    }

    void defaultConfig(Closure closure){
        closure.delegate = mProductFlavor
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure.call()
    }


    @Override
    String toString() {
        return "Android{" +
                "mCompileSdkVersion=" + mCompileSdkVersion +
                ", mBuildToolsVersion='" + mBuildToolsVersion + '\'' +
                ", mProductFlavor=" + mProductFlavor +
                '}'
    }

    static void main(String[] args) {

        /*
        * 闭包申明的值，赋给了两个实体对象Android和ProductFlavor
        * */
        def android = {
            /*
            * 访问代理对象的方法（函数）：
            * 1. xxx value
            * 2. xxx(value)
            * */
            // 也可以：compileSdkVersion(25)
            compileSdkVersion 25
            buildToolsVersion "25.0.2"
            // 如果方法参数类型是Closure类型，可以直接用大括号申明闭包，就像android下的defaultConfig 一样
            defaultConfig {
                minSdkVersion 15
                targetSdkVersion 25
                versionCode 1
                versionName "1.0"
            }
            // 访问代理对象的属性，用"="符合
            mCompileSdkVersion = 2
            println "mCompileSdkVersion: " + mCompileSdkVersion
            println "mBuildToolsVersion: " + mBuildToolsVersion

        }

        Android bean = new Android()
        android.delegate = bean
        android.call()
        println( bean )
    }
}
