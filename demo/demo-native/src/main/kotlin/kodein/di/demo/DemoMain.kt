package kodein.di.demo

import org.kodein.di.*
import org.kodein.di.erased.*
import kodein.di.demo.coffee.*

fun main(args: Array<String>) {
    Application()
}

class Application : KodeinAware {

    override val kodein = Kodein {
        import(thermosiphonModule)
        import(electricHeaterModule)

        bind<Coffee>() with provider { Coffee() }

        // this is bound in the scope of an activity so any retrieval using the same activity will return the same Kettle instance
        bind<Kettle<*>>() with singleton { Kettle<Coffee>(instance(), instance(), provider()) }

        constant("author") with "Salomon BRYS"
    }

    private val _kettle: Kettle<Coffee> by instance()

    init {
        val author: String by instance("author")
        println("Kodein 5 Demo by $author")

        _kettle.brew()
    }
}
