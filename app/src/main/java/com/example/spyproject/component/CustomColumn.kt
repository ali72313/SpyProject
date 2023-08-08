package com.example.spyproject.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun CustomColumn(modifier: Modifier = Modifier, columnIcon: ImageVector, columnValue: String) {

    Column(modifier = modifier.fillMaxHeight()) {
        Icon(imageVector = columnIcon, contentDescription = "null")
        Text(text = columnValue)

    }

}