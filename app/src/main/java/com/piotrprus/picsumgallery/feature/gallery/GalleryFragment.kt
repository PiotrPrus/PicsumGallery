package com.piotrprus.picsumgallery.feature.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.piotrprus.picsumgallery.base.BaseFragment
import com.piotrprus.picsumgallery.databinding.FragmentGalleryBinding
import com.piotrprus.picsumgallery.feature.gallery.recyclerview.PicsumAdapter
import com.piotrprus.picsumgallery.feature.gallery.recyclerview.PicsumItemDecoration
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.pictures.observe { picsumAdapter?.submitList(it) }
        viewModel.loadingVisibility.observe { setLoadingVisibility(it) }
    }

    private fun setupRecyclerView() {
        picsumAdapter = PicsumAdapter()
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

    private fun setLoadingVisibility(isVisible: Boolean?) {
        binding.fragmentGalleryProgressBar.visibility =
            if (isVisible == true) View.VISIBLE else View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}