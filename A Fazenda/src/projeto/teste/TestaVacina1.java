package projeto.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.afazenda.*;


/**
 * Classe de testes para vacina
 * 
 * @author Grupo 07 - A Fazenda
 *
 */

public class TestaVacina1 {

	
		private Vacina v1;
		private Vacina v2;
		
		@Before
		public void setUp() throws Exception {
			v1 = new Vacina("ContraAftosa",44.55);
			v2 = new Vacina("ContraTuberculose", 44.66);
		}
		
		@Test (expected = Exception.class)
		public void testaNomeNull() throws Exception {
			Vacina v3 = new Vacina(null, 3366);
		}
		
		@Test (expected = Exception.class)
		public void testaNomeVazio() throws Exception {
			Vacina v3 = new Vacina("", 1112);
		}
		
		@Test (expected = Exception.class)
		public void testaDosagemNegativa() throws Exception {
			Vacina v3 = new Vacina("ContraFebre",-0.5);
		}
		
		@Test (expected = Exception.class)
		public void testaDosagemZero() throws Exception {
			Vacina v3 = new Vacina("ContraFebre",0);
		}
		
				
		@Test (expected=Exception.class)
		public void testaGetNome() throws Exception {
			Assert.assertEquals("Nome errado", "ContraAftosa", v1.getNome());
			Assert.assertEquals("Nome errado", "ContraTuberculose", v2.getNome());
			
			v1.setNome("");
			v2.setNome(null);
			
			Assert.assertEquals("Nome errado", "ContraAftosa", v1.getNome());
			Assert.assertEquals("Nome errado", "ContraTuberculose", v2.getNome());
			
			v1.setNome("Rubeola");
			v2.setNome("Vaca Doida");
			
			Assert.assertEquals("Nome errado", "Rubeola", v1.getNome());
			Assert.assertEquals("Nome errado", "Vaca Doida", v2.getNome());
			
			v1.setNome("123");
			v2.setNome("as324gd5");
			
			Assert.assertEquals("Nome errado", "Rubeola", v1.getNome());
			Assert.assertEquals("Nome errado", "Vaca Doida", v2.getNome());
		}
		
		@Test
		public void testaGetDosagem() {
			Assert.assertEquals("Dosagem Errada", 44.55, v1.getDosagem(), 0.01);
			Assert.assertEquals("Dosagem Errada", 44.66, v2.getDosagem(), 0.01);
			
			v1.setDosagem(0);
			v2.setDosagem(-11.66);
			
			Assert.assertEquals("Dosagem Errada", 44.55, v1.getDosagem(), 0.01);
			Assert.assertEquals("Dosagem Errada", 44.66, v2.getDosagem(), 0.01);
			
			v1.setDosagem(13.66);
			v2.setDosagem(55.85);
			
			Assert.assertEquals("Dosagem Errada", 13.66, v1.getDosagem(), 0.01);
			Assert.assertEquals("Dosagem Errada", 55.85, v2.getDosagem(), 0.01);
		}
		
		@Test
		public void testaGetIDVacaVacinada() throws Exception {
			Vaca v1 = new Vaca("Mimosa", 2, 3);
			Vaca v2 = new Vaca("Safadona", 4, 5);
			v1.setID(1);
			v2.setID(2);
			
			Vacina vacina1 = new Vacina("Tetano", 4);
			Vacina vacina2 = new Vacina("Aids", 58.9);
			
			vacina1.vacinar(v1.getID());
			vacina2.vacinar(v2.getID());
			
			Assert.assertEquals(v1.getID(), vacina1.getIDVacaVacinada());
			Assert.assertEquals(v2.getID(), vacina2.getIDVacaVacinada());
			
			vacina1.vacinar(v2.getID());
			vacina2.vacinar(v1.getID());
			
			Assert.assertEquals(v1.getID(), vacina1.getIDVacaVacinada());
			Assert.assertEquals(v2.getID(), vacina2.getIDVacaVacinada());
		}

}