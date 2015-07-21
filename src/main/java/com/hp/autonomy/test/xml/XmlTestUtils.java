package com.hp.autonomy.test.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

/**
 * Contains utility methods for using XML resources in unit tests.
 */
public class XmlTestUtils {

    private static XMLInputFactory xmlInputFactory;

    private XmlTestUtils() {
        super();
    }

    private static void createXMLInputFactory() {
        // Create the factory
        xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty(XMLInputFactory.IS_VALIDATING, false);
        xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
    }

    /**
     * Get the named resource as a StAX stream reader instance.
     * @param resource The resource to wrapper
     * @return An <tt>XMLStreamReader</tt> instance wrapping the resource
     * @throws javax.xml.stream.XMLStreamException if something went wrong
     */
    public static XMLStreamReader getResourceAsXMLStreamReader(final String resource) throws XMLStreamException {
        if (xmlInputFactory == null) {
            createXMLInputFactory();
        }

        // Get the resource as a StAX reader
        return xmlInputFactory.createXMLStreamReader(XmlTestUtils.class.getResourceAsStream(resource));
    }

    /**
     * Get the XML string as a StAX stream reader instance.
     * @param string a string containing XML
     * @return An <tt>XMLStreamReader</tt> instance wrapping the XML string
     * @throws XMLStreamException if something went wrong
     */
    public static XMLStreamReader getStringAsXMLStreamReader(final String string) throws XMLStreamException {
        if (xmlInputFactory == null) {
            createXMLInputFactory();
        }

        // Give the string to the StAX reader
        return xmlInputFactory.createXMLStreamReader(new StringReader(string));
    }

}
