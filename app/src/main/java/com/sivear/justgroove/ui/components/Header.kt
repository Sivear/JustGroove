package com.sivear.justgroove.ui.components

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.sivear.justgroove.model.account.AccountModel
import com.sivear.justgroove.preference.AccountPreference
import kotlinx.coroutines.flow.first
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun Header() {
    val ctx: Context = LocalContext.current
    val accountInfo: AccountModel? = AccountPreference.getInstance().getAccountInfo(ctx).collectAsState(initial = null).value

    Row(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
            .height(72.dp)
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Avatar(accountInfo)
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Column(
                modifier = Modifier.widthIn(max = 100.dp).height(48.dp).padding(2.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = accountInfo?.name ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
                if (accountInfo != null) {
                    Text(
                        text = stringResource(accountInfo.title.titleResId) ,
                        fontWeight = FontWeight.Thin,
                        fontSize = 10.sp,
                        lineHeight = 10.sp,
                        color = Color.White,
                        modifier = Modifier.clip(RoundedCornerShape(4.dp))
                            .background(Color(accountInfo.title.color))
                            .padding(vertical = 2.dp, horizontal = 4.dp),
                    )
                }
            }
        }

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

@Composable
fun Avatar(accountInfo: AccountModel?) {
    Button(
        modifier = Modifier.clip(shape = CircleShape)
            .size(48.dp),
        contentPadding = (PaddingValues(0.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        enabled = true,
        onClick = {}
    ) {
        if (accountInfo == null) {
            // 未登录状态
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "avatar",
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        } else {
            // 已登录但是没有设置头像
            if (accountInfo.avatar == "") {
                Text(text = (if(accountInfo.name.isNotEmpty()) accountInfo.name.first().toString() else ""),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            } else {
                // 已登陆并且有头像
                Image(
                    painter = rememberAsyncImagePainter(accountInfo.avatar),
                    modifier = Modifier.fillMaxSize()
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop,
                    contentDescription = "avatar",
                )
            }
        }

    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}