package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmarciasTest extends SpringTest{

// 	Hacer con junit un test que busque todas las farmacias de turno los días martes.
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
		
		List<Farmacia> ListaDeFarmaciasTurnoMartes = getSession().createCriteria(Farmacia.class).add(Restrictions.eqOrIsNull("diaDeTurno", "Martes")).list();
		assertThat(ListaDeFarmaciasTurnoMartes.size()).isEqualTo(2);
				
	}
	
//	Hacer con junit un test que busque todas las farmacias de una calle.
	@Test
	@Transactional
	@Rollback(true)
	public void FarmaciasDeUnaCalle() {

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
		
		List<Farmacia> ListaDeFarmaciasTurnoMartes = getSession().createCriteria(Farmacia.class).add(Restrictions.eqOrIsNull("diaDeTurno", "Martes")).list();
		assertThat(ListaDeFarmaciasTurnoMartes.size()).isEqualTo(2);
				
	}
}
