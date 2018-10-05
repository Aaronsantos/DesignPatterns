package BuscOtel.Model

import java.util.*

class Repositorio {

    private lateinit var  hoteis: ArrayList<Hotel>
    private lateinit var usuarios: ArrayList<Usuario>

    constructor(){

        this.hoteis = ArrayList<Hotel>()
        this.usuarios = ArrayList<Usuario>()


        var end: Endereco = Endereco("Av primeiro de maio", "11", "", "Jaguaribe" , "João Pessoa", "PB", "3.0".toFloat())
        this.hoteis.add( Hotel("IFPB", end, 400.0, 600.0, 700.0, 1000.0))

        end = Endereco("Av Pedro Segundo", "33", "", "Centro", "João Pessoa", "PB", "2.0".toFloat())
        this.hoteis.add(Hotel("Pedro2", end, 500.0, 700.0, 800.0, 2000.0))

        end = Endereco("Das Estrelas", "11", "",  "Ceus", "João Pessoa", "PB", "3.0".toFloat())
        this.hoteis.add(Hotel("GRASP", end, 600.0, 800.0, 900.0, 3000.0))

        var cont:Int = 1
        for( hotel:Hotel in this.hoteis) {


            hotel.addQuarto(Quarto(1, TipoQuarto.SINGLE, hotel ))
            hotel.addQuarto(Quarto(2, TipoQuarto.DUPLO, hotel))
            hotel.addQuarto(Quarto(3, TipoQuarto.TRIPLO, hotel ))
            hotel.addQuarto(Quarto(4, TipoQuarto.PRESIDENCIAL, hotel ))
            cont++
        }

        var user: Usuario = Usuario("petronio", "123456", "Francisco Petronio", FormaPagamentoCartao())

        this.usuarios.add(user)
    }

    fun findHotel(cidade: String, entrada: Date, saida: Date, tipo: TipoQuarto, precoMin: Double, precoMax: Double): ArrayList<Hotel> {

        var hoteisEncontrados: ArrayList<Hotel> = this.filtrarCidade(cidade)
        hoteisEncontrados = this.filtrarPreco(this.hoteis, tipo, precoMin, precoMax)
        hoteisEncontrados = this.filtrarTipoQuarto(hoteisEncontrados, tipo, entrada, saida)


        return hoteisEncontrados
    }

    private fun filtrarCidade(cidade:String): ArrayList<Hotel> {

        var hoteisNaCidade: ArrayList<Hotel> = ArrayList<Hotel>()

        for(hotel:Hotel in this.hoteis) {

            if( hotel.getCidade() == cidade )
                hoteisNaCidade.add(hotel)
        }
        return hoteisNaCidade
    }

    private fun filtrarTipoQuarto(hoteis: ArrayList<Hotel>, tipo: TipoQuarto, entrada:Date, saida: Date) : ArrayList<Hotel> {

        var hoteisDisponiveis: ArrayList<Hotel> = ArrayList<Hotel>()
        for(hotel: Hotel in hoteis) {

            if(hotel.existeQuartoDisponivel(entrada, saida, tipo))
                hoteisDisponiveis.add(hotel)
        }

        return hoteisDisponiveis
    }

    private fun filtrarPreco(hoteis: ArrayList<Hotel>, tipo: TipoQuarto, min: Double, max: Double): ArrayList<Hotel> {

        println()
        var hoteisEncontrados: ArrayList<Hotel> = ArrayList<Hotel>()
        for(hotel: Hotel in hoteis) {

            var preco: Double = hotel.getPrecoDiaria(tipo)
            if( preco <= max && preco >= min ) hoteisEncontrados.add(hotel)
        }

        return hoteisEncontrados
    }

    fun findUsuario(login: String):Usuario? {

        for( usuario:Usuario in usuarios)
            if(usuario.getLogin() == login)
                return usuario
        return null
    }
}