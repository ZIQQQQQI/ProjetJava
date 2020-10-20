package Compte;

<<<<<<< HEAD
import Reclamation.AbstractReclamation;
import Tache.AbstractLigneTache;

import java.util.ArrayList;

=======
import Donnee.Competence;
import Reclamation.Reclamation;
import Tache.LigneTache;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Intervenant extends AbstractIntervenant{
   String nom;
   String dateDebut;
   String dateFin;
   String profession;
   ArrayList<Competence> listCompetence;


    public Intervenant(Integer id, String adresse, String mail, String iban, String bic, String mdp) {
        super(id, adresse, mail, iban, bic, mdp);
        this.listCompetence=new ArrayList<>();
    }

    @Override
    public void entrepreise(String nom, String dateDebut, String dateFin, String profession) {
        this.nom=nom;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.profession=profession;
    }

    //envoyer message
    public void envoyerMessageTache(String contenu, LigneTache ligneTache){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        ligneTache.addMessage(new MessageIntervenant(date,contenu,this));
    }


    public void envoyerMessageReclamation(String contenu, Reclamation reclamtion){
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String date = sdf.format(new Date());
        reclamtion.addMessage(new MessageIntervenant(date,contenu,this));
    }
    //refuse et accpter ligne tache
    public void refuseTache(LigneTache lignetahce){
        lignetahce.addRefuse(this);
    }

    public void accepterTache(LigneTache ligneTache){
        ligneTache.setEtatLT("accepte");
        ligneTache.accpteTache((this));
    }
    //add une competence pour un intervenant
    public void addCompetence(Competence competence){
        this.listCompetence.add(competence);
    }

    //get le nom de intervenant
    public String getNom(){return this.nom;}
    //get list de competence
    public ArrayList<Competence> getListCompetence(){return this.listCompetence;}

}
>>>>>>> 437d908a5b86e22e49032a32e38cb739a7d6b4c5
