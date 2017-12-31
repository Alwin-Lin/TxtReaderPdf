/*
 * $Id: RefImage.java,v 1.3 2009/01/16 16:26:10 tomoke Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.hsl.txtreader.pdf.port;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;

/**
 * A Bitmap subclass that holds a strong reference to its graphics
 * object.  This means that the graphics will never go away as long as
 * someone holds a reference to this image, and createGraphics() and
 * getGraphics() can be called multiple times safely, and will always return
 * the same graphics object.
 */
public class RefImage {

    private Bitmap bitmap;

    /** a strong reference to the graphics object */
    private Canvas g;

    /** Creates a new instance of RefImage */
    public RefImage(int width, int height, Config config) {
        bitmap = Bitmap.createBitmap(width, height, config);
    }

    /**
     * Create a graphics object only if it is currently null, otherwise
     * return the existing graphics object.
     */
    public Canvas createGraphics() {
        if (g == null) {
            g = new Canvas(bitmap);
        }

        return g;
    }
}
