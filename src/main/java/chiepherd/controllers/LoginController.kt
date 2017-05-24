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
import chiepherd.annotations.RabbitMessage
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane

class LoginController : ApplicationController() {
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
        switchScene(actionEvent, "chiepherd/views/SignUp.fxml")
    }
}
