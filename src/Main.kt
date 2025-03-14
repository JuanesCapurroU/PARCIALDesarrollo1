fun main() {
    val reservarr = mutableListOf<Reservas>()
    val huespeds =  mutableListOf<Huesped>()

    var opcion=0;
    do {
        println(
            """
            1. Registrar Cliente
            2. Registrar Reserva
            3. Cancelar Reserva
            4. Mostrar Todas Las reservas Activas
            5. Salir
        """.trimIndent()
        )
        opcion = readln().toInt()
        when(opcion){
            1->{
                println("Registrar Cliente\n")
                print("Id: ")
                var id = readln().toInt()
                print("Nombre: ")
                var nombre = readln()
                print("Email: ")
                var email = readln()
                val huesped = Huesped(id,nombre,email)
                huespeds.add(huesped)

                println("Huesped registrado con exito....")

            }
            2->{
                println("Registrar Reserva\n")
                if (huespeds.isEmpty()){
                    println("Registra un cliente primero, para añadir una reserva..")
                }else{
                    println("ID del huesped: ")
                    var idHuesped = readln().toInt()
                    var huespedSeleccionado = huespeds.find { it.id == idHuesped }
                    if(huespedSeleccionado!=null){
                        println("ID Reserva: ")
                        val id = readln().toInt()
                        println("Numero de habitacion: ")
                        val numHabitacion = readln().toInt()
                        var habitacionSelecionada = reservarr.find { it.numeroHabitacion == numHabitacion && it.estado }
                        if (habitacionSelecionada != null) {
                            println("La habitación $numHabitacion ya está ocupada.")
                        } else {
                            println("Tipo de Habitacion: ")
                            var tipoHabitacion = readln()
                            println("Precio noche: ")
                            var precioNoche = readln().toDouble()
                            println("Cantidad de noches a reservar: ")
                            var noches = readln().toInt()
                            println("Confirme con true para reservar..")
                            var estado = readln().toBoolean()
                            var reserva = Reservas(huespedSeleccionado,id,numHabitacion,tipoHabitacion,precioNoche,noches,estado)

                            reservarr.add(reserva)
                            println("Reserva registrada correctamente...")

                        }
                    }else{
                        println("No se encontro un Huesped con ese id.. Intente de nuevo..")
                    }
                }
            }
            3->{
                println("Cancelar Reserva\n")
                println("ingresa el ID de la reserva a cancelar: ")
                val idReserva = readln().toInt()
                val reserva = reservarr.find { it.idReserva == idReserva }
                if (reserva != null) {
                    reservarr.remove(reserva)
                    println("Reserva canselada  exitosamente...")
                } else {
                    println("No se encontro una reserva con ese ID...")
                }
            }
            4->{
                println("MOSTRADOR DE RESERVAS ACTIVAS CON PRECIO A PAGAR: ")
                reservarr.forEach { reserva ->
                    if (reserva.estado==true) {
                        println(reserva)
                        var calculo = reserva.precioNoche * reserva.cantidadNochesReservadad
                        println("Monto que debe pagar el huesped: ${reserva.idHuesped} Es de: $  ${calculo}")
                    }
                }
            }
            5->{
                println("Saliendo..... Adiosss...")
            }
        }
    }while (opcion!=5)

}