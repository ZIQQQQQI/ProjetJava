package Donnee;

import java.util.ArrayList;

public class DomaineCompetence extends AbstractCompetence{
    ArrayList<AbstractCompetence> listCompetence;
    //Un domaine possède un ensemblre de compétences
    public DomaineCompetence(String nomComp, Integer id) {
        super(nomComp, id);
        this.listCompetence=new ArrayList<>();
    }

    public void add(AbstractCompetence competence){
        this.listCompetence.add(competence);
    }

    public ArrayList<AbstractCompetence> getListCompetence() {
        return listCompetence;
    }
}
