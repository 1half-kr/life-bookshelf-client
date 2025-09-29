package com.tdd.bookshelf.feature.my

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.tdd.bookshelf.core.designsystem.BackGround4
import com.tdd.bookshelf.core.designsystem.Black900
import com.tdd.bookshelf.core.designsystem.Blue900
import com.tdd.bookshelf.core.designsystem.BookShelfTypo
import com.tdd.bookshelf.core.designsystem.Gray600
import com.tdd.bookshelf.core.designsystem.MyTitle
import com.tdd.bookshelf.core.designsystem.PublishStatusTitle
import com.tdd.bookshelf.core.designsystem.SubmitStatusSubTitle
import com.tdd.bookshelf.core.designsystem.SubmitStatusTitle
import com.tdd.bookshelf.core.designsystem.White0
import com.tdd.bookshelf.core.ui.common.content.TopBarContent
import com.tdd.bookshelf.domain.entity.response.publication.PublicationProgressUIModel
import com.tdd.bookshelf.domain.entity.response.publication.PublicationProgressUIModel.UIModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MyScreen() {

    val viewModel: MyViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MyContent(
        publishStatus = uiState.publishStatus
    )
}

@Composable
private fun MyContent(
    publishStatus: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround4)
    ) {
        TopBarContent(
            content = MyTitle
        )

        MyProfileBox()

        PublicationStatus(
            submitUI = publicationStatusUI(publishStatus).submitUI,
            progressUI = publicationStatusUI(publishStatus).progressUI,
            completeUI = publicationStatusUI(publishStatus).completeUI
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MyProfileBox() {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Blue900)
    ) {
        AsyncImage(
            model = Res.getUri("files/ic_profile_default.svg"),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 22.dp, top = 17.dp, bottom = 17.dp)
                .size(42.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 13.dp, top = 21.dp, bottom = 21.dp)
                .weight(1f)
        ) {
            Text(
                text = "이름",
                color = White0,
                style = BookShelfTypo.Medium,
                fontSize = 16.sp
            )

            Text(
                text = "2001.01.01",
                color = White0,
                style = BookShelfTypo.Medium,
                fontSize = 11.sp
            )
        }

        AsyncImage(
            model = Res.getUri("files/ic_pen.svg"),
            contentDescription = "edit",
            modifier = Modifier
                .padding(horizontal = 22.dp, vertical = 26.dp)
        )
    }
}

@Composable
private fun PublicationStatus(
    submitUI: UIModel,
    progressUI: UIModel,
    completeUI: UIModel,
) {
    Text(
        text = PublishStatusTitle,
        color = Black900,
        style = BookShelfTypo.Bold,
        fontSize = 15.sp,
        modifier = Modifier
            .padding(top = 17.dp, start = 22.dp, bottom = 10.dp)
    )

    PublicationStatusBox(
        statusUI = submitUI
    )

    PublicationStatusBox(
        statusUI = progressUI
    )

    PublicationStatusBox(
        statusUI = completeUI
    )
}

@Composable
private fun PublicationStatusBox(
    statusUI: UIModel,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = statusUI.topStartCorner.dp,
                    topEnd = statusUI.topEndCorner.dp,
                    bottomStart = statusUI.bottomStartCorner.dp,
                    bottomEnd = statusUI.bottomEndCorner.dp
                )
            )
            .background(statusUI.backgroundColor)
            .border(1.dp, statusUI.strokeColor)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Gray600)
                .padding(vertical = 13.dp, horizontal = 19.dp)
                .size(31.dp)
        )

        Column(
            modifier = Modifier
                .padding(vertical = 13.dp)
        ) {
            Text(
                text = SubmitStatusTitle,
                color = statusUI.titleColor,
                style = BookShelfTypo.Medium,
                fontSize = 11.sp
            )

            Text(
                text = SubmitStatusSubTitle,
                color = statusUI.subTitleColor,
                style = BookShelfTypo.Medium,
                fontSize = 11.sp
            )
        }
    }
}

private fun publicationStatusUI(
    publishStatus: String,
): PublicationProgressUIModel {
    //

    return PublicationProgressUIModel()
}