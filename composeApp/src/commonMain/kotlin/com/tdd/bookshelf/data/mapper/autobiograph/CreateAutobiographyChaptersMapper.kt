package com.tdd.bookshelf.data.mapper.autobiograph

import com.tdd.bookshelf.data.base.BaseMapper
import com.tdd.bookshelf.data.entity.request.autobiography.PostCreateAutobiographyChaptersRequestDto
import com.tdd.bookshelf.domain.entity.request.autobiography.CreateAutobiographyChaptersRequestModel

object CreateAutobiographyChaptersMapper : BaseMapper() {
    fun CreateAutobiographyChaptersRequestModel.toDto() =
        PostCreateAutobiographyChaptersRequestDto(
            chapters =
                chapters.map { chapterItem ->
                    PostCreateAutobiographyChaptersRequestDto.ChapterItem(
                        number = chapterItem.number,
                        name = chapterItem.name,
                        description = chapterItem.description,
                        subchapters =
                            chapterItem.subchapters.map { subChapterItem ->
                                PostCreateAutobiographyChaptersRequestDto.ChapterItem.SubChapterItem(
                                    number = subChapterItem.number,
                                    name = subChapterItem.name,
                                    description = subChapterItem.description,
                                )
                            },
                    )
                },
        )
}
