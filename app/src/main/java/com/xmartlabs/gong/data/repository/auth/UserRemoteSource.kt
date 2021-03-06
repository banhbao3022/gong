package com.xmartlabs.gong.data.repository.auth

import com.xmartlabs.gong.data.model.User
import com.xmartlabs.gong.data.model.service.SignInResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * Created by mirland on 25/04/20.
 */
class UserRemoteSource {
    companion object {
        private const val VALID_PASSWORD = "xmartlabs"
        private const val VALID_ID = "xmartlabs"
        private val XMARTLABS_USER = User("xmartlabs", "xmartlabs", "hi@xmartlabs.com")
    }

    suspend fun signIn(id: String, password: String) = withContext(Dispatchers.IO) {
        @Suppress("MagicNumber")
        delay(100) // Simulate network delay
        if (id.equals(VALID_ID, ignoreCase = true) && password == VALID_PASSWORD) {
            SignInResponse("auth_token", XMARTLABS_USER)
        } else {
            throw SecurityException("Invalid User")
        }
    }
}
