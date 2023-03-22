package com.demo.jetpackdemo.fragment

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.palette.graphics.Palette
import com.demo.jetpackdemo.R
import com.demo.jetpackdemo.databinding.FragmentPaletteBinding

/**
 * User: wanglei
 * Date: 2023/3/21 17:45
 * Description:
 */
class PaletteFragment : Fragment() {

    private lateinit var mBinding: FragmentPaletteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentPaletteBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.ivBack.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }
        val drawable: BitmapDrawable =
            ContextCompat.getDrawable(view.context, R.drawable.testimg) as BitmapDrawable

        val builder = Palette.from(drawable.bitmap)
        val palette = builder.generate()


        mBinding.color0.setBackgroundColor(palette.getDominantColor(Color.WHITE))
        mBinding.color1.setBackgroundColor(palette.getMutedColor(Color.WHITE))
        mBinding.color2.setBackgroundColor(palette.getDarkMutedColor(Color.WHITE))
        mBinding.color3.setBackgroundColor(palette.getLightMutedColor(Color.WHITE))
        mBinding.color4.setBackgroundColor(palette.getVibrantColor(Color.WHITE))
        mBinding.color5.setBackgroundColor(palette.getDarkVibrantColor(Color.WHITE))
        mBinding.color6.setBackgroundColor(palette.getLightVibrantColor(Color.WHITE))
    }
}