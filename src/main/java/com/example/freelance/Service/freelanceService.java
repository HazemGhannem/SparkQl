package com.example.freelance.Service;

import com.example.freelance.Entity.Contrat;
import com.example.freelance.Entity.Deliverable;
import com.example.freelance.Tool.FileTool;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class freelanceService {

    @Autowired
    private Model rdfModel;
    public List<Contrat> getContrat(){
        File queryFile = new File("data/query.txt");
        String queryString = FileTool.getContents(queryFile);
        List<Contrat> results = new ArrayList<>();

        try {
            Query query = QueryFactory.create(queryString);
            QueryExecution queryExecution = QueryExecutionFactory.create(query, rdfModel);

            ResultSet resultSet = queryExecution.execSelect();
            System.out.println("==========================");

            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
                System.out.println("==========================");
                System.out.println(solution);
                System.out.println(resultSet);
                System.out.println("==========================");
                Contrat result = new Contrat();
                result.setName(solution.get("name").toString());
                result.setDate(solution.get("date").toString());
                result.setStatus(solution.get("status").toString());
                result.setMoneyAmount(solution.get("moneyAmount").toString());
                result.setFreelancer(solution.get("freelancer").toString());
                result.setProject(solution.get("projet").toString());
                results.add(result);
            }
        } catch (QueryParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

        return results;
    }

    public List<Deliverable> getDeliverable(){
        File queryFile = new File("data/deliverableQuery.txt");
        String queryString = FileTool.getContents(queryFile);
        List<Deliverable> results = new ArrayList<>();

        try {
            Query query = QueryFactory.create(queryString);
            QueryExecution queryExecution = QueryExecutionFactory.create(query, rdfModel);

            ResultSet resultSet = queryExecution.execSelect();
            System.out.println("==========================");

            while (resultSet.hasNext()) {
                QuerySolution solution = resultSet.nextSolution();
                System.out.println("==========================");
                System.out.println(solution);
                System.out.println(resultSet);
                System.out.println("==========================");
                Deliverable result = new Deliverable();
                result.setName(solution.get("name").toString());
                result.setDescription(solution.get("description").toString());
                result.setDeadline(solution.get("deadline").toString());
                result.setType(solution.get("type").toString());
                result.setReview(solution.get("review").toString());
                result.setFreelancer(solution.get("freelancer").toString());
                result.setProject(solution.get("projet").toString());
                results.add(result);
            }
        } catch (QueryParseException e) {
            // Handle query parsing error
        } catch (Exception e) {
            // Handle other exceptions
        }

        return results;
    }
}
