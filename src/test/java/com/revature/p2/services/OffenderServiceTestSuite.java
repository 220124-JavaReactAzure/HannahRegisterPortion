package com.revature.p2.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.p2.models.Offender;
import com.revature.p2.repository.OffenderDAO;

public class OffenderServiceTestSuite {

	OffenderService sut;
	OffenderDAO mockOffenderDAO;
	Offender validOffender;
	
	@Before
	public void testPrep() {
		mockOffenderDAO = mock(OffenderDAO.class);
		sut = new OffenderService(mockOffenderDAO);
		validOffender = new Offender(1, "src", "fullname", "alias", "dob", "sex", "height", "weight", "eyes", "hair", 100);
	}
	
	@Test
	public void test_addOffender_with_validOffender() {
		when(mockOffenderDAO.save(validOffender)).thenReturn(validOffender);
		
		Assert.assertEquals(sut.addOffender(validOffender), validOffender);
	}
	
	
	
	
	
	
	
}
