package com.demo.jetpackdemo.fragment

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import coil.load
import coil.transform.CircleCropTransformation
import com.demo.jetpackdemo.R
import com.demo.jetpackdemo.databinding.FragmentCoilBinding


/**
 * User: wanglei
 * Date: 2023/3/21 17:45
 * Description:
 */
class CoilFragment : Fragment() {

    private lateinit var mBinding: FragmentCoilBinding
//    private val imgUrl = "https://p1.img.cctvpic.com/photoAlbum/templet/common/DEPA1502157896010276/newslog200.jpg";
    private val imgUrl = "https://img.zcool.cn/community/01983b6183421511013f22cf713959.jpg@1280w_1l_2o_100sh.jpg";

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCoilBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermissions(activity)
        mBinding.ivBack.setOnClickListener{
            Navigation.findNavController(it).popBackStack()
        }
        mBinding.ivUrl.load(imgUrl){
            error(R.drawable.error)
            placeholder(R.drawable.placeholder)
            crossfade(true)
            transformations(CircleCropTransformation())
        }

    }

    /**
     * 当有多个权限需要申请的时候
     * 这里以打电话和SD卡读写权限为例
     */
    private fun requestPermissions(activity : Activity?) {
        if (activity == null){
            return
        }
        val permissionList: MutableList<String> = ArrayList()
        if (ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionList.add(Manifest.permission.INTERNET)
        }
        if (ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (!permissionList.isEmpty()) {
            //申请的集合不为空时，表示有需要申请的权限
            ActivityCompat.requestPermissions(activity, permissionList.toTypedArray(), 1)
        } else { //所有的权限都已经授权过了
        }
    }
}