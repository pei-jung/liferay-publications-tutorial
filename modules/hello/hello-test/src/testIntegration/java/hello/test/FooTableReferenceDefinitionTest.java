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

package hello.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.change.tracking.test.util.BaseTableReferenceDefinitionTestCase;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.change.tracking.CTModel;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import hello.model.Foo;

import hello.service.FooLocalService;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * @author Pei-Jung Lan
 */
@RunWith(Arquillian.class)
public class FooTableReferenceDefinitionTest
	extends BaseTableReferenceDefinitionTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Override
	protected CTModel<?> addCTModel() throws Exception {
		Foo foo = _fooLocalService.createFoo(_counterLocalService.increment());

		foo.setCompanyId(TestPropsValues.getCompanyId());
		foo.setGroupId(group.getGroupId());

		User user = TestPropsValues.getUser();

		foo.setUserId(user.getUserId());
		foo.setUserName(user.getFullName());
		foo.setUserUuid(user.getUserUuid());

		foo.setField1(RandomTestUtil.randomString());
		foo.setField2(RandomTestUtil.randomBoolean());
		foo.setField3(RandomTestUtil.randomInt());
		foo.setField4(RandomTestUtil.nextDate());
		foo.setField5(RandomTestUtil.randomString());

		return _fooLocalService.addFoo(foo);
	}

	@Inject
	private CounterLocalService _counterLocalService;

	@Inject
	private FooLocalService _fooLocalService;

}