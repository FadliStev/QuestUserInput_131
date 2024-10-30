package com.example.praktikum5

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable{ mutableStateOf("") }
    var email by remember { mutableStateOf("")}
    var alamat by rememberSaveable{ mutableStateOf("") }
    var nohp by remember { mutableStateOf("")}
    var selectedGender by remember { mutableStateOf("")}

    val jenisKelamin = listOf("LAKI - LAKI", "PEREMPUAN" )

    var confirmname by rememberSaveable{ mutableStateOf("") }
    var confirmemail by remember { mutableStateOf("")}
    var confirmalamat by rememberSaveable{ mutableStateOf("") }
    var confirmnohp by remember { mutableStateOf("")}
    var confirmselectedGender by remember { mutableStateOf("")}
    
    Column (
        Modifier
            .fillMaxSize()
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "BIODATA")
        
        OutlinedTextField(

            value = nama, 
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama Anda")},
            label = {Text("Nama" )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


            )

        Row {
            jenisKelamin.forEach{item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                   RadioButton(
                       selected = selectedGender == item,
                       onClick = {
                           selectedGender = item
                       })
                    Text(item)
                }

            }

        }

        OutlinedTextField(

            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email Anda")},
            label = {Text("Email" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        OutlinedTextField(

            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat Anda")},
            label = {Text("Alamat" )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        OutlinedTextField(

            value = nohp,
            onValueChange = {nohp = it},
            placeholder = { Text("Masukkan NoHP Anda")},
            label = {Text("No HP" )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)


        )

        Button(onClick = {
            confirmname = nama
            confirmselectedGender = selectedGender
            confirmemail = email
            confirmalamat = alamat
            confirmnohp = nohp
        },

            ) {
           Text("SAVE POINT")
        }

        Card(modifier = Modifier.size(height = 300.dp, width = 350.dp)) {
            Column {
                CardSection(judulParam = "Nama", isiParam = confirmname)
                CardSection(judulParam = "Jenis Kelamin", isiParam = confirmselectedGender)
                CardSection(judulParam = "Email", isiParam = confirmemail)
                CardSection(judulParam = "Alamat", isiParam = confirmalamat)
                CardSection(judulParam = "No HP", isiParam = confirmnohp)
            }

        }
        
    }
    
    
}


@Composable
fun CardSection(
    judulParam: String,
    isiParam: String

){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(5.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = judulParam,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = " : ",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )
        }
    }

}