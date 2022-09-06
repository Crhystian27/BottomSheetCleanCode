package co.cristian.bottomsheet.data.mappers

import co.cristian.bottomsheet.data.local.entity.TransactionRealm
import co.cristian.bottomsheet.domain.models.Transaction
import java.util.*

fun Transaction.toTransactionRealm() =
    TransactionRealm(date, name, amount, UUID.randomUUID().mostSignificantBits)

fun List<Transaction>.toListTransaction() = map { domain ->
    domain.toTransactionRealm()
}