package com.revature.p2.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void test_getAllDeputies() {
		Deputy dep1 = new Deputy(2, "usernam2", "email2@email.com", "password2");
		Deputy dep2 = new Deputy(3, "usernam3", "email3@email.com", "password3");
		List<Deputy> depList = new ArrayList<>();
		
		depList.add(dep2);depList.add(dep1);depList.add(validDeputy);
		
		when(mockDeputyDAO.findAll()).thenReturn(depList);
		
		Assert.assertEquals(sut.getAllDeputies(), depList);
	}
	
	@Test
	public void test_updateDeputy_validDeputyId() {
		Deputy updateDeputyRequest = new Deputy(1, "Altreredusername", "Alteredemail@email.com", "Alteredpassword");
		Deputy existingDeputy = spy(new Deputy(1, "username", "email@email.com", "password"));
		
		when(mockDeputyDAO.findDeputyById(updateDeputyRequest.getId())).thenReturn(existingDeputy);
		
		sut.updateDeputy(updateDeputyRequest);
		
		verify(existingDeputy).setUsername("Altreredusername");
		verify(existingDeputy).setEmail("Alteredemail@email.com");
		verify(existingDeputy).setPassword("Alteredpassword");
	}
	
	@Test
	public void test_deletedeputyById_validId() {
		when(mockDeputyDAO.existsById(1)).thenReturn(true);
		when(mockDeputyDAO.existsById(2)).thenReturn(false);
		
		sut.deleteDeputyById(2);
		verify(mockDeputyDAO, never()).deleteById(2);
		
		sut.deleteDeputyById(1);
		verify(mockDeputyDAO).deleteById(1);
	}
	
	
}
