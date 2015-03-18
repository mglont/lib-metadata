package eu.ddmore.metadata.service;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Sarala Wimalaratne
 *         Date: 17/03/2015
 *         Time: 11:06
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MetadataMapTests {

    @Autowired
    private MetadataMap metadataMap;

    @Test
    public void testPropertiesMap() {
        Resource resource = ResourceFactory.createResource("http://www.pharmml.org/ontology/PHARMMLO_0000001");
        ArrayList<Property> properties = metadataMap.getAssociatedProperties(resource);
        org.junit.Assert.assertEquals(properties.size(), 9);
    }

    @Test
    public void testOntologyMap() {
        Property property = ResourceFactory.createProperty("http://www.pharmml.org/2013/10/PharmMLMetadata#model-field-purpose");
        ArrayList<Resource> resources = metadataMap.getAssociatedResources(property);
        org.junit.Assert.assertEquals(resources.size(),10);
    }
}
