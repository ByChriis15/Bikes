package com.example.bikes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
//import com.crespoboop.examen.data.ComidaDatabase
import com.example.bikes.data.BicicletaDatabase
//import com.crespoboop.examen.data.ComidaRepository
import com.example.bikes.data.BicicletaRepository
//import com.crespoboop.examen.main.ComidaScreen
import com.example.bikes.main.BicicletasScreen
//import com.crespoboop.examen.main.MainScreen
import com.example.bikes.main.MainScreen
//import com.crespoboop.examen.main.MainViewModel
import com.example.bikes.main.MainViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db= Room.databaseBuilder(this, BicicletaDatabase::class.java, "Comidadb").build()
        val dao= db.dao
        val repository= BicicletaRepository(dao)
        val viewmodel = MainViewModel(repository)

        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "main" ){
                composable("main" ){

                    MainScreen(navController,viewmodel)

                }
                composable(route="detail"+"/{text}/{text2}/{text3}/{text4}", arguments =  listOf(navArgument(name = "text") {type= NavType.StringType }, (navArgument(name="text2") { type= NavType.StringType }),
                    (navArgument(name="text3"){
                        type= NavType.StringType }
                            ),
                    (navArgument(name="text4"){
                        type= NavType.StringType }
                            )
                )
                )
                {
                    it.arguments?.getString("text")?.let { it1 ->
                        DetailScreen(navController, it1,
                            it.arguments?.getString("text2")!!,
                            it.arguments?.getString("text3")!!, it.arguments?.getString("text4")!!
                        )
                    }
                }

                composable("lista"){
                    BicicletasScreen(viewModel = viewmodel, navController =navController )
                }
            }
        }
    }

    private fun BicicletasScreen(viewModel: MainViewModel, navController: NavHostController) {
        TODO("Not yet implemented")
    }
}