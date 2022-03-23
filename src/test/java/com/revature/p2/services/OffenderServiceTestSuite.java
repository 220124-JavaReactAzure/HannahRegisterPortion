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
	
	@Test
	public void test_getAllOffenders() {
		Offender off1 = new Offender(2, "src2", "fullname2", "alias2", "dob2", "sex2", "height2", "weight2", "eyes2", "hair2", 200);
		Offender off2 = new Offender(3, "src3", "fullname3", "alias3", "dob3", "sex3", "height3", "weight3", "eyes3", "hair3", 300);
		List<Offender> offList = new ArrayList<>();
		
		offList.add(off2); offList.add(off1); offList.add(validOffender);
		
		when(mockOffenderDAO.findAll()).thenReturn(offList);
		
		Assert.assertEquals(sut.getAllOffenders(), offList);
	}
	
	@Test
	public void test_getOffenderById_validId_invalidId() {
		
		when(mockOffenderDAO.findOffenderById(2)).thenReturn(validOffender);
		when(mockOffenderDAO.findOffenderById(3)).thenReturn(null);
		
		Assert.assertEquals(sut.getOffenderById(2), validOffender);
		
		Assert.assertEquals(sut.getOffenderById(3), null);
	}
	
	@Test
	public void test_updateOffender_validId() {
		Offender updateOffenderRequest = new Offender(1, "Updatesrc", "Updatefullname", "Updatealias", "Updatedob", "Updatesex", "Updateheight", "Updateweight", "Updateeyes", "Updatehair", 6699);
		Offender existingOffender = spy(new Offender(1, "src", "fullname", "alias", "dob", "sex", "height", "weight", "eyes", "hair", 100));
		
		when(mockOffenderDAO.findOffenderById(updateOffenderRequest.getId())).thenReturn(existingOffender);
		
		sut.updateOffender(updateOffenderRequest);
		
		verify(existingOffender).setSrc("Updatesrc");
		verify(existingOffender).setWeight("Updateweight");
		verify(existingOffender).setAlias("Updatealias");
		verify(existingOffender).setDob("Updatedob");
		verify(existingOffender).setHeight("Updateheight");
		verify(existingOffender).setEyes("Updateeyes");
		verify(existingOffender).setHair("Updatehair");
		verify(existingOffender).setFullname("Updatefullname");
		verify(existingOffender).setSex("Updatesex");
	}
	
	@Test
	public void test_deleteOffenderById() {
		when(mockOffenderDAO.existsById(1)).thenReturn(true);
		when(mockOffenderDAO.existsById(2)).thenReturn(false);
		
		sut.deleteOffenderById(2);
		verify(mockOffenderDAO, never()).deleteById(2);
		
		sut.deleteOffenderById(1);
		verify(mockOffenderDAO).deleteById(1);
	}
	
	
}
