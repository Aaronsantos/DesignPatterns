package BuscOtel.Model

class Usuario {

    private var login: String
    private var nome: String
    private var senha: String
    private var reservas: ArrayList<Reserva>
    private lateinit var formaPagamento: FormaPagamento

    constructor(login:String, senha:String, nome:String, formaPagamento: FormaPagamento) {

        this.login = login
        this.senha = senha
        this.nome = nome
        this.formaPagamento = formaPagamento
        this.reservas = ArrayList<Reserva>()

    }

    fun pagarReserva( reserva: Reserva) {

        this.formaPagamento.pagar(reserva)
    }

    fun cancelarReserva ( reserva: Reserva) {

        this.reservas.remove(reserva)
        reserva.cancelar()
    }

    fun getReserva( num: Long): Reserva? {

        for(reserva: Reserva in this.reservas) {
            if(reserva.getNum() == num)
                return reserva
        }
        return null
    }

    fun getReservas(): ArrayList<Reserva> {

        return this.reservas
    }

    fun getLogin(): String{

        return this.login
    }

    fun addReserva( reserva: Reserva) {

        this.reservas.add(reserva)
    }





}