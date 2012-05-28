/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.exoplatform.cms.service.Utils;

import junit.framework.TestCase;

/**
 * Created by The eXo Platform SAS
 * Author : Vu Duy Tu
 *          tu.duy@exoplatform.com
 * Apr 28, 2011  
 */
public class TestUtils extends TestCase {
  public TestUtils() {
    super();
  }

  protected void setUp() throws Exception {
    super.setUp();
  }

  public void testIsEmpty() {
    assertEquals(true, Utils.isEmpty(null));
    assertEquals(true, Utils.isEmpty(""));
    assertEquals(true, Utils.isEmpty(" "));
    assertEquals(false, Utils.isEmpty("abc"));
  }

  public void testIsListEmpty() {
    List<String> list = null;
    assertEquals(true, Utils.isListEmpty(list));
    list = new ArrayList<String>();
    assertEquals(true, Utils.isListEmpty(list));
    list.add("");
    list.add(" ");
    list.add("");
    assertEquals(true, Utils.isListEmpty(list));
    list.add("");
    list.add("foo");
    list.add("");
    assertEquals(false, Utils.isListEmpty(list));
  }

}