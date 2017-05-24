import chiepherd.services.RabbitMQ
import sun.reflect.annotation.AnnotationParser

fun main(args: Array<String>) {
    val rabbitmq = RabbitMQ.instance
    // Code
    rabbitmq.stop()
}
