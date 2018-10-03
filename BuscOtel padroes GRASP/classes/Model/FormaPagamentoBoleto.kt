package BuscOtel.Model

class FormaPagamentoBoleto : FormaPagamento() {

    override  fun pagar(valor: Float): Boolean {

        return true
    }
}