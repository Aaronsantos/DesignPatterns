package BuscOtel.Model

class Endereco {

    var cidade: String
        get() = field
        set(value) {
            field = value
        }

    private var uf: String
    private var rua: String
        get() = field
        set(value) {
            field = value
        }
    private var numero: String
        get() = field
        set(value) {
            field = value
        }
    private var complemento: String
        get() = field
        set(value) {
            field = value
        }
    private  var distanciaDoCentro: Float
        get() = field
        set(value) {
            field = value
        }

    var bairro: String
        get() = field
        set(value) {
            field = value
        }

    constructor( rua:String, numero: String, comp: String, bairro:String, cidade:String, uf:String, distancia: Float) {

        this.cidade = cidade
        this.uf = uf
        this.rua = rua
        this.numero = numero
        this.bairro = bairro
        this.complemento = comp
        this.distanciaDoCentro = distancia
    }

    override fun toString(): String {
        return "Endereço: ${this.rua}, num ${this.numero}, ${this.complemento}, ${this.cidade} - ${this.uf}"
    }


}