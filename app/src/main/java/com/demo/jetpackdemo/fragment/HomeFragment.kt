package com.demo.jetpackdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.demo.jetpackdemo.R
import com.demo.jetpackdemo.builderMode.Computer
import com.demo.jetpackdemo.builderMode.ComputerBuilder
import com.demo.jetpackdemo.builderMode.Director
import com.demo.jetpackdemo.builderMode.HPComputerBuilder
import com.demo.jetpackdemo.databinding.FragmentHomeBinding

/**
 * User: wanglei
 * Date: 2023/3/21 17:45
 * Description:
 */
class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvFirst.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_paletteFragment)
        }

        mBinding.tvSecond.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_coilFragment)
        }

        mBinding.tvMode.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_modeFragment)
        }

    }
}