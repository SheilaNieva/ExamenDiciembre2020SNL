package com.example.examendiciembre2020snl
//Sheila Nieva 05985717-J

import android.content.Context
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where

object PersonajeController {
    private const val DATOS_BD = "REPASO_EXAMEN"
    private const val DATOS_BD_VERSION = 1L

    fun initRealm(context: Context?) {
        Realm.init(context)
        val config = RealmConfiguration.Builder()
            .name(DATOS_BD)
            .schemaVersion(DATOS_BD_VERSION) // Versión de esquema estamos trabajando, si lo cambiamos, debemos incrementar
            .deleteRealmIfMigrationNeeded() // Podemos borrar los datos que ya haya si cambiamos el esquema,
            .build()
        Realm.setDefaultConfiguration(config)
        Log.d("Datos", "Iniciando Realm")
    }

    //Consultas basicas en una base de datos Realm según nuestra clase pollo


    //Insertamos un nuevo objeto en nuestra bbdd
    fun insertDato(dato: Personaje) {
        Realm.getDefaultInstance().executeTransaction {
            it.copyToRealm(dato); // Copia, inserta
        }
    }

    //Actualizamos un personaje en nuestra base de datos
    fun updateDato(dato: Personaje) {
        Realm.getDefaultInstance().executeTransaction {
            it.copyToRealmOrUpdate(dato)
        }
    }

    //Obtenemos toda la lista de personajes que tengamos guardados en la bbdd
    fun selectAll(): MutableList<Personaje>? {
        return Realm.getDefaultInstance().copyFromRealm(
            Realm.getDefaultInstance().where<Personaje>().findAll()
        )
    }

    //Borramos toda la lista que exista en la table de Personajes de la bbdd
    fun removeAll() {
        Realm.getDefaultInstance().executeTransaction {
            it.deleteAll();
        }
    }

    //Consultamos por ID
    fun consultaPorID(id: String): Personaje? {
        return Realm.getDefaultInstance().where<Personaje>().equalTo("id", id).findFirst()
    }


}