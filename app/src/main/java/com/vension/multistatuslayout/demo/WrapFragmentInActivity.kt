package com.vension.multistatuslayout.demo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

/**
 * ===================================================================
 * @author: Created by Vension on 2019/1/21 16:20.
 * @email:  250685***4@qq.com
 * @update: update by *** on 2019/1/21 16:20
 * @desc:   character determines attitude, attitude determines destiny
 * ===================================================================
 */
class WrapFragmentInActivity :AppCompatActivity() {

    private lateinit var fragment: WrapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wrap_fragment)
        fragment = WrapFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }


    @SuppressLint("ResourceAsColor")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_loading -> {
                fragment.getMulLayout().showLoading()
                return true
            }
            R.id.action_empty -> {
                fragment.getMulLayout().showEmpty()
                return true
            }
            R.id.action_error -> {
                fragment.getMulLayout().showError()
                return true
            }
            R.id.action_not_net -> {
                fragment.getMulLayout()
                    .setErrorImage(R.drawable.img_default_no_net)
                    .setErrorText(R.string.page_not_network)
                    .showError()
                return true
            }
            R.id.action_content -> {
                fragment.getMulLayout().showContent()
                return true
            }
            R.id.action_custom_loading -> {
                fragment.getMulLayout()
                    .setLoadingText("我是自定义加载文本~")
                    .setLoadingColor(Color.parseColor("#cddc39"))
                    .showLoading()
                return true
            }
            R.id.action_custom_empty -> {
                fragment.getMulLayout()
                    .setTextColor(android.R.color.holo_red_dark)
                    .setTextSize(40)
                    .setEmptyImage(R.drawable.img_change_empty)
                    .setEmptyText("我是自定义的空数据数据提示")
                    .showEmpty()
                return true
            }
            R.id.action_custom_error -> {
                fragment.getMulLayout()
                    .setTextColor(android.R.color.holo_red_dark)
                    .setTextSize(40)
                    .setErrorImage(R.drawable.img_change_error)
                    .setErrorText("我是自定义的错误数据提示")
                    .setRetryTextColor(R.color.colorAccent)
                    .setRetryBackground(R.drawable.shape_custom_retry)
                    .showError()
                return true
            }
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.msl_menu, menu)
        return true
    }

}