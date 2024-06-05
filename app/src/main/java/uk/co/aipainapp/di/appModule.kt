package uk.co.aipainapp.di


import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single
import retrofit2.Retrofit
import uk.co.aipainapp.data.remote.ApiService
import uk.co.aipainapp.data.remote.provideRetrofit
import uk.co.aipainapp.data.repository.FacebookLoginRepository
import uk.co.aipainapp.data.repository.FacebookLoginRepositoryImpl
import uk.co.aipainapp.data.repository.GoogleLoginRepository
import uk.co.aipainapp.data.repository.GoogleLoginRepositoryImpl
import uk.co.aipainapp.data.repository.LoginRepository
import uk.co.aipainapp.data.repository.LoginRepositoryImpl
import uk.co.aipainapp.presentation.viewmodel.GoogleLoginViewModel
import uk.co.aipainapp.presentation.viewmodel.FacebookLoginViewModel
import uk.co.aipainapp.presentation.viewmodel.LoginViewModel

val appModule = module {
    single { provideGoogleSignInClient(androidContext()) }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single<GoogleLoginRepository> { GoogleLoginRepositoryImpl(get()) }
    single<FacebookLoginRepository> { FacebookLoginRepositoryImpl(get())}
    single { provideRetrofit() }
    single { get<Retrofit>().create(ApiService::class.java) }

    viewModel { GoogleLoginViewModel(get()) }
    viewModel { FacebookLoginViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}

fun provideGoogleSignInClient(context: Context): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("696034599107-i40mfvpvvdltbn1hr2bhlg74n8l11n54.apps.googleusercontent.com")
        .requestEmail()
        .build()
    return GoogleSignIn.getClient(context, gso)
}
