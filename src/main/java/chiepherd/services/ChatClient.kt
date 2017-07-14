package chiepherd.services

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

class ChatClient(uri : URI) : WebSocketClient(uri) {
    override fun onOpen(p0: ServerHandshake?) {
        println("Hello")
    }

    override fun onClose(p0: Int, p1: String?, p2: Boolean) {
        println("See U")
    }

    override fun onMessage(p0: String?) {
        println("Get message '$p0' with WS")
    }

    override fun onError(p0: Exception?) {
        error(p0.toString())
    }
}
