fun main(args: Array<String>) {
    /**
     * Solicita un número entero en un rango.
     *
     * @param min Int - valor mínimo
     * @param max Int - valor máximo
     *
     * @return Int - número entero válido dentro del rango especificado
     */
    fun pedirNum(min: Int, max: Int): Int {
        var num = 0

        do {
            print("Introduce un número 1-100: ")
            num = try {
                readln().toInt()
            } catch(e: NumberFormatException) {
                min - 1
            }
            if (num < min || num > max) {
                println("**error** número no válido")
            }
        } while (num < min || num > max)

        return num
    }

    /**
     * Realiza una pregunta para contestar con s/si ó n/no
     *
     * @param text String - Texto de la pregunta
     *
     * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
     */
    fun pregunta(text: String): Boolean {
        var respuesta: String

        do {
            println("¿Desea generar otra tabla de multiplicación? (s/n)")
            respuesta = readln().lowercase()
        } while ( respuesta != "s" && respuesta != "n")

        if (respuesta == "s") {
            return true
        } else if (respuesta == "n") {
            return false
        }
        return true
    }

    fun main() {
        //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su table de multiplicar...
        //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"

        do {
            val num = pedirNum(min = 1, max = 100)

            val tablas = Array(10) {"${it + 1} x $num = ${num * (it + 1)}"}
            for (linea in tablas) {
                println(linea)
            }
        } while (pregunta("s"))
    }

    main()
}