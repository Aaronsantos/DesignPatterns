package BuscOtel.Model

class FormaPagamentoCartao : FormaPagamento(){

    override fun pagar(valor: Float): Boolean {


        return  true
    }

}