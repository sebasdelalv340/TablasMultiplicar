/**
 * Clase que representa a un robot con capacidad de movimiento en un plano bidimensional.
 *
 * @property nombre Nombre del robot.
 * @property posX Posición actual en el eje X.
 * @property posY Posición actual en el eje Y.
 * @property dir Dirección actual del robot (0: hacia arriba, 1: hacia la izquierda, 2: hacia abajo, 3: hacia la derecha).
 */
class Robot(private val nombre: String) {
    private var posX: Int = 0
    private var posY: Int = 0
    private var dir: Int = 0


    /**
     * Mueve el robot en la dirección actual según la cantidad de movimientos especificada.
     *
     * @param movs Arreglo de enteros que representa la cantidad de movimientos en cada iteración.
     */
    fun mover(movs: IntArray) {
        for (i in movs) {
            when (this.dir) {
                0 -> this.posY += i
                1 -> this.posX -= i
                2 -> this.posY -= i
                3 -> this.posX += i
            }
            if (this.dir == 3) {this.dir = 0} else this.dir++
        }
    }


    /**
     * Obtiene una cadena que representa la posición actual y la dirección del robot.
     *
     * @return Cadena que describe la posición y dirección del robot.
     */
    fun mostrarPosicion(): String {
        return "${this.nombre} está en (${this.posX}, ${this.posY}) ${obtenerDireccion()}"
    }


    /**
     * Obtiene una cadena que representa la dirección actual del robot.
     *
     * @return Cadena que describe la dirección del robot.
     */
    private fun obtenerDireccion(): String {
        return when (this.dir) {
            0 -> "POSITIVE Y"
            1 -> "NEGATIVE X"
            2 -> "NEGATIVE Y"
            3 -> "POSITIVE X"
            else -> ""
        }
    }
}


fun main() {

    val robot1 = Robot("R2D2")
    val movs = arrayOf(
        intArrayOf(1, -5, 0, -9),
        intArrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        intArrayOf(2, 1, 0, -1, 1, 1, -4),
        intArrayOf(),
        intArrayOf(3, 5)
    )

    for (mov in movs) {
        robot1.mover(mov)
        println(robot1.mostrarPosicion())
    }

}