package com.example.wyklad12_widget

import android.R.attr
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.random.Random
import android.R.attr.level
import android.R.attr.packageType
import android.content.ComponentName
import android.media.Image
import androidx.core.content.res.ResourcesCompat






class NewAppWidget : AppWidgetProvider() {
    private var requestCode = 0

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId, requestCode++)
        }
    }
    override fun onEnabled(context: Context) {
        Log.i("widget-app", "Pierwszy widget dodany.")

    }
    override fun onDisabled(context: Context) {
        Log.i("widget-app", "Ostatni widget usunięty.")
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if(intent?.action.equals("com.example.widgetapplication.Action1"))
            Toast.makeText(context, "Action1", Toast.LENGTH_SHORT).show()




//startowanie muzyki 1
        val action = intent!!.action
        val actionName = "use_custom_class"

        val songId = R.raw.test
        val mediaPlayer = MediaPlayer.create(
            context,
            songId
        )
        if (actionName == action) {

        mediaPlayer.start()
        }
        val action6 = intent!!.action
        val actionName6 = "use_custom_class6"

        val songId2 = R.raw.test2

        if (actionName6 == action6) {
            MediaPlayer.create(
                context,
                songId2
            )
            mediaPlayer.start()
        }


        //stopowanie muzyki
          val action5 = intent!!.action
        val actionName5 = "use_custom_class5"

        if (actionName5 == action5) {

            mediaPlayer.stop()

        }

// zdjecia
        val action3 = intent!!.action

        val actionName3 = "use_custom_class2"

        if (actionName3 == action3) {


            var appWidgetManager = AppWidgetManager.getInstance(context)

            var remoteViews = RemoteViews(context!!.getPackageName(), R.layout.new_app_widget)
            var watchWidget = ComponentName(context, NewAppWidget::class.java)
            remoteViews.setImageViewResource(R.id.imageView3, R.drawable.a);

            appWidgetManager.updateAppWidget(watchWidget, remoteViews)
        }

            // zdjecia
            val action4 = intent!!.action

            val actionName4 = "use_custom_class4"

            if (actionName4 == action4) {


                var appWidgetManager = AppWidgetManager.getInstance(context)

                var remoteViews = RemoteViews(context!!.getPackageName(), R.layout.new_app_widget)
                var watchWidget = ComponentName(context, NewAppWidget::class.java)
                remoteViews.setImageViewResource(R.id.imageView3, R.drawable.b);

                appWidgetManager.updateAppWidget(watchWidget, remoteViews)

            }
        }

        internal fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int,
            requestCode: Int
        ) {
            val views = RemoteViews(context.packageName, R.layout.new_app_widget)

            //strona www
            val intent2 = Intent(Intent.ACTION_VIEW)
            intent2.data =
                Uri.parse("https://rozgrywki.pzkosz.pl/liga/4/zawodnicy/p/23339/rafal-mikita.html")
            val pendingIntent2 = PendingIntent.getActivity(
                context,
                0,
                intent2,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            views.setOnClickPendingIntent(R.id.bt_www, pendingIntent2)


            //muzyka

            val intent = Intent(context, NewAppWidget::class.java)
            intent.action = "use_custom_class"
            val pendingIntent =
                PendingIntent.getBroadcast(context, 0, intent, 0)
            views.setOnClickPendingIntent(R.id.bt_play, pendingIntent)


            val intent6 = Intent(context, NewAppWidget::class.java)
            intent6.action = "use_custom_class6"
            val pendingIntent6 =
                PendingIntent.getBroadcast(context, 0, intent6, 0)
            views.setOnClickPendingIntent(R.id.bt_play2, pendingIntent6)



            //muzyka stop

            val intent5 = Intent(context, NewAppWidget::class.java)
            intent5.action = "use_custom_class5"
            val pendingIntent5 =
                PendingIntent.getBroadcast(context, 0, intent5, 0)
            views.setOnClickPendingIntent(R.id.bt_stop, pendingIntent5)


            //obrazek 1

            val intent3 = Intent(context, NewAppWidget::class.java)
            intent3.action = "use_custom_class2"
            val pendingIntent3 =
                PendingIntent.getBroadcast(context, 0, intent3, 0)
            views.setOnClickPendingIntent(R.id.bt_photo1, pendingIntent3)

            //obrazek 2

            val intent4 = Intent(context, NewAppWidget::class.java)
            intent4.action = "use_custom_class4"
            val pendingIntent4 =
                PendingIntent.getBroadcast(context, 0, intent4, 0)
            views.setOnClickPendingIntent(R.id.bt_photo2, pendingIntent4)

            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }}
