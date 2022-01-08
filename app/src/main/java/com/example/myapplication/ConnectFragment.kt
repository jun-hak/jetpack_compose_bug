package com.example.myapplication


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject




class ConnectFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ComposeView(requireContext())
        view.apply {
            setContent {
                RecordScreen()
            }
        }

        return view
    }

    @Composable
    fun RecordScreen() {
        var serialNumber by remember { mutableStateOf("81143") }
        var connectState by remember { mutableStateOf(false) }

        when(connectState) {
           false -> Box(modifier = Modifier.fillMaxSize()) {
               Column(
                   modifier = Modifier
                       .fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally,
               ) {
                   Text("Serial Number")
                   Spacer(modifier = Modifier.height(4.dp))
                   // TODO TextField 버그 수정 (Text안보임 키보드 관련 버그)
                   BasicTextField(
                       value = serialNumber,
                       onValueChange = { serialNumber = it },
                       singleLine = true,
                       textStyle = TextStyle(
                           color = Color.White,
                           fontSize = 14.sp,
                           textAlign = TextAlign.Center
                       ),
                       modifier = Modifier
                   )
                   Spacer(modifier = Modifier.height(4.dp))
                   Button(onClick = {
                       connectState = true
                   }, enabled = serialNumber.isNotEmpty()) {
                       Text("Test")
                   }
               }
           }
           true -> LazyColumn(modifier = Modifier.fillMaxSize() ) {
               items(4) { item ->
                   Button(
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(10.dp),
                       onClick = {
                           connectState = false
                       }) {
                       Text(item.toString())
                   }
               }
               item {
                   Button(
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(10.dp),
                       onClick = {
                           connectState = false
                       }) {
                       Text("GoText")
                   }
               }
           }
        }
    }
}