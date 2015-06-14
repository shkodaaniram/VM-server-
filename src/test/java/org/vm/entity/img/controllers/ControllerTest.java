package org.vm.entity.img.controllers;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.vm.entity.img.dao.ImageDAO;
import org.vm.entity.img.model.Image;
import org.vm.entity.model.EntityType;
import org.vm.entity.model.FilterType;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
	@InjectMocks
	ImageDAO imageDaoMock;
	
	@Test
	public void testInsert(){
		Image img = new Image(12, "testimage.png", FilterType.AQUA, "d:" + File.separator + "Pictures" + File.separator, EntityType.IMAGE, null,  1);
		imageDaoMock = mock(ImageDAO.class);
		verify(imageDaoMock).findAllForAccount(1);
		verify(imageDaoMock).findById(12);
		assertEquals(img, imageDaoMock.findById(12));
	}
}
