package com.dmm.bootcamp.yatter2023.infra.pref

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MePreferences @Inject constructor(@ApplicationContext context: Context) {
  companion object {
    private const val PREF_NAME = "me"
    private const val KEY_USERNAME = "username"
  }

  private val sharedPreferences = context.getSharedPreferences(
    PREF_NAME,
    Context.MODE_PRIVATE
  )

  fun getUsername(): String? = sharedPreferences.getString(
    KEY_USERNAME,
    ""
  )

  fun putUserName(username: String?) {
    sharedPreferences.edit().putString(
      KEY_USERNAME,
      username
    ).apply()
  }

  fun clear() = sharedPreferences.edit().clear().apply()
}
