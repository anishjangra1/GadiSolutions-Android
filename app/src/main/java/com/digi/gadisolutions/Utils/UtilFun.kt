package com.digi.gadisolutions.Utils

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import android.widget.Toast

class UtilFun {
    private var progressDialog: ProgressDialog? = null
   public fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    public fun showToast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showProgressDialog(context: Context?, title: String?, message: String?, cancelable: Boolean) {
        try {
            dismissProgressDialog()

            if (context == null) {
                return
            }

            progressDialog = ProgressDialog.show(
                context,
                title,
                message,
                true,
                cancelable)
        } catch (e: Exception) {
//            LogUtils.e(e)
        }

    }

    fun dismissProgressDialog() {
        try {
            if (progressDialog?.isShowing == true) {
                progressDialog?.dismiss()
            }
        } catch (e: Exception) {
//            LogUtils.e(e)
        } finally {
            progressDialog = null
        }
    }




}