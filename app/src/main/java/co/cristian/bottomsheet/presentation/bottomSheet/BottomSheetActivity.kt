package co.cristian.bottomsheet.presentation.bottomSheet

import android.view.LayoutInflater
import androidx.navigation.findNavController
import co.cristian.bottomsheet.R
import co.cristian.bottomsheet.base.BaseActivity
import co.cristian.bottomsheet.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateView(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun setUI() {
        binding.navHostFragment.findNavController()
            .setGraph(R.navigation.navigation_bottom_sheet)
    }
}