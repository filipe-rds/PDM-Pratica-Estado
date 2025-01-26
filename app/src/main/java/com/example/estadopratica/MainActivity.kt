package com.example.estadopratica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estadopratica.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeGalleryApp()
        }
    }
}

@Composable
fun AnimeGalleryApp() {
    val animes = listOf(
        Anime(R.drawable.solo_leveling, "Solo Leveling", "Ficção",
            "Sung Jin-Woo é um dos protagonistas mais poderosos em uma história repleta de ação, reviravoltas e momentos épicos. Em um mundo onde pessoas com habilidades especiais, conhecidas como \"caçadores\", enfrentam monstros em portais misteriosos, Sung Jin-Woo, inicialmente o caçador mais fraco, se torna um dos mais fortes após uma missão que transformou sua vida para sempre."),
        Anime(R.drawable.dragon_ball_daima, "Dragon Ball Daima", "Aventura",
            "Goku e seus amigos vivem uma nova aventura quando são transformados em crianças por uma conspiração do Mundo dos Demônios. Para restaurar seus amigos e enfrentar novos desafios, Goku deve usar sua Nyoibo (Nuvem de Energia) e explorar um mundo cheio de mistérios e batalhas épicas."),
        Anime(R.drawable.one_piece, "One Piece", "Aventura",
            "Monkey D. Luffy e seus companheiros navegam pelo Grand Line em busca do tesouro lendário, One Piece. Em sua busca, eles enfrentam inimigos poderosos, descobrem segredos do mundo e formam laços inquebráveis enquanto perseguem seus sonhos."),
        Anime(R.drawable.boruto, "Boruto: Naruto Next Generations", "Ação",
            "Boruto Uzumaki enfrenta novos perigos enquanto tenta proteger a vila e seguir os passos de seu pai, Naruto. Em sua jornada, Boruto descobre segredos sombrios e desenvolve suas próprias habilidades para se tornar um verdadeiro herói.")
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Galeria de Animes",
            fontSize = 28.sp,
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Por Filipe Rodrigues",
            fontSize = 14.sp,
            color = Color.Gray,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(id = animes[currentIndex].imageRes),
            contentDescription = animes[currentIndex].title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
                .padding(bottom = 16.dp)
        )

        Text(
            text = animes[currentIndex].title,
            fontSize = 24.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif, // Fonte padrão alterada
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Gênero: ${animes[currentIndex].genre}",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Descrição: ${animes[currentIndex].description}",
            fontSize = 14.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else animes.size - 1
                }
            ) {
                Text(text = "Anterior")
            }

            Button(
                onClick = {
                    currentIndex = if (currentIndex < animes.size - 1) currentIndex + 1 else 0
                }
            ) {
                Text(text = "Próximo")
            }
        }
    }
}

data class Anime(
    val imageRes: Int,
    val title: String,
    val genre: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun PreviewAnimeGalleryApp() {
    AnimeGalleryApp()
}
