package com.arturdziombek.coffeecounter.commons

//import jdk.nashorn.internal.objects.NativeFunction.call
//import androidx.lifecycle.ViewModel
//import javax.inject.Inject
//import androidx.lifecycle.ViewModelProvider
//import javax.inject.Singleton
//
//
//@Singleton
//class ProjectViewModelFactory @Inject
//constructor(viewModelSubComponent: ViewModelSubComponent) : ViewModelProvider.Factory {
//  private val creators: ArrayMap<Class<*>, Callable<out ViewModel>>
//
//  init {
//    creators = ArrayMap()
//
//    // View models cannot be injected directly because they won't be bound to the owner's
//    // view model scope.
//    creators.put(ProjectViewModel::class.java, { viewModelSubComponent.projectViewModel() })
//    creators.put(ProjectListViewModel::class.java, { viewModelSubComponent.projectListViewModel() })
//  }
//
//  override fun <T : ViewModel> create(modelClass: Class<T>): T {
//    var creator = creators.get(modelClass)
//    if (creator == null) {
//      for (entry in creators.entrySet()) {
//        if (modelClass.isAssignableFrom(entry.key)) {
//          creator = entry.value
//          break
//        }
//      }
//    }
//    if (creator == null) {
//      throw IllegalArgumentException("Unknown model class $modelClass")
//    }
//    try {
//      return creator!!.call()
//    } catch (e: Exception) {
//      throw RuntimeException(e)
//    }
//
//  }
//}