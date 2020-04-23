package com.giantcell.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.animation.TranslateAnimation
import android.view.inputmethod.InputMethodManager
import com.digi.gadisolutions.R

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern


object Utility {
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(120, TimeUnit.SECONDS)
        .connectTimeout(120, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    fun slideUp(view: View) {
        view.setVisibility(View.VISIBLE)
        val animate = TranslateAnimation(
            0f, // fromXDelta
            0f, // toXDelta
            view.getHeight().toFloat(), // fromYDelta
            0f
        )                // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    // slide the view from its current position to below itself
    fun slideDown(view: View) {
        val animate = TranslateAnimation(
            0f, // fromXDelta
            0f, // toXDelta
            0f, // fromYDelta
            view.getHeight().toFloat()
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
    }

    fun printKeyHash(context: Activity): String? {
        val packageInfo: PackageInfo
        var key: String? = null
        try {
            val packageName = context.applicationContext.packageName
            packageInfo =
                context.packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in packageInfo.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                key = String(Base64.encode(md.digest(), 0))
                Log.e("Key Hash=", key)
            }
        } catch (e1: PackageManager.NameNotFoundException) {
            Log.e("Name not found", e1.toString())
        } catch (e: NoSuchAlgorithmException) {
            Log.e("No such an algorithm", e.toString())
        } catch (e: Exception) {
            Log.e("Exception", e.toString())
        }

        return key
    }


    fun getCurrentLocale(context: Context): Locale? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.getResources().getConfiguration().getLocales().get(0)
        } else {
            context.getResources().getConfiguration().locale
        }
    }
}


object Utils {
    fun isConnected(context: Context): Boolean {
        val connectivityManager = context.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    fun showAlert(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Network Issue")
        builder.setMessage("Internet is not connected please try again!")
        builder.setIcon(R.drawable.ic_warning)
        builder.setPositiveButton("Ok") { dialogInterface, which ->

        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun hideKeyboard(context: Context, view: View) {
        val inputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun checkEmail(email: String): Boolean {
        return !EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    fun isValidMobile(phone: String): Boolean {
        return if (!Pattern.matches("[a-zA-Z]+", phone)) {
            phone.length > 9 && phone.length <= 10
        } else false
    }

    fun dialogForMessage(context: Context, title: String, message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { dialogInterface, which ->

        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun activityCloseTransition(activity: Activity) {
        activity.overridePendingTransition(0, R.anim.push_bottom_out);
    }

//    fun showAlertForLogin(context: Context, fromActivity: String) {
//        val builder = AlertDialog.Builder(context)
//        if (fromActivity.equals(Constant.FROM_LAB)) {
//            builder.setMessage("You have to Login/Register! Add To Cart")
//        } else {
//            builder.setMessage("You have to Login/Register! Go to pharmacy")
//        }
//        builder.setIcon(android.R.drawable.ic_dialog_alert)
//        builder.setPositiveButton("Ok") { dialogInterface, which ->
//            PreferenceHelper.saveData(context, Constant.FROM, fromActivity)
//            val intent = Intent(context, LoginActivity::class.java)
//            context.startActivity(intent)
//        }
//        val alertDialog: AlertDialog = builder.create()
//        alertDialog.setCancelable(true)
//        alertDialog.show()
//    }

    fun getImageContentUri(
        context: Context,
        imageFile: File
    ): Uri? {
        val filePath = imageFile.absolutePath
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            arrayOf(MediaStore.Images.Media._ID),
            MediaStore.Images.Media.DATA + "=? ",
            arrayOf(filePath),
            null
        )
        return if (cursor != null && cursor.moveToFirst()) {
            val id = cursor.getInt(
                cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID)
            )
            val baseUri =
                Uri.parse("content://media/external/images/media")
            Uri.withAppendedPath(baseUri, "" + id)
        } else {
            if (imageFile.exists()) {
                val values = ContentValues()
                values.put(MediaStore.Images.Media.DATA, filePath)
                context.contentResolver.insert(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
                )
            } else {
                null
            }
        }
    }

    fun getRealPathFromURI(
        context: Context,
        uri: Uri?
    ): String? {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor =
            context.contentResolver.query(uri!!, proj, null, null, null)
        val column_index = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(column_index)
    }
}
