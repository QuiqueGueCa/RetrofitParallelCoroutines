package com.example.retrofitparallelcoroutines.ui.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitparallelcoroutines.databinding.FragmentMainBinding
import com.example.retrofitparallelcoroutines.ui.main_fragment.adapter.UsersAdapter

class MainFragment : Fragment(), UsersAdapter.UserListener {

    private lateinit var mBinding: FragmentMainBinding
    private lateinit var mAdapter: UsersAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentMainBinding.inflate(inflater, container, false)

        setupAdapter()

        return mBinding.root
    }

    private fun setupAdapter() {
        mAdapter = UsersAdapter(this, mutableListOf())
        with(mBinding.recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun onUserClick(idUser: Int) {
        // TODO: Aquí iría la magia
    }
}