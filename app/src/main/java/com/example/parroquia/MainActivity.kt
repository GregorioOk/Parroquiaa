package com.example.parroquia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Composable
fun PantallaInicio() {
    val rojo = Color(0xFFA64B4B)
    val gris = Color(0xFFEBEBEE)
    val azul = Color(0xFF1E3A8A)
    val margen = Modifier
        .padding(horizontal = 24.dp)
        .fillMaxWidth()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F8FA))
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 1. Encabezado azul con imagen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(azul, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header_banner),
                contentDescription = "Imagen de encabezado",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }

        // 2. Tarjeta gris principal
        Box(
            modifier = margen
                .height(200.dp)
                .background(gris, RoundedCornerShape(32.dp))
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Lecturas",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }

        // 3. Bloque rojo
        Box(
            modifier = margen
                .height(140.dp)
                .background(rojo, RoundedCornerShape(32.dp))
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Parroquia La Epifania " +
                        "\n Parroquia Ntra. Sra. De Lourdes",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        // 4. Cuadrícula 2 x 2
        Column(
            modifier = margen,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Tarjeta("Canciones", Modifier.weight(1f), rojo)
                Tarjeta("Los Avisos Parroquiales", Modifier.weight(1f), rojo)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Tarjeta("Palabras de parroco", Modifier.weight(1f), rojo)
                Tarjeta("La historia de la parroquia", Modifier.weight(1f), rojo)
            }
        }
    }
}

@Composable
fun Tarjeta(texto: String, modifier: Modifier, colorBorde: Color) {
    Box(
        modifier = modifier
            .height(110.dp)
            .border(2.dp, colorBorde, RoundedCornerShape(20.dp))
            .background(Color(0xFFEBEBEE), RoundedCornerShape(20.dp))
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = texto, textAlign = TextAlign.Center)
    }
}