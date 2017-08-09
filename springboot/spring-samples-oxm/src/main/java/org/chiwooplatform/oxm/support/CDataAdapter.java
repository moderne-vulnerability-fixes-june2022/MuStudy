package org.chiwooplatform.oxm.support;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/** 
 * @author seonbo.shim 
 */
public class CDataAdapter
    extends XmlAdapter<String, String> {

    @Override
    public String marshal( String v )
        throws Exception {
        return "<![CDATA[" + v + "]]>";
    }

    @Override
    public String unmarshal( String v )
        throws Exception {
        return v;
    }
}