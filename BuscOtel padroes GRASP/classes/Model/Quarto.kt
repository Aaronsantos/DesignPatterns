package BuscOtel.Model

import java.util.*

class Quarto {

    private var numero:Int
    private var tipo: TipoQuarto
    private var reservas: ArrayList<Reserva>
    private var hotel: Hotel


    constructor(num:Int, tipo:TipoQuarto, hotel:Hotel) {

        this.numero = num
        this.tipo = tipo
        this.reservas = ArrayList<Reserva>()
        this.hotel = hotel
    }

    fun reservar(dataEntrada: Date, dataSaida: Date, usuario: Usuario) {

        var novaReserva: Reserva = Reserva(  Date(), dataEntrada, dataSaida, this, usuario)
        this.reservas.add(novaReserva)
        usuario.addReserva(novaReserva)
    }

    fun verificaDisponibilidade(dataEntrada: Date, dataSaida: Date): Boolean {

        for( reserva:Reserva in this.reservas){

            if( reserva.getDataEntrada().equals(dataEntrada) )
                    return false
            if (  reserva.getDataSaida().after(dataEntrada) && reserva.getDataEntrada().before(dataEntrada) )
                return false
            if (reserva.getDataEntrada().before(dataSaida) && reserva.getDataSaida().after(dataEntrada) )
                return false
        }

        return true

    }

    fun cancelarReserva( reserva: Reserva) {

        this.reservas.remove(reserva)
    }

    fun getNumero():Int {

        return this.numero
    }

    fun setNumero(num:Int) {
        this.numero = num
    }

    fun getPrecoDiaria(): Double {
        return this.hotel.getPrecoDiaria(this.tipo)
    }


    fun getTipo(): TipoQuarto {
        return this.tipo
    }

    fun setTipo(tipo:TipoQuarto) {
        this.tipo = tipo
    }


}