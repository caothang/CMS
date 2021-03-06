/*
 * Copyright (C) 2012 - BigB.
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
package org.exoplatform.cms.rendering;

import java.util.HashMap;
import java.util.Map;

import org.exoplatform.cms.rendering.api.Renderer;
import org.exoplatform.cms.rendering.api.UnsupportedSyntaxException;
import org.exoplatform.cms.rendering.spi.MarkupRenderDelegate;
import org.exoplatform.cms.rendering.spi.RendererPlugin;

/**
 * @author <a href="mailto:patrice.lamarque@exoplatform.com">Patrice Lamarque</a>
 * @version $Revision$
 */
public class MarkupRenderingService {

  protected Map<String, Renderer> rendererRegistry;

  public MarkupRenderingService() {
    rendererRegistry = new HashMap<String, Renderer>();
  }

  public void registerRenderer(RendererPlugin plugin) {
    registerRenderer(plugin.getRenderer());
  }

  public void registerRenderer(Renderer renderer) {
    rendererRegistry.put(renderer.getSyntax(), renderer);
  }

  public Renderer getRenderer(String syntax) {
    Renderer r = rendererRegistry.get(syntax);
    if (r == null) {
      throw new UnsupportedSyntaxException("No renderer has been registered for syntax " + syntax);
    }
    return r;
  }

  /**
   * Convenience method to delegate markup of an object.
   * @param <T>
   * @param delegate
   * @param target
   * @return
   */
  public <T> String delegateRendering(MarkupRenderDelegate<T> delegate, T target) {
    String message = delegate.getMarkup(target);
    if (message != null) {
      Renderer renderer = getRenderer(delegate.getSyntax(target));
      return renderer.render(message);
    }
    return null;
  }

}
