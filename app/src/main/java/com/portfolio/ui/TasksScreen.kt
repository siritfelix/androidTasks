package com.portfolio.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.model.Task
import com.portfolio.presentation.TaskUiState
import com.portfolio.theme.MyColors
import com.portfolio.theme.colorsTheme
import org.w3c.dom.Text

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TasksScreen(
    uiState: TaskUiState,
    colors: MyColors,
    paddingValues: PaddingValues,
    onClickTask: (tak: Task) -> Unit,
    sordList: (sord: Boolean) -> Unit
) {
    when (uiState) {
        is TaskUiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("TASKS_SCREEN_LOADING_TEST_TAG"),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is TaskUiState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                stickyHeader {
                    Column(modifier = Modifier.background(colors.backgroundColor)) {
                        Card(
                            shape = RoundedCornerShape(30),
                            colors = CardDefaults.cardColors(),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            Row(
                                modifier = Modifier.padding(
                                    horizontal = 8.dp,
                                    vertical = 16.dp
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Surface(
                                    modifier = Modifier.size(50.dp),
                                    shape = RoundedCornerShape(35),
                                    color = colors.colorTaskItem
                                ) {
                                    Image(
                                        modifier = Modifier.padding(10.dp),
                                        imageVector = Icons.Default.Check,
                                        colorFilter = ColorFilter.tint(Color.Green),
                                        contentScale = ContentScale.Crop,
                                        contentDescription = "Image icono expense Item"
                                    )
                                }
                                Text(
                                    text = "${uiState.endTotal}",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 18.sp,
                                    color = colors.textColor,
                                    modifier = Modifier.padding(5.dp)
                                )
                                Surface(
                                    modifier = Modifier.size(50.dp),
                                    shape = RoundedCornerShape(35),
                                    color = colors.colorTaskItem
                                ) {
                                    Image(
                                        modifier = Modifier.padding(10.dp),
                                        imageVector = Icons.Default.Clear,
                                        colorFilter = ColorFilter.tint(Color.Red),
                                        contentScale = ContentScale.Crop,
                                        contentDescription = "Image icono expense Item"
                                    )
                                }
                                Text(
                                    text = "${uiState.toDo}",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 18.sp,
                                    color = colors.textColor,
                                    modifier = Modifier.padding(5.dp)
                                )
                                Switch(
                                    colors = SwitchDefaults.colors()
                                        .copy(
                                            checkedTrackColor = colors.backgroundColor,
                                            checkedThumbColor = colors.textColor
                                        ),
                                    checked = uiState.sord,
                                    modifier = Modifier.padding(horizontal = 5.dp),
                                    onCheckedChange = sordList
                                )
                                Text(
                                    text = "Ordenar",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 18.sp,
                                    color = colors.textColor,
                                    modifier = Modifier.padding(5.dp)
                                )

                            }
                        }
                    }
                }
                items(uiState.tasks) { task ->
                    TaskItemScreen(task = task, colors = colors, onClickStatus = onClickTask)
                }
            }
        }

        is TaskUiState.Error -> {

        }
    }

}