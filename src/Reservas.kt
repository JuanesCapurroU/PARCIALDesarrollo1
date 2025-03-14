class Reservas(var idHuesped :Huesped, var idReserva:Int, var numeroHabitacion:Int, var tipoHabitacion:String, var precioNoche:Double, var cantidadNochesReservadad:Int, var estado:Boolean ) {


    fun reservarHabitacion(){
        if(estado==true){
            println("Habitacion reservada con exito..")
        }else{
            println("Esta habitacion no se puede reservar ya que esta ocupada...")
        }
    }

    override fun toString(): String {
        return "Reservas(idReserva=$idReserva, numeroHabitacion=$numeroHabitacion, tipoHabitacion='$tipoHabitacion', precioNoche=$precioNoche, cantidadNochesReservadad=$cantidadNochesReservadad, estado=$estado)"
    }

}