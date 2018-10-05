package BuscOtel.Model

import java.util.*
import java.util.concurrent.TimeUnit

class Reserva {

    private var num: Long
    private var dataHora: Date
    private var dataEntrada: Date
    private var dataSaida: Date
    private var quarto: Quarto
    private lateinit var usuario: Usuario
    private var statusPagamento: Boolean


    constructor( dataHora: Date, dataEntrada: Date, saida: Date, quarto: Quarto, usuario: Usuario) {

        this.num = dataHora.time
        this.dataHora = dataHora
        this.dataEntrada = dataEntrada
        this.dataSaida = saida
        this.quarto = quarto
        this.statusPagamento = false
        this.usuario = usuario
        }

    fun getValor(): Double{

        return this.quarto.getPrecoDiaria() * this.calcularQuantidadeDiarias()
    }

    fun calcularQuantidadeDiarias(): Long  {
        return Math.abs( TimeUnit.DAYS.convert(this.dataEntrada.time - this.dataSaida.time, TimeUnit.MILLISECONDS) )
    }

    fun getDataEntrada(): Date {

        return  this.dataEntrada
    }

    fun getDataSaida(): Date {
        return this.dataSaida
    }

    fun pagar() {

        this.usuario.pagarReserva(this)
        this.statusPagamento = true
    }

    fun cancelar() {

        this.quarto.cancelarReserva(this)
    }

    fun getNum(): Long {
        return this.num
    }
}