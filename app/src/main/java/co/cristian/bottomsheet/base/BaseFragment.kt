package co.cristian.bottomsheet.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


abstract class BaseFragment <VB : ViewBinding, VM : ViewModel> : Fragment() {

    private var _binding: ViewBinding? = null
    @Suppress("UNCHECKED_CAST")
    protected val binding
        get() = _binding as VB
    protected abstract val viewModel: VM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateView(inflater, container)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
        setListeners()
        observe()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleArgs()
    }

    open fun setUI() {}
    /**
     * Set on click listeners of input views in the fragment
     */
    open fun setListeners() {}
    /**
     * In case of having to collect arguments that come from the navigation action,
     * this function will be implemented
     */
    open fun getBundleArgs() {}

    /**
     * Inflate the view with the binding corresponding to the fragment
     */
    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup?): VB
    /**
     * Observe the live data values of the viewModel
     */
    protected abstract fun observe()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}