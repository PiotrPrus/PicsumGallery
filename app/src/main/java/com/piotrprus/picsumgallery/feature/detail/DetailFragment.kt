package com.piotrprus.picsumgallery.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.piotrprus.picsumgallery.base.BaseFragment
import com.piotrprus.picsumgallery.databinding.FragmentDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment() {

    private val viewModel : DetailViewModel by viewModel()
    private val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun start() {
        binding.detailFragmentAuthorName.text = args.picsum.author
        binding.detailFragmentImage.load(args.picsum.downloadUrl)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}