package com.mvptest.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import com.google.android.play.core.review.ReviewManagerFactory
import com.mvptest.data.SharedPrefStorage

suspend fun showInAppReview(
    appPreferencesStorage: SharedPrefStorage,
    activity: Activity
) {

    val createRoomCounter = appPreferencesStorage.createRoomCounter

    if (createRoomCounter < 2) {
        appPreferencesStorage.createRoomCounter += 1
    } else{
        appPreferencesStorage.createRoomCounter = 0
        requestReviewFlow(activity)
    }
}

@SuppressLint("LogNotTimber")
fun requestReviewFlow(activity: Activity) {

    val reviewManager = ReviewManagerFactory.create(activity)

    val requestReviewFlow = reviewManager.requestReviewFlow()

    requestReviewFlow.addOnCompleteListener { request ->

        if (request.isSuccessful) {

            val reviewInfo = request.result

            val flow = reviewManager.launchReviewFlow(activity, reviewInfo)

            flow.addOnCompleteListener {

                Log.d("requestReviewFlow", "reviewInfo = ${it.result}")
            }

        } else {
            Log.e("requestReviewFlow", "error = ${request.exception}")
        }
    }
}
