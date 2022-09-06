package co.cristian.bottomsheet.presentation.mappers

import co.cristian.bottomsheet.domain.models.Transaction
import co.cristian.bottomsheet.presentation.bottomSheet.models.TransactionPresentation


fun Transaction.toTransactionPresentation() = TransactionPresentation(date, name, amount)

fun List<Transaction>.toListTransactionPresentation() = map{domain ->
    domain.toTransactionPresentation()
}