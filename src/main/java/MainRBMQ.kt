import chiepherd.services.RabbitMQ
import sun.reflect.annotation.AnnotationParser

fun main(args: Array<String>) {
    // val rabbitmq = RabbitMQ.instance
    // rabbitmq.sendMessage("bunny.examples.hello_world", "fanout", "demo.test", "bla bla bla")

    val list = System.getProperty("java.class.path")

    println(list)
    println("Close")
}
