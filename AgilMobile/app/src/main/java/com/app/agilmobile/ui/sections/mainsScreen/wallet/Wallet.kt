package com.app.agilmobile.ui.sections.mainsScreen.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.theme.AgilMobileTheme
import com.app.agilmobile.ui.theme.Grey
import com.app.agilmobile.ui.theme.Orange
import com.app.agilmobile.ui.theme.Orange30

@Composable
fun Wallet(navController: NavController) {
    Column(
        modifier = Modifier.padding(6.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = "Ganhos",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Histórico de Ganhos",
                fontSize = 14.sp
            )


        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, Color.Transparent, RoundedCornerShape(16.dp))
                .width(400.dp)
                .height(intrinsicSize = IntrinsicSize.Min)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ){
                Text(text = "15 julho - 21 julho")
                Spacer(modifier = Modifier.height(6.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "R$",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Orange
                    )
                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "2.400,00",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "480 entregas nesta semana")
                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .background(Grey)
                        .fillMaxWidth()
                        .height(2.dp)
                )

                Column (
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ){
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                                .fillMaxWidth()
                    ) {
                        Text(text = "Desempenho atual", fontWeight = FontWeight.Bold)
                        Text(text = "97%", fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                            .height(intrinsicSize = IntrinsicSize.Max)
                            .background(Orange30)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Parabéns, você tem um aproveitamento de 97%, sobre suas entregas nesta semana!"
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "465/480", fontWeight = FontWeight.SemiBold,color = Color.DarkGray )
                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(12.dp))


        Box(
            modifier = Modifier
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, Color.Transparent, RoundedCornerShape(16.dp))
                .width(400.dp)
                .height(intrinsicSize = IntrinsicSize.Min)
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = "21 Julho", fontSize = 16.sp)
                Column (
                    horizontalAlignment = Alignment.End
                ){
                    Text(text = "R$ 480,00", fontWeight = FontWeight.SemiBold)
                    Text(text = "96 Pacotes")
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, Color.Transparent, RoundedCornerShape(16.dp))
                .width(400.dp)
                .weight(1f)
                .align(Alignment.End)

        ) {
            Column (
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = "Meus Recursos", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

                Spacer(modifier = Modifier.height(12.dp))

                Column {

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountBalance,
                                contentDescription = "Icon Bank",
                                tint = Orange,
                                modifier = Modifier
                                    .size(40.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(text = "Conta Bancária", fontWeight = FontWeight.SemiBold)
                                Text(text = "Não Registrada", fontSize = 14.sp)
                            }
                        }

                        IconButton(
                            onClick = {  },
                            modifier = Modifier
                                .background(Orange, RoundedCornerShape(8.dp))
                                .size(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward, contentDescription = "Back", tint = Color.White,
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(text = "Banco  --/-", fontWeight = FontWeight.SemiBold)
                        Text(text = "AG  --/-", fontWeight = FontWeight.SemiBold)
                        Text(text = "CC  -----/-", fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WalletPreview() {
    AgilMobileTheme {
        val navController = rememberNavController()
        Wallet(navController)
    }
}
