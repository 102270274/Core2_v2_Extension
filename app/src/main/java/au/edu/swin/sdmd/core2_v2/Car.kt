package au.edu.swin.sdmd.core2_v2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(
    var name: String, var location: String,
    var year: String, var rating: Float,
    val carImage: Int): Parcelable {
}