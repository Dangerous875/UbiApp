package com.barzabaldevs.ubiapp.ui.screens.homeScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.barzabaldevs.ubiapp.ui.components.CircularProgressBar
import com.barzabaldevs.ubiapp.ui.screens.homeScreen.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigateToMap: (Double, Double) -> Unit
) {
    var address by remember { mutableStateOf("") }
    val coordinates = viewModel.coordinates.collectAsState().value
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        CircularProgressBar("Cargando...")
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                TextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Ingresa una dirección") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.size(16.dp))
                Button(
                    onClick = { if (address.isNotBlank()) viewModel.fetchCoordinates(address) },
                    enabled = address.isNotBlank()
                ) {
                    Text("Obtener Coordenadas")
                }

                coordinates?.let { (lat, lng) ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(top = 16.dp)
                            .border(width = 8.dp, color = Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                modifier = Modifier.padding(bottom = 16.dp),
                                text = "Your coordinates: ",
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                            HorizontalDivider(
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )
                            Spacer(Modifier.size(16.dp))
                            Text("Latitude: $lat", textAlign = TextAlign.Center)
                            Spacer(Modifier.size(16.dp))
                            Text("Longitude: $lng", textAlign = TextAlign.Center)
                            Spacer(Modifier.size(16.dp))
                            HorizontalDivider(
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.White
                            )
                            Spacer(Modifier.size(16.dp))
                            Button(onClick = { navigateToMap(lat, lng) }) {
                                Text("Go to Map")
                            }
                        }
                    }
                }

            }
        }

    }
}