package com.example.examen_ikercatala.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tarjeta(
    @StringRes val nombreResId: Int,
    @StringRes val rolResId: Int,
    @DrawableRes val imagenResId: Int
)
