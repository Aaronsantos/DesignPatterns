package BuscOtel.Model

import java.util.*

class RepositorioHoteis {

    private lateinit var  hoteis: ArrayList<Hotel>

    constructor(){

        this.hoteis = ArrayList<Hotel>()

        var end: Endereco = Endereco("Av primeiro de maio", "11", "", "Jaguaribe" , "João Pessoa", "PB", "3.0".toFloat())
        this.hoteis.add( Hotel("IFPB", end))

        end = Endereco("Av Pedro Segundo", "33", "", "Centro", "João Pessoa", "PB", "2.0".toFloat())
        this.hoteis.add(Hotel("Pedro2", end))

        end = Endereco("Das Estrelas", "11", "",  "Ceus", "João Pessoa", "PB", "3.0".toFloat())
        this.hoteis.add(Hotel("GRASP", end))

        var cont:Int = 1
        for( hotel:Hotel in this.hoteis) {


            hotel.addQuarto(Quarto(1, "400".toFloat() * cont, TipoQuarto.SINGLE, hotel ))
            hotel.addQuarto(Quarto(2, "600".toFloat() * cont, TipoQuarto.DUPLO, hotel))
            hotel.addQuarto(Quarto(3, "700".toFloat() * cont, TipoQuarto.TRIPLO, hotel ))
            hotel.addQuarto(Quarto(4, "1000".toFloat() * cont, TipoQuarto.PRESIDENCIAL, hotel ))
            cont++
        }
    }

    fun findHotel(cidade: String, entrada: Date, saida: Date, tipo: TipoQuarto, precoMin: Float, precoMax: Float): ArrayList<Quarto> {

        var hoteisNaCidade: ArrayList<Hotel> = this.filtrarCidade(cidade)
        var quartosEncontrados: ArrayList<Quarto> = this.filtrarTipoQuarto(hoteisNaCidade, tipo)
        quartosEncontrados = this.filtrarPreco(quartosEncontrados, precoMin, precoMax)

        for(quarto:Quarto in quartosEncontrados){
                if( !quarto.verificaDisponibilidade(entrada, saida))
                    quartosEncontrados.remove(quarto)
        }

        return quartosEncontrados
    }

    private fun filtrarCidade(cidade:String): ArrayList<Hotel> {

        var hoteisNaCidade: ArrayList<Hotel> = ArrayList<Hotel>()

        for(hotel:Hotel in this.hoteis) {

            if( hotel.getEndereco().cidade.equals(cidade) )
                hoteisNaCidade.add(hotel)
        }
        return hoteisNaCidade
    }

    private fun filtrarTipoQuarto(hoteis: ArrayList<Hotel>, tipo: TipoQuarto) : ArrayList<Quarto> {

        var quartosEncontrados: ArrayList<Quarto> = ArrayList<Quarto>()
        for( hotel:Hotel in hoteis) {

            for(quarto:Quarto in hotel.getQuartos()) {
                if (quarto.getTipo() == tipo)
                    quartosEncontrados.add(quarto)
            }
        }
        return quartosEncontrados;
    }

    private fun filtrarPreco(quartos: ArrayList<Quarto>, min: Float, max: Float): ArrayList<Quarto> {

        for(quarto:Quarto in quartos) {
            if(quarto.getPrecoDiaria() > max) {
                quartos.remove(quarto)
            }
        }

        return quartos
    }
}