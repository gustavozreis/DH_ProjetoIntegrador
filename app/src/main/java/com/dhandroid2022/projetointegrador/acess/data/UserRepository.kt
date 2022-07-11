package com.dhandroid2022.projetointegrador.acess.data





import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository {

    private val firebaseAuth = FirebaseAuth.getInstance()
    val loggedUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    suspend fun register(email: String, password: String) = withContext(Dispatchers.IO) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    suspend fun login(email: String, password: String) = withContext(Dispatchers.IO) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
    }

     fun googleAuthForFirebase (account: GoogleSignInAccount) {
        val credentials = GoogleAuthProvider.getCredential(account.idToken, null)
        CoroutineScope(Dispatchers.IO).launch {
            firebaseAuth.signInWithCredential(credentials)
        }
    }
}