package com.example.exchangecurrency.ui.view

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.exchangecurrency.R
import com.example.exchangecurrency.domain.GetCurrencyRep
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


private const val MY_ACTION ="MY_ACTION"

class MyWidget : AppWidgetProvider() {



    private val scope = CoroutineScope(Dispatchers.Main)
    private val getCurrencyRep: GetCurrencyRep by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.apilayer.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(GetCurrencyRep::class.java)
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

//for clickable action

        val pendingIntent = Intent(context,MyWidget::class.java).let {
            it.action = MY_ACTION
            PendingIntent.getBroadcast(context,0,it,PendingIntent.FLAG_IMMUTABLE)
        }

        appWidgetIds.forEach { appWidgetIds ->
            RemoteViews(
                context.opPackageName,
                R.layout.initial_layout
            ).apply {
                scope.launch {
                    setOnClickPendingIntent(R.id.widget_text_id,pendingIntent)

                   // val url = getCurrencyRep.getRate().await()
                   // val rate = 1.2
                   // setDouble(R.id.widget_text_id, "MethodName", rate)
                   // setTextViewText(R.id.widget_text_id,rate.toString())

                    appWidgetManager.updateAppWidget(appWidgetIds, this@apply)

                }
            }
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if(intent.action != MY_ACTION) return

        //for clickable action

        val pendingIntent = Intent(context,MyWidget::class.java).let {
            it.action = MY_ACTION
            PendingIntent.getBroadcast(context,0,it,PendingIntent.FLAG_IMMUTABLE)
        }
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val appWidgetIds = ComponentName(context,MyWidget::class.java)

        RemoteViews(
            context.opPackageName,
            R.layout.initial_layout
        ).apply {
            scope.launch {
                setOnClickPendingIntent(R.id.widget_text_id,pendingIntent)


                // val url = getCurrencyRep.getRate().await()
                val rate = 1.2
                // setDouble(R.id.widget_text_id, "MethodName", rate)
                setTextViewText(R.id.widget_text_id,rate.toString())

                appWidgetManager.updateAppWidget(appWidgetIds, this@apply)

            }
        }

    }

}