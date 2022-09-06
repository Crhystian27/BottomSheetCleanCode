package co.cristian.bottomsheet.data.repository

import co.cristian.bottomsheet.data.interfaces.IBottomSheetDataBase
import co.cristian.bottomsheet.data.local.MockDataBase
import co.cristian.bottomsheet.data.local.entity.TransactionRealm
import co.cristian.bottomsheet.data.mappers.toListTransaction
import co.cristian.bottomsheet.domain.interfaces.IBottomSheetRepository
import co.cristian.bottomsheet.domain.models.Transaction
import io.realm.kotlin.where
import javax.inject.Inject

class BottomSheetRepository @Inject constructor(private val realmDataBase: IBottomSheetDataBase)
    : IBottomSheetRepository {

    private val mockDataBase by lazy { MockDataBase() }


    override suspend fun getListTransaction(): List<Transaction> {
        insertListTransaction(mockDataBase.transaction())
        return realmDataBase.getObjectsFromRealm { where<TransactionRealm>().findAll() }.toListTransaction()
    }

    override suspend fun insertListTransaction(transaction: List<Transaction>) {
        realmDataBase.deleteAllObjectFromRealm { TransactionRealm() }
        return realmDataBase.addObjectFromRealm { transaction.toListTransaction() }
    }
}