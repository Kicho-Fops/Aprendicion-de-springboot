package com.svruso.api.chinguenasumadre

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChinguenasumadreApplication



/*
*
* Basicamente esta API consiste de 3 capas
*
* 1. Data Layer
* 2. Data Source -> Sirve para que podamos sacar informacion de diferentes lugares, como una base de datos, cache, un acrhivo, etc...
* 3. Service Layer
* 4. Controller Layer
*
*
*
*
*
* */








fun main(args: Array<String>) {
	runApplication<ChinguenasumadreApplication>(*args)
}
