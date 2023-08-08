package com.example.spyproject.ui

import android.widget.Space
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spyproject.R
import com.example.spyproject.component.CustomColumn
import com.example.spyproject.data.players


@Composable
fun PlayersScreen(modifier: Modifier = Modifier) {


    Column() {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .wrapContentSize(align = Alignment.Center)
        ) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.add_new_player))
            }
        }

        Box(modifier = modifier.fillMaxSize()) {
            PlayersContent()
        }
    }

}

@Composable
fun PlayersContent(modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        items(players)
        { myItem ->
            Card(
                modifier = modifier.padding(16.dp),
                shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.padding(start = 8.dp, end = 8.dp)
                )
                {
                    Text(text = myItem.name, fontSize = 24.sp)
                    Spacer(modifier = modifier.weight(1f))
                    CustomColumn(
                        columnIcon = Icons.Default.ThumbUp,
                        columnValue = myItem.gameCount.toString()
                    )
                    CustomColumn(
                        columnIcon = Icons.Default.ThumbUp,
                        columnValue = myItem.gameCount.toString()
                    )
                    CustomColumn(
                        columnIcon = Icons.Default.ThumbUp,
                        columnValue = myItem.gameCount.toString()
                    )

                }
            }
        }
    }
}


@Preview
@Composable
fun PlayerScreenPreview() {
    PlayersScreen()
}