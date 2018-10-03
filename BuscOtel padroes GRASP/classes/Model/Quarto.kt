package BuscOtel.Model

import java.util.*

class Quarto {

    private var numero:Int
    private var precoDiaria:Float
    private var tipo: TipoQuarto
    private var reservas: ArrayList<Reserva>
    private var hotel: Hotel


    constructor(num:Int, preco:Float, tipo:TipoQuarto, hotel:Hotel) {

        this.numero = num
        this.precoDiaria = preco
        this.tipo = tipo
        this.reservas = ArrayList<Reserva>()
        this.hotel = hotel
    }

    fun reservar(dataEntrada: Date, dataSaida: Date) {

        var novaReserva: Reserva = Reserva(  Date(), dataEntrada, dataSaida, this)
        this.reservas.add(novaReserva)
    }

    fun verificaDisponibilidade(dataEntrada: Date, dataSaida: Date): Boolean {

        for( reserva:Reserva in this.reservas){

            if( reserva.dataEntrada.equals(dataEntrada) )
                    return false
            if (  reserva.dataSaida.after(dataEntrada) && reserva.dataEntrada.before(dataEntrada) )
                return false
            if (reserva.dataEntrada.before(dataSaida) && reserva.dataSaida.after(dataEntrada) )
                return false
        }

        return true

    }

    fun getNumero():Int {

        return this.numero
    }

    fun setNumero(num:Int) {
        this.numero = num
    }

    fun getPrecoDiaria(): Float {

        return this.precoDiaria
    }

    fun setPrecoDiaria(preco: Float) {

        this.precoDiaria = preco;
    }


    fun getTipo(): TipoQuarto {
        return this.tipo
    }

    fun setTipo(tipo:TipoQuarto) {
        this.tipo = tipo
    }


}