
				/*
 *  OpenVPNALS
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
			
package com.maverick.crypto.asn1;

import java.io.IOException;

/**
 * DER T61String (also the teletex string)
 */
public class DERT61String
    extends DERObject
    implements DERString
{
    String  string;

    /**
     * return a T61 string from the passed in object.
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    public static DERT61String getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERT61String)
        {
            return (DERT61String)obj;
        }

        if (obj instanceof ASN1OctetString)
        {
            return new DERT61String(((ASN1OctetString)obj).getOctets());
        }

        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an T61 String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    public static DERT61String getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(obj.getObject());
    }

    /**
     * basic constructor - with bytes.
     */
    public DERT61String(
        byte[]   string)
    {
		char[]  cs = new char[string.length];

		for (int i = 0; i != cs.length; i++)
		{
			cs[i] = (char)(string[i] & 0xff);
		}

		this.string = new String(cs);
    }

    /**
     * basic constructor - with string.
     */
    public DERT61String(
        String   string)
    {
        this.string = string;
    }

    public String getString()
    {
        return string;
    }

    void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(T61_STRING, this.getOctets());
    }

	public byte[] getOctets()
	{
		char[]  cs = string.toCharArray();
		byte[]  bs = new byte[cs.length];

		for (int i = 0; i != cs.length; i++)
		{
			bs[i] = (byte)cs[i];
		}

		return bs;
	}

    public boolean equals(
        Object  o)
    {
        if ((o == null) || !(o instanceof DERT61String))
        {
            return false;
        }

        return this.getString().equals(((DERT61String)o).getString());
    }
}
