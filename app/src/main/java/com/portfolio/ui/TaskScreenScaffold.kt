package com.portfolio.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.portfolio.data.TaskMock
import com.portfolio.data.TaskServiceImpl
import com.portfolio.presentation.TaskUiState
import com.portfolio.presentation.TasksViewModel
import com.portfolio.theme.TasksTheme
import com.portfolio.theme.colorsTheme
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.asStateFlow

//@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreenScaffold(isDark: Boolean) {
    val viewModel: TasksViewModel = viewModel {
        TasksViewModel(TaskServiceImpl(TaskMock))
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    TasksTheme(darkTheme = isDark) {
        val colors = colorsTheme(isDark)
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            TopAppBar(title = {
                Text(
                    text = "Lista de tareas",
                    fontSize = 25.sp,
                    color = colors.textColor
                )
            })
        }, content = { innerPadding ->

            TasksScreen(
                uiState = uiState,
                colors = colors,
                paddingValues = innerPadding,
                onClickTask = { task -> viewModel.upDateTask(task) },
                sordList = { sord -> viewModel.sordList(sord) }
            )
        },
            floatingActionButton = {

                FloatingActionButton(
                    onClick = { },
                    contentColor = colors.textColor,
                    shape = RoundedCornerShape(50),
                    containerColor = colors.addIconColor
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add",
                        tint = colors.textColor
                    )
                }
            }

        )
    }
}