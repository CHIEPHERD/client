package chiepherd.controllers

import com.jfoenix.controls.JFXPasswordField
import com.jfoenix.controls.JFXTextField
import javafx.fxml.FXML
import javafx.fxml.Initializable
import java.net.URL
import java.util.*

class SignUpController : Initializable {
    @FXML lateinit var first_name            : JFXTextField
    @FXML lateinit var last_name             : JFXTextField
    @FXML lateinit var email                 : JFXTextField
    @FXML lateinit var password              : JFXPasswordField
    @FXML lateinit var password_confirmation : JFXPasswordField

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        println("Sign UP Controller")
    }
}