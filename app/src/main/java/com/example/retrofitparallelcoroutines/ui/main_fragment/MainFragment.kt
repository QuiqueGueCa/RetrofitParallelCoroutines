package com.example.retrofitparallelcoroutines.ui.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetJobUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetNamesListUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetSalaryUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetSurnameUseCase
import com.example.retrofitparallelcoroutines.databinding.FragmentMainBinding
import com.example.retrofitparallelcoroutines.ui.main_fragment.adapter.UsersAdapter
import kotlinx.coroutines.launch

class MainFragment : Fragment(), UsersAdapter.UserListener {

    private lateinit var mBinding: FragmentMainBinding
    private lateinit var mAdapter: UsersAdapter
    private val mViewModel = MainFragmentViewModel(
        GetNamesListUseCase(),
        GetSurnameUseCase(),
        GetJobUseCase(),
        GetSalaryUseCase(),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mViewModel.getNamesList()
        mBinding = FragmentMainBinding.inflate(inflater, container, false)

        setupAdapter()
        observeViewModel()

        return mBinding.root
    }

    private fun observeViewModel() {

        lifecycleScope.launch {
            mViewModel.namesListStateFlow.collect { dataSet ->
                mAdapter.refreshData(dataSet)
            }
        }

        lifecycleScope.launch {
            mViewModel.payrollStateFlow.collect { dataSet ->
                setInformationAtUi(dataSet)
            }
        }

        lifecycleScope.launch {
            mViewModel.namesListErrorSharedFlow.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        lifecycleScope.launch {
            mViewModel.surnameErrorSharedFlow.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        lifecycleScope.launch {
            mViewModel.jobErrorSharedFlow.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        lifecycleScope.launch {
            mViewModel.salaryErrorSharedFlow.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setInformationAtUi(dataSet: PayrollModel) {
        with(mBinding) {
            tvIdContent.text = dataSet.id.toString()
            tvNameContent.text = dataSet.name
            tvSurnameContent.text = dataSet.surname
            tvCompanyContent.text = dataSet.company
            tvSalaryContent.text = dataSet.salary.toString()
        }
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
        mViewModel.getPayroll(idUser)
    }
}