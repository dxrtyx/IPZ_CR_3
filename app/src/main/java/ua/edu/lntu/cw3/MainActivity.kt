package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw3.affirmations.data.Datasource
import ua.edu.lntu.cw3.affirmations.model.ItemAffirmations
import ua.edu.lntu.cw3.ui.theme.IPZ_CR_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationItemList(affirmationItemList = Datasource().loadAffirmations(), modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun AffirmationItemCard(affirmationItem: ItemAffirmations, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Image(
            painter = painterResource(id = affirmationItem.imageResourceId),
            contentDescription = stringResource(id = affirmationItem.stringResourceId),
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AffirmationItemList(affirmationItemList: List<ItemAffirmations>, modifier: Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), userScrollEnabled = true) {
        items(affirmationItemList) {
                affirmationItem -> AffirmationItemCard(
            affirmationItem = affirmationItem,
            modifier = Modifier)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AffrimationPreview() {
    IPZ_CR_3Theme {
        AffirmationItemList(affirmationItemList = Datasource().loadAffirmations(), modifier = Modifier)
    }
}