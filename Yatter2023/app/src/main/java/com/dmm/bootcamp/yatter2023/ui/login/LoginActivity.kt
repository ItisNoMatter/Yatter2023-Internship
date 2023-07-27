package com.dmm.bootcamp.yatter2023.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import com.dmm.bootcamp.yatter2023.ui.timeline.PublicTimelineActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            LoginActivity::class.java,
        )
    }

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigateToPublicTimeline.observe(this) {
            startActivity(PublicTimelineActivity.newIntent(this))
            finish()
        }

        viewModel.navigateToRegister.observe(this) {
            //TODO: 会員登録画面への遷移
        }
        setContent {
            Yatter2023Theme {
                Surface {
                    LoginPage(viewModel = viewModel)
                }
            }
        }
    }
}