package BuscOtel.Model

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {

    //O usuário seria um dado compartilhado de seção de login, recuperado do repositório e passado ao buscador
    var user = Usuario("aaron", "1234", "Aaron S", FormaPagamentoBoleto())

    val buscador = Buscador(user)

    println("Buscando Hotel")

    val cidade = "João Pessoa"
    val entradaString = "10/10/2018"
    val saidaString = "15/10/2018"
    val tipo = TipoQuarto.SINGLE
    val min:Double = 0.00
    val max:Double = 500.00

    val df:DateFormat = SimpleDateFormat("dd/MM/yyyy")
    val entrada: Date = df.parse(entradaString)
    val saida: Date = df.parse(saidaString)

    buscador.executarBusca(cidade, entrada, saida, tipo, min, max)

    //mostrnado resultados
    var hoteis = buscador.getUltimaBusca()

    for(hotel: Hotel in hoteis) {

        println("Hotel ${hotel.getNome()} Preco: ${hotel.getPrecoDiaria(tipo)}")
    }

    //Escolhendo hotel

    //recuperando primeiro resultado da busca
    val hotel = buscador.getHotel(1 -1 )!!
    buscador.realizarReserva(hotel, entrada, saida)

    //Printando reservas:

    for( reserva: Reserva in buscador.getReservas()) {
        println("Reserva: ${reserva.getDataEntrada()} - ${reserva.getDataSaida()} ${reserva.getValor()}")
        //pagando reservas:
        //reserva.pagar()
    }
    
}
