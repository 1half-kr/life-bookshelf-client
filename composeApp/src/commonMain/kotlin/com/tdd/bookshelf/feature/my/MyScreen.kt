package com.tdd.bookshelf.feature.my

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.tdd.bookshelf.core.designsystem.Blue300
import com.tdd.bookshelf.core.designsystem.Blue900
import com.tdd.bookshelf.core.designsystem.BookShelfTypo
import com.tdd.bookshelf.core.designsystem.CompleteStatusSubTitle
import com.tdd.bookshelf.core.designsystem.CompleteStatusTitle
import com.tdd.bookshelf.core.designsystem.Gray300
import com.tdd.bookshelf.core.designsystem.Gray600
import com.tdd.bookshelf.core.designsystem.MyTitle
import com.tdd.bookshelf.core.designsystem.ProgressStatusSubTitle
import com.tdd.bookshelf.core.designsystem.ProgressStatusTitle
import com.tdd.bookshelf.core.designsystem.PublishStatusTitle
import com.tdd.bookshelf.core.designsystem.SubmitStatusSubTitle
import com.tdd.bookshelf.core.designsystem.SubmitStatusTitle
import com.tdd.bookshelf.core.designsystem.White0
import com.tdd.bookshelf.core.ui.common.content.TopBarContent
import com.tdd.bookshelf.domain.entity.enums.PublishStatusType
import com.tdd.bookshelf.domain.entity.response.publication.PublicationProgressUIContentModel
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
                .size(24.dp)
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
        statusUI = submitUI,
        progressContent = PublicationProgressUIContentModel(
            5,
            5,
            0,
            0,
            SubmitStatusTitle,
            SubmitStatusSubTitle,
            "files/ic_step_first.svg"
        )
    )

    PublicationStatusBox(
        statusUI = progressUI,
        progressContent = PublicationProgressUIContentModel(
            0,
            0,
            0,
            0,
            ProgressStatusTitle,
            ProgressStatusSubTitle,
            "files/ic_step_second.svg"
        )
    )

    PublicationStatusBox(
        statusUI = completeUI,
        progressContent = PublicationProgressUIContentModel(
            0,
            0,
            5,
            5,
            CompleteStatusTitle,
            CompleteStatusSubTitle,
            "files/ic_step_third.svg"
        )
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun PublicationStatusBox(
    statusUI: UIModel,
    progressContent: PublicationProgressUIContentModel,
) {
    val shape = RoundedCornerShape(
        topStart = progressContent.topStartCorner.dp,
        topEnd = progressContent.topEndCorner.dp,
        bottomStart = progressContent.bottomStartCorner.dp,
        bottomEnd = progressContent.bottomEndCorner.dp
    )

    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(shape)
            .border(1.dp, statusUI.strokeColor, shape)
            .background(statusUI.backgroundColor)
    ) {
        if (statusUI.isChecked) {
            AsyncImage(
                model = Res.getUri("files/ic_step_check.svg"),
                contentDescription = "step",
                modifier = Modifier
                    .padding(vertical = 13.dp, horizontal = 19.dp)
                    .size(31.dp)
                    .clip(CircleShape)
            )
        } else {
            AsyncImage(
                model = Res.getUri(progressContent.stepImg),
                contentDescription = "step",
                modifier = Modifier
                    .padding(vertical = 13.dp, horizontal = 19.dp)
                    .size(31.dp)
                    .clip(CircleShape)
            )
        }

        Column(
            modifier = Modifier
                .padding(vertical = 13.dp)
        ) {
            Text(
                text = progressContent.titleText,
                color = statusUI.titleColor,
                style = BookShelfTypo.Medium,
                fontSize = 11.sp
            )

            Spacer(modifier = Modifier.padding(top = 2.dp))

            Text(
                text = progressContent.subTitleText,
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
    val statusType = PublishStatusType.getPublishStatus(publishStatus)
    var progressUI: PublicationProgressUIModel

    when (statusType) {
        PublishStatusType.REQUEST -> {
            progressUI = PublicationProgressUIModel(
                submitUI = publicationStatusProgress(),
                progressUI = publicationStatusYet(),
                completeUI = publicationStatusYet()
            )
        }

        PublishStatusType.REQUEST_CONFIRM -> {
            progressUI = PublicationProgressUIModel(
                submitUI = publicationStatusCompleted(),
                progressUI = publicationStatusProgress(),
                completeUI = publicationStatusYet()
            )
        }

        PublishStatusType.IN_PUBLISHING -> {
            progressUI = PublicationProgressUIModel(
                submitUI = publicationStatusCompleted(),
                progressUI = publicationStatusProgress(),
                completeUI = publicationStatusYet()
            )
        }

        PublishStatusType.PUBLISHED -> {
            progressUI = PublicationProgressUIModel(
                submitUI = publicationStatusCompleted(),
                progressUI = publicationStatusCompleted(),
                completeUI = publicationStatusProgress()
            )
        }

        else -> {
            progressUI = PublicationProgressUIModel(
                submitUI = publicationStatusYet(),
                progressUI = publicationStatusYet(),
                completeUI = publicationStatusYet()
            )
        }
    }

    return progressUI
}

private fun publicationStatusCompleted(): UIModel =
    UIModel(
        backgroundColor = White0,
        strokeColor = Gray300,
        titleColor = Black900,
        subTitleColor = Gray600,
        isChecked = true,
    )

private fun publicationStatusProgress(): UIModel =
    UIModel(
        backgroundColor = Blue300,
        strokeColor = Blue300,
        titleColor = White0,
        subTitleColor = White0,
    )

private fun publicationStatusYet(): UIModel =
    UIModel(
        backgroundColor = White0,
        strokeColor = Gray300,
        titleColor = Gray600,
        subTitleColor = Gray600,
    )