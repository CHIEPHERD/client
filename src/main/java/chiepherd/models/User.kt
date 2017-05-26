package chiepherd.models

class User : ApplicationModel() {
    lateinit var firstname              : String
    lateinit var lastname               : String
    lateinit var description            : String
    lateinit var password               : String
    lateinit var password_confirmation  : String
    var isAdmin  : Boolean = false
    var isActive : Boolean = true

}