package com.sivear.justgroove.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sivear.justgroove.R
import com.sivear.justgroove.model.dance.DanceCategory
import com.sivear.justgroove.local.entity.DanceRecordEntity
import com.sivear.justgroove.model.dance.danceCategoryData
import com.sivear.justgroove.utils.TimeUtils

val recordList: List<DanceRecordEntity> = listOf(
    DanceRecordEntity(1, "第一次练习", System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), 1, "momo", "", "练舞是一种不断挑战自我的过程，不仅提升身体协调性，还能增强节奏感和表现力。每次训练都要专注基本功，打好基础才能跳得更稳、更自如。同时，舞蹈不仅仅是动作，更是情感的表达，要学会用身体去讲故事。坚持练习，耐心突破瓶颈，才能看到进步。最重要的是，享受音乐，释放自我，让每一支舞都充满灵魂和热情！", "1. isolation\n2. step", "练舞是一种不断挑战自我的过程，不仅提升身体协调性，还能增强节奏感和表现力。每次训练都要专注基本功，打好基础才能跳得更稳、更自如。同时，舞蹈不仅仅是动作，更是情感的表达，要学会用身体去讲故事。坚持练习，耐心突破瓶颈，才能看到进步。最重要的是，享受音乐，释放自我，让每一支舞都充满灵魂和热情！", "") ,
    DanceRecordEntity(2, "第二次练习", System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), 2, "luzi", "", "练舞是一种不断挑战自我的过程，不仅提升身体协调性，还能增强节奏感和表现力。每次训练都要专注基本功，打好基础才能跳得更稳、更自如。同时，舞蹈不仅仅是动作，更是情感的表达，要学会用身体去讲故事。坚持练习，耐心突破瓶颈，才能看到进步。最重要的是，享受音乐，释放自我，让每一支舞都充满灵魂和热情！", "1. isolation\n2. step", "练舞是一种不断挑战自我的过程，不仅提升身体协调性，还能增强节奏感和表现力。每次训练都要专注基本功，打好基础才能跳得更稳、更自如。同时，舞蹈不仅仅是动作，更是情感的表达，要学会用身体去讲故事。坚持练习，耐心突破瓶颈，才能看到进步。最重要的是，享受音乐，释放自我，让每一支舞都充满灵魂和热情！", ""),

)

@Composable
fun RecordList() {
    LazyColumn {
        items(recordList, key = { it.id }) { item ->
            RecordItem(item)
        }

    }
}


@Composable
fun RecordItem(item: DanceRecordEntity) {
    val category = danceCategoryData.find { it.id == item.category }
    if (category == null) {
        return
    }

    Box(
        modifier = Modifier
            .padding(8.dp) // 外边距（margin）
            .clickable {  }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.Transparent)
                .border(width = 0.5.dp, color = Color(0, 0, 0, 36), shape = RoundedCornerShape(4.dp))
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxHeight().weight(1f).padding(horizontal = 8.dp)
            ) {
                Text(text = item.title, style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(text = item.description, style = MaterialTheme.typography.bodySmall, maxLines = 2, overflow = TextOverflow.Ellipsis)
                Spacer(Modifier.weight(1f))
                Text(text = "${category.name}, ${item.teacher}, ${TimeUtils.formatTimestampCompat(item.lessonTime)}",
                    fontSize = 12.sp,
                    style = TextStyle(color = Color(0xffcccccc)),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Image(
                painter = if (item.cover == "") painterResource(getDefaultCover(item.category)) else rememberAsyncImagePainter(item.cover),
                modifier = Modifier.size(84.dp).clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop,
                contentDescription = "record-cover",
            )
        }
    }

}

fun getDefaultCover(categoryId: Int): Int {
    return when(categoryId) {
        DanceCategory.Hiphop.id -> R.drawable.hiphop
        DanceCategory.Jazz.id -> R.drawable.jazz
        DanceCategory.Breaking.id -> R.drawable.breaking
        DanceCategory.Locking.id -> R.drawable.locking
        DanceCategory.Urban.id -> R.drawable.urban
        DanceCategory.Popping.id -> R.drawable.popping
        else -> R.drawable.ic_launcher_background
    }
}
