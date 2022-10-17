package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity (name = "Reiziger")
@Table (name = "reiziger")
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    @OneToOne(
            mappedBy = "reiziger",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Adres adres;

    @OneToMany(mappedBy = "reiziger")
    private List<OVChipkaart> ovChipkaarten = new ArrayList<>();


    public Reiziger() {

    }

    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public List<OVChipkaart> getovChipkaarten() {
        return ovChipkaarten;
    }

    public void getovChipkaarten(List<OVChipkaart> kaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    @Override
    public String toString() {
        return id + " " + voorletters + " " + tussenvoegsel+ " " +achternaam+ " " +geboortedatum + adres + ovChipkaarten;
    }
}
