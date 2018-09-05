package com.arturdziombek.coffeecounter.ui.main.di

import com.arturdziombek.coffeecounter.ui.main.MainActivity
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import dagger.Module
import dagger.Provides

@Module
class DynamicLinkModule {
  @Provides
  fun provideTask(activity: MainActivity) = FirebaseDynamicLinks.getInstance().getDynamicLink(
      activity.intent)
}