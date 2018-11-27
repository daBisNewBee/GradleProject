class Main {

    // person中也定义了该方法，演示冲突
    void eat(String name){
        println "这里是Main中的eat: " + name
    }

    def cc = {
        name = "hanmeimei"
        age = 26

        // 在闭包中访问被代理对象的方法，即：调用Person中的方法
        eat("油条")
        eat "豆浆"
    }

    /*
    * delegate的意义:
    *   就是将闭包和一个具体的对象关联起来，
    *
    * */
    static void main(String... args){
        Person person = new Person(name: "lilei", age: 30)
        println "person: " + person

        Main main = new Main()
        // 通过闭包"cc"修改Person中的字段！
        main.cc.delegate = person
        /*
        *
        * 闭包所在的类或者闭包中，有和被代理对象相同名称的方法，即方法冲突了，怎么办？
        *
        * 可以设置策略：
        *   DELEGATE_FIRST ：优先在delegate（被代理对象）寻找，delegate没有再owner
        *   OWNER_FIRST：优先在owner寻找，owner没有再delegate
        *   其他
        * */
        main.cc.setResolveStrategy(Closure.OWNER_FIRST)
        main.cc.call()
        println("After delegate, person: " + person)
    }
}
