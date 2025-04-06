package com.sivear.justgroove.model.dance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dance_category")
data class DanceCategory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "color")
    val color: Long
) {
    companion object {
        val Hiphop = DanceCategory(id = 1, name = "Hiphop", color = 0xffFF3B30)
        val Breaking = DanceCategory(id = 2, name = "Breaking", color = 0xffFF9500)
        val Jazz = DanceCategory(id = 3, name = "Jazz", color = 0xffFF2D55)
        val Locking = DanceCategory(id = 4, name = "Locking", color = 0xffAF52DE)
        val Popping = DanceCategory(id = 5, name = "Popping", color = 0xff30D158)
        val Urban = DanceCategory(id = 6, name = "Urban", color = 0xff007AFF)
    }
}

val danceCategoryData: List<DanceCategory> = listOf(
    DanceCategory.Hiphop,
    DanceCategory.Jazz,
    DanceCategory.Urban,
    DanceCategory.Locking,
    DanceCategory.Popping,
    DanceCategory.Breaking
)