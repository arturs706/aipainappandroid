import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task

class AuthResultContract : ActivityResultContract<Intent, Task<GoogleSignInAccount>?>() {
    override fun createIntent(context: Context, input: Intent): Intent {
        return input
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Task<GoogleSignInAccount>? {
        return if (resultCode == Activity.RESULT_OK && intent != null) {
            GoogleSignIn.getSignedInAccountFromIntent(intent)
        } else {
            null
        }
    }
}
