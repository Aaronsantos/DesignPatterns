package BuscOtel.Model

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {

    //O usuário seria um dado compartilhado de seção de login
    var user = Usuario("aaron", "1234", "Aaron S", FormaPagamentoBoleto())

    val buscador = Buscador(user)


    var op:Int
    do{

        println("BuscOtel\n")
        println("Escolha uma das opcoes abaixo:\n")
        println("1- Buscar Hotel  2- Ver reservas 0- sair\n")
        println("Opcao: ")
        op = readLine()!!.toInt()

        when(op){
            1 -> buscarHotel(buscador)
            2 -> menuReservas(buscador)
            else -> println("Digite uma opcao válida!\n\n")
        }


    }while(op != 0)


}

fun buscarHotel(buscador: Buscador) {

    println("Digite a cidade para qual deseja pesquisar:")
    var cidade = readLine()!!
    println("Digite a data de entrada (dd/mm/aaaa):")
    var dataInput = readLine()!!
    println("Digite a data de saida (dd/mm/aaaa):")
    var dataInputSaida = readLine()!!
    println("Digite o preco minimo (00.00):")
    var min = readLine()!!.toDouble()
    println("Digite o preco maximo (00.00):")
    var max = readLine()!!.toDouble()
    println("Digite o tipo de quarto:\n 1 - Single 2 - Duplo 3 - triplo  4 - presidencial")
    var tipo: TipoQuarto? = when(readLine()!!.toInt()){
        1 -> TipoQuarto.SINGLE
        2 -> TipoQuarto.DUPLO
        3 -> TipoQuarto.TRIPLO
        4 -> TipoQuarto.PRESIDENCIAL
        else -> null
    }

    if(tipo == null){
        println("Tipo inválido!")
        return
    }

    val df:DateFormat = SimpleDateFormat("dd/MM/yyyy")
    val entrada: Date = df.parse(dataInput)
    val saida: Date = df.parse(dataInputSaida)

    buscador.executarBusca(cidade, entrada, saida, tipo, min, max)

    printBusca(buscador, tipo)

    print("Digite o numero do resultado para reservar:\n")
    val indiceHotel = readLine()!!.toInt() - 1
    val hotel: Hotel? = buscador.getHotel(indiceHotel)
    buscador.realizarReserva(hotel!!, entrada, saida)
}

fun printBusca(buscador: Buscador, tipo: TipoQuarto) {

    var hoteis = buscador.getUltimaBusca()

    for(hotel: Hotel in hoteis) {

        println("Hotel ${hotel.getNome()} Preco: ${hotel.getPrecoDiaria(tipo)}")
    }
}

fun menuReservas(buscador: Buscador) {

    var cont = 0
    println(buscador.getReservas().size)
    for( reserva: Reserva in buscador.getReservas()) {
        println("${cont++} Reserva: ${reserva.getDataEntrada()} - ${reserva.getDataSaida()} ${reserva.getValor()}")
    }
}