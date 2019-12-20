package kiwi.test.loginvalidator

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import java.util.regex.Matcher
import java.util.regex.Pattern

object LoginValidator {

    var withPasswordValidation = true
    var passwordRegularExpression = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
    var withEmailValidation = true
    var emailRegularExpression = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"

    fun validate(
        txtEmail: EditText?,
        txtPassword: EditText?,
        btnLogin: Button?,
        forgotPassword: Any?,
        mainActivity: Activity

    ): String {
        var message = ""

        try {
            if (txtEmail!!.text != null && txtPassword!!.text != null) {

                btnLogin!!.setOnClickListener {

                    if(withEmailValidation ){
                        message = ""+ isValidated(emailRegularExpression,txtEmail!!.text.toString())
                    }
                    if(withPasswordValidation)
                        message = ""+ isValidated(passwordRegularExpression,txtPassword!!.text.toString())
                    if (forgotPassword != null) {
                        val intent = Intent(mainActivity, forgotPassword as Class<*>)
                        intent.putExtra("key", "Kotlin")
                        mainActivity.startActivity(intent)
                    }
                }
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }

        return message
    }
    fun isValidated(myPattern: String ,myText: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        pattern = Pattern.compile(myPattern)
        matcher = pattern.matcher(myText)
        return matcher.matches()
    }
}


