package org.d3if3026.allunit.unit2.pathway3

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.d3if3026.allunit.R
import org.d3if3026.allunit.ui.theme.AllUnitTheme

@Composable
fun ArtSpace(){
    var currentArtWork by remember {
        mutableIntStateOf(0)
    }
   Surface(
       modifier = Modifier
           .fillMaxSize()
           .padding(8.dp, top = 70.dp),
   ) {
       Column{

           when (currentArtWork){
               0 -> {
                   ImagePolaroid(
                       imageRes = R.drawable.giuseppe_arcimboldo,
                       contentDescription = stringResource(R.string.Vertumnus_image),
                       modifier = Modifier
                           .padding(8.dp)
                           .weight(2f)
                   )
               }
               1 -> {
                   ImagePolaroid(
                       imageRes = R.drawable.monalisa,
                       contentDescription = stringResource(R.string.MonaLisa_image),
                       modifier = Modifier
                           .padding(8.dp)
                           .weight(2f)
                   )
               }
               2 -> {
                   ImagePolaroid(
                       imageRes = R.drawable.the_milkmaid,
                       contentDescription = stringResource(R.string.The_Milkmaid_image),
                       modifier = Modifier
                           .padding(8.dp)
                           .weight(2f)
                   )
               }
           }

           Column(
               modifier = Modifier.weight(1f),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Bottom,
           ) {
               when(currentArtWork){
                   0 -> {
                       ImageDescription(
                           artWorkTitle = R.string.Vertumnus_title,
                           artWorkArtist = R.string.Vertumnus_artist,
                           year = R.string.Vertumnus_year
                       )
                   }
                   1 -> {
                       ImageDescription(
                           artWorkTitle = R.string.MonaLisa_title,
                           artWorkArtist = R.string.MonaLisa_artist,
                           year = R.string.MonaLisa_year
                       )
                   }
                   2 -> {
                       ImageDescription(
                           artWorkTitle = R.string.The_Milkmaid_title,
                           artWorkArtist = R.string.The_Milkmaid_artist,
                           year = R.string.The_Milkmaid_year
                       )
                   }
               }
               Spacer(modifier = Modifier.size(10.dp))
               NextPrevButton(
                   onNextClick = {
                       if(currentArtWork != 2) currentArtWork++
                       else currentArtWork = 0
                   },
                   onPrevClick = {
                       if(currentArtWork != 0) currentArtWork--
                       else currentArtWork = 2
                   },
               )
           }
       }
   }
}

@Composable
fun NextPrevButton(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit,
    onPrevClick: () -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Button(onClick = { onPrevClick() },
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Button(onClick = { onNextClick() },
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Composable
fun ImageDescription(
    @StringRes artWorkTitle: Int,
    @StringRes artWorkArtist: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .background(Color(0xFFECEBF4))
            .padding(23.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Light
            )
            ) {
                append("${stringResource(id = artWorkTitle)}\n")
            }

            withStyle(style = SpanStyle(
                fontWeight = FontWeight.Bold
            )
            ) {
                append(stringResource(id = artWorkArtist))
            }

            withStyle(style = SpanStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Light
            )
            ) {
                append(" (${stringResource(id = year)})")
            }
        })
    }
}

@Composable
fun ImagePolaroid(
    @DrawableRes imageRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(38.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevArtSpace(){
    AllUnitTheme {
        ArtSpace()
    }
}

