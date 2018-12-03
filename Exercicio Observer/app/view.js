
class View extends Observer {

    constructor(selector) {


        super()
        let root = document.querySelector(selector)

        this._data = document.createElement('h3')
        this._hora = document.createElement('h3')
        this._temperatura = document.createElement('h2')
        this._humidade = document.createElement('h2')
        this._pressao = document.createElement('h2')

        root.appendChild(this._data)
        root.appendChild(this._hora)
        root.appendChild(this._temperatura)
        root.appendChild(this._humidade)
        root.appendChild(this._pressao)
    }

    notify(subject) {

        this._render(subject)
    }

    _render(data){

        this._atualizaTemperatura(data.temperature)
        this._atualizaHumidade(data.humidity)
        this._atualizaPressao(data.pressure)
        this._atualizaDataHora(data.dateTime)
    }

    _atualizaTemperatura(temperatura) {

        this._temperatura.textContent = `Temperatura: ${temperatura}` 
    }

    _atualizaPressao(pressao) {

        this._pressao.textContent = `Pressão: ${pressao}` 
    }

    _atualizaHumidade(humidade) {

        this._humidade.textContent = `Humidade: ${humidade} `
    }

    _atualizaDataHora(dateTime) {

        this._data.textContent = `${dateTime.getDate()}/${dateTime.getMonth() + 1}/${dateTime.getYear()}`
        this._hora.textContent = `${dateTime.getHours()}:${dateTime.getMinutes()}:${dateTime.getSeconds()}` 
    }
}