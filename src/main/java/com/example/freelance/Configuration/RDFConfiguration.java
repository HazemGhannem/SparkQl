package com.example.freelance.Configuration;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class RDFConfiguration {

    @Bean
    public Model rdfModel() {
        // Create and configure your RDF data model here
        Model model = ModelFactory.createDefaultModel();
        InputStream in = FileManager.get().open("data/freelancer.owl");
        model.read(in,""); // Replace with your RDF data file path
        return model;
    }
}