class WeatherData extends Subject {

    constructor() {

        super()

        this._temperature = 0
        this._humidity = 0
        this._pressure = 0
        this._datetime = new Date()

    }

    registerObserver(observer){

        this._observerCollection.push(observer)
    }

    unregisterObserver(observer) {
        let index = this._observerCollection.indexOf(observer)

        if(index === -1)
            return 
            
        this._observerCollection.splice(index , 1) 
    }

    measurementsChanged(){

        this._datetime = new Date() 

        this._observerCollection.forEach( observer => {
            observer.notify(this)
        })
    }

    get temperature(){

        return this._temperature
    }

    get humidity() {

        
        return this._humidity
    }

    get pressure(){


        return this._pressure
    }


    set temperature(temperature){
        
        this._temperature = temperature
        
    }

    set humidity(humidity) {

        this._humidity = humidity
        
    }

    set pressure(pressure){

        this._pressure = pressure 
        
    }

    get dateTime () {


        return this._datetime
    }



}