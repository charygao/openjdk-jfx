/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package javafx.scene.input;

import java.util.Set;

import com.sun.javafx.tk.TKClipboard;
import javafx.scene.image.Image;

/**
 * A drag and drop specific {@link Clipboard}.
 */
public final class Dragboard extends Clipboard {

    Dragboard(TKClipboard peer) {
        super(peer);
    }

    /**
     * Gets set of transport modes supported by source of this drag opeation.
     * @return set of supported transfer modes
     */
    public final Set<TransferMode> getTransferModes() {
        return peer.getTransferModes();
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    public TKClipboard impl_getPeer() {
        return peer;
    }

    /**
     * @treatAsPrivate implementation detail
     * @deprecated This is an internal API that is not intended for use and will be removed in the next version
     */
    @Deprecated
    public static Dragboard impl_create(TKClipboard peer) {
        return new Dragboard(peer);
    }

    // PENDING_DOC_REVIEW
    /**
     * Sets the visual representation of data being transfered 
     * in a drag and drop gesture.
     * Uses the given image for the drag view with the offsetX and offsetY 
     * specifying cursor position over the image.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param image image to use for the drag view
     * @param offsetX x position of the cursor over the image
     * @param offsetY y position of the cursor over the image
     */
    public void setDragView(Image image, double offsetX, double offsetY) {
        peer.setDragView(image);
        peer.setDragViewOffsetX(offsetX);
        peer.setDragViewOffsetY(offsetY);
    }

    /**
     * Sets the visual representation of data being transfered 
     * in a drag and drop gesture.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param image image to use for the drag view
     */
    public void setDragView(Image image) {
        peer.setDragView(image);
    }

    /**
     * Sets the x position of the cursor of the drag view image.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param offsetX x position of the cursor over the image
     */
    public void setDragViewOffsetX(double offsetX) {
        peer.setDragViewOffsetX(offsetX);
    }

    /**
     * Sets the y position of the cursor of the drag view image.
     * This method should be called only when starting drag and drop operation
     * in the DRAG_DETECTED handler, calling it at other times
     * doesn't have any effect.
     * @param offsetY y position of the cursor over the image
     */
    public void setDragViewOffsetY(double offsetY) {
        peer.setDragViewOffsetY(offsetY);
    }

    /**
     * Gets the image used as a drag view.
     * This method returns meaningful value only when starting drag and drop
     * operation in the DRAG_DETECTED handler, it returns null at other times.
     * @return the image used as a drag view
     */
    public Image getDragView() {
        return peer.getDragView();
    }

    /**
     * Gets the x position of the cursor of the drag view image.
     * This method returns meaningful value only when starting drag and drop
     * operation in the DRAG_DETECTED handler, it returns 0 at other times.
     * @return x position of the cursor over the image
     */
    public double getDragViewOffsetX() {
        return peer.getDragViewOffsetX();
    }

    /**
     * Gets the y position of the cursor of the drag view image.
     * This method returns meaningful value only when starting drag and drop
     * operation in the DRAG_DETECTED handler, it returns 0 at other times.
     * @return y position of the cursor over the image
     */
    public double getDragViewOffsetY() {
        return peer.getDragViewOffsetY();
    }
}
