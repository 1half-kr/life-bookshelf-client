package com.tdd.bookshelf.feature.interview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import bookshelf.composeapp.generated.resources.Res
import coil3.compose.AsyncImage
import com.tdd.bookshelf.core.designsystem.Blue300
import com.tdd.bookshelf.core.designsystem.BookShelfTypo
import com.tdd.bookshelf.core.designsystem.Gray50
import com.tdd.bookshelf.core.designsystem.Gray600
import com.tdd.bookshelf.core.designsystem.InterviewScreenTitle
import com.tdd.bookshelf.core.designsystem.Neutral900
import com.tdd.bookshelf.core.designsystem.White0
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun InterviewScreen() {

    val viewModel: InterviewViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    InterviewContent()
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun InterviewContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White0)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = InterviewScreenTitle,
                style = BookShelfTypo.SemiBold,
                color = Neutral900,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 30.dp)
            )

            AsyncImage(
                model = Res.getUri("files/ic_back.svg"),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 20.dp)
                    .size(24.dp)
            )
        }

        InterviewChat(
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun InterviewChat(
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .padding(bottom = 120.dp)
    ) {
        InterviewBotChatItem(
            content = "bot",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp)
                .fillMaxWidth(0.7f)
        )

        InterviewHumanChatItem(
            content = "human",
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp)
                .fillMaxWidth(0.7f)
        )
    }
}

@Composable
private fun InterviewBotChatItem(
    content: String,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomEnd = 12.dp))
            .background(Gray50)
    ) {
        Text(
            text = content,
            color = Gray600,
            style = BookShelfTypo.Regular,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp, start = 16.dp, end = 40.dp)
        )
    }
}

@Composable
private fun InterviewHumanChatItem(
    content: String,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp))
            .background(Blue300)
    ) {
        Text(
            text = content,
            color = Gray600,
            style = BookShelfTypo.Regular,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp, end = 16.dp, start = 40.dp)
        )
    }
}

@Preview
@Composable
fun PreviewInterview() {
    InterviewContent()
}