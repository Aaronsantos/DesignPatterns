package BuscOtel.Model

class FormaPagamentoCartao : FormaPagamento(){

    override fun pagar(reserva: Reserva): Boolean {


        return  true
    }

}