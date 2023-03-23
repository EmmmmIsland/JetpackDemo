package com.demo.jetpackdemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.demo.jetpackdemo.builderMode.Director
import com.demo.jetpackdemo.builderMode.HPComputerBuilder
import com.demo.jetpackdemo.databinding.FragmentModeBinding

/**
 * User: wanglei
 * Date: 2023/3/21 17:45
 * Description:
 */
class ModeFragment : Fragment() {

    private lateinit var mBinding: FragmentModeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentModeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.ivBack.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

        val director = Director()
        director.setComputerBuilder(HPComputerBuilder())
        director.constructComputer()
        val computer = director.computer
        Log.d("TAG", computer.audio)
    }
}