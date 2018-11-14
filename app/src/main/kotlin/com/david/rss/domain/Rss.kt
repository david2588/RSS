package com.david.rss.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rss(
    val description: String?,
    val image: String?,
    val link: String?,
    val publishDate: String?,
    val title: String?) : Parcelable