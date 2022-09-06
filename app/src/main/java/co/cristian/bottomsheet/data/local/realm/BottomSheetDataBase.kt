package co.cristian.bottomsheet.data.local.realm

import android.content.Context
import co.cristian.bottomsheet.data.interfaces.IBottomSheetDataBase
import dagger.hilt.android.qualifiers.ApplicationContext
import io.realm.*
import javax.inject.Inject

class BottomSheetDataBase @Inject constructor(@ApplicationContext private val context:Context)
    :IBottomSheetDataBase {

    private val realmConfiguration by lazy { RealmConfigurationModule.realmConfiguration(context) }

    private fun getRealm(): Realm {
        return try {
            Realm.getInstance(realmConfiguration)
        } catch (e: IllegalArgumentException) {
            Realm.getInstance(realmConfiguration)
        }
    }


    override fun <O : RealmResults<I>, I : RealmModel> getObjectsFromRealm(action: Realm.() -> O): List<I> {
        val realm = getRealm()
        val results = action(realm)
        val list = results.map { realm.copyFromRealm(it) }
        realm.close()
        return list
    }



    override fun <T : RealmModel> addObjectFromRealm(action: () -> List<T>) {
        val realmModel = action()
        val realm = getRealm()
        realm.beginTransaction()
        realm.insertOrUpdate(realmModel)
        realm.commitTransaction()
        realm.close()
    }


    override fun <T : RealmObject> deleteObjectFromRealm(action: Realm.() -> T, id: Long) {
        val realm = getRealm()
        val realmModel = action(realm)
        realm.beginTransaction()
        try {
            if (realmModel.isValid) {
                val obj = realm.where(realmModel.javaClass).equalTo("id", id).findFirst()
                if (obj != null) {
                    obj.deleteFromRealm()
                    realm.commitTransaction()
                    realm.close()
                } else realm.cancelTransaction()
            } else realm.cancelTransaction()
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
    }

    override fun <T : RealmModel> deleteAllObjectFromRealm(action: () -> T) {
        val realm = getRealm()
        val realmModel = action()
        realm.beginTransaction()
        try {
            realm.where(realmModel.javaClass).findAll()
            realm.deleteAll()
            realm.commitTransaction()
            realm.close()
        }catch (e: Exception){
            realm.cancelTransaction()
        }
    }
}