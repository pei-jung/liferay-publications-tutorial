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

package hello.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import hello.model.Foo;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dtruong
 */
public class HelloDisplayContextFactory {

	public static HelloToolbarDisplayContext createToolbarDisplayContext(
		HttpServletRequest httpServletRequest, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		return new HelloToolbarDisplayContext(
			httpServletRequest,
			PortalUtil.getLiferayPortletRequest(renderRequest),
			PortalUtil.getLiferayPortletResponse(renderResponse),
			_getSearchContainer(renderRequest, renderResponse));
	}

	private static SearchContainer<Foo> _getSearchContainer(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		return new SearchContainer<>(
			renderRequest, new DisplayTerms(renderRequest), null,
			SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			PortletURLUtil.getCurrent(renderRequest, renderResponse), null,
			"No Results Found");
	}

}