package co.cristian.bottomsheet.presentation.bottomSheet

import co.cristian.bottomsheet.base.BaseViewModel
import co.cristian.bottomsheet.domain.useCase.GetTransactionBottomSheetUseCase
import co.cristian.bottomsheet.presentation.mappers.toListTransactionPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(
    private val getTransactionBottomSheetUseCase: GetTransactionBottomSheetUseCase
): BaseViewModel<TransactionEvent>(){

    fun getTransactionList(){
        executeUseCase(
            {
                getTransactionBottomSheetUseCase.execute()
            },
            {
                    getCardCarrouselUseCase ->
                getCardCarrouselUseCase.toListTransactionPresentation()
                    .also{ presentationTransactionList ->
                        _event.value = TransactionEvent.ListTransaction(presentationTransactionList)
                    }
            }
        )
    }
}