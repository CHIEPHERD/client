package chiepherd.controllers

import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXPasswordField
import com.jfoenix.controls.JFXTextField
import extensions.javafx.event.stage
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.net.URL
import java.util.*

import Main
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane

class LoginController : Initializable {
    @FXML lateinit var email    : JFXTextField
    @FXML lateinit var password : JFXPasswordField
    @FXML lateinit var sign_in  : JFXButton
    @FXML lateinit var sign_up  : JFXButton

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println("INIT View Login")
    }

    @FXML fun onSignUp(actionEvent : ActionEvent?) {
        println("Sign up")
        if(actionEvent == null) { return }

        val loader = FXMLLoader()
        loader.location = Main::class.java.getResource("chiepherd/views/layouts/Application.fxml")

        val home_parent = loader.load<VBox>()
        val contentLayout = home_parent.lookup("#Content") as AnchorPane

        val home_scene  = Scene(home_parent)

        val home_stage = actionEvent.stage
        home_stage.scene = home_scene
        home_stage.show()


        val loader_scene = FXMLLoader()
        loader_scene.location = Main::class.java.getResource("chiepherd/views/SignUp.fxml")
        val personOverview = loader_scene.load<BorderPane>()

        contentLayout.children.add(personOverview)
    }
}
