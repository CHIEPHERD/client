package chiepherd.annotations

import jdk.nashorn.internal.ir.annotations.Immutable
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Arrays



@SupportedAnnotationTypes("chiepherd.annotations.RabbitMessage")
class RabbitMessageProcessor : AbstractProcessor() {
    override fun process(annotation : Set<TypeElement>, environment: RoundEnvironment) : Boolean {
        val lines = Arrays.asList("The first line", "The second line")
        val file = Paths.get("the-file-name.txt")
        Files.write(file, lines, Charset.forName("UTF-8"))

        println("Foo")
        environment.getElementsAnnotatedWith(RabbitMessage::class.java)
                .asSequence()
                .filterIsInstance<TypeElement>()
                .forEach {
                    it.enclosedElements
                            .asSequence()
                            .filterIsInstance<VariableElement>()
                            .forEach { println("Proccess") }
                }

        return true
    }
}

//class SimpleAnnotationProcessor : AbstractProcessor() {
//    fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
//
//        for (element in roundEnv.getElementsAnnotatedWith(Immutable::class.java)) {
//            if (element is TypeElement) {
//                val typeElement = element
//
//                for (eclosedElement in typeElement.enclosedElements) {
//                    if (eclosedElement is VariableElement) {
//                        val variableElement = eclosedElement as VariableElement
//
//                        if (!variableElement.getModifiers().contains(Modifier.FINAL)) {
//                            processingEnv.messager.printMessage(Diagnostic.Kind.ERROR,
//                                    String.format("Class '%s' is annotated as @Immutable, , ,
//                                            but, , field))
//                            '%s'
//                            val not: `is`
//                            val `as`: declared
//
//                            ",
//                            typeElement.simpleName
//                            variableElement.getSimpleName()
//                        }
//                    }
//                }
//            }
//
//            // Claiming that annotations have been processed by this processor
//            return true
//        }
//    }
//}