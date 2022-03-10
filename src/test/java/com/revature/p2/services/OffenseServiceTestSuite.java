package com.revature.p2.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
		validOffense = new Offense(1, "offenseDate", "offenseDescription");
	}
	
	
	@Test
	public void test_addOffense_with_validOffense() {
		
		when(mockOffenseDAO.save(validOffense)).thenReturn(validOffense);
		
		Assert.assertEquals(sut.addOffense(validOffense), validOffense);
	}
	
	@Test
	public void test_getAllOffense() {
		Offense off1 = new Offense(2, "offenseDate2", "offenseDescription2");
		Offense off2 = new Offense(3, "offenseDate3", "offenseDescription3");
		
		List<Offense> offList = new ArrayList<>();
		
		offList.add(off2); offList.add(off1); offList.add(validOffense);
		
		when(mockOffenseDAO.findAll()).thenReturn(offList);
		
		Assert.assertEquals(sut.getAllOffenses(), offList);
	}
	
	@Test
	public void test_updateOffense_validOffenseId() {
		Offense updateOffenseRequest = new Offense(1, "UpdateoffenseDate", "UpdateoffenseDescription");
		Offense existingOffense = spy(new Offense(1, "offenseDate", "offenseDescription"));
		
		when(mockOffenseDAO.findOffenseById(updateOffenseRequest.getId())).thenReturn(existingOffense);
		
		sut.updateOffense(updateOffenseRequest);
		
		verify(existingOffense).setId(1);;
		verify(existingOffense).setOffenseDate("UpdateoffenseDate");
		verify(existingOffense).setOffenseDescription("UpdateoffenseDescription");
	}
	
	@Test
	public void test_deleteOffenseById_validId_invalidId() {
		when(mockOffenseDAO.existsById(1)).thenReturn(true);
		when(mockOffenseDAO.existsById(2)).thenReturn(false);
		
		sut.deleteOffenseById(2);
		verify(mockOffenseDAO, never()).deleteById(2);
		
		sut.deleteOffenseById(1);
		verify(mockOffenseDAO).deleteById(1);
	}
	
	
	
	
	
}
