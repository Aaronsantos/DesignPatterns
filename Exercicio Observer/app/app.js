
var wd  = new WeatherData()
var view = new View('#root')

wd.registerObserver(view)
wd.measurementsChanged()


setInterval( function() {

    wd.temperature = Math.floor(Math.random() * 100)
    wd.pressure = Math.random() * 100
    wd.humidity = Math.random() * 100

    wd.measurementsChanged()

}, 1000)
