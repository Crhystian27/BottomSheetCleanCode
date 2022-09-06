package co.cristian.bottomsheet.presentation.bottomSheet.models

data class TransactionPresentation(
    var date: String,
    var name: String,
    var amount: String
)

fun equals(oldItem: TransactionPresentation, newItem: TransactionPresentation): Boolean =
    oldItem.date == newItem.date && oldItem.name == newItem.name && oldItem.amount == newItem.amount