package co.cristian.bottomsheet.presentation.bottomSheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.cristian.bottomsheet.base.BaseFragment
import co.cristian.bottomsheet.databinding.FragmentBottomSheetBinding
import co.cristian.bottomsheet.presentation.bottomSheet.adapter.TransactionAdapter
import co.cristian.bottomsheet.presentation.bottomSheet.models.TransactionPresentation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetFragment:
    BaseFragment<FragmentBottomSheetBinding,BottomSheetViewModel>() {

        override val viewModel by viewModels<BottomSheetViewModel>()

    private lateinit var transactionItems: List<TransactionPresentation>
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentBottomSheetBinding.inflate(inflater,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTransactionList()
    }

    private fun setAdapter(transactions: List<TransactionPresentation>){
        with(binding.rvTransaction){
            if (adapter == null) {
                layoutManager = LinearLayoutManager(
                    this@BottomSheetFragment.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = TransactionAdapter()
            }
            (adapter as? TransactionAdapter)?.submitList(transactions)
        }
    }

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner) { event ->
            when (event) {
                is TransactionEvent.ListTransaction -> {
                    transactionItems = event.ls
                    Log.e("elements",transactionItems[0].name)
                    setAdapter(transactionItems)
                }
                else -> {}
            }
        }
    }
}