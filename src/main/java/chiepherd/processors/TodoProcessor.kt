package chiepherd.processors

import chiepherd.annotations.Todo
import java.io.File
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.JavaFileManager

@SupportedAnnotationTypes(value = *arrayOf("chiepherd.annotations.Todo"))
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class TodoProcessor : AbstractProcessor() {
    override fun process(annotations : Set<TypeElement>, roundEnv: RoundEnvironment) : Boolean {
        File("somefile.txt").printWriter().use { out ->
            out.println("Hello")
        }


        processingEnv.filer.createResource(SOURCE_OUTPUT, )

        println("Début du traitement console !")
        annotations.forEach {
            println("Traitement annotation " + it.qualifiedName)

            //Permet de récupérer tous les éléments annotés avec l'annotation en cours
            roundEnv.getElementsAnnotatedWith(it).forEach {
                println("----------------------------------")
                //Permet de savoir quel type d'élément est annoté (constructeur, paramètre, classe...)
                println("\n Type d'élément annoté : " + it.kind + "\n")

                //retourne le nom de l'élément annoté, le nom de la variable, le nom de la classe...
                println("\t --> Traitement de l'élément : " + it.simpleName + "\n")

                //Différentes informations sur l'élément annoté
                println("enclosed elements : " + it.enclosedElements)
                println("as type : " + it.asType())
                println("enclosing element : " + it.enclosingElement + "\n")

                //Nous récupérons notre annotation
                val todo = it.getAnnotation(Todo::class.java)

                if (todo != null) {
                    println("\t\t Author : " + todo.author)
                    println("\t\t Comment : " + todo.message)
                    println("\t\t Level : " + todo.level)
                }
            }
        }
        return true
    }
}
