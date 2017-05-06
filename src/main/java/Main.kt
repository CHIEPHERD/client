import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.stage.Stage

class Main : Application() {
    var primaryStage : Stage? = null
    var rootLayout : BorderPane? = null

    override fun start(primaryStage: Stage) {
        this.primaryStage = primaryStage
        this.primaryStage!!.title = "AddressApp"

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
        rootLayout = loader.load<Any>() as BorderPane

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
        loader.location = Main::class.java.getResource("chiepherd/views/Main.fxml")
        val personOverview = loader.load<GridPane>()

        rootLayout!!.center = personOverview
    }
}

fun main(args: Array<String>) {
    Application.launch(Main::class.java, *args)
}
