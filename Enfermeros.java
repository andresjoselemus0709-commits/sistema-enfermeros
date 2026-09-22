import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class parcial{
public static void main (String []args) {
Scanner teclado = new Scanner (System.in);

final int sueldo = 2525000;
String nombre="",especialidad="",fecha_contrato="",fecha_nacimiento="",celular="";
double descuento=0,sueldo_pagar=0,pacientes_atendidos=0,abono=0;

System.out.println("Ingrese su nombre completo:");
nombre = teclado.nextLine();
System.out.println("Ingrese su fecha de nacimiento (dd/mm/aaaa)");
fecha_nacimiento = teclado.nextLine();

System.out.println("Ingrese la fecha de caducidad de su contrato (dd/mm/aaaa)");
fecha_contrato = teclado.nextLine();
System.out.println("Ingrese el numero de pacientes atendidos:");
pacientes_atendidos = teclado.nextInt();
teclado.nextLine();
System.out.println("Ingrese su especialidad:");
especialidad = teclado.nextLine();
System.out.println("Ingrese su numero de celular:");
celular = teclado.nextLine();


if(pacientes_atendidos>=1 && pacientes_atendidos<=5) {
descuento= (sueldo) * (0.0125);
}
if(pacientes_atendidos>=6 && pacientes_atendidos<=8) {
descuento= (sueldo) * (0.011);
}
if(pacientes_atendidos>8) {
abono= (sueldo) * (0.025);
}
if (pacientes_atendidos<=8) {
sueldo_pagar = (sueldo) - (descuento); }
if (pacientes_atendidos>8) {
    sueldo_pagar = (sueldo) + (abono);
}

LocalTime hora_ingreso =LocalTime.now();
LocalDate Fecha =LocalDate.now();

//linea 51 a 53 con ayuda de IA
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate nacimiento = LocalDate.parse(fecha_nacimiento, formato);
int edad = Period.between(nacimiento,Fecha).getYears();

try {

FileWriter fw = new FileWriter("C:\\Users\\soyol\\OneDrive\\Desktop\\enfermeria.txt");
BufferedWriter bw = new BufferedWriter (fw);
bw.write("SISTEMA ENFERMEROS");
bw.write("\n");
bw.write("\n");
bw.write("\n");
bw.write("Nombre: " + nombre + "\n");
bw.write("Edad: " + edad + " años" +"\n");
bw.write("Especialidad : " + especialidad +"\n");
bw.write("Numero de pacientes atendidos: " + pacientes_atendidos + "\n");
bw.write("Sueldo: " + sueldo_pagar + "\n");
bw.write("Numero de celular: " + celular + "\n");
bw.write("Su contrato vence el " + fecha_contrato + "\n");
bw.write("\n");
bw.write("\n");
bw.write("Ingresó al sistema el: " + Fecha + " a las " + hora_ingreso+" hrs" +"\n");


bw.close();
fw.close();
}
catch (IOException error) {
System.out.println("ALERTA VERIFICAR RESPALDO"+ error.getMessage());
}
teclado.close();
}}