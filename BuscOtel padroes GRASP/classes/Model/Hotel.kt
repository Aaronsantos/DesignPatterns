package BuscOtel.Model

class Hotel {

    private lateinit var nome:String
    private lateinit var recomendacoes: ArrayList<Int>
    private lateinit var quartos: ArrayList<Quarto>
    private lateinit var endereco: Endereco

    constructor(nome:String, endereco: Endereco) {

        this.nome = nome
        this.endereco = endereco;
        this.recomendacoes = ArrayList<Int>()
        this.quartos = ArrayList<Quarto>()
    }

    fun getNome(): String {

        return this.nome
    }

    fun setNome(nome:String) {

        this.nome = nome
    }

    fun getQuartos() : ArrayList<Quarto> {

        return this.quartos
    }

    fun removeQuarto(quarto: Quarto) {

        this.quartos.remove(quarto)
    }

    fun addQuarto( novoQuarto: Quarto) {

        this.quartos.add(novoQuarto)
    }

    fun getEndereco():Endereco {

        return this.endereco
    }

    fun setEndereco( end: Endereco) {
        this.endereco = end
    }

    fun addRecomendacao( nota: Int) {

        this.recomendacoes.add(nota)
    }

    fun getRecomendacaoMedia(): Double {

        var media:Double

        for( rec:Int in this.recomendacoes) {

        }
    }




}