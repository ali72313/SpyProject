package com.example.spyproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spyproject.R
import com.example.spyproject.models.NavigationItem


@Composable
fun SpyMainUiScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SpyMainUiScreenTopAppBar(topAppBarTitle = "Spy Game") },
        bottomBar = { SpyMainScreenBottomBar() }) {


        Surface(modifier = Modifier.padding(it)) {

            SpyMainScreenUiContent()
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpyMainUiScreenTopAppBar(topAppBarTitle: String) {
    CenterAlignedTopAppBar(
        title = { Text(text = "SpyGame") },
        actions = { TopAppBarActions() },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Gray.copy(
                alpha = 0.6f
            )
        )
    )
}

@Composable
fun TopAppBarActions() {
    Icon(imageVector = Icons.Default.Warning, contentDescription = "warning")
}

@Composable
fun SpyMainScreenBottomBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Players,
        NavigationItem.Places,
        NavigationItem.About,

        )
    // val navBackStackEntry by navController.currentBackStackEntryAsState()
    //   val currentRout = navBackStackEntry?.destination?.route

    NavigationBar(
        contentColor = Color.White,
        tonalElevation = 4.dp,
        containerColor = Color(33, 17, 52)
    ) {
        items.forEach()
        { item ->
            NavigationBarItem(
                alwaysShowLabel = false,
                selected = false,
                onClick = {

                },
                icon = {
                    Image(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(Color.White),
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White.copy(0.5f),
                    indicatorColor = Color.Red.copy(alpha = 0.3f)
                )
            )

        }
    }
}

@Composable
fun SpyMainScreenUiContent() {


    Column() {

        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
        )
        {

        }
        Row(
            modifier = Modifier
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(color = Color.Blue.copy(0.2f)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                Text(text = "time")
                SpyMainUiDropDown()


            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                Text(text = "time")
                SpyMainUiDropDown()

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                Text(text = "time")
                SpyMainUiDropDown()

            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .background(color = Color.Yellow.copy(alpha = 0.2f))
                .wrapContentSize(align = Alignment.Center)
        )
        {
            Button(onClick = { /*TODO*/ }) {
               Text(text = stringResource(R.string.start))
            }
        }


    }


}

@Composable
fun SpyMainUiDropDown(modifier: Modifier = Modifier) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }


    IconButton(onClick = { isExpanded = !isExpanded }) {
        Icon(
            imageVector = if (!isExpanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
            contentDescription = null
        )
        DropdownMenu(

            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            DropdownMenuItem(text = { Text(text = "ali") }, onClick = { /*TODO*/ })
            DropdownMenuItem(text = { Text(text = "ali") }, onClick = { /*TODO*/ })
            DropdownMenuItem(text = { Text(text = "ali") }, onClick = { /*TODO*/ })
        }
    }


}

@Composable
@Preview
fun SpyMainScreenUiContentPreview() {

    SpyMainScreenUiContent()
}


@Composable
@Preview
fun SpyUiPreview() {
    SpyMainUiScreen()

}