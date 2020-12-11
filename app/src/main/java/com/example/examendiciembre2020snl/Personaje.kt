package com.example.examendiciembre2020snl
//Sheila Nieva 05985717-J

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Personaje (@PrimaryKey var id: String = "",
                      var nombre: String="",
                      var raza : String="",
                      var ki : Int =0,
                      var ataque: String="",
                      var imagen: String=""): RealmObject(){
    constructor(nombre:String, raza:String, ki:Int, ataque:String, imagen:String):this(UUID.randomUUID().toString(), nombre, raza, ki, ataque, imagen)
}