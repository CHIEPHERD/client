import chiepherd.services.RabbitMQ

fun main(args: Array<String>) {
    val rabbitmq = RabbitMQ.instance

    rabbitmq.sendMessage("bunny.examples.hello_world", "fanout", "demo.test", "bla bla bla")

    println("Close")
}
