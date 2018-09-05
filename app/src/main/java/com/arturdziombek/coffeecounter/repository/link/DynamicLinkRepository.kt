package com.arturdziombek.coffeecounter.repository.link

import io.reactivex.Maybe

interface DynamicLinkRepository {
  fun observeDynamicFink(): Maybe<String>
}