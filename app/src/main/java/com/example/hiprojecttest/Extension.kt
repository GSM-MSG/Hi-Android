package com.example.hiprojecttest


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator


fun EditText.setOnTextChanged(action: (p0: CharSequence?, p1: Int, p2: Int, p3: Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun afterTextChanged(p0: Editable?) = Unit

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            action(p0, p1, p2, p3)
        }
    })
}
fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(resId, args, navOptions, navExtras)
    }
}
fun NavController.navigateSafeUp(@IdRes currentFragmentResId: Int) {
    if (currentDestination?.id == currentFragmentResId) {
        navigateUp()
    }
}
