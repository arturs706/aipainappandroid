package uk.co.aipainapp.presentation.viewmodel


import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.login.LoginManager

class FacebookLoginViewModel : ViewModel() {

    private val _accessToken = mutableStateOf<AccessToken?>(null)
    val accessToken get() = _accessToken.value

    fun handleLoginResult(accessToken: AccessToken?) {
        _accessToken.value = accessToken
        accessToken?.let { fetchUserData(it) }
    }

    private fun fetchUserData(accessToken: AccessToken) {
        val request = GraphRequest.newMeRequest(accessToken) { _, response ->
            val email = response?.jsonObject?.getString("email")
            val id = response?.jsonObject?.getString("id")
            Log.e("Facebook ID","Id: $id")
            Log.e("Facebook Login", "Email: $email")
        }
        val parameters = Bundle()
        parameters.putString("fields", "email")
        request.parameters = parameters
        request.executeAsync()
    }

    fun logout() {
        LoginManager.getInstance().logOut()
        _accessToken.value = null
    }
}
