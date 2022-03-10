package com.revature.p2.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.p2.models.Offense;
import com.revature.p2.repository.OffenseDAO;

public class OffenseServiceTestSuite {

	OffenseService sut;
	OffenseDAO mockOffenseDAO;
	Offense validOffense;
	
	@Before
	public void testPrep() {
		mockOffenseDAO = mock(OffenseDAO.class);
		sut = new OffenseService(mockOffenseDAO);
		validOffense = new Offense();
	}
	
	@Test
	public void test_addOffense_with_validOffense() {
		
		when(mockOffenseDAO.save(validOffense)).thenReturn(validOffense);
		
		Assert.assertEquals(sut.addOffense(validOffense), validOffense);
	}
}
