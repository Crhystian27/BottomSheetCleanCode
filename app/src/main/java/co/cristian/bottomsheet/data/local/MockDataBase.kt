package co.cristian.bottomsheet.data.local

import co.cristian.bottomsheet.domain.models.Transaction

class MockDataBase {


    fun transaction():List<Transaction> = listOf(
        Transaction("07 Agosto","Mercadona","-34,98€"),
        Transaction("03 Agosto","Restaurante","-45,00€"),
        Transaction("29 Julio","Goiko Burguer","-14,95€"),
        Transaction("26 Julio","JD Sports","-79,99€"),
        Transaction("23 Julio","Mercadona","-34,98€"),
        Transaction("20 Julio","Restaurante","-45,00€"),
        Transaction("01 Junio","Goiko Burger","-14,95€"),
        Transaction("29 Diciembre - 2021","JD Sports","-79,99€"),
        Transaction("27 Diciembre - 2021","JD Sports","-79,99€")
    )
}