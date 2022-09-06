package co.cristian.bottomsheet.data.mappers

import co.cristian.bottomsheet.data.local.entity.TransactionRealm
import co.cristian.bottomsheet.domain.models.Transaction

fun TransactionRealm.toTransaction()= Transaction(date, name, amount)

fun List<TransactionRealm>.toListTransaction() = map { data -> data.toTransaction() }
