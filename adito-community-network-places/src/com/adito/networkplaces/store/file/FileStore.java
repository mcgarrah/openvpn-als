
				/*
 *  Adito
 *
 *  Copyright (C) 2003-2006 3SP LTD. All Rights Reserved
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2 of
 *  the License, or (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public
 *  License along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
			
package com.adito.networkplaces.store.file;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adito.networkplaces.AbstractNetworkPlaceMount;
import com.adito.networkplaces.AbstractNetworkPlaceStore;
import com.adito.policyframework.LaunchSession;

public class FileStore extends AbstractNetworkPlaceStore {
    final static Log log = LogFactory.getLog(FileStore.class);
	/**
	 * File scheme name
	 */
	public final static String FILE_SCHEME = "file";

    public FileStore() {
        this(FILE_SCHEME);
    }

    public FileStore(String storeName) {
        super(storeName, "UTF-8");
    }

    /* (non-Javadoc)
     * @see com.adito.vfs.AbstractNetworkPlaceStore#createMount(com.adito.policyframework.LaunchSession)
     */
    protected AbstractNetworkPlaceMount createMount(LaunchSession launchSession) throws Exception {
        return new FileMount(launchSession, this);
    }
}