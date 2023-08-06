package com.example.spyproject.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


data class CheckBoxValues(val text: String, val isChecked: Boolean)


@Composable
fun CheckBoxes(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        CheckBox()
        Switch()
        RadioButton()

    }
}

@Composable
fun CheckBox() {
    val checkBoxes = remember {
        mutableStateListOf(
            CheckBoxValues("Ali", true),
            CheckBoxValues("Mojtaba", false),
            CheckBoxValues("Mohammad", false),
        )
    }
    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }
    val triStateOnClick = {
        triState = when (triState) {
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkBoxes.indices.forEach { index ->
            checkBoxes[index] = checkBoxes[index].copy(isChecked = triState == ToggleableState.On)
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { triStateOnClick() }) {
        TriStateCheckbox(state = triState, onClick = triStateOnClick)
        Text(text = "all names")
    }
    checkBoxes.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    checkBoxes[index] = info.copy(isChecked = !info.isChecked)
                }
                .padding(end = 16.dp)
        ) {
            Checkbox(checked = info.isChecked, onCheckedChange = { isCheckedToggle ->
                checkBoxes[index] = info.copy(isChecked = isCheckedToggle)
            })
            Text(text = info.text)
        }


    }

}

@Composable
fun Switch() {
    var switchState by remember { mutableStateOf(CheckBoxValues("Dark-mode", isChecked = false)) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = switchState.text)
        Spacer(modifier = Modifier.weight(1f))
        androidx.compose.material3.Switch(
            thumbContent = {
                Icon(
                    imageVector = if (switchState.isChecked) Icons.Default.Check else Icons.Default.Close,
                    contentDescription = null
                )
            },
            checked = switchState.isChecked,
            onCheckedChange = { isChecked ->
                switchState = switchState.copy(isChecked = isChecked)
            })

    }
}

@Composable
fun RadioButton() {
    val radioButtons = remember {
        mutableStateListOf(
            CheckBoxValues("Ali", true),
            CheckBoxValues("Mojtaba", true),
            CheckBoxValues("Mohammad", false),
        )
    }
    radioButtons.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    radioButtons.replaceAll { it.copy(isChecked = it.text == info.text) }
                }
                .padding(end = 16.dp)
        ) {
            androidx.compose.material3.RadioButton(
                selected = info.isChecked,
                onClick = {
                    radioButtons.replaceAll { it.copy(isChecked = it.text == info.text) }
                })
            Text(text = info.text)
        }
    }
}

@Composable
@Preview
fun CheckBoxPreview() {
    CheckBoxes()
}