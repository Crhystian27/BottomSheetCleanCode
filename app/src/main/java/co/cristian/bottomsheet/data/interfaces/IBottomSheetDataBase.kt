package co.cristian.bottomsheet.data.interfaces

import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults

interface IBottomSheetDataBase {
    fun <O : RealmResults<I>, I : RealmModel> getObjectsFromRealm(action: Realm.() -> O): List<I>
    fun <T : RealmModel> addObjectFromRealm(action: () -> List<T>)
    fun <T : RealmObject> deleteObjectFromRealm(action: Realm.() -> T, id: Long)
    fun <T : RealmModel> deleteAllObjectFromRealm(action: () -> T)
}