package com.tdd.bookshelf.feature

import bookshelf.composeapp.generated.resources.Res
import bookshelf.composeapp.generated.resources.ic_send
import com.tdd.bookshelf.core.designsystem.Empty
import com.tdd.bookshelf.core.designsystem.Home
import com.tdd.bookshelf.core.designsystem.MyPage
import com.tdd.bookshelf.core.designsystem.Publication
import com.tdd.bookshelf.core.navigation.NavRoutes
import org.jetbrains.compose.resources.DrawableResource

enum class BottomNavType(
    val navName: String,
    val navIcon: DrawableResource,
    val destination: String,
) {
    HOME(Home, Res.drawable.ic_send, NavRoutes.HomeScreen.route),
    PUBLICATION(Publication, Res.drawable.ic_send, NavRoutes.PublicationScreen.route),
    MY(MyPage, Res.drawable.ic_send, NavRoutes.MyPageScreen.route),
    DEFAULT(Empty, Res.drawable.ic_send, "");

    companion object {
        fun getBottomNavIcon(navType: BottomNavType): DrawableResource =
            entries.firstOrNull { it == navType }?.navIcon ?: Res.drawable.ic_send
        
        fun getDestination(navType: BottomNavType): String =
            entries.firstOrNull { it == navType }?.destination ?: ""
    }

}