package co.cristian.bottomsheet.domain.useCase

import co.cristian.bottomsheet.base.BaseUseCase
import co.cristian.bottomsheet.domain.interfaces.IBottomSheetRepository
import co.cristian.bottomsheet.domain.models.Transaction
import javax.inject.Inject

class GetTransactionBottomSheetUseCase @Inject constructor(
    private val repository: IBottomSheetRepository
): BaseUseCase<Transaction>(){

    override suspend fun execute(): List<Transaction> {
        return repository.getListTransaction()
    }
}