package chiepherd.annotations

import chiepherd.services.RabbitMQ

@Target(AnnotationTarget.FUNCTION)
annotation class RabbitMessage(val message : String)
