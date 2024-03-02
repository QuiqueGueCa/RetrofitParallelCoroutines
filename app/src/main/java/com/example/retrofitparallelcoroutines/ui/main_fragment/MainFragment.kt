package com.example.retrofitparallelcoroutines.ui.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitparallelcoroutines.R
import com.example.retrofitparallelcoroutines.data.domain.model.UserModel
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetJobUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetNamesListUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetSalaryUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.GetSurnameUseCase
import com.example.retrofitparallelcoroutines.data.domain.use_cases.PostPayrollUseCase
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
        PostPayrollUseCase()
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
            mViewModel.namesList.collect { dataSet ->
                mAdapter.refreshData(dataSet)
            }
        }

        lifecycleScope.launch {
            mViewModel.uiState.collect { dataSet ->
                when (dataSet) {
                    is MainFragmentUiState.LoadingList -> {
                        mBinding.progressBarList.visibility = View.VISIBLE
                        mBinding.vCoverage.visibility = View.VISIBLE
                    }

                    is MainFragmentUiState.ListLoaded -> {
                        mBinding.vCoverage.visibility = View.VISIBLE
                        mBinding.progressBarUserData.visibility = View.INVISIBLE
                        mBinding.progressBarList.visibility = View.INVISIBLE
                    }

                    is MainFragmentUiState.Error -> {}

                    is MainFragmentUiState.Success -> {
                        mBinding.vCoverage.visibility = View.INVISIBLE
                        mBinding.progressBarUserData.visibility = View.INVISIBLE
                        setInformationAtUi(dataSet.userModel)
                    }

                    is MainFragmentUiState.LoadingUserData -> {
                        mBinding.vCoverage.visibility = View.VISIBLE
                        mBinding.progressBarUserData.visibility = View.VISIBLE
                    }
                }
            }
        }

        lifecycleScope.launch {
            mViewModel.payrollError.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        lifecycleScope.launch {
            mViewModel.namesListError.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        lifecycleScope.launch {
            mViewModel.surnameError.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        lifecycleScope.launch {
            mViewModel.jobError.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        lifecycleScope.launch {
            mViewModel.salaryError.collect { error ->
                Toast.makeText(
                    requireContext(),
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setInformationAtUi(dataSet: UserModel) {
        with(mBinding) {
            tvIdContent.text = dataSet.id.toString()
            tvNameContent.text = dataSet.name
            tvSurnameContent.text = dataSet.surname
            tvCompanyContent.text = dataSet.company
            tvJobContent.text = dataSet.job
            tvSalaryContent.text = getString(R.string.salaryCurrent, dataSet.salary.toString())
            tvTaxContent.text = dataSet.tax.toString()
            tvFormationContent.text = dataSet.formation.toString()
            tvTotalContent.text = getString(R.string.totalCurrent, dataSet.total.toString())
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