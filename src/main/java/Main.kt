import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.SplitPane
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import chiepherd.controllers.*
import chiepherd.processors.TodoProcessor
import chiepherd.services.RabbitMQ

class Main : Application() {
    lateinit var primaryStage : Stage
    lateinit var rootLayout : VBox
    lateinit var contentLayout : AnchorPane

    override fun start(primaryStage: Stage) {
        RabbitMQ.instance // Start RabbitMQ

        this.primaryStage = primaryStage
        this.primaryStage.title = "Chiepherd"

        initRootLayout()

        showPersonOverview()
    }

    override fun stop() {
        RabbitMQ.instance.stop()
    }

    /**
     * Initializes the root layout.
     */
    fun initRootLayout() {
        // Load root layout from fxml file.
        val loader = FXMLLoader()
        loader.location = Main::class.java.getResource("chiepherd/views/layouts/Application.fxml")
        rootLayout = loader.load<Any>() as VBox
        contentLayout = rootLayout.lookup("#Content") as AnchorPane

        // Show the scene containing the root layout.
        val scene = Scene(rootLayout)
        primaryStage.scene = scene
        primaryStage.show()
    }

    /**
     * Shows the person overview inside the root layout.
     */
    fun showPersonOverview() {
        val loader = FXMLLoader()
        loader.location = Main::class.java.getResource("chiepherd/views/Login.fxml")
        val personOverview = loader.load<BorderPane>()

        contentLayout.children.add(personOverview)
    }
}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}
