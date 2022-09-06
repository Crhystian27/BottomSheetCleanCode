package co.cristian.bottomsheet.data.local.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TransactionRealm(
    var date: String = "",
    var name: String = "",
    var amount: String = "",
    @PrimaryKey var id: Long? = 0
): RealmObject()