package com.hp.autonomy.test.xml;

import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class XmlTestUtilsTest {
    @Test
    public void getsResourceAsXmlStreamReader() throws XMLStreamException {
        final XMLStreamReader streamReader = XmlTestUtils.getResourceAsXMLStreamReader("/com/hp/autonomy/test/xml/users.xml");
        streamReader.next();

        assertThat(streamReader.getAttributeName(0).toString(), is("count"));
        assertThat(streamReader.getAttributeValue(0), is("2"));
    }

    @Test
    public void getsStringAsXmlStreamReader() throws XMLStreamException {
        final XMLStreamReader streamReader = XmlTestUtils.getStringAsXMLStreamReader("<animal type=\"dog\"/>");
        streamReader.next();

        assertThat(streamReader.getAttributeName(0).toString(), is("type"));
        assertThat(streamReader.getAttributeValue(0), is("dog"));
    }
}
