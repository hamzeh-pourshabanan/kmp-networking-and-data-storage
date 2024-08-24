package com.hamzeh.kmp_networking_and_data_storage.android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.hamzeh.kmp_networking_and_data_storage.android.ui.AppBar
import com.hamzeh.kmp_networking_and_data_storage.domain.model.RocketLaunchDomainModel

@Composable
fun HomeScreen(
    data: List<RocketLaunchDomainModel>,
    onClick: (RocketLaunchDomainModel) -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.app_name)
            )
        }
    ) { padding ->
        GridOfCharacters(data, padding, onClick)
    }
}

@Composable
private fun GridOfCharacters(
    rockets: List<RocketLaunchDomainModel>,
    padding: PaddingValues,
    onClick: (RocketLaunchDomainModel) -> Unit,
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.item_min_width)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.x_small)),
        modifier = Modifier.padding(padding)
    ) {

        items(rockets) { rocket ->
            CharacterItem(
                rocket = rocket,
                modifier = Modifier.clickable { onClick(rocket) }
            )
        }
    }
}

@Composable
fun CharacterItem(rocket: RocketLaunchDomainModel, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(dimensionResource(R.dimen.x_small))) {
//        Text(text = rocket.missionName, modifier = Modifier
//            .size(dimensionResource(id = R.dimen.item_size))
//            .align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = dimensionResource(id = R.dimen.font_size).value.sp
//
//        )

        AsyncImage(
            model = rocket.patchSmall,
            contentDescription = rocket.missionName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .aspectRatio(ratio = 0.67f),
        )
        Text(text = rocket.missionName, modifier = Modifier.padding(dimensionResource(id = R.dimen.x_small)))
    }
}