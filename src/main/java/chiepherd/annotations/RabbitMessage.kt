package chiepherd.annotations

import chiepherd.services.RabbitMQ

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class RabbitMessage(val message : String)
