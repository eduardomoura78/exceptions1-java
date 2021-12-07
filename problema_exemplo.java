package tratamento_excecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class problema_exemplo {
	/*
	 * Fazer um programa para ler os dados de uma reserva de hotel (n�mero do
	 * quarto, data de entrada e data de sa�da) e mostrar os dados da reserva,
	 * inclusive sua dura��o em dias. Em seguida, ler novas datas de entrada e
	 * sa�da, atualizar a reserva, e mostrar novamente a reserva com os dados
	 * atualizados. O programa n�o deve aceitar dados inv�lidos para a reserva,
	 * conforme as seguintes regras: - Altera��es de reserva s� podem ocorrer para
	 * datas futuras - A data de sa�da deve ser maior que a data de entrada
	 */

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy):");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (dd/mm/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy):");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null ) {
				System.out.println("Error in reservation: "+ error);
			}else {
				System.out.print("Reservation : "+ reservation);
			}								
		}		
		sc.close();
	}
}
