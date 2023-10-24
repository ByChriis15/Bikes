package com.example.bikes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bikes.bicicletas.ui.BicicletaViewModel
import com.example.bikes.bicicletas.ui.BicicletaViewModelFactory
import com.example.bikes.data.BicicletaDatabase
import com.example.bikes.data.BicicletaRepository
import com.example.bikes.ui.theme.BikesTheme
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private lateinit var db: BicicletaDatabase
    private lateinit var repository: BicicletaRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = BicicletaDatabase.getInstance(this)
        repository = BicicletaRepository(db.bicicletaDao())

        setContent {
            BikesTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}
val viewModel: BicicletaViewModel = viewModel(factory = BicicletaViewModelFactory(repository))



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BikesTheme {
        Greeting("Android")
    }
}