package BuscOtel.Model

import java.util.*

class Hotel {

    private lateinit var nome:String
    private lateinit var recomendacoes: ArrayList<Int>
    private var recomendacaoMedia: Double
    private lateinit var quartos: ArrayList<Quarto>
    private lateinit var endereco: Endereco
    private var precoDuplo: Double
    private var precoSingle: Double
    private var precoTriplo: Double
    private var precoPresidencial: Double

    constructor(nome:String, endereco: Endereco, precoSingle: Double, precoDuplo: Double, precoTriplo: Double, precoPresidencial: Double) {

        this.nome = nome
        this.endereco = endereco;
        this.recomendacoes = ArrayList<Int>()
        this.quartos = ArrayList<Quarto>()
        this.precoSingle = precoSingle
        this.precoDuplo = precoDuplo
        this.precoTriplo = precoTriplo
        this.precoPresidencial = precoPresidencial
        this.recomendacaoMedia = this.calculaRecomendacaoMedia()

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

    fun getPrecoDiaria(tipo: TipoQuarto): Double {

        return  when(tipo) {
            TipoQuarto.SINGLE -> this.precoSingle
            TipoQuarto.DUPLO -> this.precoDuplo
            TipoQuarto.TRIPLO -> this.precoTriplo
            TipoQuarto.PRESIDENCIAL -> this.precoPresidencial
            else -> 0.0
        }
    }

    fun getCidade() : String {
        return this.endereco.cidade
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
        this.recomendacaoMedia = this.calculaRecomendacaoMedia()
    }

    fun calculaRecomendacaoMedia(): Double {

        var media:Double = 0.0

        for( rec:Int in this.recomendacoes) {
            media += rec
        }

        media = media/this.recomendacoes.size
        return media
    }

    fun existeQuartoDisponivel(entrada: Date, saida: Date, tipo: TipoQuarto ):Boolean {

        for( quarto:Quarto in this.quartos) {

            if(quarto.getTipo() == tipo)
                if(quarto.verificaDisponibilidade(entrada, saida)) return true
        }
        return false
    }

    fun reservarQuarto(entrada: Date, saida: Date, tipo: TipoQuarto, usuario: Usuario) {

        for( quarto:Quarto in this.quartos) {

            if(quarto.getTipo() == tipo)
                if(quarto.verificaDisponibilidade(entrada, saida)) {
                    quarto.reservar(entrada, saida, usuario)
                    return
                }
        }
    }


}