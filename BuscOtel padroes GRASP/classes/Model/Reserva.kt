package BuscOtel.Model

import java.util.*
import java.util.concurrent.TimeUnit

class Reserva {


    var dataHora: Date
        get() = field

    var dataEntrada: Date
        get() = field
        set(value) {
            field = value
        }
    var dataSaida: Date
        get() = field
        set(value) {
            field = value
        }
    var quarto: Quarto
        get() = field
        set(value) {
            field = value
        }



    constructor( dataHora: Date, dataEntrada: Date, saida: Date, quarto: Quarto) {
        this.dataHora = dataHora
        this.dataEntrada = dataEntrada
        this.dataSaida = saida
        this.quarto = quarto
        }

    fun getValor():Float {

        return this.quarto.getPrecoDiaria() * this.calcularQuantidadeDiarias()
    }

    fun calcularQuantidadeDiarias(): Long  {
        return TimeUnit.DAYS.convert(this.dataEntrada.time - this.dataSaida.time, TimeUnit.MILLISECONDS)
    }
}