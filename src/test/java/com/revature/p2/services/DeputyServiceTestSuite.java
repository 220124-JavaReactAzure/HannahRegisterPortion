package com.revature.p2.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.IllegalArgumentException;

import com.revature.p2.models.Deputy;
import com.revature.p2.repository.DeputyDAO;
import com.revature.p2.services.DeputyService;

public class DeputyServiceTestSuite {

	DeputyService sut;
	DeputyDAO mockDeputyDAO;
	Deputy validDeputy;
	
	@Before
	public void testPrep() {
		mockDeputyDAO = mock(DeputyDAO.class);
		sut = new DeputyService(mockDeputyDAO);
		validDeputy = new Deputy(1, "username", "email@email.com", "password");
	}
	
	
	@Test
	public void test_addDeputy_with_valid_deputy() {
		
		when(mockDeputyDAO.save(validDeputy)).thenReturn(validDeputy);
		
		Assert.assertEquals(sut.addDeputy(validDeputy), validDeputy);
	}
	
	
	
	
	
	
	
	
	
	
}
