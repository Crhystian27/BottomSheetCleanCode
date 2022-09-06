package co.cristian.bottomsheet.presentation.bottomSheet.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import co.cristian.bottomsheet.base.BaseAdapter
import co.cristian.bottomsheet.base.BaseViewHolder
import co.cristian.bottomsheet.databinding.HolderItemTransactionBinding
import co.cristian.bottomsheet.presentation.bottomSheet.models.*

class TransactionAdapter :
    BaseAdapter<TransactionPresentation, TransactionAdapter.TransactionViewHolder>(
        diffCallBack
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TransactionViewHolder(
        HolderItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class TransactionViewHolder(
        private val binding: HolderItemTransactionBinding
    ) : BaseViewHolder<TransactionPresentation>(binding) {
        @SuppressLint("SetTextI18n")
        override fun bind(data: TransactionPresentation) {
            binding.apply {

                tvDateHolderItemTransaction.text = data.date
                tvNameHolderItemTransaction.text = data.name
                tvAmountHolderItemTransaction.text = data.amount
            }
        }

    }


    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<TransactionPresentation>() {
            override fun areItemsTheSame(
                oldItem: TransactionPresentation,
                newItem: TransactionPresentation
            ): Boolean = equals(oldItem, newItem)


            override fun areContentsTheSame(
                oldItem: TransactionPresentation,
                newItem: TransactionPresentation
            ): Boolean =

                oldItem.date == newItem.date && oldItem.name == newItem.name && oldItem.amount == newItem.amount

        }
    }
}