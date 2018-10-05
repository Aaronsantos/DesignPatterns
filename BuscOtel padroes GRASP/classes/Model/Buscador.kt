package BuscOtel.Model

import java.util.*

class Buscador {

    private lateinit var ultimaBusca: ArrayList<Hotel>
    private lateinit var usuario: Usuario
    private lateinit var repositorio: Repositorio

    private lateinit var ultimaEntrada: Date
    private lateinit var ultimaSaida: Date
    private lateinit var ultimoTipoQuarto: TipoQuarto
    private lateinit var ultimaCidade: String
    private  var ultimoPrecoMax: Double?
    private var ultimoPrecoMin: Double?

    constructor(usuario: Usuario) {

        this.usuario = usuario
        this.repositorio = Repositorio()
        this.ultimaBusca = ArrayList<Hotel>()

        this.ultimoPrecoMin= null
        this.ultimoPrecoMax= null

    }

    fun executarBusca(cidade: String, entrada: Date, saida: Date, tipo: TipoQuarto, precoMin: Double, precoMax: Double) {

        this.ultimaEntrada = entrada
        this.ultimaSaida = saida
        this.ultimoTipoQuarto = tipo
        this.ultimaCidade = cidade
        this.ultimoPrecoMax = precoMax
        this.ultimoPrecoMin = precoMin

        this.ultimaBusca = this.repositorio.findHotel(cidade, entrada, saida, tipo, precoMin, precoMax )
    }

    fun realizarReserva( hotel: Hotel, entrada: Date, saida: Date) {

        hotel.reservarQuarto(this.ultimaEntrada, this.ultimaSaida, this.ultimoTipoQuarto, this.usuario)
    }

    fun getHotel(indice:Int): Hotel? {

        return this.ultimaBusca.get(indice)
    }

    fun getReserva (num: Long) :Reserva? {

        return this.usuario.getReserva(num)
    }

    fun getReservas() :ArrayList<Reserva> {

        return this.usuario.getReservas()
    }

    fun getUltimaBusca(): ArrayList<Hotel> {

        return this.ultimaBusca
    }
}