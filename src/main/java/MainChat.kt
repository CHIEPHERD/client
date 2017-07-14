import chiepherd.services.ChatClient
import java.net.URI

fun main(args: Array<String>) {
    val chat = ChatClient(URI("ws://localhost:5050"))
    chat.connect()
}
