package co.cristian.bottomsheet.data.local.realm

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import io.realm.Realm
import io.realm.RealmConfiguration

object RealmConfigurationModule {
    fun realmConfiguration(@ApplicationContext context: Context): RealmConfiguration {
        Realm.init(context)
        return RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
    }
}