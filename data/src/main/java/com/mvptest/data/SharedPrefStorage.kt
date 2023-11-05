package com.mvptest.data

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefStorage(@ApplicationContext context: Context) {

    private val prefToken = context.getSharedPreferences(USER_TOKEN, Context.MODE_PRIVATE)
    private val prefUserId = context.getSharedPreferences(USER_ID, Context.MODE_PRIVATE)
    private val prefEmail = context.getSharedPreferences(USER_EMAIL, Context.MODE_PRIVATE)
    private val prefPassword = context.getSharedPreferences(USER_PASSWORD, Context.MODE_PRIVATE)
    private val prefCreateRoomCounter = context.getSharedPreferences(CREATE_ROOM_COUNTER, Context.MODE_PRIVATE)

    var token: String?
        get() {
            return prefToken.getString(USER_TOKEN, null)
        }
        set(value) {
            value?.let {
                prefToken.edit()
                    .putString(USER_TOKEN, it)
                    .apply()
            }
        }

    var userId: String?
        get() {
            return prefUserId.getString(USER_ID, null)
        }
        set(value) {
            value?.let {
                prefUserId.edit()
                    .putString(USER_ID, it)
                    .apply()
            }
        }

    var email: String?
        get() {
            return prefEmail.getString(USER_EMAIL, null)
        }
        set(value) {
            value?.let {
                prefEmail.edit()
                    .putString(USER_EMAIL, it)
                    .apply()
            }
        }

    var password: String?
        get() {
            return prefPassword.getString(USER_PASSWORD, null)
        }
        set(value) {
            value?.let {
                prefPassword.edit()
                    .putString(USER_PASSWORD, it)
                    .apply()
            }
        }

    var createRoomCounter: Int
        get() {
            return prefCreateRoomCounter.getInt(CREATE_ROOM_COUNTER, 0)
        }
        set(value) {
            value.let {
                prefCreateRoomCounter.edit()
                    .putInt(CREATE_ROOM_COUNTER, it)
                    .apply()
            }
        }

    private companion object {
        private const val USER_TOKEN = "user_token"
        private const val USER_ID = "user_id"
        private const val USER_EMAIL = "user_token"
        private const val USER_PASSWORD = "user_token"
        private const val CREATE_ROOM_COUNTER = "create_room_counter"
    }
}