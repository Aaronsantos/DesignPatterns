package BuscOtel.Model

abstract class FormaPagamento {

    abstract  fun pagar( reserva: Reserva): Boolean
}