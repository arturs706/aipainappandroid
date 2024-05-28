package uk.co.aipainapp.di


import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uk.co.aipainapp.presentation.viewmodel.GoogleLoginViewModel
import uk.co.aipainapp.presentation.viewmodel.FacebookLoginViewModel

val appModule = module {
    single { provideGoogleSignInClient(androidContext()) }
    viewModel { GoogleLoginViewModel() }
    viewModel { FacebookLoginViewModel() }

}

fun provideGoogleSignInClient(context: Context): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("696034599107-i40mfvpvvdltbn1hr2bhlg74n8l11n54.apps.googleusercontent.com")
        .requestEmail()
        .build()
    return GoogleSignIn.getClient(context, gso)
}
