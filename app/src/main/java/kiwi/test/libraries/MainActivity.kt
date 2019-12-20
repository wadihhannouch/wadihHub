package kiwi.test.libraries

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kiwi.test.loginvalidator.LoginValidator

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginValidator.withPasswordValidation = false
        LoginValidator.passwordRegularExpression = ""
        var validate = LoginValidator.validate(
            txtEmail,
            txtPassword,
            btnLogin,
            ForgotPassword::class.java,
            this)
    }
}


