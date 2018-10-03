package BuscOtel.Model

class Pagamento {

    var pago:Boolean
        get() = field
        set(value) {
            field = value
        }
    var desconto: Float
        get() = field
        set(value) {
            field = value
        }
    var reserva: Reserva
        get() = field
        set(value) {
            field = value
        }
    var metodoPagamento: FormaPagamento
        get() = field
        set(value) {
            field = value
        }

    constructor( reserva: Reserva, desconto: Float, mtdPagamento: FormaPagamento) {
        this.pago = false
        this.desconto = desconto
        this.metodoPagamento = mtdPagamento
        this.reserva = reserva
    }

    private fun calcularTotal(): Float {
        return this.reserva.getValor() - this.desconto
    }

    public fun pagar() {

        this.pago = this.metodoPagamento.pagar(this.calcularTotal())
    }
}