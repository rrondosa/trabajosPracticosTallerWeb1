package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Punto;

public class FarmarciasTest extends SpringTest {

	// 2 -Hacer con junit un test que busque todas las farmacias de turno los días
	// martes.
	@Test
	@Transactional
	@Rollback(true)
	public void TestFarmarciasTunoDiaMartes() {

		Session sessionTest = getSession();

		Farmacia farmacia1 = new Farmacia();
		Farmacia farmacia2 = new Farmacia();
		Farmacia farmacia3 = new Farmacia();
		Farmacia farmacia4 = new Farmacia();

		farmacia1.setDiaDeTurno("Martes");
		farmacia2.setDiaDeTurno("Martes");
		farmacia3.setDiaDeTurno("Jueves");
		farmacia4.setDiaDeTurno("Miercoles");

		sessionTest.save(farmacia1);
		sessionTest.save(farmacia2);
		sessionTest.save(farmacia3);
		sessionTest.save(farmacia4);

		List<Farmacia> ListaDeFarmaciasTurnoMartes = getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eqOrIsNull("diaDeTurno", "Martes")).list();
		assertThat(ListaDeFarmaciasTurnoMartes.size()).isEqualTo(2);

	}

	// 3 -Hacer con junit un test que busque todas las farmacias de una calle.
	@Test
	@Transactional
	@Rollback(true)
	public void FarmaciasDeUnaCalleTest() {

		Session sessionTest = getSession();
		Punto coordenadas1 = new Punto("-34.6131500°", "-58.3772300°");
		Punto coordenadas2 = new Punto("-34.6231500°", "-58.3672300°");
		Punto coordenadas3 = new Punto("-34.6331500°", "-58.3572300°");
		Punto coordenadas4 = new Punto("-34.6431500°", "-58.3472300°");

		sessionTest.save(coordenadas1);
		sessionTest.save(coordenadas2);
		sessionTest.save(coordenadas3);
		sessionTest.save(coordenadas4);

		Barrio barrioCaba = new Barrio("Microcentro");
		Barrio barrioProvincia = new Barrio("Matanza");

		sessionTest.save(barrioCaba);
		sessionTest.save(barrioProvincia);

		Direccion direccion1 = new Direccion("Av. Corrientes", "156", barrioCaba);
		Direccion direccion2 = new Direccion("Av. Corrientes", "550", barrioCaba);
		Direccion direccion3 = new Direccion("Av. Belgrano", "453", barrioCaba);
		Direccion direccion4 = new Direccion("Florencio Varela", "1986", barrioProvincia);

		sessionTest.save(direccion1);
		sessionTest.save(direccion2);
		sessionTest.save(direccion3);
		sessionTest.save(direccion4);

		Farmacia farmacia1 = new Farmacia("farmacia1", "1111-2222", "Martes", direccion1, coordenadas1);
		Farmacia farmacia2 = new Farmacia("farmacia2", "3333-4444", "Jueves", direccion2, coordenadas2);
		Farmacia farmacia3 = new Farmacia("farmacia3", "5555-6666", "Viernes", direccion3, coordenadas3);
		Farmacia farmacia4 = new Farmacia("farmacia4", "7777-8888", "Domingo", direccion4, coordenadas4);

		sessionTest.save(farmacia1);
		sessionTest.save(farmacia2);
		sessionTest.save(farmacia3);
		sessionTest.save(farmacia4);

		List<Farmacia> ListaFarmaciasMismaCalle = getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "direccionBuscado")
				.add(Restrictions.eqOrIsNull("direccionBuscado.calle", "Av. Corrientes")).list();

		assertThat(ListaFarmaciasMismaCalle.size()).isEqualTo(2);
	}
	
	// 4 -Hacer con junit un test que busque todas las farmacias de un barrio.
	@Test
	@Transactional
	@Rollback(true)
	public void FarmaciasPorBarrioTest() {

		Session sessionTest = getSession();
		Punto coordenadas1 = new Punto("-34.6131500°", "-58.3772300°");
		Punto coordenadas2 = new Punto("-34.6231500°", "-58.3672300°");
		Punto coordenadas3 = new Punto("-34.6331500°", "-58.3572300°");
		Punto coordenadas4 = new Punto("-34.6431500°", "-58.3472300°");

		sessionTest.save(coordenadas1);
		sessionTest.save(coordenadas2);
		sessionTest.save(coordenadas3);
		sessionTest.save(coordenadas4);

		Barrio barrioCaba = new Barrio("Microcentro");
		Barrio barrioProvincia = new Barrio("Matanza");

		sessionTest.save(barrioCaba);
		sessionTest.save(barrioProvincia);

		Direccion direccion1 = new Direccion("Av. Corrientes", "156", barrioCaba);
		Direccion direccion2 = new Direccion("Av. Corrientes", "550", barrioCaba);
		Direccion direccion3 = new Direccion("Av. Belgrano", "453", barrioCaba);
		Direccion direccion4 = new Direccion("Florencio Varela", "1986", barrioProvincia);

		sessionTest.save(direccion1);
		sessionTest.save(direccion2);
		sessionTest.save(direccion3);
		sessionTest.save(direccion4);

		Farmacia farmacia1 = new Farmacia("farmacia1", "1111-2222", "Martes", direccion1, coordenadas1);
		Farmacia farmacia2 = new Farmacia("farmacia2", "3333-4444", "Jueves", direccion2, coordenadas2);
		Farmacia farmacia3 = new Farmacia("farmacia3", "5555-6666", "Viernes", direccion3, coordenadas3);
		Farmacia farmacia4 = new Farmacia("farmacia4", "7777-8888", "Domingo", direccion4, coordenadas4);

		sessionTest.save(farmacia1);
		sessionTest.save(farmacia2);
		sessionTest.save(farmacia3);
		sessionTest.save(farmacia4);
		
		List<Farmacia> ListaFarmaciasMismoBarrio = (getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "direccionBuscada").createAlias("direccionBuscada.barrio", "barrioBuscado")
				.add(Restrictions.eq("barrioBuscado.nombre", "Microcentro"))).list();

		assertThat(ListaFarmaciasMismoBarrio.size()).isEqualTo(3);
	}
		/*
		 * List<Farmacia> ListaFarmaciasMismoBarrio
		 * =(getSession().createCriteria(Farmacia.class) .createCriteria("direccion")
		 * .setFetchMode("Barrio", FetchMode.JOIN) .add(Restrictions.eq("barrio",
		 * "barrioCaba" ))).list();
		 * assertThat(ListaFarmaciasMismoBarrio.size()).isEqualTo(3);
		 */

	// 5 -Usando path variables, hacer un action que reciba una operación y sus dos
	// operandos y que lleve a una vista
	// que muestra la siguiente frase “El resultado de s umar 3 y 6 da 9 ”. En caso
	// que no pueda realizarse la operación
	// se debe llevar a otra vista diferente donde se muestra un mensaje
	// descriptivo.
}
