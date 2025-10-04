package com.tdd.bookshelf.feature.detailchapter

import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class DetailChapterViewModel: BaseViewModel<DetailChapterPageState>(
    DetailChapterPageState()
) {

    fun setAutobiographyId(autobiographyId: Int) {
        d("[test] detailChapterViewModel -> $autobiographyId")
        updateState(
            uiState.value.copy(
                selectedAutobiographyId = autobiographyId
            )
        )
    }
}