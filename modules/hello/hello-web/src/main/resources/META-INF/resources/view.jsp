<%--
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
--%>

<%@ include file="/init.jsp" %>

<clay:management-toolbar
	managementToolbarDisplayContext="<%= HelloDisplayContextFactory.createToolbarDisplayContext(request, renderRequest, renderResponse) %>"
/>

<clay:container-fluid>
	<liferay-ui:search-container
		total="<%= fooLocalService.getFoosCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= fooLocalService.getFoos(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="hello.model.Foo"
			escapedModel="true"
			modelVar="foo"
		>
			<liferay-ui:search-container-column-text
				name="id"
				property="fooId"
				valign="top"
			/>

			<liferay-ui:search-container-column-text
				name="field1"
				valign="top"
			>
				<strong><%= foo.getField1() %></strong>

				<br />

				<div class="lfr-asset-categories">
					<liferay-asset:asset-categories-summary
						className="<%= Foo.class.getName() %>"
						classPK="<%= foo.getFooId() %>"
					/>
				</div>

				<div class="lfr-asset-tags">
					<liferay-asset:asset-tags-summary
						className="<%= Foo.class.getName() %>"
						classPK="<%= foo.getFooId() %>"
						message="tags"
					/>
				</div>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
				property="field2"
				valign="top"
			/>

			<liferay-ui:search-container-column-text
				property="field3"
				valign="top"
			/>

			<liferay-ui:search-container-column-date
				name="field4"
				valign="top"
				value="<%= foo.getField4() %>"
			/>

			<liferay-ui:search-container-column-text
				property="field5"
				valign="top"
			/>

			<liferay-ui:search-container-column-jsp
				cssClass="entry-action"
				path="/foo_action.jsp"
				valign="top"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</clay:container-fluid>