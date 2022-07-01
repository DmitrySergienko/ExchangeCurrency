package com.example.exchangecurrency.ui.view

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.widget.RemoteViews
import com.example.exchangecurrency.R
import com.example.exchangecurrency.data.retrofit.ApiService
import com.example.exchangecurrency.data.retrofit.RetrofitCurrencyImpl
import com.example.exchangecurrency.domain.GetCurrencyRep
import com.example.exchangecurrency.ui.viewmodel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import coil.load
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

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