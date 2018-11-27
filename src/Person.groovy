class Person{

    String name

    int age

    void eat(String food){
        println "传进来的food是:${food}"
    }

    @Override
    String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }

    static void main(String... args){
        println ""
    }
}
