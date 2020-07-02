package com.piotrprus.picsumgallery.feature.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.piotrprus.picsumgallery.base.BaseFragment
import com.piotrprus.picsumgallery.data.model.Picsum
import com.piotrprus.picsumgallery.databinding.FragmentGalleryBinding
import com.piotrprus.picsumgallery.feature.gallery.recyclerview.PicsumAdapter
import com.piotrprus.picsumgallery.feature.gallery.recyclerview.PicsumItemDecoration
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class GalleryFragment : BaseFragment() {

    private val viewModel: GalleryViewModel by viewModel()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private var picsumAdapter: PicsumAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun start() {
        setupRecyclerView()
        lifecycleScope.launch {
            viewModel.fetchData().collectLatest {
                picsumAdapter?.submitData(it)
            }
        }
    }

    private fun setupRecyclerView() {
        picsumAdapter = PicsumAdapter() {
            it?.let { navigateToDetailView(it) }
        }
        picsumAdapter?.addLoadStateListener { loadState ->
            binding.fragmentGalleryProgressBar.isVisible = loadState.refresh is LoadState.Loading
        }
        binding.picsumGridRV.apply {
            adapter = picsumAdapter
            addItemDecoration(PicsumItemDecoration())
            layoutManager = GridLayoutManager(
                requireContext(),
                2,
                RecyclerView.VERTICAL,
                false
            )
        }
    }

    private fun navigateToDetailView(picsum: Picsum) {
        val action = GalleryFragmentDirections.actionGalleryFragmentToDetailFragment(picsum)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}