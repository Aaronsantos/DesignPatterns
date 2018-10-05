package BuscOtel.Model

class FormaPagamentoBoleto : FormaPagamento() {

    override  fun pagar(reserva: Reserva): Boolean {

        return true
    }
}