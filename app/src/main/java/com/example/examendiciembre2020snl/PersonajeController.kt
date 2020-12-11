package com.example.examendiciembre2020snl

import android.content.Context
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration

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
}