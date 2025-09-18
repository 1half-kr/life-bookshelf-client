package com.tdd.bookshelf.feature.interview

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import com.tdd.bookshelf.domain.entity.enums.ChatType
import com.tdd.bookshelf.domain.entity.response.interview.InterviewChatItem
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun InterviewScreen() {

    val viewModel: InterviewViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val interactionSource = remember { MutableInteractionSource() }

    InterviewContent(
        interviewChatList = uiState.interviewChatList
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun InterviewContent(
    interviewChatList: List<InterviewChatItem> = emptyList()
) {
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
            modifier = Modifier.weight(1f),
            interviewChatList = interviewChatList
        )
    }
}

@Composable
private fun InterviewChat(
    modifier: Modifier,
    interviewChatList: List<InterviewChatItem>,
) {
    BoxWithConstraints(
        modifier = modifier
            .padding(bottom = 120.dp)
            .fillMaxWidth()
    ) {
        val chatMaxWidth = maxWidth * 0.7f

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            interviewChatList.forEachIndexed { index, chatItem ->
                when (chatItem.chatType) {
                    ChatType.BOT -> {
                        InterviewBotChatItem(
                            content = chatItem.content,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(start = 20.dp)
                                .widthIn(max = chatMaxWidth)
                        )
                    }
                    ChatType.HUMAN -> {
                        InterviewHumanChatItem(
                            content = chatItem.content,
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(end = 20.dp)
                                .widthIn(max = chatMaxWidth)
                        )
                    }
                }
            }
        }
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
                .padding(top = 20.dp, bottom = 20.dp, start = 16.dp, end = 20.dp)
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
            color = White0,
            style = BookShelfTypo.Regular,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp, end = 16.dp, start = 20.dp)
        )
    }
}

@Preview
@Composable
fun PreviewInterview() {
    InterviewContent()
}