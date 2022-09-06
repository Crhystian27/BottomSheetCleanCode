package co.cristian.bottomsheet.domain.interfaces

import co.cristian.bottomsheet.domain.models.Transaction

interface IBottomSheetRepository {

    suspend fun getListTransaction():List<Transaction>
    suspend fun insertListTransaction(transaction: List<Transaction>)
}