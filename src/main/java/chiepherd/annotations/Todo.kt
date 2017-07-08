package chiepherd.annotations

enum class LEVEL constructor(private val description: String) {
    MINOR("Minor Action"),
    ENHANCE("Possible improvement"),
    BUG("Bug to fix quickly"),
    CRITICAL("Critical bug to fix urgently!");

    override fun toString(): String {
        return description
    }
}


@MustBeDocumented
@Retention(AnnotationRetention.SOURCE)
annotation class Todo(val level : LEVEL, val author : String,  val message : String)
