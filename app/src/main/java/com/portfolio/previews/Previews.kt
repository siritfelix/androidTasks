package com.portfolio.previews

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.portfolio.theme.TasksTheme
import com.portfolio.ui.TaskScreenScaffold


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, backgroundColor = 0)
@Composable
fun AppPreviewDark() {
    TaskScreenScaffold(true)
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    TaskScreenScaffold(false)
}
