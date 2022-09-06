package co.cristian.bottomsheet.presentation.bottomSheet

import co.cristian.bottomsheet.presentation.bottomSheet.models.TransactionPresentation

sealed class TransactionEvent {
    class ListTransaction(val ls: List<TransactionPresentation>) : TransactionEvent()
}