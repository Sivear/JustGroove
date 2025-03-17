package com.sivear.justgroove.ui.components

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sivear.justgroove.model.account.AccountModel
import com.sivear.justgroove.preference.AccountPreference

@Composable
fun Header() {
//    val ctx: Context = LocalContext.current
//    LaunchedEffect("") {
//        Log.i("testtttttt", AccountPreference.getInstance().getAccountInfo(ctx).toString())
//    }
    Row(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
            .height(60.dp)
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // TODO: 根据是否有头像判断使用默认头像
        Button(
            modifier = Modifier.clip(shape = androidx.compose.foundation.shape.CircleShape)
                .size(36.dp),
            contentPadding = (PaddingValues(0.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            enabled = true,
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "avatar",
                tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
        }
//        Text(text = accountInfo?.name ?: "")
        Button(
            contentPadding = (PaddingValues(5.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            enabled = true,
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "operations",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}