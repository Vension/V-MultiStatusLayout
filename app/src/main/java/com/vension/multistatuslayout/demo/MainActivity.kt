package com.vension.multistatuslayout.demo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()//模拟加载数据

        //重试点击监听
        main_MSLayout.setOnRetryClickListener(View.OnClickListener { v ->
            loadData()//获取数据
        })

        acb_warpActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity,WrapActivity::class.java))
        }
        acb_warpFragment.setOnClickListener {
            startActivity(Intent(this@MainActivity,WrapFragmentInActivity::class.java))
        }
        acb_warpView.setOnClickListener {
            startActivity(Intent(this@MainActivity,WrapViewActivity::class.java))
        }
    }

    /**模拟网络获取数据*/
    private fun loadData() {
        main_MSLayout.showLoading()
        Handler().postDelayed({
            main_MSLayout.showContent()
        }, 3000)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_loading -> {
                loadData()//获取数据
                return true
            }
            R.id.action_empty -> {
                main_MSLayout.showEmpty()
                return true
            }
            R.id.action_error -> {
                main_MSLayout
                    .setErrorImage(R.drawable.img_default_error)
                    .setErrorText(R.string.page_error_load)
                    .showError()
                return true
            }
            R.id.action_not_net -> {
                main_MSLayout
                    .setErrorImage(R.drawable.img_default_no_net)
                    .setErrorText(R.string.page_not_network)
                    .showError()
                return true
            }
            R.id.action_content -> {
                main_MSLayout.showContent()
                return true
            }

            R.id.action_custom_loading -> {
                main_MSLayout
                    .setLoadingText("我是自定义加载文本~")
                    .setLoadingColor(Color.parseColor("#cddc39"))
                    .showLoading()
                return true
            }
            R.id.action_custom_empty -> {
                main_MSLayout
                    .setTextColor(android.R.color.holo_red_dark)
                    .setTextSize(40)
                    .setEmptyImage(R.drawable.img_change_empty)
                    .setEmptyText("我是自定义的空数据数据提示")
                    .showEmpty()
                return true
            }
            R.id.action_custom_error -> {
                main_MSLayout
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
