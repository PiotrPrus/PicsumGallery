package com.piotrprus.picsumgallery.feature.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.piotrprus.picsumgallery.databinding.FragmentGalleryBinding
import com.piotrprus.picsumgallery.feature.gallery.recyclerview.PicsumAdapter
import com.piotrprus.picsumgallery.feature.gallery.recyclerview.PicsumItemDecoration
import org.koin.android.viewmodel.ext.android.viewModel

class GalleryFragment : Fragment() {

    private val viewModel: GalleryViewModel by viewModel()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

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
    }

    private fun setupRecyclerView() {
        val picsumAdapter = PicsumAdapter()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}