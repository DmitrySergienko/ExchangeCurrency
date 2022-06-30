package com.example.exchangecurrency.ui.view

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MyWidget: AppWidgetProvider() {

    private val scope = CoroutineScope(Dispatchers.IO)

    //create viewModel
    //private val viewModel: MainActivityViewModel by viewModel()

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

       /* appWidgetIds.forEach {
            RemoteViews(
                context.opPackageName,
                R.layout.initial_layout
            ).apply {

                scope.launch {
                    val url = viewModel.getData()
                }
            }
        }*/
    }
}