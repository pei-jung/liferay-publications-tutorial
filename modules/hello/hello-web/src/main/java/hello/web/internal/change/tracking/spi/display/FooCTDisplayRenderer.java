/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hello.web.internal.change.tracking.spi.display;

import com.liferay.change.tracking.spi.display.BaseCTDisplayRenderer;
import com.liferay.change.tracking.spi.display.CTDisplayRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.util.Portal;

import hello.model.Foo;

import java.util.Locale;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(service = CTDisplayRenderer.class)
public class FooCTDisplayRenderer extends BaseCTDisplayRenderer<Foo> {

	@Override
	public String getEditURL(HttpServletRequest httpServletRequest, Foo foo) {
		return PortletURLBuilder.create(
			PortletURLFactoryUtil.create(
				httpServletRequest, "hello_web_JSPPortlet",
				PortletRequest.RENDER_PHASE)
		).setMVCPath(
			"/edit_foo.jsp"
		).setRedirect(
			_portal.getCurrentURL(httpServletRequest)
		).setBackURL(
			_portal.getCurrentURL(httpServletRequest)
		).setParameter(
			"fooId", foo.getFooId()
		).buildString();
	}

	@Override
	public Class<Foo> getModelClass() {
		return Foo.class;
	}

	@Override
	public String getTitle(Locale locale, Foo foo) throws PortalException {
		return foo.getField1();
	}

	@Override
	protected void buildDisplay(DisplayBuilder<Foo> displayBuilder) {
		Foo foo = displayBuilder.getModel();

		displayBuilder.display(
			"field1", foo.getField1()
		).display(
			"field2", foo.getField2()
		).display(
			"field3", foo.getField3()
		).display(
			"field4", foo.getField4()
		);
	}

	@Reference
	private Portal _portal;

}