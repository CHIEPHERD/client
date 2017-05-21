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

class Main : Application() {
    var primaryStage : Stage? = null
    var rootLayout : VBox? = null
    var contentLayout : AnchorPane? = null

    override fun start(primaryStage: Stage) {
        this.primaryStage = primaryStage
        this.primaryStage!!.title = "Chiepherd"

        initRootLayout()

        showPersonOverview()
    }

    /**
     * Initializes the root layout.
     */
    fun initRootLayout() {
        // Load root layout from fxml file.
        val loader = FXMLLoader()
        loader.location = Main::class.java.getResource("chiepherd/views/layouts/Application.fxml")
        rootLayout = loader.load<Any>() as VBox
        contentLayout = rootLayout!!.lookup("#Content") as AnchorPane

        // Show the scene containing the root layout.
        val scene = Scene(rootLayout)
        primaryStage!!.scene = scene
        primaryStage!!.show()
    }

    /**
     * Shows the person overview inside the root layout.
     */
    fun showPersonOverview() {
        val loader = FXMLLoader()
        loader.location = Main::class.java.getResource("chiepherd/views/Login.fxml")
        val personOverview = loader.load<BorderPane>()

        contentLayout!!.children.add(personOverview)
    }
}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}
