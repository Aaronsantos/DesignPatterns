package BuscOtel.Model

abstract class FormaPagamento {

    abstract  fun pagar(valor:Float): Boolean
}