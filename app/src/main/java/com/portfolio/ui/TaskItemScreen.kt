package com.portfolio.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.portfolio.model.Prioridad
import com.portfolio.model.Task
import com.portfolio.theme.MyColors

@Composable
fun TaskItemScreen(
    task: Task, colors: MyColors, onClickStatus: (Task) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 2.dp)
            .clickable { },
        shape = RoundedCornerShape(5),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        //  colors = CardDefaults.cardColors().copy(Color.Gray)

    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(60.dp),
                shape = RoundedCornerShape(35),
                color = colors.colorTaskItem,
                onClick = { onClickStatus(task) }
            ) {
                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = if (task.completada) Icons.Default.Check else Icons.Default.Clear,
                    colorFilter = ColorFilter.tint(if (task.completada) Color.Green else Color.Red),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Image icono expense Item"
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = task.titulo,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = colors.textColor
                )
                Text(
                    text = task.descripcion,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = colors.textColor
                )
            }
            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = colors.colorTaskItem
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = task.prioridad.name,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp,
                        color = if (task.prioridad == Prioridad.ALTA) colors.textColorA else if (task.prioridad == Prioridad.MEDIA) colors.textColorM else colors.textColorB,
                        textAlign = TextAlign.Center,
                    )
                }
            }

        }

    }
}